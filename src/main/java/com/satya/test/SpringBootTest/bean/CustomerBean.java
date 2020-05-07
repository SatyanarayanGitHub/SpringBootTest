package com.satya.test.SpringBootTest.bean;

import com.satya.test.SpringBootTest.entity.Customer;

public class CustomerBean {

	private Integer id;

	private String firstName;

	private String lastName;

	private String email;

	private String customLabel;

	private String customField;

	private String status;

	private Long prospectTime;

	private Long customerTime;

	private String tag;

	public CustomerBean() {

	}

	public CustomerBean(Customer customer) {
		this.id = customer.getId();
		this.firstName = customer.getFirstName();
		this.lastName = customer.getLastName();
		this.email = customer.getEmail();
		this.customLabel = customer.getCustomLabel();
		this.customField = customer.getCustomField();
		this.status = customer.getStatus();
		this.prospectTime = customer.getProspectTime();
		this.customerTime = customer.getCustomerTime();
		this.tag = customer.getCustomerTag().getTagName();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCustomLabel() {
		return customLabel;
	}

	public void setCustomLabel(String customLabel) {
		this.customLabel = customLabel;
	}

	public String getCustomField() {
		return customField;
	}

	public void setCustomField(String customField) {
		this.customField = customField;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getProspectTime() {
		return prospectTime;
	}

	public void setProspectTime(Long prospectTime) {
		this.prospectTime = prospectTime;
	}

	public Long getCustomerTime() {
		return customerTime;
	}

	public void setCustomerTime(Long customerTime) {
		this.customerTime = customerTime;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	

}
