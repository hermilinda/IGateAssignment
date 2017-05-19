package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@Autowired
	private ApplicationService employeeService;

	@RequestMapping("/view-employee")
	public List<EmployeeRecord> getAllEmployee() {
		return employeeService.getAllEmployees();
	}

	@RequestMapping(value = "/add-employee", method = RequestMethod.POST)
	public String addEmployee(@RequestBody EmployeeRecord employeeRecord) {
		employeeService.addEmployee(employeeRecord);
		return "Employee Added Successfully";
	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	public EmployeeRecord getEmployee(@PathVariable String id) {
		return employeeService.getEmployee(id);
	}

	@RequestMapping(value = "/delete-employee/{id}", method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable String id) {
		employeeService.delete(id);
		return "Employee Deleted Successfully";
	}

	@RequestMapping(value = "/update-employee", method = RequestMethod.POST)
	public String updateEmployee(@RequestBody EmployeeRecord employeeRecord) {
		String result;
		EmployeeRecord record = employeeService.getEmployee(employeeRecord.getId());
		if (record.equals(null) || record.equals("")) {
			result = "Employee Not Found";
		} else {
			employeeService.addEmployee(employeeRecord);
			result = "Employee Updated Successfully";
		}

		return result;
	}
}