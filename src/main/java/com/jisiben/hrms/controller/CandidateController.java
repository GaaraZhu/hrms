package com.jisiben.hrms.controller;

import com.google.common.collect.ImmutableMap;
import com.jisiben.hrms.controller.common.AbstractController;
import com.jisiben.hrms.controller.dto.CandidateDTO;
import com.jisiben.hrms.controller.dto.PageableSearchResultDTO;
import com.jisiben.hrms.controller.dto.mapper.common.Mapper;
import com.jisiben.hrms.domain.entity.Candidate;
import com.jisiben.hrms.service.CandidateService;
import com.jisiben.hrms.service.common.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import java.util.Optional;
import java.util.logging.Logger;

@Controller
public class CandidateController extends AbstractController<Candidate, CandidateDTO, Candidate.Builder> {

    @Autowired
    private CandidateService candidateService;

    @Autowired
    @Qualifier("candidateEntityDTOMapper")
    private Mapper<Candidate, CandidateDTO> mapper;

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
        return doFindAll(
                ImmutableMap.of(
                "name", Optional.ofNullable(name),
                "phone", Optional.ofNullable(phone),
                "city", Optional.ofNullable(city)), currentPage, pageSize);
    }

    @ResponseBody
    @RequestMapping(value = "/candidate", method = RequestMethod.GET)
    public CandidateDTO find(Long id) {
        return doFind(id);
    }

    @RequestMapping(value = "/candidate", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void add(@RequestBody CandidateDTO dto) {
        doAdd(dto);
    }

    @RequestMapping(value = "/candidate", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void update(Long id, @RequestBody CandidateDTO dto) {
        doUpdate(id, dto);
    }

    @RequestMapping(value = "/candidate", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@RequestParam Long id, ModelMap model) {
        doDelete(id);
    }

    @Override
    protected Service<Candidate> getService() {
        return candidateService;
    }

    @Override
    protected Mapper<Candidate, CandidateDTO> getMapper() {
        return mapper;
    }

    @Override
    protected Candidate.Builder getEntityBuilder() {
        return new Candidate.Builder();
    }
}
