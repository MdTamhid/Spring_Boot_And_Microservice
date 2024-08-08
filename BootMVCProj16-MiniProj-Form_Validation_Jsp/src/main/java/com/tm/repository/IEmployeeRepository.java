package com.tm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tm.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

}
