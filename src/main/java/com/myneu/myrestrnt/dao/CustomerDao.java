package com.myneu.myrestrnt.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.myneu.myrestrnt.model.Address;
import com.myneu.myrestrnt.model.Customer;
import com.myneu.myrestrnt.model.Food;



public class CustomerDao extends DAO {

	/*
	    * Since its a query, it is not necessary to wrap code
	    * inside the begin transaction and commit part, unlike
	    * update, create, and delete. Since there is no object
	    * in the session yet, nothing will be committed.  After
	    * Adding these, "transaction is not successfully started'
	    * Exception will be thrown.
	    */
		public Customer queryUserByNameAndPassword(String name, String password)
	            throws Exception {
			try {
				//      begin();
	            Query q = getSession().createQuery("from Customer where username = :username1 and password = :password1");
	            //System.out.print();
	            q.setString("username1", name);
	            q.setString("password1", password);
	         //   System.out.print(name);
	         //   System.out.print(password);
	           // List customers=q.list();
	         //   System.out.print(customers.size());
	            Customer customer = (Customer) q.uniqueResult();
	            //       commit();
	            
	            close();
	            return customer;
			} catch (HibernateException e) {
				//       rollback();
	            throw new Exception("Could not get customer " + name, e);
			}
	    }
		
		
		public void addCustomer(String username, String password,String cpassword, String gender, String firstName,String lastName,long mobileNo,String emailId, String date,String state,String street,int zip_code,String apt_number) throws Exception{
			try {
				SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
				Session session = sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				//Transaction transaction = getSession().beginTransaction();
				Customer c = new Customer();
				c.setUsername(username);
				c.setPassword(password);
				c.setConfirmPassword(cpassword);
				c.setGender(gender);
				c.setFirstName(firstName);
				c.setLastName(lastName);
				c.setMobileNo(mobileNo);
				c.setEmailId(emailId);
				c.setDate(date);
				Address address=new Address();
				address.setApt_no(apt_number);
				address.setState(state);
				address.setStreet(street);
				address.setZip_code(zip_code);
				c.getAddressList().add(address);
				
				session.save(c);
//				System.out.println("Message is "+dbMessage.getMessage());
//				System.out.println("Sent by:"+dbMessage.getFromUser()+" Sent to:"+dbMessage.getUserName());
//				System.out.println("Message date "+dbMessage.getMessageDate());
				
				tx.commit();
				close();
			} catch (HibernateException e) {
				throw new Exception("Could not add message");
			}	
					
		}
//		public ArrayList<Food> viewFoodItems(String[]) throws Exception{
//			try {
//				SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//				Session session = sessionFactory.openSession();
//				for(String foodToBeDeleted : foodItemsDelete) {
//					Transaction tx = session.beginTransaction();
//					//Transaction transaction = getSession().beginTransaction();
//				
//					String hql = "from  Food ";
//					Query query = session.createQuery(hql);
//					ArrayList<Food> foods = (ArrayList<Food>)query.list();
//					int rowCount = query.executeUpdate();
//					tx.commit();
//					return foods;
//				}
//				close();
//			} catch (HibernateException e) {
//				throw new Exception("Food Item cannot be deleted");
//			}
//			return null;	
//			
//			
//			
//			
//		}
//		
		public List<Food> geAllFoodList() throws Exception {
			

			try{
				Query q=getSession().createQuery("from Food");
				
				List<Food> foodList=q.list();
				
				 
	          //  close();     
				
				return foodList;
				
			}	
			catch (HibernateException e) {
				//       rollback();
	            throw new Exception("Could not get foodtype " + e);
			}
		}
		
		
}

