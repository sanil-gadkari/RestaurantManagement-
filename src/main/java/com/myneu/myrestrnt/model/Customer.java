package com.myneu.myrestrnt.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn


;
import javax.validation.constraints.Size;
@Entity
@Table(name="customer")
public class Customer implements Serializable{

	
	@Id
	@GeneratedValue
	@Column(name ="c_id")
	private int c_id;
	
	@Column
	
	private String username;
	
	@Column
	private String password;
	

	@Column
	private String confirmPassword;
	
	@Column
	private String gender; 
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private long mobileNo;
	@OneToMany(mappedBy="customer", cascade=CascadeType.ALL)
	private List<Item> item;
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	@Column
	private String emailId;
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	@OneToOne(mappedBy="customer", cascade=CascadeType.ALL)
	private Payment payment;
	
	
	
	
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	@ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="CUSTOMER_ADDRESS", 
                joinColumns={@JoinColumn(name="c_id")}, 
                inverseJoinColumns={@JoinColumn(name="address_id")})
	private Set<Address> addressList = new HashSet<Address>();
	@Column
	private String date;
	
	@OneToMany(cascade = {CascadeType.ALL},mappedBy = "customer")
	private Set<OrderTable> orderList = new HashSet<OrderTable>();
	
//	@OneToMany
//	private Collection<Payment> paymentList = new ArrayList<Payment>();
	
	
	public Set<OrderTable> getOrderList() {
		return orderList;
	}
	public void setOrderList(Set<OrderTable> orderList) {
		this.orderList = orderList;
	}
//	public Collection<Payment> getPaymentList() {
//		return paymentList;
//	}
//	public void setPaymentList(Collection<Payment> paymentList) {
//		this.paymentList = paymentList;
//	}
	public Set<Address> getAddressList() {
		return addressList;
	}
	public void setAddressList(Set<Address> address) {
		this.addressList = addressList;
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
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<Item> getItem() {
		return item;
	}
	public void setItem(List<Item> item) {
		this.item = item;
	}
	
	
	
}
