package com.satya.test.SpringBootTest.controller.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.satya.test.SpringBootTest.bean.CustomerBean;
import com.satya.test.SpringBootTest.bean.CustomerGroupByTag;

/**
 * 
 * @author SATYA
 *
 */
public interface CustomerService {

	public List<CustomerBean> getAllCustomer(Pageable pageable);

	public List<CustomerGroupByTag> getAllCustomerGroupByTag();

}
