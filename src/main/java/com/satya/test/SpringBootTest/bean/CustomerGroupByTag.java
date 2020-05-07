package com.satya.test.SpringBootTest.bean;

import java.util.List;

import com.satya.test.SpringBootTest.utility.Tag;

/**
 * 
 * @author SATYA
 *
 */
public class CustomerGroupByTag {

	private Tag tag;
	List<CustomerBean> customerBeans;

	public CustomerGroupByTag(String tagName, List<CustomerBean> customers) {

	}

	public CustomerGroupByTag(Tag tag, List<CustomerBean> customerBeans) {
		super();
		this.tag = tag;
		this.customerBeans = customerBeans;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public List<CustomerBean> getCustomerBeans() {
		return customerBeans;
	}

	public void setCustomerBeans(List<CustomerBean> customerBeans) {
		this.customerBeans = customerBeans;
	}

}
