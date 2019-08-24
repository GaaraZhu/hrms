package com.jisiben.hrms.controller;

import javax.annotation.Resource;
import javax.ws.rs.Produces;

import com.google.common.collect.Streams;
import com.jisiben.hrms.controller.dto.DepartmentDTO;
import com.jisiben.hrms.controller.dto.PageableSearchResultDTO;
import com.jisiben.hrms.controller.dto.mapper.DepartmentDTOMapper;
import com.jisiben.hrms.domain.entity.Department;
import com.jisiben.hrms.service.DepartmentService;
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
public class DepartmentController {
    @Resource
    private DepartmentService departmentService;

    private Logger logger = Logger.getLogger(DepartmentController.class.getSimpleName());

    @ResponseBody
    @Produces("application/json")
    @RequestMapping(value = "/departments", method = RequestMethod.GET)
    public PageableSearchResultDTO<DepartmentDTO> findAll(
            @RequestParam("depNum") String depNumber,
            @RequestParam("depName") String depName,
            @RequestParam("currentPage") int currentPage,
            @RequestParam("pageSize") int pageSize) {
        PageRequest pageRequest = new PageRequest(currentPage-1, pageSize);
        Page<Department> allDepartments = Arrays.asList(depNumber, depName)
                .stream()
                .filter(Objects::nonNull)
                .findAny()
                .map((String s)->getDepartmentService()
                        .search(depNumber, depName, pageRequest))
                .orElse(getDepartmentService()
                        .findAll(pageRequest));
        List<DepartmentDTO> ds = Streams.stream(allDepartments.iterator())
                .map(DepartmentDTOMapper::map)
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
                .map(DepartmentDTOMapper::map).orElse(new DepartmentDTO());
    }

    @RequestMapping(value = "/department", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void add(@RequestBody DepartmentDTO dto) {
        getDepartmentService().save(new Department.Builder()
                .manager(dto.getManager())
                .name(dto.getName())
                .number(dto.getNumber())
                .telephone(dto.getTelephone())
                .build());
    }

    @RequestMapping(value = "/department", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void update(Long id, @RequestBody DepartmentDTO dto) {
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
    public void delete(@RequestParam Long id, ModelMap model) {
        getDepartmentService().delete(id);
    }

    public DepartmentService getDepartmentService() {
        return departmentService;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
}