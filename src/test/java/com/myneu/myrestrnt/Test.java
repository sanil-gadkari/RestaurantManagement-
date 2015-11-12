package com.myneu.myrestrnt;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

import org.hibernate.Session;

import com.myneu.myrestrnt.dao.HibernateUtil;
import com.myneu.myrestrnt.model.Address;
import com.myneu.myrestrnt.model.Admin;
import com.myneu.myrestrnt.model.Category;
import com.myneu.myrestrnt.model.Customer;
import com.myneu.myrestrnt.model.Food;
import com.myneu.myrestrnt.model.FoodType;
import com.myneu.myrestrnt.model.OrderDetails;
import com.myneu.myrestrnt.model.OrderTable;
import com.myneu.myrestrnt.model.Payment;



public class Test {
public static void main(String []args){
		
		Session session2 = HibernateUtil.getSessionFactory().openSession();
		org.hibernate.Transaction transaction=session2.beginTransaction();
		
		
		Admin admin=new Admin();
		admin.setUsername("sanil");
		admin.setRoleName("superadmin");
		admin.setPassword("root");
		
		Category category1 = new Category();
		category1.setCategory_name("Italian");
//		
		Category category2 = new Category();
		category2.setCategory_name("Chinese");
		
		Category indian = new Category();
		indian.setCategory_name("Indian");
		
//		
		FoodType food_type1 = new FoodType();
		food_type1.setFtype_name("starter");
//		
		FoodType food_type2 = new FoodType();
		food_type2.setFtype_name("Beverages");
		
		FoodType food_type3 = new FoodType();
		food_type3.setFtype_name("dessert");
		
		FoodType food_type4 = new FoodType();
		food_type4.setFtype_name("MainCourse");
		
		Food food=new Food();
		
		food.setFoodName("Burger");
		food.setDescription("Cheese ");
		food.setCost(25);
		
		Food food2 = new Food();
		food2.setFoodName("Noodles");
		food2.setDescription("Top Ramen");
		food2.setCost(35);
		
		
		
		category1.setFoodList(new HashSet<Food>());
		category1.getFoodList().add(food);
		category2.setFoodList(new HashSet<Food>());
		category2.getFoodList().add(food2);
//		
		food_type1.setFoodList(new ArrayList<Food>());
		food_type1.getFoodList().add(food2);
		food_type2.setFoodList(new ArrayList<Food>());
		food_type2.getFoodList().add(food2);
//		
		food.setCategory(category1);
		food2.setCategory(category2);
		food.setFoodType(food_type2);
		food2.setFoodType(food_type1);
		
		Customer customer1 = new Customer();
		customer1.setEmailId("naik.v@husky.neu.edu");
		customer1.setFirstName("vijay");
		customer1.setLastName("Naik");
		customer1.setMobileNo(4564545);
		customer1.setUsername("chets");
		customer1.setPassword("root");
		customer1.setGender("male");
		
		
		
		
		
		
		
		
		Customer customer2 = new Customer();
		customer2.setEmailId("gadkari.s@husky.neu.edu");
		customer2.setFirstName("Sanil");
		customer2.setLastName("Gadkari");
		customer2.setMobileNo(4564545);
		customer2.setUsername("sanil");
		customer2.setPassword("1234");
		customer2.setGender("male");
		
		Address address1 = new Address();
		address1.setStreet("75 Saint Alphonsus");
		address1.setState("MA");
		address1.setApt_no("609");
		address1.setZip_code(02120);
		
		
		Address address2 = new Address();
		address2.setStreet("75 Saint Patrick");
		address2.setState("MA");
		address2.setApt_no("454");
		address2.setZip_code(02115);
		
		OrderTable order = new OrderTable();
		order.setCustomer(customer1);
		order.setStatus("Delivered");
		order.setDate(new Date());
		order.setTotal(100);
		customer1.getOrderList().add(order);
		customer2.getOrderList().add(order);
		

		OrderDetails od1 = new OrderDetails();
		od1.setFood(food);
		od1.setQuantity(2);
		od1.setTotal_cost(0);
		od1.setOrder(order);
//		
//		
//		
		OrderDetails od2 = new OrderDetails();
		od2.setFood(food2);
		od2.setQuantity(3);
		od2.setTotal_cost(0);
		od2.setOrder(order);
		
		
		
		
		
		
//		order.getOrderDetailsList().add(od1);
//		order.getOrderDetailsList().add(od2);
//		
//		food.setOd(od1);
//		food2.setOd(od2);
		
	    //customer1.getPayment();
		customer1.getAddressList().add(address1);
		customer2.getAddressList().add(address1);
		address2.getCustomerList().add(customer1);
		
		
		
		Payment payment=new Payment();
		payment.setCardType("MasterCard");
		payment.setCard_number(19383);
		payment.setCustomer(customer1);
		
		
		session2.save(admin);
		
		session2.save(category1);
		session2.save(category2);
		session2.save(indian);
		
		
		session2.save(food_type1);
		session2.save(food_type2);
		session2.save(food_type3);
		session2.save(food_type4);
		
//		session2.save(food);
//		session2.save(food2);
//		
//		session2.save(address1);
//		session2.save(address2);
		
		session2.save(customer1);
		session2.save(customer2);
		session2.save(order);
		
		
		
		session2.save(od1);
		
		session2.save(od2);
		
		session2.save(payment);
		
		
		
		
	
		transaction.commit();
		session2.close();
		
		
		
		
	}
		

}
