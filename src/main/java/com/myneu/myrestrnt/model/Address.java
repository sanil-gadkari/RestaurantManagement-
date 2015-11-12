package com.myneu.myrestrnt.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name= "address")
public class Address implements Serializable{
	@Id
	@GeneratedValue
	private int address_id;
	@Column
	private String street;
	@Column
	private String apt_no;
	@Column
	private int zip_code;
	@Column
	private String state;
	@ManyToMany(mappedBy = "addressList")
	private Set<Customer> customerList = new HashSet<Customer>();
	
	public String getStreet() {
		return street;
	}
	
	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public Set<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(Set<Customer> customerList) {
		this.customerList = customerList;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	public String getApt_no() {
		return apt_no;
	}
	public void setApt_no(String apt_no) {
		this.apt_no = apt_no;
	}
	public int getZip_code() {
		return zip_code;
	}
	public void setZip_code(int zip_code) {
		this.zip_code = zip_code;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	

}