package com.myneu.myrestrnt;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myneu.myrestrnt.dao.CustomerDao;
import com.myneu.myrestrnt.model.Address;
import com.myneu.myrestrnt.model.Customer;
import com.myneu.myrestrnt.model.Food;



/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	
	@Autowired
	@Qualifier("customerValidator")
	private Validator validator;
	
	
	@Autowired
	private CustomerDao customerDao;
	
	
	/*
	 * This is to initialize webDataBinder,set its
	 * validator as we specify.
	 */
	@InitBinder
	private void initBinder (WebDataBinder binder){
		binder.setValidator(validator);
	}
	
	
	
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String initUserLoginForm(Model model) {
		
		
		return "home";
	}
	


	

@RequestMapping(value="/custLogin")
public String showLogin(Model model,HttpServletRequest request){
	Customer customer = new Customer();
	//Address a=new Address();
	//HttpSession session=request.getSession();
//	session.setAttribute("customer", customer);

	model.addAttribute("customer", customer);
	//model.addAttribute("address", a);
	
	return "custLogin";
}



@RequestMapping(value="/customerSignUp1")
public String customerSignUp(Model model,HttpServletRequest request){
//	Customer customer1=new Customer();
//	model.addAttribute("customerForm", customer1);
	//return "register";
	
	return "customerSignUp1";
	
	
}

@RequestMapping(value="/custLogin",method=RequestMethod.POST)
public String selectFood(Model model,@Validated Customer customer,BindingResult result,HttpServletRequest request)
{
	//model.addAttribute("customer",customer2);
//	String returnVal="message";
	HttpSession session=request.getSession();
	//Customer c=(Customer)session.getAttribute("customer");
//	model.addAttribute("customer",customer2);
	if(result.hasErrors()){
		
		return "custLogin";
	}
	else{
		try{
		Customer cust=customerDao.queryUserByNameAndPassword(customer.getUsername(), customer.getPassword());
		//System.out.print(c);
			if(cust!=null){
				//HttpSession session=request.getSession();
			//	session.setAttribute("test", "devashri");
				session.setAttribute("customer",cust);
				
				return "customerHome";
				
			}
			
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	return "customerLogin";
	
	

	
	
}

@RequestMapping(value = "/logoutcust", method = RequestMethod.GET)
private String getLogout(Model model, HttpServletRequest request) {

	HttpSession session = request.getSession();

	session.invalidate();

	return "home";
}









/*@RequestMapping(value="/customerSignUp1",method=RequestMethod.POST)
public String addMessage(Model model, @Validated @ModelAttribute ("customer1") Customer customer1,HttpServletRequest request){
	System.out.println("I am in addCustomer");
	
	//Customer c = (Customer)session.getAttribute("customerForm");
//	Customer newCustomer = new Customer();
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	String date = sdf.format(new Date()); 
	
	System.out.println(customer1.getUsername());
	System.out.println("message is "+request.getParameter("messageText"));
    
    try {
    customerDao.addCustomer(customer1.getUsername(),customer1.getPassword(),customer1.getGender(),customer1.getFirstName(),
    						customer1.getLastName(),customer1.getMobileNo(),customer1.getEmailId(),date,request.getParameter("state"),request.getParameter("street"),Integer.parseInt(request.getParameter("zip_code")),request.getParameter("apt_no"));
   
       // session=request.getSession();
    HttpSession session = request.getSession();
	session.setAttribute("registeredCustomer",customer1);
    
    
    System.out.println("Added");
    
    } catch (Exception e) {
    	e.printStackTrace();
    }
	
	return "selectFood";
}*/


@RequestMapping(value="/customerSign",method=RequestMethod.POST)
public String addMessage(Model model,HttpServletRequest request){
	System.out.println("I am in addCustomer");
	
	//Customer c = (Customer)session.getAttribute("customerForm");
	Customer newCustomer = new Customer();
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	String date = sdf.format(new Date()); 
	
//	System.out.println(customer1.getUsername());
//	System.out.println("message is "+request.getParameter("messageText"));
    
    try {
    	int i = Integer.parseInt(request.getParameter("zipcode"));
    	long number=Long.parseLong(request.getParameter("number"));
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String cpassword=request.getParameter("confirmPassword");
        String fname=request.getParameter("firstname");
        String lname=request.getParameter("lastname");
        
        String gender=request.getParameter("option");
        String email=request.getParameter("email");
        String state=request.getParameter("state");
        String street=request.getParameter("street");
        String apt=request.getParameter("apt_no");
    	
        if(!password.equals(cpassword)){
        String message="Entered passwords donnot match";	
        	model.addAttribute("error",message);
        	return "customerSignUp1";
        }
        
        
        customerDao.addCustomer(request.getParameter("username"),request.getParameter("password"),cpassword,request.getParameter("option"),request.getParameter("firstname"), request.getParameter("lastname"),number,request.getParameter("email"),date,request.getParameter("state"), request.getParameter("street"),i,request.getParameter("apt_no"));
       //session=request.getSession();
    
    	
    	newCustomer.setFirstName(fname);
    	newCustomer.setLastName(lname);
    	newCustomer.setPassword(password);
    	newCustomer.setConfirmPassword(cpassword);
    	newCustomer.setUsername(username);
    	newCustomer.setEmailId(email);
    	newCustomer.setGender(gender);
    	
    	newCustomer.setMobileNo(number);;
    	newCustomer.setLastName(lname);
    	
    	
    	
    	
    	
    	Address a=new Address();
    	a.setState(state);
    	a.setApt_no(apt);
    	a.setStreet(street);
    	a.setZip_code(i);
    	
    	newCustomer.getAddressList().add(a);
    
    	
    HttpSession session = request.getSession();
	session.setAttribute("registeredCustomer",newCustomer);
    
    
    System.out.println("Added");
    
    } catch (Exception e) {
    	e.printStackTrace();
    }
	
	return "selectFood";
}

@RequestMapping(value="/viewcustproducts")
public String viewcustproducts(Model model,HttpServletRequest request)
{
	List<Food> foodlist=new ArrayList<Food>();
	try {
		foodlist=customerDao.geAllFoodList();
		
		model.addAttribute("foods",foodlist);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}






	return "viewcustproducts";

}
















}