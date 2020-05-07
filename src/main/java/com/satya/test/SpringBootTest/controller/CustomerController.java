package com.satya.test.SpringBootTest.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satya.test.SpringBootTest.bean.CustomerBean;
import com.satya.test.SpringBootTest.bean.CustomerGroupByTag;
import com.satya.test.SpringBootTest.controller.service.CustomerService;
import com.satya.test.SpringBootTest.entity.Customer;

@RestController
@RequestMapping("/restapi")
public class CustomerController {

	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	@GetMapping(value = "hello")
	public String sayHello() {
		return "BE Spring Boot - Hello";
	}

	@GetMapping(value = "customers/{pageNo}/{pageSize}")
	public List<CustomerBean> getAll(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize) {

		Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by("firstName").and(Sort.by("LastName")));
		return this.customerService.getAllCustomer(pageable);
	}

	@GetMapping(value = "customersGroupByTag")
	public List<CustomerGroupByTag> getAllGroupByTag() {
		return this.customerService.getAllCustomerGroupByTag();

	}

}
