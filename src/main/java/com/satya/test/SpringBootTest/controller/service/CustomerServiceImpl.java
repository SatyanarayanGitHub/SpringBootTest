package com.satya.test.SpringBootTest.controller.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.satya.test.SpringBootTest.bean.CustomerBean;
import com.satya.test.SpringBootTest.bean.CustomerGroupByTag;
import com.satya.test.SpringBootTest.controller.repository.CustomerRepository;
import com.satya.test.SpringBootTest.entity.Customer;
import com.satya.test.SpringBootTest.utility.Tag;

/**
 * 
 * @author SATYA
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;

	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public List<CustomerBean> getAllCustomer(Pageable pageable) {
		Page<Customer> findAll = this.customerRepository.findAll(pageable);
		List<CustomerBean> customerBeans = findAll.getContent().stream().map(CustomerBean::new)
				.collect(Collectors.toList());

		return customerBeans;
	}

	@Override
	public List<CustomerGroupByTag> getAllCustomerGroupByTag() {

		List<CustomerGroupByTag> CustomerGroupByTags = new ArrayList<CustomerGroupByTag>();
		
		List<CustomerBean> customerVip = new ArrayList<CustomerBean>();
		List<CustomerBean> customerPromter = new ArrayList<CustomerBean>();
		List<CustomerBean> customerRed = new ArrayList<CustomerBean>();
		List<CustomerBean> customerOrange = new ArrayList<CustomerBean>();

		List<Customer> customers = this.customerRepository.findAll();
		
		for (Customer customer : customers) {
			System.out.println("Customer :: "+customer);
			if (customer.getCustomerTag().getTagName().equals(Tag.VIP.name()))
				customerVip.add(new CustomerBean(customer));
			else if (customer.getCustomerTag().getTagName().equals(Tag.PROMOTER.name()))
				customerPromter.add(new CustomerBean(customer));
			else if (customer.getCustomerTag().getTagName().equals(Tag.RED.name()))
				customerRed.add(new CustomerBean(customer));
			else if (customer.getCustomerTag().getTagName().equals(Tag.ORANGE.name()))
				customerOrange.add(new CustomerBean(customer));
		}

		CustomerGroupByTags.add(new CustomerGroupByTag(Tag.VIP, customerVip));
		CustomerGroupByTags.add(new CustomerGroupByTag(Tag.PROMOTER, customerPromter));
		CustomerGroupByTags.add(new CustomerGroupByTag(Tag.RED, customerRed));
		CustomerGroupByTags.add(new CustomerGroupByTag(Tag.ORANGE, customerOrange));

		return CustomerGroupByTags;
	}

}
