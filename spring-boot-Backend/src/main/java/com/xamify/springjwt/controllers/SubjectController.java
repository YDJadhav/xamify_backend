package com.xamify.springjwt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xamify.springjwt.models.Subject;
import com.xamify.springjwt.repository.SubjectRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class SubjectController {

	@Autowired
	SubjectRepository subjectRepository;

	@RestController
	@RequestMapping("/subject")
	public class TutorialController {

		@PostMapping("/write")
		public ResponseEntity<Subject> createTutorial(@RequestBody Subject tutorial) {
			try {
				Subject _tutorial = subjectRepository.save(new Subject(tutorial.getsubjectname(),
						tutorial.getsubjectid(), tutorial.getcourseid(), tutorial.getcollegeid()));
				return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

	}

}
