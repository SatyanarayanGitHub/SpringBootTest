package com.satya.test.SpringBootTest.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	@Column(name = "CUSTOMERTAG_ID", updatable = false)
	private Integer id;

	@Column(name = "tagName")
	private String tagName;

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

}
