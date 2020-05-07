package com.satya.test.SpringBootTest.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.satya.test.SpringBootTest.entity.CustomerTag;

/**
 * 
 * @author SATYA
 *
 */
@Repository
public interface CustomerTagRepository extends JpaRepository<CustomerTag, Integer> {
}
