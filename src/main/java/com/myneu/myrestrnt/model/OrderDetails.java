package com.myneu.myrestrnt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orderlist")
public class OrderDetails {
	
	@Id
	@GeneratedValue
	private int orderDeatils_id;
	@Column
	private int quantity;
	@Column
	private float total_cost;
	
	@ManyToOne
	@JoinColumn(name = "food_id")
	private Food food;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private OrderTable orderTable;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getTotal_cost() {
		return total_cost;
	}

	public void setTotal_cost(float total_cost) {
		this.total_cost = total_cost;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public OrderTable getOrder() {
		return orderTable;
	}

	public void setOrder(OrderTable orderTable) {
		this.orderTable = orderTable;
	}
	
	
	
	

}