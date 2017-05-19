package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<EmployeeRecord> getAllEmployees() {
		List<EmployeeRecord> employeeRecords = new ArrayList<>();
		employeeRepository.findAll().forEach(employeeRecords::add);
		return employeeRecords;
	}

	public EmployeeRecord getEmployee(String id) {
		return employeeRepository.findOne(id);
	}

	public void addEmployee(EmployeeRecord employeeRecord) {
		employeeRepository.save(employeeRecord);
	}

	public void delete(String id) {
		employeeRepository.delete(id);
	}

}