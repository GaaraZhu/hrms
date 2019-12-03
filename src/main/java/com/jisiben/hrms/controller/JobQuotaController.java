package com.jisiben.hrms.controller;

import com.google.common.collect.ImmutableMap;
import com.jisiben.hrms.controller.common.AbstractController;
import com.jisiben.hrms.controller.dto.JobQuotaDTO;
import com.jisiben.hrms.controller.dto.PageableSearchResultDTO;
import com.jisiben.hrms.controller.dto.mapper.common.Mapper;
import com.jisiben.hrms.domain.entity.JobQuota;
import com.jisiben.hrms.service.JobQuotaService;
import com.jisiben.hrms.service.common.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import java.util.Optional;

@Controller
public class JobQuotaController extends AbstractController<JobQuota, JobQuotaDTO, JobQuota.Builder> {
    @Autowired
    private JobQuotaService jobQuotaService;

    @Autowired
    @Qualifier("jobQuotaEntityDTOMapper")
    private Mapper<JobQuota, JobQuotaDTO> mapper;

    @ResponseBody
    @Produces("application/json")
    @RequestMapping(value = "/jobQuotas", method = RequestMethod.GET)
    public PageableSearchResultDTO<JobQuotaDTO> findAll(
            @RequestParam("company")String company,
            @RequestParam("city")String city,
            @RequestParam("jobName")String jobName,
            @RequestParam("month") String month,
            @RequestParam("currentPage") int currentPage,
            @RequestParam("pageSize") int pageSize) {
        return doFindAll(
                ImmutableMap.<String, Optional<Object>>builder()
                        .put("company", Optional.ofNullable(company))
                        .put("city", Optional.ofNullable(city))
                        .put("jobName", Optional.ofNullable(jobName))
                        .put("month", Optional.ofNullable(month)).build(), currentPage, pageSize);
    }

    @ResponseBody
    @RequestMapping(value = "/jobQuotaCount", method = RequestMethod.GET)
    public Long findJobQuotaCount(@RequestParam("jobId") Long jobId, @RequestParam("month") String month, @RequestParam("branchId") Long branchId) {
        return jobQuotaService.countJobQuota(jobId, month, branchId);
    }

    @ResponseBody
    @RequestMapping(value = "/jobQuota", method = RequestMethod.GET)
    public JobQuotaDTO find(Long id) { //TODO: optional serialization
        return doFind(id);
    }

    @RequestMapping(value = "/jobQuota", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void add(@RequestBody JobQuotaDTO dto) {
        doAdd(dto);
    }

    @RequestMapping(value = "/jobQuota", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void update(Long id, @RequestBody JobQuotaDTO dto) {
        doUpdate(id, dto);
    }

    @RequestMapping(value = "/jobQuota", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@RequestParam Long id, ModelMap model) {
        doDelete(id);
    }

    @Override
    protected Service<JobQuota> getService() {
        return jobQuotaService;
    }

    @Override
    protected Mapper<JobQuota, JobQuotaDTO> getMapper() {
        return mapper;
    }

    @Override
    protected JobQuota.Builder getEntityBuilder() {
        return new JobQuota.Builder();
    }
}