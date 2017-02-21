package com.journaldev.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.journaldev.spring.model.Meal;
import com.journaldev.spring.model.Menu;
import com.journaldev.spring.model.Restaurant;
import com.journaldev.spring.service.MealRatingService;
import com.journaldev.spring.service.MealService;
import com.journaldev.spring.service.MenuService;
import com.journaldev.spring.service.RestCategoryService;
import com.journaldev.spring.service.RestRatingService;
import com.journaldev.spring.service.RestaurantService;
import com.journaldev.spring.util.Utils;

@Controller
@SessionAttributes({ "user", "cart", "lat", "lan", "restaurant", "menu", "rating", "starsOn", "category","menuRestaurant" })
public class RestaurantOwnerController {

	@Autowired
	private RestaurantService restaurantService;
	@Autowired
	private RestCategoryService categoryService;
	@Autowired
	private MenuService menuService;
	@Autowired
	private MealService mealService;
	@Autowired
	private RestRatingService restRatingService;
	@Autowired
	private MealRatingService mealRatingService;
	
	@RequestMapping(value = "/restaurantOwner")
	public String mainOwner(Model model, RedirectAttributes att, HttpServletRequest request) {
		
		Restaurant restaurant = (Restaurant) request.getSession().getAttribute("restaurant");
		Utils.restaurantInfoToModel(restaurant.getRestId(), menuService, mealRatingService, model, restaurantService, restRatingService, att);
		return "restaurantOwner";
	}
	
	@RequestMapping(value = "/restaurant/addPicture")
	public String addPicture(@RequestParam("photo") String photo, Model model, HttpServletRequest request) {

		Restaurant restaurant = (Restaurant) request.getSession().getAttribute("restaurant");
		restaurant.setRestImageUrl(photo);
		restaurantService.update(restaurant);
		model.addAttribute("restaurant", restaurant);
		model.addAttribute("messageSuccess", "Information Updated");
		return "restaurantOwner";
	}

	@RequestMapping(value = "/restaurant/saveName")
	public String saveName(@RequestParam("name") String name, @RequestParam("phone1") Long phone1,
			@RequestParam("phone2") Long phone2, Model model, HttpServletRequest request) {

		Restaurant restaurant = (Restaurant) request.getSession().getAttribute("restaurant");
		restaurant.setName(name);
		restaurant.setPhoneNum1(phone1);
		restaurant.setPhoneNum2(phone2);
		restaurantService.update(restaurant);
		model.addAttribute("restaurant", restaurant);
		model.addAttribute("messageSuccess", "Information Updated");
		return "restaurantOwner";
	}

	@RequestMapping(value = "/restaurant/saveAddress")
	public String saveAddress(@RequestParam("description") String description, @RequestParam("address") String address,
			Model model, HttpServletRequest request) {

		Restaurant restaurant = (Restaurant) request.getSession().getAttribute("restaurant");
		restaurant.setAddress(address);
		restaurant.setDescription(description);
		restaurantService.update(restaurant);
		model.addAttribute("restaurant", restaurant);
		model.addAttribute("messageSuccess", "Information Updated");
		return "restaurantOwner";
	}

	@RequestMapping(value = "/restaurant/saveDelivery")
	public String saveDelivery(@RequestParam("isHomeDelivery") String isHomeDelivery,
			@RequestParam("deliveryTime") String deliveryTime, @RequestParam("deliveryCharge") Double ChargeForDelivery,
			@RequestParam("isChargeDelivery") String isChargeDelivery, @RequestParam("category") Long category,
			Model model, HttpServletRequest request) {
		boolean homeDel = isHomeDelivery.equals("yes") ? true : false;
		boolean chargDel = isChargeDelivery.equals("yes") ? true : false;
		Restaurant restaurant = (Restaurant) request.getSession().getAttribute("restaurant");
		restaurant.setHomeDelivery(homeDel);
		restaurant.setDeliveryCharge(chargDel);
		restaurant.setChargeForDelivery(ChargeForDelivery);
		restaurant.setRestCategory(categoryService.getById(category));
		restaurant.setDeliveryTime(deliveryTime);
		restaurantService.update(restaurant);
		model.addAttribute("restaurant", restaurant);
		model.addAttribute("messageSuccess", "Information Updated");
		return "restaurantOwner";
	}

	@RequestMapping(value = "/restaurant/saveCity")
	public String saveCity(@RequestParam("zip") String zip, @RequestParam("city") String city,
			@RequestParam("opening") String opening, @RequestParam("closing") String closing, Model model,
			HttpServletRequest request) {

		Restaurant restaurant = (Restaurant) request.getSession().getAttribute("restaurant");
		restaurant.setCity(city);
		restaurant.setZip(zip);
		restaurant.setOpening(opening);
		restaurant.setClosing(closing);
		restaurantService.update(restaurant);
		model.addAttribute("restaurant", restaurant);
		model.addAttribute("messageSuccess", "Information Updated");
		return "restaurantOwner";
	}
	
	@RequestMapping(value = "/restaurant/saveMeal")
	public String saveMeal(@RequestParam("name") String name, @RequestParam("description") String description,
			@RequestParam("price") Double price, @RequestParam("isAvailable") String available, @RequestParam("photo") String photo, Model model,
			HttpServletRequest request) {
		
		boolean avail = available.equals("yes") ? true : false;
		Menu menu = (Menu) request.getSession().getAttribute("menuRestaurant");
		Menu menu2 = (Menu) request.getSession().getAttribute("menuRestaurant");
		Meal meal = new Meal();
		meal.setAvailable(avail);
		meal.setDescription(description);
		meal.setMealImageUrl(photo);
		meal.setMealName(name);
		meal.setMenu(menu);
		meal.setPrice(price);
		mealService.add(meal);
		menu2.getMeal().add(meal);
		menuService.update(menu2);
		model.addAttribute("menu", menu2.getMeal());
		return "restaurantOwner";
	}
	
	@RequestMapping(value = "/restaurant/deleteMeal/{id}")
	public String deleteMeal(@PathVariable("id") Long id, Model model,
			HttpServletRequest request) {
		Menu menu = (Menu) request.getSession().getAttribute("menuRestaurant");
		menu.getMeal().remove(mealService.getById(id));
		menuService.update(menu);
		mealService.remove(id);
		
		return "restaurantOwner";
	}
	
	@RequestMapping(value = "/restaurant/editMeal/{id}")
	public String editMeal(@PathVariable("id") Long id, Model model,
			HttpServletRequest request) {
		Meal meal = mealService.getById(id);
		model.addAttribute("mealToUpdate", meal);
		model.addAttribute("update", "update");

		return "restaurantOwner";
	}
	
	@RequestMapping(value = "/restaurant/updateMeal/{id}")
	public String updateMeal(@PathVariable("id") Long id, @RequestParam("name") String name, @RequestParam("description") String description,
			@RequestParam("price") Double price, @RequestParam("isAvailable") String available, @RequestParam("photo") String photo, Model model,
			HttpServletRequest request) {
		
		boolean avail = available.equals("yes") ? true : false;
		Meal meal = mealService.getById(id);
		meal.setAvailable(avail);
		meal.setDescription(description);
		meal.setMealImageUrl(photo);
		meal.setMealName(name);
		meal.setPrice(price);
		mealService.update(meal);
		Menu menu = menuService.getById(meal.getMenu().getMenuId());
		model.addAttribute("menu", menu.getMeal());
		
		return "restaurantOwner";
	}
}
