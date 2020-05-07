package com.satya.test.SpringBootTest.controller.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.satya.test.SpringBootTest.controller.repository.CustomerTagRepository;
import com.satya.test.SpringBootTest.entity.CustomerTag;

/**
 * 
 * @author SATYA
 *
 */
@Service
public class CustomerTagServiceImpl implements CustomerTagService {

	private CustomerTagRepository customerTagRepository;

	public CustomerTagServiceImpl(CustomerTagRepository customerTagRepository) {
		this.customerTagRepository = customerTagRepository;
	}

	@Override
	public List<CustomerTag> getAllTags() {
		return customerTagRepository.findAll();
	}

}
