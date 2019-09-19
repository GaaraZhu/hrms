package com.jisiben.hrms.controller;

import com.jisiben.hrms.domain.entity.Candidate;
import com.jisiben.hrms.service.CandidateService;
import com.jisiben.hrms.service.bean.CandidateBean;
import com.poiji.bind.Poiji;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class UploadController {

    protected Logger logger = Logger.getLogger(this.getClass().getSimpleName());

    @Autowired
    private CandidateService candidateService;

    @RequestMapping(value = "/uploadData", method = RequestMethod.POST)
    public String uploadFile(Model model, MultipartFile file) throws IOException {
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

        List<CandidateBean> candidates = Poiji.fromExcel(new File(fileLocation), CandidateBean.class);

        candidates.forEach((CandidateBean c)->logger.info(c.toString()));

        return "redirect:/index";
    }
}
