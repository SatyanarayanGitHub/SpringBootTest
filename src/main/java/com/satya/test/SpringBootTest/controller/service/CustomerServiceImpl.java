package com.satya.test.SpringBootTest.controller.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.satya.test.SpringBootTest.bean.CustomerBean;
import com.satya.test.SpringBootTest.controller.repository.CustomerRepository;
import com.satya.test.SpringBootTest.entity.Customer;

/**
 * 
 * @author SATYA
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

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

}
