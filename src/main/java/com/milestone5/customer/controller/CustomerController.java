package com.milestone5.customer.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.milestone5.customer.exception.ResourceNotFoundException;
import com.milestone5.customer.model.Customer;
import com.milestone5.customer.repository.CustomerRepository;


@RestController
//@CrossOrigin(origins="http://localhost:4200/")
@RequestMapping("/api/v1")
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	//get all employees
	@GetMapping("/customers")
	public List<Customer> getAllEmployees(){
		return customerRepository.findAll();
	}
	
	//create employee rest api
	@PostMapping("/customers")
	public Customer createEmployee(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}
	
	//get employee by id rest api
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getEmployeeById(@PathVariable int id){
		Customer customer=customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with this id"+id));
		return ResponseEntity.ok(customer);
	}
	
	//update employee
	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updateEmployee(@PathVariable int id, @RequestBody Customer customerDetails) {
		Customer employee=customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with this id"+id));
		employee.setName(customerDetails.getName());
		employee.setGender(customerDetails.getGender());
		employee.setAge(customerDetails.getAge());
		employee.setPrefferedFood(customerDetails.getPrefferedFood());
		
		Customer updateEmployee=customerRepository.save(employee);
		return ResponseEntity.ok(updateEmployee);
	}
	
	//delete employee rest api
	@DeleteMapping("/customers/{id}")
	private ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable int id){
		Customer customer=customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with this id"+id));
	     customerRepository.delete(customer);
	     Map<String,Boolean> response= new HashMap<>();
	     response.put("Deleted", Boolean.TRUE);
	     return ResponseEntity.ok(response);
		}
	

}
