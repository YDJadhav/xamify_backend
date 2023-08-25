package com.xamify.springjwt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xamify.springjwt.models.CreateCourse;
import com.xamify.springjwt.repository.CourseRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class CourseController {

	@Autowired
	CourseRepository CourseRepository;

	@RestController
	@RequestMapping("/course")
	public class TutorialController {

		@PostMapping("/write")
		public ResponseEntity<CreateCourse> createTutorial(@RequestBody CreateCourse tutorial) {
			try {
				CreateCourse _tutorial = CourseRepository.save(new CreateCourse(tutorial.getcoursename(),
						tutorial.getcourseid(), tutorial.getDuration(), tutorial.getcollegeid()));
				return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

	}

}
