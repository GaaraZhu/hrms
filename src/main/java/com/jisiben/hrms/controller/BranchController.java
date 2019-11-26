package com.jisiben.hrms.controller;

import javax.ws.rs.Produces;

import com.google.common.collect.ImmutableMap;
import com.jisiben.hrms.controller.common.AbstractController;
import com.jisiben.hrms.controller.dto.BranchDTO;
import com.jisiben.hrms.controller.dto.PageableSearchResultDTO;
import com.jisiben.hrms.controller.dto.mapper.common.Mapper;
import com.jisiben.hrms.domain.entity.Branch;
import com.jisiben.hrms.service.BranchService;
import com.jisiben.hrms.service.common.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class BranchController extends AbstractController<Branch, BranchDTO, Branch.Builder> {
    @Autowired
    private BranchService branchService;

    @Autowired
    @Qualifier("branchEntityDTOMapper")
    private Mapper<Branch, BranchDTO> mapper;

    @ResponseBody
    @Produces("application/json")
    @RequestMapping(value = "/branches", method = RequestMethod.GET)
    public PageableSearchResultDTO<BranchDTO> findAll(
            @RequestParam("company") String company,
            @RequestParam("branch") String branch,
            @RequestParam("currentPage") int currentPage,
            @RequestParam("pageSize") int pageSize) {
        return doFindAll(
                ImmutableMap.of(
                        "company", Optional.ofNullable(company),
                        "branch", Optional.ofNullable(branch)), currentPage, pageSize);
    }

    @ResponseBody
    @RequestMapping(value = "/branch", method = RequestMethod.GET)
    public BranchDTO find(Long id) {
        return doFind(id);
    }

    @RequestMapping(value = "/branch", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void add(@RequestBody BranchDTO dto) {
        doAdd(dto);
    }

    @RequestMapping(value = "/branch", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void update(Long id, @RequestBody BranchDTO dto) {
        doUpdate(id, dto);
    }

    @RequestMapping(value = "/branch", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@RequestParam Long id, ModelMap model) {
        doDelete(id);
    }

    @Override
    protected Service<Branch> getService() {
        return branchService;
    }

    @Override
    protected Mapper<Branch, BranchDTO> getMapper() {
        return mapper;
    }

    @Override
    protected Branch.Builder getEntityBuilder() {
        return new Branch.Builder();
    }
}