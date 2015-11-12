package com.myneu.myrestrnt.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;













import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.ui.Model;

import com.myneu.myrestrnt.model.Customer;
import com.myneu.myrestrnt.model.Food;
import com.myneu.myrestrnt.model.Item;
import com.myneu.myrestrnt.model.OrderDetails;
import com.myneu.myrestrnt.model.OrderTable;

public class OrderDao extends DAO {
	
	public Food getfoodById(int food_id) throws Exception{
		
		try{
			Query q= getSession().createQuery("from Food where food_id = :food_id");
			q.setInteger("food_id", food_id);
			Food food=(Food)q.uniqueResult();
			close();
			return food;
		}catch (Exception e) {
			// TODO Auto-generated catch block
			 throw new Exception("Could not get food " + food_id, e);
		}
		
	}
public List<Item> getAllCartItems(HttpServletRequest request) throws Exception {
		
HttpSession httpSession =request.getSession();
Customer c= (Customer)httpSession.getAttribute("customer");
int c_id = c.getC_id();
		try{
			Query q=getSession().createQuery("from Item where c_id = :c_id");
			q.setInteger("c_id", c_id);
			List<Item> itemList=q.list();
			
			 
          //  close();     
			
			return itemList;
			
		}	
		catch (HibernateException e) {
			//       rollback();
            throw new Exception("Could not get cartItems " + e);
		}
	}
public Item addCartItem(int quantity,Food food,Customer customer) throws Exception{
	try {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		//Transaction transaction = getSession().beginTransaction();
		Item cartItems=new Item();
		cartItems.setFood(food);
		cartItems.setQuantity(quantity);
		cartItems.setTotal(quantity*((int)food.getCost()));
		cartItems.setCustomer(customer);
		
		session.save(cartItems);
		tx.commit();
		close();
		return cartItems;
	} catch (HibernateException e) {
		throw new Exception("Could not add orderItem");
	}	
	
	
	
}
public void createOrder(Customer customer,HttpServletRequest request) throws Exception{
	try {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		//Transaction transaction = getSession().beginTransaction();
		OrderTable orderTable=new OrderTable();
		orderTable.setCustomer(customer);
		orderTable.setDate(new Date());
		List<Item> ci=new ArrayList<Item>();
		ci=getAllCartItems(request);
		for(Item cart:ci){
			OrderDetails od=new OrderDetails();
			od.setFood(cart.getFood());
			od.setOrder(orderTable);
			od.setQuantity(cart.getQuantity());
			od.setTotal_cost(cart.getTotal());
			
			session.save(od);
		}
		session.save(orderTable);
//		System.out.println("Message is "+dbMessage.getMessage());
//		System.out.println("Sent by:"+dbMessage.getFromUser()+" Sent to:"+dbMessage.getUserName());
//		System.out.println("Message date "+dbMessage.getMessageDate());
		
		tx.commit();
		close();
	} catch (HibernateException e) {
		throw new Exception("Could not add order");
	}	
	
	
}


public List<OrderDetails> getOrderDetails() throws Exception{
	try{
		Query q=getSession().createQuery("from OrderDetails");
		
		List<OrderDetails> orderDetails=q.list();
		
		 
      //  close();     
		
		return orderDetails;
		
	}	
	catch (HibernateException e) {
		//       rollback();
        throw new Exception("Could not get OrderDetails " + e);
	}
	
	
}

public void removeCartItem(int cartId) throws Exception {

	try {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
			Transaction tx = session.beginTransaction();
			//Transaction transaction = getSession().beginTransaction();
		
			String hql = "delete from Item where cartId =:cartId ";
			Query query = session.createQuery(hql);
			query.setInteger("cartId", cartId);
		
			int rowCount = query.executeUpdate();
			tx.commit();
		
		close();
	} catch (HibernateException e) {
		throw new Exception("Food Item cannot be deleted");
	}

}






		

}
