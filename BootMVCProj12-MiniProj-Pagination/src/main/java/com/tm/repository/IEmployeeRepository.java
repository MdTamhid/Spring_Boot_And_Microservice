package com.tm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tm.entity.Emplyee;

public interface IEmployeeRepository extends JpaRepository<Emplyee, Integer> {

}
