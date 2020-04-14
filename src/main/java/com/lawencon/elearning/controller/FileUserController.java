package com.lawencon.elearning.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.lawencon.elearning.model.FileUser;
import com.lawencon.elearning.service.FileUserService;
@RestController
@CrossOrigin("*")
public class FileUserController extends BaseController<FileUser> {

	@Autowired
	private FileUserService fileUserService;

	@PostMapping("/upload/user")
	public ResponseEntity<?> uploadTask(@RequestParam("file") MultipartFile file) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			FileUser fileTask = new FileUser();
			fileTask.setFile(file.getBytes());
			fileTask.setFileName(fileName);
			fileTask.setFileType(file.getContentType());
			fileUserService.insert(fileTask);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/files/download/")
				.path(fileName).path("/db").toUriString();
		return ResponseEntity.ok(fileDownloadUri);
	}
	
	@GetMapping("download/user")
	public void zipDownload() {
		try {
			List<FileUser> list = fileUserService.findAll();
			list.forEach(x->{
				
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}

}
