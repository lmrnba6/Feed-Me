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
import com.journaldev.spring.model.RestRating;
import com.journaldev.spring.model.Restaurant;
import com.journaldev.spring.model.ShoppingCart;
import com.journaldev.spring.model.User;
import com.journaldev.spring.service.MealRatingService;
import com.journaldev.spring.service.MealService;
import com.journaldev.spring.service.MenuService;
import com.journaldev.spring.service.RestRatingService;
import com.journaldev.spring.service.RestaurantService;
import com.journaldev.spring.util.Utils;

@Controller
@SessionAttributes({ "user", "cart" ,"lat", "lan","restaurant","menu","rating","starsOn","category" })
public class RestaurantController {

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


	@RequestMapping(value = {"/restaurant/list/{city}","/googleRegister/{email}/{name}/{id}/restaurant/list/{city}"}, method = RequestMethod.GET)
	public String restaurantInfo(@PathVariable ("city") String city, Model model) {
		
		model.addAttribute("restaurantList", Utils.getByCity(restaurantService, city));
		return "restaurantList";
	}

	@RequestMapping(value = {"/restaurant/list/{city}/main/{id}/{lat}/{lan}","/googleRegister/{email}/{name}/{userId}/restaurant/list/{city}/main/{id}/{lat}/{lan}"}, method = RequestMethod.GET)
	public String restaurantMain(@PathVariable("lat") String lat, @PathVariable("lan") String lan,@PathVariable("id") Long id, Model model, RedirectAttributes att) {
		model.addAttribute("lan", lan);
		model.addAttribute("lat", lat);
		
		Utils.restaurantInfoToModel(id, menuService, mealRatingService, model, restaurantService, restRatingService,att);
		return "restaurant";
	}
	
	@RequestMapping(value = "/restaurant/main/{id}", method = RequestMethod.GET)
	public String restaurantMain2(@PathVariable("id") Long id, Model model, RedirectAttributes att) {
		model.addAttribute("lan");
		model.addAttribute("lat");
		
		Utils.restaurantInfoToModel(id, menuService, mealRatingService, model, restaurantService, restRatingService,att);
		return "restaurant";
	}
	
	

	@RequestMapping(value = "/restaurant/main/comment/{id}", method = RequestMethod.GET)
	public String restaurantMainComment(@PathVariable("id") Long id, Model model,
			@RequestParam("comment") String comment, HttpServletRequest request,RedirectAttributes att) {

		User user = (User) request.getSession().getAttribute("user");
		
		if (user == null) {
			model.addAttribute(restaurantService.getById(id));
			model.addAttribute("ok", "ok");
			return "login";
		}
		RestRating rating = new RestRating();
		rating.setRateDate(new java.sql.Date(new Date().getTime()));
		rating.setRatingValue(0);
		rating.setRestaurant(restaurantService.getById(id));
		rating.setReview(comment);
		rating.setUser(user);
		//if(!Utils.checkDoubleComment(restRatingService, rating))
		restRatingService.add(rating);
		Utils.restaurantInfoToModel(id, menuService, mealRatingService, model, restaurantService, restRatingService,att);
		return "restaurant";

	}

	@RequestMapping(value ="/restaurant/addCart/{restId}/{mealId}", method = {RequestMethod.GET,RequestMethod.POST})
	public String restaurantAdd(@PathVariable("restId") Long restId,@PathVariable("mealId") Long mealId, Model model, HttpServletRequest request,
			RedirectAttributes attribute) {

		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		User user = (User) request.getSession().getAttribute("user");
		Meal m = mealService.getById(mealId);

		if (cart == null) {

			cart = new ShoppingCart();
			cart.setSize(0);
		} 
		
		if(!Utils.checkDoubleMeal(m, cart)){
			
			cart.getMeals().add(m);
			cart.setSize(cart.getSize() + 1);
		}
		
		
		cart.setPrice(Utils.setCartPrice(cart));
		if (user == null) {
			model.addAttribute(restaurantService.getById(restId));
			model.addAttribute(mealService.getById(mealId));
			model.addAttribute("cart", cart);
			model.addAttribute("ok", "ok");
			return "login";
		}
		model.addAttribute("cart", cart);
		Utils.restaurantInfoToModel(restId, menuService, mealRatingService, model, restaurantService, restRatingService,attribute);
		return "restaurant";
	}

