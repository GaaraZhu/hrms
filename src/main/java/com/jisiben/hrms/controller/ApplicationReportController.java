package com.jisiben.hrms.controller;

import com.google.common.collect.ImmutableMap;
import com.jisiben.hrms.controller.common.AbstractController;
import com.jisiben.hrms.controller.dto.ApplicationReportDTO;
import com.jisiben.hrms.controller.dto.PageableSearchResultDTO;
import com.jisiben.hrms.controller.dto.mapper.common.Mapper;
import com.jisiben.hrms.controller.dto.PairDTO;
import com.jisiben.hrms.domain.entity.ApplicationReport;
import com.jisiben.hrms.domain.dao.bean.Pair;
import com.jisiben.hrms.service.ApplicationReportService;
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
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class ApplicationReportController extends AbstractController<ApplicationReport, ApplicationReportDTO, ApplicationReport.Builder> {

    @Autowired
    private ApplicationReportService service;

    @Autowired
    private JobService jobService;

    @Autowired
    private JobApplicationService jobApplicationService;

    @Autowired
    @Qualifier("applicationReportEntityDTOMapper")
    private Mapper<ApplicationReport, ApplicationReportDTO> mapper;

    @ResponseBody
    @Produces("application/json")
    @RequestMapping(value = "/applicationReports", method = RequestMethod.GET)
    public PageableSearchResultDTO<ApplicationReportDTO> findAll(
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
    @RequestMapping(value = "/applicationReports/successApplicantsByCompany", method = RequestMethod.GET)
    public List<PairDTO> findSuccessApplicantsByCompany(
            @RequestParam("fromDate") Date fromDate,
            @RequestParam("toDate") Date toDate) {
                
        List<Pair> totalQuatoByCompany = jobService.findTotalQuotaByCompany(fromDate, toDate);
        List<Pair> successApplicantsByCompany = jobApplicationService.findSuccessApplicantsByCompany(fromDate, toDate);

        List<PairDTO> results = new ArrayList<>();
        totalQuatoByCompany.stream().forEach(p1-> {
            for(Pair p2 : successApplicantsByCompany) {
                if (p1.getKey().equals(p2.getKey())) {
                    results.add(new PairDTO(p1.getKey(), (double)p2.getValue()/p1.getValue()));
                }
            }
        });
        return results;
    }

    @Override
    protected Service<ApplicationReport> getService() {
        return service;
    }

    @Override
    protected Mapper<ApplicationReport, ApplicationReportDTO> getMapper() {
        return mapper;
    }

    @Override
    protected ApplicationReport.Builder getEntityBuilder() {
        return new ApplicationReport.Builder();
    }
}
