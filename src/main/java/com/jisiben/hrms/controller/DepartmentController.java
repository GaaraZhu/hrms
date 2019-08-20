package com.jisiben.hrms.controller;

import javax.annotation.Resource;
import javax.ws.rs.Produces;

import com.google.common.collect.Streams;
import com.jisiben.hrms.controller.dto.DepartmentDTO;
import com.jisiben.hrms.controller.dto.PageableSearchResultDTO;
import com.jisiben.hrms.domain.entity.Department;
import com.jisiben.hrms.service.DepartmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Controller
public class DepartmentController {
    @Resource
    private DepartmentService departmentService;

    private Logger logger = Logger.getLogger(DepartmentController.class.getSimpleName());

    @ResponseBody
    @Produces("application/json")
    @RequestMapping(value = "/departments", method = RequestMethod.GET)
    public PageableSearchResultDTO<DepartmentDTO> findAll(@RequestParam("currentPage") int currentPage,
                                                          @RequestParam("pageSize") int pageSize) {
        Page<Department> allDepartments = getDepartmentService()
                .findAll(new PageRequest(currentPage-1, pageSize));
        List<DepartmentDTO> ds = Streams.stream(allDepartments.iterator())
                .map((Department dep)
                    -> new DepartmentDTO.Builder()
                        .id(dep.getId())
                        .name(dep.getName())
                        .number(dep.getNumber())
                        .manager(dep.getManager())
                        .telephone(dep.getTelephone())
                        .build())
                .collect(Collectors.toList());
        return new PageableSearchResultDTO.Builder<DepartmentDTO>()
                .totalElements(allDepartments.getTotalElements())
                .totalPages(allDepartments.getTotalPages())
                .results(ds)
                .build();
    }

    @ResponseBody
    @RequestMapping(value = "/department", method = RequestMethod.GET)
    public DepartmentDTO find(Long id) { //TODO: optional serialization
        return getDepartmentService()
                .findById(id)
                .map((Department dep)
                        -> new DepartmentDTO.Builder()
                        .id(dep.getId())
                        .name(dep.getName())
                        .number(dep.getNumber())
                        .manager(dep.getManager())
                        .telephone(dep.getTelephone())
                        .build()).get();
    }

    @RequestMapping(value = "/department", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void addDepartment(@RequestBody DepartmentDTO dto) {
        Department dp = new Department.Builder()
                .manager(dto.getManager())
                .name(dto.getName())
                .number(dto.getNumber())
                .telephone(dto.getTelephone())
                .build();
        getDepartmentService().save(dp);
    }

    @RequestMapping(value = "/department", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateDepartment(Long id, @RequestBody DepartmentDTO dto) {
        getDepartmentService().findById(id)
                .ifPresent((Department dep)-> {
                    dep.setName(dto.getName());
                    dep.setNumber(dto.getNumber());
                    dep.setManager(dto.getManager());
                    dep.setTelephone(dto.getTelephone());
                    getDepartmentService().save(dep);
                });
    }

    @RequestMapping(value = "/department", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteDepartment(@RequestParam Long id, ModelMap model) {
        getDepartmentService().delete(id);
        model.put("msg", "部门删除成功");
    }

    public DepartmentService getDepartmentService() {
        return departmentService;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
}