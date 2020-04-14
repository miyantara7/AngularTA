package com.lawencon.elearning.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.lawencon.elearning.model.Materi;
import com.lawencon.elearning.service.MateriService;

@RestController
@CrossOrigin("*")
public class MateriController extends BaseController<Materi> {

	@Autowired
	private MateriService materiService;

	@PostMapping("/upload/materi")
	public ResponseEntity<?> uploadMateri(@RequestParam("file") MultipartFile file, @RequestParam("name") String name) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			Materi materi = new Materi();
			materi.setJudulMateri(name);
			materi.setTypeFile(file.getContentType());
			materi.setFileMateri(file.getBytes());
			materi.setActiveflag("ACTIVE");
			materiService.insertMateri(materi);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/files/download/")
				.path(fileName).path("/db").toUriString();
		return ResponseEntity.ok(fileDownloadUri);
	}

	@GetMapping("/materi")
	public ResponseEntity<?> getMateriByWeekAndDay(@RequestParam("week") int week, @RequestParam("day") int day, @RequestParam("id") String id) {
		List<Materi> listMateri = new ArrayList<>();
		try {
			listMateri = materiService.findByWeekAndDay(week, day, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(listMateri.get(0).getTypeFile()))
		.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + listMateri.get(0).getJudulMateri() + "\"")
		.body(listMateri.get(0).getFileMateri());
	}
	
	@GetMapping("/viewall")
	public ResponseEntity<?> getMateriAll(@RequestParam("week") int week, @RequestParam("day") int day) {
		List<Materi> listMateri = new ArrayList<>();
		try {
			listMateri = materiService.findAll(week, day);
			return new ResponseEntity<>(listMateri, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(listMateri, HttpStatus.BAD_REQUEST);
	}

}
