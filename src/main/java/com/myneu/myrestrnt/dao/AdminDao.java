package com.myneu.myrestrnt.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.myneu.myrestrnt.model.Admin;
import com.myneu.myrestrnt.model.Category;
import com.myneu.myrestrnt.model.Food;
import com.myneu.myrestrnt.model.FoodType;



public class AdminDao extends DAO {

	
	
	
	public Admin queryUserByNameAndPassword(String name, String password)
            throws Exception {
		try {
			//      begin();
            Query q = getSession().createQuery("from Admin where username = :username and password = :password");
            //System.out.print();
            q.setString("username", name);
            q.setString("password", password);
         //   System.out.print(name);
         //   System.out.print(password);
           // List customers=q.list();
         //   System.out.print(customers.size());
            Admin admin = (Admin) q.uniqueResult();
            //       commit();
            
            close();
            return admin;
		} catch (HibernateException e) {
			//       rollback();
            throw new Exception("Could not get customer " + name, e);
		}
    }

	
	public void deleteFoodItems(String[] foodItemsDelete) throws Exception{
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			for(String foodToBeDeleted : foodItemsDelete) {
				Transaction tx = session.beginTransaction();
				//Transaction transaction = getSession().beginTransaction();
			
				String hql = "delete from  Food where food_id = :foodToBeDeleted";
				Query query = session.createQuery(hql);
				query.setString("foodToBeDeleted",foodToBeDeleted);
				int rowCount = query.executeUpdate();
				tx.commit();
			}
			close();
		} catch (HibernateException e) {
			throw new Exception("Food Item cannot be deleted");
		}	
		
		
		
		
	}
	
	
	
	public Food getfoodById(int food_id) throws Exception{
		
		try {
			//      begin();
            Query q = getSession().createQuery("from Food where food_id = :food_id");
            //System.out.print();
            q.setInteger("food_id",food_id);
          //  q.setString("password", password);
         //   System.out.print(name);
         //   System.out.print(password);
           // List customers=q.list();
         //   System.out.print(customers.size());
          Food food=(Food)q.uniqueResult();
            //       commit();
            
            close();
            return food;
		} catch (HibernateException e) {
			//       rollback();
            throw new Exception("Could not get food " + food_id, e);
		}
		
		
		
		
		
		
		
	}
	
	
	public void updateFood(Food food,String name,float cost) throws Exception{
		
		
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			food.setFoodName(name);
			food.setCost(cost);
			session.update(food);
			transaction.commit();
			close();
		} catch (HibernateException e) {
				throw new Exception("Product could not be deleted");
		}
		
		
		
		
	}
	
	
	public void addFood(String name, String description,float cost,FoodType foodtype,Category category)
            throws Exception {
		try{ 
		SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Food food=new Food();
		food.setFoodName(name);
		food.setCategory(category);
		food.setCost(cost);
		food.setFoodType(foodtype);
		food.setDescription(description);
		
		
		
		
			
			session.save(food);
//			System.out.println("Message is "+dbMessage.getMessage());
//			System.out.println("Sent by:"+dbMessage.getFromUser()+" Sent to:"+dbMessage.getUserName());
//			System.out.println("Message date "+dbMessage.getMessageDate());
			
			tx.commit();
			close();
			
			//foodType.setFtype_name();
			//food.setFoodType(type);
			
			
			//food.getCategory().setCategory_name(category_name);
			
            
           
		} catch (HibernateException e) {
			//       rollback();
            throw new Exception("Could not get customer " + name, e);
		}
    }
	
	public List<FoodType> getFoodList() throws Exception{
		
		try{
			Query q=getSession().createQuery("from FoodType");
			
			List<FoodType> typeList=q.list();
			
			 
          //  close();     
			
			return typeList;
			
		}	
		catch (HibernateException e) {
			//       rollback();
            throw new Exception("Could not get foodtupe " + e);
		}
		
		
		
		
	}
	
	
	
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
	
	
	
	public FoodType queryFoodType(int x) throws Exception{
		
		try {
			//      begin();
            Query q = getSession().createQuery("from FoodType where ftype_id = :ftype_id");
            //System.out.print();
            q.setInteger("ftype_id", x);
          //  q.setString("password", password);
         //   System.out.print(name);
         //   System.out.print(password);
           // List customers=q.list();
         //   System.out.print(customers.size());
           FoodType foodType=(FoodType)q.uniqueResult();
            //       commit();
            
            close();
            return foodType;
		} catch (HibernateException e) {
			//       rollback();
            throw new Exception("Could not get customer " + x, e);
		}
		
		
		
		
	}
	

	public Category queryCategoryType(int x) throws Exception{
		
		try {
			//      begin();
            Query q = getSession().createQuery("from Category where category_id = :category_id");
            //System.out.print();
            q.setInteger("category_id", x);
          //  q.setString("password", password);
         //   System.out.print(name);
         //   System.out.print(password);
           // List customers=q.list();
         //   System.out.print(customers.size());
           Category category=(Category)q.uniqueResult();
            //       commit();
            
          //  close();
            return category;
		} catch (HibernateException e) {
			//       rollback();
            throw new Exception("Could not get customer " + x, e);
		}
		
		
		
		
	}
	
	
	
public List<Category> getCategoryListt() throws Exception{
		
		try{
			Query q=getSession().createQuery("from Category");
			
			List<Category> categoryList=q.list();
			
			 
         //	   close();     
			
			return categoryList;
			
		}	
		catch (HibernateException e) {
			//       rollback();
            throw new Exception("Could not get foodtupe " + e);
		}
		
		
		
		
	}
}
	
	
	
