package com.jisiben.hrms.controller;

import javax.ws.rs.Produces;

import com.google.common.collect.ImmutableMap;
import com.jisiben.hrms.controller.common.AbstractController;
import com.jisiben.hrms.controller.dto.DepartmentDTO;
import com.jisiben.hrms.controller.dto.PageableSearchResultDTO;
import com.jisiben.hrms.controller.dto.mapper.common.Mapper;
import com.jisiben.hrms.domain.entity.Department;
import com.jisiben.hrms.service.DepartmentService;
import com.jisiben.hrms.service.common.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class DepartmentController extends AbstractController<Department, DepartmentDTO, Department.Builder> {
    @Autowired
    private DepartmentService departmentService;

    @Autowired
    @Qualifier("departmentEntityDTOMapper")
    private Mapper<Department, DepartmentDTO> mapper;

    @ResponseBody
    @Produces("application/json")
    @RequestMapping(value = "/departments", method = RequestMethod.GET)
    public PageableSearchResultDTO<DepartmentDTO> findAll(
            @RequestParam("depNum") String depNumber,
            @RequestParam("depName") String depName,
            @RequestParam("currentPage") int currentPage,
            @RequestParam("pageSize") int pageSize) {
        return doFindAll(
                ImmutableMap.of(
                        "depNum", Optional.ofNullable(depNumber),
                        "depName", Optional.ofNullable(depName)), currentPage, pageSize);
    }

    @ResponseBody
    @RequestMapping(value = "/department", method = RequestMethod.GET)
    public DepartmentDTO find(Long id) {
        return doFind(id);
    }

    @RequestMapping(value = "/department", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void add(@RequestBody DepartmentDTO dto) {
        doAdd(dto);
    }

    @RequestMapping(value = "/department", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void update(Long id, @RequestBody DepartmentDTO dto) {
        doUpdate(id, dto);
    }

    @RequestMapping(value = "/department", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@RequestParam Long id, ModelMap model) {
        doDelete(id);
    }

    @Override
    protected Service<Department> getService() {
        return departmentService;
    }

    @Override
    protected Mapper<Department, DepartmentDTO> getMapper() {
        return mapper;
    }

    @Override
    protected Department.Builder getEntityBuilder() {
        return new Department.Builder();
    }
}