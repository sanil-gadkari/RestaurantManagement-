package com.myneu.myrestrnt.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="food")
public class Food implements Serializable{
	@Id
	@GeneratedValue
	@Column(name = "food_id")
	private int food_id;
	@Column(name="img_url")
	private String imgurl;
	
	
	@Column(name = "food_name")
	private String foodName;
	@Column(name = "description")
	private String description;
	@Column(name = "food_cost")
	private float cost;
	
	
	@OneToMany(mappedBy="food", cascade=CascadeType.ALL)
	private List<Item> item;
	@ManyToOne
    @JoinColumn(name = "category_id")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "ftype_id")
	private FoodType foodType;
	
	@OneToMany(mappedBy="food", cascade=CascadeType.ALL)
	private List<OrderDetails> od;

	

	

	public FoodType getFoodType() {
		return foodType;
	}

	public void setFoodType(FoodType foodType) {
		this.foodType = foodType;
	}

	public int getFood_id() {
		return food_id;
	}

	public void setFood_id(int food_id) {
		this.food_id = food_id;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public Category getCategory() {
		return category;
	}

	
	
	
	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}

	public List<OrderDetails> getOd() {
		return od;
	}

	public void setOd(List<OrderDetails> od) {
		this.od = od;
	}

	

}