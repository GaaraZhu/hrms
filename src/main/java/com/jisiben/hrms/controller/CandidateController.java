package com.jisiben.hrms.controller;

import com.google.common.collect.Streams;
import com.jisiben.hrms.controller.dto.CandidateDTO;
import com.jisiben.hrms.controller.dto.PageableSearchResultDTO;
import com.jisiben.hrms.domain.entity.Candidate;
import com.jisiben.hrms.service.CandidateService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.ws.rs.Produces;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Controller
public class CandidateController {

    @Resource
    private CandidateService candidateService;

    private Logger logger = Logger.getLogger(CandidateController.class.getSimpleName());

    @ResponseBody
    @Produces("application/json")
    @RequestMapping(value = "/candidates", method = RequestMethod.GET)
    public PageableSearchResultDTO<CandidateDTO> findAll(
            @RequestParam("name") String name,
            @RequestParam("phone") String phone,
            @RequestParam("city") String city,
            @RequestParam("currentPage") int currentPage,
            @RequestParam("pageSize") int pageSize) {
        PageRequest pageRequest = new PageRequest(currentPage-1, pageSize);
        Page<Candidate> allCandidates = Arrays.asList(name, phone, city)
                .stream()
                .filter(Objects::nonNull)
                .findAny()
                .map((String s)->getCandidateService()
                        .search(name, phone, city, pageRequest))
                .orElse(getCandidateService()
                        .findAll(pageRequest));
        List<CandidateDTO> ds = Streams.stream(allCandidates.iterator())
                .map(CandidateDTO::map)
                .collect(Collectors.toList());
        return new PageableSearchResultDTO.Builder<CandidateDTO>()
                .totalElements(allCandidates.getTotalElements())
                .totalPages(allCandidates.getTotalPages())
                .results(ds)
                .build();
    }

    @ResponseBody
    @RequestMapping(value = "/candidate", method = RequestMethod.GET)
    public CandidateDTO find(Long id) { //TODO: optional serialization
        return getCandidateService()
                .findById(id)
                .map(CandidateDTO::map).orElse(new CandidateDTO());
    }

    @RequestMapping(value = "/candidate", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void add(@RequestBody CandidateDTO dto) {
        getCandidateService().save(new Candidate.Builder()
                .name(dto.getName())
                .phone(dto.getPhone())
                .idNumber(dto.getIdNumber())
                .gender(dto.getGender())
                .city(dto.getCity())
                .address(dto.getAddress())
                .build());
    }

    @RequestMapping(value = "/candidate", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void update(Long id, @RequestBody CandidateDTO dto) {
        getCandidateService().findById(id)
                .ifPresent((Candidate c)-> {
                    c.setName(dto.getName());
                    c.setPhone(dto.getPhone());
                    c.setIdNumber(dto.getIdNumber());
                    c.setGender(dto.getGender());
                    c.setCity(dto.getCity());
                    c.setAddress(dto.getAddress());
                    getCandidateService().save(c);
                });
    }

    @RequestMapping(value = "/candidate", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@RequestParam Long id, ModelMap model) {
        getCandidateService().delete(id);
    }

    public CandidateService getCandidateService() {
        return candidateService;
    }

    public void setCandidateService(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
