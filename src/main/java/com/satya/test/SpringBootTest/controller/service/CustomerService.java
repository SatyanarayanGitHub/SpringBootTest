package com.satya.test.SpringBootTest.controller.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.satya.test.SpringBootTest.bean.CustomerBean;

/**
 * 
 * @author SATYA
 *
 */
public interface CustomerService {

	public List<CustomerBean> getAllCustomers(Pageable pageable);
	
	public List<CustomerBean> getAllCustomers();

}
