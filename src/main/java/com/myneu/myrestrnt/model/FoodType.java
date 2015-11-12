package com.myneu.myrestrnt.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="foodtype")
public class FoodType implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "ftype_id")
	private int ftype_id;
	@Column
	private String ftype_name;
	
	@OneToMany(cascade = {CascadeType.ALL}, mappedBy = "foodType")
//	@JoinColumn(name = "ftype_id")
	private List<Food> foodList=new ArrayList<Food>();

	public List<Food> getFoodList() {
		return foodList;
	}
	public void setFoodList(List<Food> foodList) {
		this.foodList = foodList;
	}
	public int getFtype_id() {
		return ftype_id;
	}
	public void setFtype_id(int ftype_id) {
		this.ftype_id = ftype_id;
	}
	public String getFtype_name() {
		return ftype_name;
	}
	public void setFtype_name(String ftype_name) {
		this.ftype_name = ftype_name;
	}
	@Override
	public String toString() {
		return ftype_name;
	}
	
	
	
	
	
	
}