package com.xamify.springjwt.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
  @GetMapping("/all")
  public String allAccess() {
    return "Public Content.";
  }

  @GetMapping("/user")
  @PreAuthorize("hasRole('SuperAdmin') or hasRole('CollegeAdmin') or hasRole('Faculty') or hasRole('Student')")
  public String userAccess() {
    return "User Content.";
  }

  @GetMapping("/SuperAdmin")
  @PreAuthorize("hasRole('SuperAdmin')")
  public String superAdminAccess() {
    return "SuperAdmin Board.";
  }
  @GetMapping("/CollegeAmin")
  @PreAuthorize("hasRole('CollegeAdmin')")
  public String adminAccess() {
    return "CollegeAdmin Board.";
  }

  @GetMapping("/Faculty")
  @PreAuthorize("hasRole('Faculty')")
  public String facultyAccess() {
    return "Faculty Board.";
  }
  @GetMapping("/Student")
  @PreAuthorize("hasRole('Student')")
  public String studentAccess() {
    return "Student Board.";
  }

}