	@RequestMapping(value = "/restaurant/thumbsUpRest/{restId}", method = RequestMethod.GET)
	public String restaurantThumsUpRest(@PathVariable("restId") Long restId, Model model, HttpServletRequest request, RedirectAttributes att) {

		User user = (User) request.getSession().getAttribute("user");
		
		if (user == null) {
			model.addAttribute("ok", "ok");
			model.addAttribute("restaurant", restaurantService.getById(restId));
			return "login";
		}

		Utils.restaurantInfoToModel(restId, menuService, mealRatingService, model, restaurantService, restRatingService,att);
		Utils.addRestRate(restId, user, 5,restaurantService,restRatingService);
		return "restaurant";
	}

	

	@RequestMapping(value = "/restaurant/thumbsUpMeal/{restId}/{mealId}", method = RequestMethod.GET)
	public String restaurantThumsUpMeal(@PathVariable("restId") Long restId,@PathVariable("mealId") Long mealId, Model model,HttpServletRequest request,RedirectAttributes att) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			model.addAttribute("ok", "ok");
			model.addAttribute("restaurant", restaurantService.getById(restId));
			return "login";
		}
		
		Utils.addMealRate(mealId, user, 5, mealService, mealRatingService);
		Meal meal = mealService.getById(mealId);
		meal.setType(String.valueOf(Utils.mealRating(Utils.mealRatingById(mealRatingService.list(), mealId), mealId)));
		mealService.update(meal);
		
		Utils.restaurantInfoToModel(restId, menuService, mealRatingService, model, restaurantService, restRatingService,att);
		return "restaurant";
	}

	@RequestMapping(value = "/restaurant/thumbsDownRest/{restId}", method = RequestMethod.GET)
	public String restaurantThumsDownRest(@PathVariable("restId") Long restId, Model model,HttpServletRequest request,RedirectAttributes att) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			model.addAttribute("ok", "ok");
			model.addAttribute("restaurant", restaurantService.getById(restId));
			return "login";
		}
		
		Utils.addRestRate(restId, user, 0,restaurantService,restRatingService);
		Utils.restaurantInfoToModel(restId,menuService, mealRatingService, model, restaurantService, restRatingService,att);
		return "restaurant";
	}

	@RequestMapping(value = "/restaurant/thumbsDownMeal/{restId}/{mealId}", method = RequestMethod.GET)
	public String restaurantThumsDownMeal(@PathVariable("restId") Long restId,@PathVariable("mealId") Long mealId, Model model,HttpServletRequest request,RedirectAttributes att) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			model.addAttribute("ok", "ok");
			model.addAttribute("restaurant", restaurantService.getById(restId));
			return "login";
		}
		Utils.addMealRate(mealId, user, 0, mealService, mealRatingService);
		Meal meal = mealService.getById(mealId);
		meal.setType(String.valueOf(Utils.mealRating(Utils.mealRatingById(mealRatingService.list(), mealId), mealId)));
		mealService.update(meal);	
		Utils.restaurantInfoToModel(restId, menuService, mealRatingService, model, restaurantService, restRatingService,att);
		return "restaurant";
	}
	
	@RequestMapping(value = "restaurant/list/map/{lat}/{lan}", method = RequestMethod.GET)
	public String map(@PathVariable("lat") String lat, @PathVariable("lan") String lan, Model model ) {
		
		
		model.addAttribute("lan", lan);
		model.addAttribute("lat", lat);
		
		return "map";
	}

}
