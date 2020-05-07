package com.satya.test.SpringBootTest.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.satya.test.SpringBootTest.entity.Customer;

/**
 * 
 * @author SATYA
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
