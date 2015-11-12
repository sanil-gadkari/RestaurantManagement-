package com.myneu.myrestrnt;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.myneu.myrestrnt.dao.AdminDao;
import com.myneu.myrestrnt.dao.OrderDao;
import com.myneu.myrestrnt.model.Admin;
import com.myneu.myrestrnt.model.Category;
import com.myneu.myrestrnt.model.Food;
import com.myneu.myrestrnt.model.FoodType;
import com.myneu.myrestrnt.model.Item;

@Controller
public class AdminController {

	private static final Logger logger = LoggerFactory
			.getLogger(AdminController.class);

	@Autowired
	private AdminDao adminDao;

	@Autowired
	@Qualifier("adminValidator")
	private Validator validator1;

	@RequestMapping(value = "/adminLogin", method = RequestMethod.GET)
	private String adminLogin(Model model) {
		Admin admin = new Admin();
		model.addAttribute("admin", admin);

		return "adminLogin";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	private String getLogout(Model model, HttpServletRequest request) {

		HttpSession session = request.getSession();

		session.invalidate();

		return "home";
	}

	@RequestMapping(value = "/logoutHome", method = RequestMethod.GET)
	public String initUserLoginFormAfterLogout(Model model) {

		return "home";
	}

	@RequestMapping(value = "/adminLogin", method = RequestMethod.POST)
	public String adminCRUD(Model model, @Validated Admin admin,
			BindingResult result, HttpServletRequest request) {
		// model.addAttribute("customer",customer2);
		// String returnVal="message";
		HttpSession session = request.getSession();
		// Customer c=(Customer)session.getAttribute("customer");
		// model.addAttribute("customer",customer2);
		if (result.hasErrors()) {
			String error = "Incorrect Username or Paasword";
			model.addAttribute("error", error);
			return "adminLogin";
		}

		else {
			try {
				Admin admin1 = adminDao.queryUserByNameAndPassword(
						admin.getUsername(), admin.getPassword());
				// System.out.print(c);
				if (admin1 != null) {
					// HttpSession session=request.getSession();
					session.setAttribute("test", "devashri");
					session.setAttribute("admin", admin1);

					return "adminCRUD";

				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return "adminLogin";

	}

	@RequestMapping(value = "/adminCRUD")
	private String adminCRUD() {

		return "adminCRUD";

	}

	@RequestMapping(value = "/addProduct")
	private String createProduct(Model model, HttpServletRequest request) {

		// Food food=new Food();
		// FoodType foodType=new FoodType();
		// Category category=new Category();
		// food.setFoodType(foodType);
		// food.setCategory(category);

		// model.addAttribute("food",food);
		// model.addAttribute("foodType",foodType);
		// model.addAttribute("category",category);
		try {
			List<Category> categoryList = new ArrayList<Category>();
			categoryList = adminDao.getCategoryListt();
			List<FoodType> foodList = new ArrayList<FoodType>();
			foodList = adminDao.getFoodList();
			model.addAttribute("catList", categoryList);
			model.addAttribute("foodList", foodList);

			// request.setAttribute("categoryList",categoryList);
			// request.setAttribute("foodList", foodList);

			// HttpSession session=request.getSession();
			// session.setAttribute("foodList", foodList);

		} catch (Exception e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "addProduct";

	}
	@RequestMapping(value="/viewItems")
	private String getProducts(Model model){


		List<Food> viewFoodlist=new ArrayList<Food>();
		try {
			viewFoodlist=adminDao.geAllFoodList();
			
			model.addAttribute("viewFoods",viewFoodlist);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return "viewItems";
	}

	@RequestMapping(value = "/menu")
	private String menu() {

		return "menu";

	}

	@RequestMapping(value = "/addNewProduct")
	private String newProduct(Model model, HttpServletRequest request) {

		try {
			Food food = new Food();

			int foodtype_id = Integer.parseInt(request.getParameter("type"));
			int category_id = Integer
					.parseInt(request.getParameter("category"));

			FoodType foodType = adminDao.queryFoodType(foodtype_id);
			Category category = adminDao.queryCategoryType(category_id);

			String name = request.getParameter("foodname");
			String description = request.getParameter("description");
			float cost = Float.parseFloat(request.getParameter("cost"));

			if (name.isEmpty() || description.isEmpty()) {
				String enter = "Enter the details Properly";
				model.addAttribute("enter", enter);

				return "addProduct";

			}

			food.setFoodName(name);
			food.setCost(cost);
			food.setDescription(description);
			food.setFoodType(foodType);
			food.setCategory(category);

			adminDao.addFood(name, description, cost, foodType, category);

			// Food f=adminDao.addFood(food.getFoodName(),food.getDescription(),
			// food.getCost(),food.getFoodType().getFtype_id(),food.getCategory().getCategory_id());

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "success1";
	}

	@RequestMapping(value = "/updatePrice")
	private String updatePrice(Model model, HttpServletRequest request) {

		String name = request.getParameter("editedName");
		String cost = request.getParameter("cost");

		if (cost.isEmpty() || name.isEmpty()) {
			String update = "Enter the price to updated";
			model.addAttribute("error", update);
			return "update";
		}

		float cost1 = Float.parseFloat(cost);

		HttpSession session = request.getSession();
		Food f = (Food) session.getAttribute("foodupdatePrice");

		try {
			adminDao.updateFood(f, name, cost1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "successupdate";
	}

	@RequestMapping(value = "/updateFoodItems")
	private String update(Model model, HttpServletRequest request) {

		List<Food> foodlistUpdate = new ArrayList<Food>();
		try {
			foodlistUpdate = adminDao.geAllFoodList();

			model.addAttribute("foodlistUpdate", foodlistUpdate);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "updateFoodItems";

	}

	@RequestMapping(value = "/update")
	private String updateItem(
			/* @PathVariable("food_id") int food_id */Model model,
			HttpServletRequest request, @RequestParam int food_id) {
		try {
			Food food = adminDao.getfoodById(food_id);
			model.addAttribute("foodUpdate", food);
			HttpSession session = request.getSession();
			session.setAttribute("foodupdatePrice", food);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "update";
	}

	@RequestMapping(value = "deleteFoodItems")
	private String deleteFoodItem(Model model, HttpServletRequest request) {

		String[] contactsArray = request
				.getParameterValues("deleteSelectedFood");

		try {
			adminDao.deleteFoodItems(contactsArray);
			HttpSession session = request.getSession();

			session.setAttribute("size", contactsArray.length);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "success";

	}

	@RequestMapping(value = "/success")
	private String addSuccess() {

		return "success";

	}

	@RequestMapping(value = "/editFood")
	private String getEditFood(Model model) {

		List<Food> foodlist = new ArrayList<Food>();
		try {
			foodlist = adminDao.geAllFoodList();

			model.addAttribute("foods", foodlist);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "editFood";

	}

}
