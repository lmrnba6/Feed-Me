package com.journaldev.spring.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.journaldev.spring.model.Meal;
import com.journaldev.spring.model.RestCategory;
import com.journaldev.spring.model.RestRating;
import com.journaldev.spring.model.Restaurant;
import com.journaldev.spring.model.ShoppingCart;
import com.journaldev.spring.model.User;
import com.journaldev.spring.service.MealRatingService;
import com.journaldev.spring.service.MealService;
import com.journaldev.spring.service.MenuService;
import com.journaldev.spring.service.RestCategoryService;
import com.journaldev.spring.service.RestRatingService;
import com.journaldev.spring.service.RestaurantService;
import com.journaldev.spring.util.Utils;

@Controller
@SessionAttributes({ "user", "cart", "lat", "lan", "restaurant", "menu", "rating", "starsOn", "category" })
public class RestaurantOwnerController {

	@Autowired
	private RestaurantService restaurantService;
	@Autowired
	private RestCategoryService categoryService;

	@RequestMapping(value = "/restaurant/addPicture")
	public String addPicture(@RequestParam("photo") String photo, Model model, HttpServletRequest request) {

		Restaurant restaurant = (Restaurant) request.getSession().getAttribute("restaurant");
		restaurant.setRestImageUrl(photo);
		restaurantService.update(restaurant);
		model.addAttribute("restaurant", restaurant);
		model.addAttribute("messageSuccess", "information Updated");
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
		model.addAttribute("messageSuccess", "information Updated");
		return "restaurantOwner";
	}

	@RequestMapping(value = "/restaurant/saveAddress")
	public String saveAddress(@RequestParam("description") String description, @RequestParam("address") String address,
			Model model, HttpServletRequest request) {

		Restaurant restaurant = (Restaurant) request.getSession().getAttribute("restaurant");
		restaurant.setAddress(address);
		restaurant.setDiscription(description);
		restaurantService.update(restaurant);
		model.addAttribute("restaurant", restaurant);
		model.addAttribute("messageSuccess", "information Updated");
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
		model.addAttribute("messageSuccess", "information Updated");
		return "restaurantOwner";
	}

	@RequestMapping(value = "/restaurant/city")
	public String saveCity(@RequestParam("zip") String zip, @RequestParam("city") String city,
			@RequestParam("opening") String opening, @RequestParam("closing") String closing, Model model,
			HttpServletRequest request) {

		Restaurant restaurant = (Restaurant) request.getSession().getAttribute("restaurant");
		restaurant.setCity(city);
		restaurant.setZip(zip);
		restaurant.setOpening(opening);
		restaurant.setClosing(closing);
		model.addAttribute("restaurant", restaurant);
		model.addAttribute("messageSuccess", "information Updated");
		return "restaurantOwner";
	}
}
