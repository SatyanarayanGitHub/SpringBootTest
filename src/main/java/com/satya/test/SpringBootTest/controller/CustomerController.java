package com.satya.test.SpringBootTest.controller;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satya.test.SpringBootTest.bean.CustomerBean;
import com.satya.test.SpringBootTest.controller.service.CustomerService;
import com.satya.test.SpringBootTest.controller.service.CustomerTagService;
import com.satya.test.SpringBootTest.entity.CustomerTag;

@RestController
@RequestMapping("/restapi")
public class CustomerController {

	private CustomerService customerService;
	private CustomerTagService customerTagService;

	public CustomerController(CustomerService customerService, CustomerTagService customerTagService) {
		this.customerService = customerService;
		this.customerTagService = customerTagService;
	}

	@GetMapping(value = "hello")
	public String sayHello() {
		return "BE Spring Boot - Hello";
	}

	@GetMapping(value = "customers/{pageNo}/{pageSize}")
	public List<CustomerBean> getAllCustomer(@PathVariable("pageNo") int pageNo,
			@PathVariable("pageSize") int pageSize) {

		Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by("firstName").and(Sort.by("LastName")));
		return this.customerService.getAllCustomers(pageable);
	}

	@GetMapping(value = "customers")
	public List<CustomerBean> getAllCustomer() {
		return this.customerService.getAllCustomers();

	}

	@GetMapping(value = "customersGroupByTag")
	public List<CustomerTag> getAllCustomerGroupByTag() {
		return this.customerTagService.getAllTags();
	}

	

}
