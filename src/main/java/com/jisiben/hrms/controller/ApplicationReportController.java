package com.jisiben.hrms.controller;

import com.google.common.collect.ImmutableMap;
import com.jisiben.hrms.controller.common.AbstractController;
import com.jisiben.hrms.controller.dto.CompanyReportDTO;
import com.jisiben.hrms.controller.dto.PersonalReportDTO;
import com.jisiben.hrms.controller.dto.PageableSearchResultDTO;
import com.jisiben.hrms.controller.dto.mapper.common.Mapper;
import com.jisiben.hrms.controller.dto.PairDTO;
import com.jisiben.hrms.domain.dao.bean.Pair;
import com.jisiben.hrms.domain.entity.PersonalReport;
import com.jisiben.hrms.service.JobQuotaService;
import com.jisiben.hrms.service.PersonalReportService;
import com.jisiben.hrms.service.JobService;
import com.jisiben.hrms.service.common.Service;
import com.jisiben.hrms.service.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.Produces;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class ApplicationReportController extends AbstractController<PersonalReport, PersonalReportDTO, PersonalReport.Builder> {

    @Autowired
    private PersonalReportService service;

    @Autowired
    private JobService jobService;

    @Autowired
    private JobQuotaService jobQuotaService;

    @Autowired
    private JobApplicationService jobApplicationService;

    @Autowired
    @Qualifier("personalReportEntityDTOMapper")
    private Mapper<PersonalReport, PersonalReportDTO> mapper;

    @ResponseBody
    @Produces("application/json")
    @RequestMapping(value = "/applicationReports/personalReport", method = RequestMethod.GET)
    public PageableSearchResultDTO<PersonalReportDTO> findPersonalReports(
            @RequestParam("fromDate") Date fromDate,
            @RequestParam("toDate") Date toDate,
            @RequestParam("name") String name,
            @RequestParam("type") String type,
            @RequestParam("currentPage") int currentPage,
            @RequestParam("pageSize") int pageSize) {
        return doFindAll(
                ImmutableMap.of(
                        "fromDate", Optional.ofNullable(fromDate),
                        "toDate", Optional.ofNullable(toDate),
                        "name", Optional.ofNullable(name),
                        "type", Optional.ofNullable(type)), currentPage, pageSize);
    }

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
    @RequestMapping(value = "/applicationReports/successApplicantsByCompany", method = RequestMethod.GET)
    public List<PairDTO> findSuccessApplicantsByCompany(
            @RequestParam("fromDate") Date fromDate,
            @RequestParam("toDate") Date toDate) {

//        List<Pair> totalQuatoByCompany = jobService.findTotalQuotaByCompany(fromDate, toDate);
//        List<Pair> successApplicantsByCompany = jobApplicationService.findSuccessApplicantsByCompany(fromDate, toDate);
//
//        List<PairDTO> results = new ArrayList<>();
//        totalQuatoByCompany.stream().forEach(p1-> {
//            for(Pair p2 : successApplicantsByCompany) {
//                if (p1.getKey().equals(p2.getKey())) {
//                    results.add(new PairDTO(p1.getKey(), (double)p2.getValue()/p1.getValue()));
//                }
//            }
//        });
//        return results;

        return new ArrayList<>();
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

    @Override
    protected Service<PersonalReport> getService() {
        return service;
    }

    @Override
    protected Mapper<PersonalReport, PersonalReportDTO> getMapper() {
        return mapper;
    }

    @Override
    protected PersonalReport.Builder getEntityBuilder() {
        return new PersonalReport.Builder();
    }
}
