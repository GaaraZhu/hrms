package com.jisiben.hrms.controller;

import com.jisiben.hrms.controller.dto.CandidateDTO;
import com.jisiben.hrms.controller.dto.mapper.common.Mapper;
import com.jisiben.hrms.domain.entity.Candidate;
import com.jisiben.hrms.domain.entity.common.JobApplicationStatus;
import com.jisiben.hrms.service.CandidateService;
import com.jisiben.hrms.service.JobApplicationService;
import com.poiji.bind.Poiji;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Controller
public class MiscellaneousController {

    protected Logger logger = Logger.getLogger(this.getClass().getSimpleName());

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private JobApplicationService jobApplicationService;

    @Autowired
    @Qualifier("candidateEntityDTOMapper")
    private Mapper<Candidate, CandidateDTO> mapper;

    @RequestMapping(value = "/uploadData", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void uploadFile(Model model, String uploadDataType, MultipartFile file) throws IOException {
        InputStream in = file.getInputStream();
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        String fileLocation = path.substring(0, path.length() - 1) + file.getOriginalFilename();
        FileOutputStream f = new FileOutputStream(fileLocation);
        int ch = 0;
        while ((ch = in.read()) != -1) {
            f.write(ch);
        }
        f.flush();
        f.close();
        logger.info("Upload file successfully: "+ fileLocation);

        List<CandidateDTO> candidateDTOs = Poiji.fromExcel(new File(fileLocation), CandidateDTO.class);
        List<Candidate> candidates = candidateDTOs.stream()
                .map((CandidateDTO dto)->mapper.toEntity(dto, new Candidate.Builder().build()))
                .collect(Collectors.toList());
        candidateService.saveAll(candidates);

        logger.info("Total candidate count: "+ candidateDTOs.size());
    }

    @RequestMapping(value = "/migrateData", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void migrateUserData(@RequestParam String originalUserId, @RequestParam String targetUserId) {
        candidateService.migrateCandidates(Long.parseLong(originalUserId), Long.parseLong(targetUserId));
        jobApplicationService.migrateJobApplications(Long.parseLong(originalUserId), Long.parseLong(targetUserId));
    }
}
