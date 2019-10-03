package com.jisiben.hrms.controller;

import com.google.common.collect.ImmutableMap;
import com.jisiben.hrms.controller.common.AbstractController;
import com.jisiben.hrms.controller.dto.JobApplicationDTO;
import com.jisiben.hrms.controller.dto.PageableSearchResultDTO;
import com.jisiben.hrms.controller.dto.mapper.common.Mapper;
import com.jisiben.hrms.domain.entity.JobApplication;
import com.jisiben.hrms.service.JobApplicationService;
import com.jisiben.hrms.service.common.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import java.util.Date;
import java.util.Optional;

@Controller
public class JobApplicationController extends AbstractController<JobApplication, JobApplicationDTO, JobApplication.Builder> {
    @Autowired
    private JobApplicationService jobApplicationService;

    @Autowired
    @Qualifier("jobApplicationDTOMapper")
    private Mapper<JobApplication, JobApplicationDTO> mapper;

    @ResponseBody
    @Produces("application/json")
    @RequestMapping(value = "/jobApplications", method = RequestMethod.GET)
    public PageableSearchResultDTO<JobApplicationDTO> findAll(
            @RequestParam("company")String company,
            @RequestParam("city")String city,
            @RequestParam("jobId")Integer jobId,
            @RequestParam("hasReferee")Boolean hasReferee,
            @RequestParam("phone")String phone,
            @RequestParam("name")String name,
            @RequestParam("status")String status,
            @RequestParam("fromTime") Date fromTime,
            @RequestParam("toTime") Date toTime,
            @RequestParam("currentPage") int currentPage,
            @RequestParam("pageSize") int pageSize) {
        return doFindAll(
                ImmutableMap.<String, Optional<Object>>builder()
                        .put("company", Optional.ofNullable(company))
                        .put("city", Optional.ofNullable(city))
                        .put("jobId", Optional.ofNullable(jobId))
                        .put("hasReferee", Optional.ofNullable(hasReferee))
                        .put("phone", Optional.ofNullable(phone))
                        .put("name", Optional.ofNullable(name))
                        .put("status", Optional.ofNullable(status))
                        .put("fromTime", Optional.ofNullable(fromTime))
                        .put("toTime", Optional.ofNullable(toTime)).build(), currentPage, pageSize);
    }

    @ResponseBody
    @RequestMapping(value = "/jobApplication", method = RequestMethod.GET)
    public JobApplicationDTO find(Long id) { //TODO: optional serialization
        return doFind(id);
    }

    @RequestMapping(value = "/jobApplication", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void add(@RequestBody JobApplicationDTO dto) {
        doAdd(dto);
    }

    @RequestMapping(value = "/jobApplication", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void update(Long id, @RequestBody JobApplicationDTO dto) {
        doUpdate(id, dto);
    }

    @RequestMapping(value = "/jobApplication", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@RequestParam Long id, ModelMap model) {
        doDelete(id);
    }

    @Override
    protected Service<JobApplication> getService() {
        return jobApplicationService;
    }

    @Override
    protected Mapper<JobApplication, JobApplicationDTO> getMapper() {
        return mapper;
    }

    @Override
    protected JobApplication.Builder getEntityBuilder() {
        return new JobApplication.Builder();
    }
}