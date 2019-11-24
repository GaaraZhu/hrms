package com.jisiben.hrms.controller;

import javax.ws.rs.Produces;

import com.google.common.collect.ImmutableMap;
import com.jisiben.hrms.controller.common.AbstractController;
import com.jisiben.hrms.controller.dto.CompanyDTO;
import com.jisiben.hrms.controller.dto.PageableSearchResultDTO;
import com.jisiben.hrms.controller.dto.mapper.common.Mapper;
import com.jisiben.hrms.domain.entity.Company;
import com.jisiben.hrms.service.CompanyService;
import com.jisiben.hrms.service.common.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class CompanyController extends AbstractController<Company, CompanyDTO, Company.Builder> {
    @Autowired
    private CompanyService companyService;

    @Autowired
    @Qualifier("companyEntityDTOMapper")
    private Mapper<Company, CompanyDTO> mapper;

    @ResponseBody
    @Produces("application/json")
    @RequestMapping(value = "/companies", method = RequestMethod.GET)
    public PageableSearchResultDTO<CompanyDTO> findAll(
            @RequestParam("city") String city,
            @RequestParam("name") String name,
            @RequestParam("currentPage") int currentPage,
            @RequestParam("pageSize") int pageSize) {
        return doFindAll(
                ImmutableMap.of(
                        "city", Optional.ofNullable(city),
                        "name", Optional.ofNullable(name)), currentPage, pageSize);
    }

    @ResponseBody
    @RequestMapping(value = "/company", method = RequestMethod.GET)
    public CompanyDTO find(Long id) {
        return doFind(id);
    }

    @RequestMapping(value = "/company", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void add(@RequestBody CompanyDTO dto) {
        doAdd(dto);
    }

    @RequestMapping(value = "/company", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void update(Long id, @RequestBody CompanyDTO dto) {
        doUpdate(id, dto);
    }

    @RequestMapping(value = "/company", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@RequestParam Long id, ModelMap model) {
        doDelete(id);
    }

    @Override
    protected Service<Company> getService() {
        return companyService;
    }

    @Override
    protected Mapper<Company, CompanyDTO> getMapper() {
        return mapper;
    }

    @Override
    protected Company.Builder getEntityBuilder() {
        return new Company.Builder();
    }
}