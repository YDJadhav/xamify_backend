package com.xamify.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xamify.springjwt.models.CreateAdmin;

public interface CollegeAdminRepository extends JpaRepository<CreateAdmin, Integer> {

}
