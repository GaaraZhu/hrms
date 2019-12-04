package com.jisiben.hrms.controller;

import com.google.common.collect.ImmutableMap;
import com.jisiben.hrms.controller.dto.*;
import com.jisiben.hrms.domain.dao.bean.Pair;
import com.jisiben.hrms.domain.entity.Branch;
import com.jisiben.hrms.domain.entity.User;
import com.jisiben.hrms.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.Produces;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class ApplicationReportController {

    @Autowired
    private JobService jobService;

    @Autowired
    private JobQuotaService jobQuotaService;

    @Autowired
    private BranchService branchService;

    @Autowired
    private UserService userService;

    @Autowired
    private JobApplicationService jobApplicationService;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @ResponseBody
    @Produces("application/json")
    @RequestMapping(value = "/applicationReports/companyReport", method = RequestMethod.GET)
    public List<CompanyReportDTO> findCompanyReports(
            @RequestParam("company") String company,
            @RequestParam("month") String month) {
        List<Pair> quotas = jobQuotaService.getMonthlyQuota(company, month);
        List<Pair> onboards = jobApplicationService.findOnboardCountByCompany(company, month);
        List<Pair> resigns = jobApplicationService.findResignCountByCompany(company, month);

        Map<String, Long> onboardsMap = onboards.stream().collect(Collectors.toMap(Pair::getKey, Pair::getValue));
        Map<String, Long> resignsMap = resigns.stream().collect(Collectors.toMap(Pair::getKey, Pair::getValue));

        List<CompanyReportDTO> results = new ArrayList<>();
        quotas.forEach(quota->{
            Long totalOnboards = onboardsMap.get(quota.getKey());
            Long totalResigns = resignsMap.get(quota.getKey());
            Double completePercentage = (double)totalOnboards/quota.getValue();

        });
        CompanyReportDTO dto = new CompanyReportDTO.Builder().company("盒马")
                .month("2019-11")
                .quota(120L)
                .completePercentage("30%")
                .dailyQuota(4L)
                .dailyCompletePercentage("25%")
                .totalOnboarded(36L)
                .totalResigned(20L)
                .netOnboarded(16L)
                .build();
        results.add(dto);
        return results;
    }

    @ResponseBody
    @Produces("application/json")
    @RequestMapping(value = "/applicationReports/branch/stuff", method = RequestMethod.GET)
    public List<MonthlyStuffReportDTO> branchStuffReport(
            @RequestParam("company") String company,
            @RequestParam("jobName") String jobName,
            @RequestParam("month") String yearAndMonth) throws ParseException {
        Date startDate = dateFormat.parse(yearAndMonth + "-01");
        Date endDate = dateFormat.parse(yearAndMonth + "-31");

        Object[][] startCounts = jobApplicationService.countStaffByBranch(company, jobName, startDate);
        Map<Long, Long> startCountMap = new HashMap<>();
        for(Object[] keyValue : startCounts) {
            startCountMap.put(Long.valueOf((int)keyValue[0]), (Long)keyValue[1]);
        }

        Object[][] endCounts = jobApplicationService.countStaffByBranch(company, jobName, startDate);
        Map<Long, Long> endCountMap = new HashMap<>();
        for(Object[] keyValue : endCounts) {
            endCountMap.put(Long.valueOf((int)keyValue[0]), (Long)keyValue[1]);
        }

        Page<Branch> branches = branchService.search(ImmutableMap.of(
                "company", Optional.ofNullable(company), "branch", Optional.empty()),1, 500);
        List<MonthlyStuffReportDTO> results = new ArrayList<>();
        for(Branch branch: branches) {
            Long startCount = startCountMap.get(branch.getId()) == null ? 0l : startCountMap.get(branch.getId());
            Long endCount = endCountMap.get(branch.getId()) == null ? 0l : endCountMap.get(branch.getId());
            results.add(new MonthlyStuffReportDTO.Builder().branch(branch.getName())
                    .company(branch.getCompany().getName())
                    .city(branch.getCompany().getCity())
                    .district(branch.getDistrict())
                    .month(yearAndMonth)
                    .firstDayCount(startCount)
                    .lastDayCount(endCount)
                    .build()
            );
        }
        return results;
    }

    @ResponseBody
    @Produces("application/json")
    @RequestMapping(value = "/applicationReports/branch", method = RequestMethod.GET)
    public List<ApplicationReportDTO> branchReport(
            @RequestParam("company") String company,
            @RequestParam("jobName") String jobName,
            @RequestParam("month") String yearAndMonth) {
        String[] yearMonthArray = yearAndMonth.split("-");
        int year = Integer.valueOf(yearMonthArray[0]);
        int month = Integer.valueOf(yearMonthArray[1]);
        Page<Branch> branches = branchService.search(ImmutableMap.of(
                "company", Optional.ofNullable(company), "branch", Optional.empty()),1, 500);

        List<Pair> quotas = jobQuotaService.getMonthlyQuota(company, yearAndMonth);
        Map<String, Long> branchToQuota = new HashMap<>();
        quotas.forEach(p->branchToQuota.put(p.getKey(), p.getValue()));
        List<ApplicationReportDTO> results = new ArrayList<>();
        for(Branch branch: branches) {
            Object[][] onboardCounts = jobApplicationService.countOnboards(company, jobName, branch.getId(), year, month);
            Object[][] resignCounts = jobApplicationService.countResigns(company, jobName, branch.getId(), year, month);
            int quota = branchToQuota.get(branch.getName())==null?0:branchToQuota.get(branch.getName()).intValue();
            results.add(new ApplicationReportDTO.Builder(branch, quota, onboardCounts, resignCounts, yearAndMonth).build());
        }
        return results;
    }

    @ResponseBody
    @Produces("application/json")
    @RequestMapping(value = "/applicationReports/personal", method = RequestMethod.GET)
    public List<ApplicationReportDTO> personalReport(
            @RequestParam("company") String company,
            @RequestParam("jobName") String jobName,
            @RequestParam("month") String yearAndMonth) {
        String[] yearMonthArray = yearAndMonth.split("-");
        int year = Integer.valueOf(yearMonthArray[0]);
        int month = Integer.valueOf(yearMonthArray[1]);
        List<User> users = userService.findByAuthority(0);

        List<Pair> quotas = jobQuotaService.getMonthlyQuota(company, yearAndMonth);
        Map<String, Long> branchToQuota = new HashMap<>();
        quotas.forEach(p->branchToQuota.put(p.getKey(), p.getValue()));
        List<ApplicationReportDTO> results = new ArrayList<>();
        for(User user: users) {
            Object[][] onboardCounts = jobApplicationService.countOnboardsByCreator(company, jobName, user.getAccount(), year, month);
            Object[][] resignCounts = jobApplicationService.countResignsByCreator(company, jobName, user.getAccount(), year, month);
            results.add(new ApplicationReportDTO.Builder(user.getAccount(), onboardCounts, resignCounts, yearAndMonth).build());
        }
        return results;
    }

    @ResponseBody
    @Produces("application/json")
    @RequestMapping(value = "/applicationReports/successApplicantsDistribution", method = RequestMethod.GET)
    public List<PairDTO> findSuccessApplicantsDistribution(
            @RequestParam("fromDate") Date fromDate,
            @RequestParam("toDate") Date toDate) {
        List<Pair> result = jobApplicationService.findSuccessApplicantsByCompany(fromDate, toDate);
        return result.stream()
                .collect(Collectors.groupingBy(Pair::getKey, Collectors.counting()))
                .entrySet().stream().map(entry->new PairDTO(entry.getKey(), (double) Math.round((double)entry.getValue()/result.size() * 100) / 100))
                .collect(Collectors.toList());
    }
}
