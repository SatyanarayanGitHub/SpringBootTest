package com.satya.test.SpringBootTest.controller;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.satya.test.SpringBootTest.bean.AverageTimeBean;
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

	@GetMapping(value = "customers/all")
	public List<CustomerBean> getAllCustomer() {
		return this.customerService.getAllCustomers();

	}

	@GetMapping(value = "customers")
	public List<CustomerBean> getAllCustomer(@RequestParam("pageNo") int pageNo,
			@RequestParam("pageSize") int pageSize) {
		System.out.println("PageNo: " + pageNo + "\tPageSize: " + pageSize);

		if (pageNo > 0) {
			Pageable pageable = PageRequest.of((pageNo - 1), pageSize, Sort.by("firstName").and(Sort.by("LastName")));
			return this.customerService.getAllCustomers(pageable);
		} else
			throw new IllegalArgumentException("Page index must not be less than one!");

	}

	@GetMapping(value = "customersGroupByTag")
	public List<CustomerTag> getAllCustomerGroupByTag() {
		return this.customerTagService.getAllTags();
	}

	@GetMapping(value = "averageProspectTime")
	public AverageTimeBean calculateAverageProspectTime() {

		return this.customerService.averageProspectTime(0);
	}

	@GetMapping(value = "averageCustomerTime")
	public AverageTimeBean calculateAverageCustomerTime() {

		return this.customerService.averageCustomerTime(0);
	}

}
