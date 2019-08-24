package com.jisiben.hrms.controller;

import javax.ws.rs.Produces;

import com.google.common.collect.Streams;
import com.jisiben.hrms.controller.dto.JobDTO;
import com.jisiben.hrms.controller.dto.PageableSearchResultDTO;
import com.jisiben.hrms.controller.dto.mapper.common.Mapper;
import com.jisiben.hrms.domain.entity.Job;
import com.jisiben.hrms.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Controller
public class JobController {
    @Autowired
    private JobService jobService;

    @Autowired
    @Qualifier("jobEntityDTOMapper")
    private Mapper<Job, JobDTO> mapper;

    private Logger logger = Logger.getLogger(JobController.class.getSimpleName());

    @ResponseBody
    @Produces("application/json")
    @RequestMapping(value = "/jobs", method = RequestMethod.GET)
    public PageableSearchResultDTO<JobDTO> findAll(
            @RequestParam("company") String company,
            @RequestParam("city") String city,
            @RequestParam("name") String name,
            @RequestParam("active") Boolean active,
            @RequestParam("currentPage") int currentPage,
            @RequestParam("pageSize") int pageSize) {
        PageRequest pageRequest = new PageRequest(currentPage-1, pageSize);
        Page<Job> allJobs = Arrays.asList(company, city, name, active, currentPage, pageSize)
                .stream()
                .filter(Objects::nonNull)
                .findAny()
                .map((Object s)->getJobService()
                        .search(company, city, name, active, pageRequest))
                .orElse(getJobService()
                        .findAll(pageRequest));
        List<JobDTO> js = Streams.stream(allJobs.iterator())
                .map(mapper::toDTO)
                .collect(Collectors.toList());
        return new PageableSearchResultDTO.Builder<JobDTO>()
                .totalElements(allJobs.getTotalElements())
                .totalPages(allJobs.getTotalPages())
                .results(js)
                .build();
    }

    @ResponseBody
    @RequestMapping(value = "/job", method = RequestMethod.GET)
    public JobDTO find(Long id) { //TODO: optional serialization
        return getJobService()
                .findById(id)
                .map(mapper::toDTO).orElse(new JobDTO.Builder().build());
    }

    @RequestMapping(value = "/job", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void add(@RequestBody JobDTO dto) {
        getJobService().save(
                mapper.toEntity(dto, new Job())
        );
    }

    @RequestMapping(value = "/job", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void update(Long id, @RequestBody JobDTO dto) {
        getJobService().findById(id)
                .ifPresent((Job job)->
                    getJobService().save(mapper.toEntity(dto, job)));
    }

    @RequestMapping(value = "/job", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@RequestParam Long id, ModelMap model) {
        getJobService().delete(id);
    }

    public JobService getJobService() {
        return jobService;
    }

    public void setJobService(JobService jobService) {
        this.jobService = jobService;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}