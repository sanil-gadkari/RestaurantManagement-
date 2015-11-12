package com.myneu.myrestrnt;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myneu.myrestrnt.dao.CustomerDao;
import com.myneu.myrestrnt.dao.OrderDao;
import com.myneu.myrestrnt.model.Customer;
import com.myneu.myrestrnt.model.Food;
import com.myneu.myrestrnt.model.Item;

@Controller
public class CartController {
	
	@Autowired
	private OrderDao orderDao;
	
	@RequestMapping(value="/addToCart")
	public String addItemToCart(Model model,HttpServletRequest request) throws Exception{
		

		
		int food_id=Integer.parseInt(request.getParameter("food_id"));
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		
		
		Food f=orderDao.getfoodById(food_id);
		HttpSession session = request.getSession();
		
		Customer customer = (Customer)session.getAttribute("customer");
		 orderDao.addCartItem(quantity, f,customer);
		
List<Item> oldCartList=new ArrayList<Item>();
//Item item=new Item();
//item.setFood(f);
//item.setQuantity(quantity);
//item.setTotal((quantity*f.getCost()));
		oldCartList=orderDao.getAllCartItems(request);
		

//		else {
			for(Item item:oldCartList){
				if(item.getFood().getFood_id()==food_id){
					String error="Cart already contains this item";
					int newQuan = item.getQuantity()+quantity;
					item.setQuantity(newQuan);
					model.addAttribute("error", error);
					model.addAttribute("cartItem", item);
					
					return "successtocart";
				}
			}
			
					
			Item c=
				    orderDao.addCartItem(quantity,  f,customer);
				    
				    String cartI="new item added";
					model.addAttribute("cartI", cartI);
					model.addAttribute("cartItem", c);
				    
					return "successtocart";
				
				
	}


	@RequestMapping(value="/foodcart")
	public String setToCart(Model model,@RequestParam int food_id){
		
		
		
			try {
				Food f=orderDao.getfoodById(food_id);
				model.addAttribute("foodItem",f);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
		return "foodcart";
	}
	@RequestMapping(value="/removefromcart")
	public String getRemoveCart(Model model,HttpServletRequest request,@RequestParam int remove){
		List<Item> cartListNew =new ArrayList<Item>();
		HttpSession session=request.getSession();
		try {
			orderDao.removeCartItem(remove);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Customer cust=(Customer) session.getAttribute("customer");
		int cust_id=cust.getC_id();
		
		
		
	
		
		return "redirect:/viewcart";
	}
	

	@RequestMapping(value="/viewcart")
	public String gealian(Model model,HttpServletRequest request){

	
		
		List<Item> cartListNew =new ArrayList<Item>();
		try {
			cartListNew=orderDao.getAllCartItems(request);
			HttpSession session=request.getSession();
			session.setAttribute("newList", cartListNew);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
			return "viewcart";
			
		}
		



}
