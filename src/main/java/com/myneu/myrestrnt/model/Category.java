package com.myneu.myrestrnt.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "category")
public class Category implements Serializable{
	
	
@Id
@GeneratedValue
@Column
private int category_id;

@Column(name = "category_name")
private String category_name;

@OneToMany(cascade = {CascadeType.ALL},mappedBy = "category")
//@JoinColumn(name = "category_id")
private Set<Food> foodList =new HashSet<Food>();

public Set<Food> getFoodList() {
	return foodList;
}

public void setFoodList(Set<Food> foodList) {
	this.foodList = foodList;
}

public int getCategory_id() {
	return category_id;
}

public void setCategory_id(int category_id) {
	this.category_id = category_id;
}

public String getCategory_name() {
	return category_name;
}

public void setCategory_name(String category_name) {
	this.category_name = category_name;
}



}
