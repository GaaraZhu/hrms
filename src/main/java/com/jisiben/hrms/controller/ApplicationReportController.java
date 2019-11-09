package com.jisiben.hrms.controller;

import com.google.common.collect.ImmutableMap;
import com.jisiben.hrms.controller.common.AbstractController;
import com.jisiben.hrms.controller.dto.ApplicationReportDTO;
import com.jisiben.hrms.controller.dto.PageableSearchResultDTO;
import com.jisiben.hrms.controller.dto.mapper.common.Mapper;
import com.jisiben.hrms.domain.entity.ApplicationReport;
import com.jisiben.hrms.service.ApplicationReportService;
import com.jisiben.hrms.service.common.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.Produces;
import java.util.Date;
import java.util.Optional;

@Controller
public class ApplicationReportController extends AbstractController<ApplicationReport, ApplicationReportDTO, ApplicationReport.Builder> {

    @Autowired
    private ApplicationReportService service;

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
