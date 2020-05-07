package com.satya.test.SpringBootTest.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author SATYA
 *
 */
@Table(name = "CUSTOMER_TAG")
@Entity
public class CustomerTag implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "CUSTOMER_TAG_ID", updatable = false)
	private Integer id;

	@Column(name = "tagName")
	private String tagName;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customerTag")
	private Set<Customer> customers = new HashSet<Customer>();

	public CustomerTag() {
		super();
	}

	public CustomerTag(String tagName) {
		this.tagName = tagName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

}
