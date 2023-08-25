package com.xamify.springjwt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xamify.springjwt.models.CreateCollege;
import com.xamify.springjwt.repository.CreateCollegeRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class CreateCollegeController {

	@Autowired
	CreateCollegeRepository CreateCollegeRepository;

	@RestController
	@RequestMapping("/superAdmin")
	public class TutorialController {

		@PostMapping("/write")
		public ResponseEntity<CreateCollege> createTutorial(@RequestBody CreateCollege tutorial) {
			try {
				CreateCollege _tutorial = CreateCollegeRepository.save(new CreateCollege(tutorial.getCollegeName(),
						tutorial.getcollegeid(), tutorial.getCollegeLocation(), tutorial.getCollegeEmaill(),
						tutorial.getcollegeStatus()));
				return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

	}

}
