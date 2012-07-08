package org.krams.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.krams.domain.Message;
import org.krams.domain.UploadedFile;
import org.krams.response.StatusResponse;
import org.krams.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/email")
public class EmailController {

	private static Logger logger = Logger.getLogger("controller");
	
	@Value("${temp.dir}")
	private String tempDirectory;
	
	@Autowired
	private EmailService emailService;
	
	@RequestMapping
	public String form() {
		return "form";
	}
	
	@RequestMapping(value ="/send", method=RequestMethod.POST)
	public @ResponseBody StatusResponse send(@RequestBody Message message) {
		return emailService.send(message);
	}
	
	@RequestMapping(value="/fileupload", method=RequestMethod.POST)
	public @ResponseBody List<UploadedFile> upload(
			@RequestParam("file") MultipartFile file) {
		
		logger.debug(file.getOriginalFilename() + " - " + file.getSize());
		
		try {
			File f = new File(tempDirectory+File.separator+file.getOriginalFilename());
			FileOutputStream fos = new FileOutputStream(f);
			fos.write(file.getBytes());
			fos.close();
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
		
		List<UploadedFile> uploadedFiles = new ArrayList<UploadedFile>();
		UploadedFile u = new UploadedFile();
		u.setName(file.getOriginalFilename());
		u.setSize(Long.valueOf(file.getSize()).intValue());
		uploadedFiles.add(u);
		
		return uploadedFiles;
	}
}