package com.myneu.myrestrnt.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "ordertable")
public class OrderTable implements Serializable{
	@Id
	@GeneratedValue
	@Column(name = "order_id")
	private int order_id;
	
	
	@Column
	private float total;
	@Column
	private String status;
	
	@Column
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "c_id")
	private Customer customer;
	
	@OneToMany(cascade = {CascadeType.ALL},mappedBy= "orderTable")
	private Set<OrderDetails> orderDetailsList = new HashSet<OrderDetails>();

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<OrderDetails> getOrderDetailsList() {
		return orderDetailsList;
	}

	public void setOrderDetailsList(Set<OrderDetails> orderDetailsList) {
		this.orderDetailsList = orderDetailsList;
	}
	
	

}
