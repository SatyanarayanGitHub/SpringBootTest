package com.satya.test.SpringBootTest.controller.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.satya.test.SpringBootTest.bean.AverageTimeBean;
import com.satya.test.SpringBootTest.bean.CustomerBean;
import com.satya.test.SpringBootTest.controller.repository.CustomerRepository;
import com.satya.test.SpringBootTest.entity.Customer;
import com.satya.test.SpringBootTest.utility.TestUtility;

/**
 * 
 * @author SATYA
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private TestUtility testUtility;

	private CustomerRepository customerRepository;

	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public List<CustomerBean> getAllCustomers(Pageable pageable) {
		Page<Customer> customers = this.customerRepository.findAll(pageable);
		List<CustomerBean> customerBeans = customers.getContent().stream().map(CustomerBean::new)
				.collect(Collectors.toList());

		return customerBeans;
	}

	@Override
	public List<CustomerBean> getAllCustomers() {
		List<Customer> customers = this.customerRepository.findAll();
		return customers.stream().map(CustomerBean::new).collect(Collectors.toList());
	}

	@Override
	public AverageTimeBean averageProspectTime(long prospectTime) {

		List<Customer> customers = this.customerRepository.findByProspectTimeGreaterThan(prospectTime);

		//customers.stream().forEach(customer -> System.out.println(customer));

		System.out.println("Size :: " + customers.size());
		long totalProspectTime = customers.stream().map(customer -> customer.getProspectTime()).reduce(0L,
				(pt1, pt2) -> pt1 + pt2);
		System.out.println("Size :: " + customers.size() + "\t Total Time : " + totalProspectTime);

		return testUtility.convertTime((totalProspectTime / customers.size()));
	}

	@Override
	public AverageTimeBean averageCustomerTime(long customerTime) {
		List<Customer> customers = this.customerRepository.findByCustomerTimeGreaterThan(customerTime);

		customers.stream().forEach(customer -> System.out.println(customer));

		System.out.println("Size :: " + customers.size());
		long totalCustomerTime = customers.stream().map(customer -> customer.getCustomerTime()).reduce(0L,
				(pt1, pt2) -> pt1 + pt2);
		System.out.println("Size :: " + customers.size() + "\t Total Time : " + totalCustomerTime);

		return testUtility.convertTime((totalCustomerTime / customers.size()));
	}

}
