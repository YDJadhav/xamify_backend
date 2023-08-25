package com.xamify.springjwt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xamify.springjwt.models.CreateAdmin;
import com.xamify.springjwt.repository.CollegeAdminRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class CreateAdminController {

	@Autowired
	CollegeAdminRepository collegeAdminRepository;

	@RestController
	@RequestMapping("/admin")
	public class TutorialController {

		@PostMapping("/write")
		public ResponseEntity<CreateAdmin> createTutorial(@RequestBody CreateAdmin tutorial) {
			try {
				CreateAdmin _tutorial = collegeAdminRepository.save(new CreateAdmin(tutorial.getcollegeadminname(),
						tutorial.getcollegeid(), tutorial.getcollegeadminid(), tutorial.getadminStatus()));
				return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

	}

}
