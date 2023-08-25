package com.xamify.springjwt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xamify.springjwt.models.Department;
import com.xamify.springjwt.repository.DepartmentRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class DepartmentController {

	@Autowired
	DepartmentRepository departmentRepository;

	@RestController
	@RequestMapping("/department")
	public class TutorialController {

		@PostMapping("/write")
		public ResponseEntity<Department> createTutorial(@RequestBody Department tutorial) {
			try {
				Department _tutorial = departmentRepository.save(new Department(tutorial.getdepartmentname(),
						tutorial.getdepartmentid(), tutorial.getcollegeid()));
				return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

	}

}
