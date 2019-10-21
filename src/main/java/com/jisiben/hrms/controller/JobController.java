package com.jisiben.hrms.controller;

import javax.ws.rs.Produces;

import com.google.common.collect.ImmutableMap;
import com.jisiben.hrms.controller.common.AbstractController;
import com.jisiben.hrms.controller.dto.JobDTO;
import com.jisiben.hrms.controller.dto.PageableSearchResultDTO;
import com.jisiben.hrms.controller.dto.mapper.common.Mapper;
import com.jisiben.hrms.domain.entity.Job;
import com.jisiben.hrms.service.JobService;
import com.jisiben.hrms.service.common.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class JobController extends AbstractController<Job, JobDTO, Job.Builder> {
    @Autowired
    private JobService jobService;

    @Autowired
    @Qualifier("jobEntityDTOMapper")
    private Mapper<Job, JobDTO> mapper;

    @ResponseBody
    @Produces("application/json")
    @RequestMapping(value = "/jobs", method = RequestMethod.GET)
    public PageableSearchResultDTO<JobDTO> findAll(
            @RequestParam("company") String company,
            @RequestParam("city") String city,
            @RequestParam("district") String district,
            @RequestParam("name") String name,
            @RequestParam("active") Boolean active,
            @RequestParam("currentPage") int currentPage,
            @RequestParam("pageSize") int pageSize) {
        return doFindAll(
                ImmutableMap.of(
                        "company", Optional.ofNullable(company),
                        "district", Optional.ofNullable(district),
                        "city", Optional.ofNullable(city),
                        "name", Optional.ofNullable(name),
                        "active", Optional.ofNullable(active)), currentPage, pageSize);
    }

    @ResponseBody
    @RequestMapping(value = "/job", method = RequestMethod.GET)
    public JobDTO find(@RequestParam("id") Long id) { //TODO: optional serialization
        return doFind(id);
    }

    @RequestMapping(value = "/job", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void add(@RequestBody JobDTO dto) {
        doAdd(dto);
    }

    @RequestMapping(value = "/job", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void update(Long id, @RequestBody JobDTO dto) {
        doUpdate(id, dto);
    }

    @RequestMapping(value = "/job", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@RequestParam Long id, ModelMap model) {
        doDelete(id);
    }

    @Override
    protected Service<Job> getService() {
        return jobService;
    }

    @Override
    protected Mapper<Job, JobDTO> getMapper() {
        return mapper;
    }

    @Override
    protected Job.Builder getEntityBuilder() {
        return new Job.Builder();
    }
}