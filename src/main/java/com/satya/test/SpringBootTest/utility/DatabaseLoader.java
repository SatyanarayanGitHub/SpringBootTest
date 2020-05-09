package com.satya.test.SpringBootTest.utility;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.satya.test.SpringBootTest.controller.repository.CustomerRepository;
import com.satya.test.SpringBootTest.controller.repository.CustomerTagRepository;
import com.satya.test.SpringBootTest.entity.Customer;
import com.satya.test.SpringBootTest.entity.CustomerTag;

/**
 * 
 * @author SATYA
 *
 */

@Component
public class DatabaseLoader implements CommandLineRunner {

	private CustomerRepository customerRepository;

	private CustomerTagRepository customerTagRepository;

	public DatabaseLoader(CustomerRepository customerRepository, CustomerTagRepository customerTagRepository) {
		super();
		this.customerRepository = customerRepository;
		this.customerTagRepository = customerTagRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		CustomerTag vip = new CustomerTag(Tag.VIP.name());
		CustomerTag promoter = new CustomerTag(Tag.PROMOTER.name());
		CustomerTag red = new CustomerTag(Tag.RED.name());
		CustomerTag orange = new CustomerTag(Tag.ORANGE.name());

		List<CustomerTag> tags = Arrays.asList(vip, promoter, red, orange);
		this.customerTagRepository.saveAll(tags);

		
		Customer c1 = new Customer("Satya", "Yadav", "satya@gmail.com", Status.PROSPECTS.name(), 168324586L, 0L, vip);
		Customer c2 = new Customer("Thompson", "Morris", "thompson@gmail.com", Status.PROSPECTS.name(), 123664586L, 0L,	vip);
		Customer c3 = new Customer("Jardine", "Patel", "jardine@gmail.com", Status.PROSPECTS.name(), 162865196L, 0L, red);
		Customer c4 = new Customer("John", "Dean", "John@gmail.com", Status.PROSPECTS.name(), 162864786L, 0L, vip);
		Customer c5 = new Customer("Morgan", "Maxwell", "morgan@gmail.com", Status.CUSTOMER.name(), 122864586L, 162114586L, promoter);
		Customer c6 = new Customer("Kivel", "Patil", "kivel@gmail.com", Status.PROSPECTS.name(), 82864586L, 0L, vip);
		Customer c7 = new Customer("Howard", "Jadav", "howard@gmail.com", Status.LEADS.name(), 0L, 0L, red);
		Customer c8 = new Customer("Sanju", "Gill", "gill@gmail.com", Status.PROSPECTS.name(), 155864856L, 0L, orange);
		Customer c9 = new Customer("Smith", "Peterson", "smith@gmail.com", Status.CUSTOMER.name(), 114841286L, 94841286L, promoter);
		Customer c10 = new Customer("Andrews", "wagh", "andrews@gmail.com", Status.LEADS.name(), 0L, 0L, vip);
		Customer c11 = new Customer("Morgan", "Kapoor", "morgan@gmail.com", Status.PROSPECTS.name(), 162864586L, 0L, red);
		Customer c12 = new Customer("Teddy", "den", "teddy@gmail.com", Status.PROSPECTS.name(), 62864586L, 0L, orange);
		Customer c13 = new Customer("David", "Starc", "david@gmail.com", Status.LEADS.name(), 0L, 0L, vip);
		Customer c14 = new Customer("Glenn", "Warner", "glen@gmail.com", Status.CUSTOMER.name(), 92464536L, 162864586L,	vip);
		Customer c15 = new Customer("Marcus", "Stoinis", "marcus@gmail.com", Status.PROSPECTS.name(), 151464586L, 0L, orange);

		// Add all customer
		List<Customer> customers = Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15);
		this.customerRepository.saveAll(customers);
		
		

	}

}
