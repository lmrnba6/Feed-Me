package com.journaldev.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.journaldev.spring.model.Menu;
import com.journaldev.spring.model.Restaurant;
import com.journaldev.spring.service.MealRatingService;
import com.journaldev.spring.service.MealService;
import com.journaldev.spring.service.MenuService;
import com.journaldev.spring.service.RestRatingService;
import com.journaldev.spring.service.RestaurantService;

@Controller
@SessionAttributes({ "user", "cart" ,"lat", "lan","restaurant","menu","rating","starsOn","category","menuRestaurant" })
public class AdminController {

	@Autowired
	private RestaurantService restaurantService;
	@Autowired
	private RestRatingService restRatingService;
	@Autowired
	private MealService mealService;
	@Autowired
	private MenuService menuService;
	@Autowired
	private MealRatingService mealRatingService;


	@RequestMapping(value = "/addRestaurant", method = RequestMethod.GET)
	public String addRestaurant(Model model) {
		Restaurant restaurant = new Restaurant();
		restaurant.setName("falafel");
		restaurant.setCity("new york");
		restaurant.setUserName("1");
		restaurant.setPassword("1");
		restaurant.setZip("10031");
		restaurantService.add(restaurant);
		model.addAttribute("restaurant", restaurant);
		return "test";
	}
	
	@RequestMapping(value = "/addMenu", method = RequestMethod.GET)
	public String addMenu(Model model, HttpServletRequest request) {
		
		Restaurant restaurant = (Restaurant) request.getSession().getAttribute("restaurant");
		Menu menu = new Menu();
		menu.setRestaurant(restaurant);
		menuService.add(menu);
		model.addAttribute("menuRestaurant", menu);
		model.addAttribute("menu", menu.getMeal());
		return "test";
	}

	

}
