package com.employeemanagementproject.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeemanagementproject.demo.entity.Employee;

@Repository
public interface Empolyee_Repo extends JpaRepository <Employee , Integer> {

}
