package com.satya.test.SpringBootTest.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author SATYA
 *
 */

@Table(name = "CUSTOMER")
@Entity
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "CUSTOMER_ID", updatable = false)
	private Integer id;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "CUSTOM_LABEL")
	private String customLabel;

	@Column(name = "CUSTOM_FIELD")
	private String customField;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "PROSPECT_TIME")
	private Long prospectTime;

	@Column(name = "CUSTOMER_TIME")
	private Long customerTime;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "customerTagId", nullable = false)
	@JsonIgnore
	private CustomerTag customerTag;

	public Customer() {
		super();
	}

	public Customer(String firstName, String lastName, String email, String status, Long prospectTime,
			Long customerTime, CustomerTag customerTag) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.status = status;
		this.prospectTime = prospectTime;
		this.customerTime = customerTime;
		this.customerTag = customerTag;
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

	public CustomerTag getCustomerTag() {
		return customerTag;
	}

	public void setCustomerTag(CustomerTag customerTag) {
		this.customerTag = customerTag;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", customLabel=" + customLabel + ", customField=" + customField + ", status=" + status
				+ ", prospectTime=" + prospectTime + ", customerTime=" + customerTime + ", customerTag=" + customerTag
				+ "]";
	}
}
