package com.journaldev.spring.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.journaldev.spring.model.Meal;
import com.journaldev.spring.model.RestRating;
import com.journaldev.spring.model.Restaurant;
import com.journaldev.spring.model.ShoppingCart;
import com.journaldev.spring.model.User;
import com.journaldev.spring.service.MealService;
import com.journaldev.spring.service.MenuService;
import com.journaldev.spring.service.RestRatingService;
import com.journaldev.spring.service.RestaurantService;
import com.journaldev.spring.service.UserService;
import com.journaldev.spring.util.Utils;

@Controller
@SessionAttributes({ "check", "user", "cart" })
public class RestaurantController {

	@Autowired
	private UserService userService;
	@Autowired
	private RestaurantService restaurantService;
	@Autowired
	private RestRatingService restRatingService;
	@Autowired
	private MealService mealService;
	@Autowired
	private MenuService menuService;

	@RequestMapping(value = "/restaurant/list", method = RequestMethod.GET)
	public String restaurantInfo(Model model) {

		model.addAttribute("restaurantList", restaurantService.list());
		return "restaurantList";
	}

	@RequestMapping(value = "/restaurant/main/{id}", method = RequestMethod.GET)
	public String restaurantMain(@PathVariable("id") Long id, Model model) {
		Restaurant restaurant = restaurantService.getById(id);
		List<RestRating> rating = restRatingService.listRestRatingsByRest(id);
		int stars = Utils.starsNumber(rating);
		model.addAttribute("restaurant", restaurant);
		model.addAttribute("rating", rating);
		model.addAttribute("ratingSize", rating.size());
		model.addAttribute("starsOn", stars);
		Meal m = new Meal();
		m.setMeal_id(1L);
		m.setMealName("pizza");
		Set<Meal> l = new HashSet<Meal>();
		l.add(m);
		l.add(m);
		l.add(m);
		l.add(m);
		l.add(m);
		menuService.getByName(restaurant.getName()).setMeal(l);
		//restaurant.getgetMenu().setMeal(l);
		model.addAttribute("menu", l);

		return "restaurant";
	}

	@RequestMapping(value = "/restaurant/addCart/{id}", method = RequestMethod.GET)
	public String restaurantAdd(@PathVariable("id") Long id, Model model, HttpServletRequest request, RedirectAttributes attribute) {

		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		User user = (User)  request.getSession().getAttribute("user");
		
		if(cart==null)
			cart= new ShoppingCart();
		
		Meal m = mealService.getById(id);

		if (user!=null) {
			Set<Meal> l = cart.getMeals();
			l.add(m);
			cart.setMeals(l);
			cart.setUser(user);
			cart.setSize(cart.getMeals().size());
			model.addAttribute("cart", cart);
		} else {
			model.addAttribute("meal", m);
			ShoppingCart cart2 = new ShoppingCart();
			cart.getMeals().add(m);
			attribute.addFlashAttribute("cart", cart2);
			return "redirect:/login";
		}

		return "restaurant";
	}

	@RequestMapping(value = "/restaurant/logout", method = RequestMethod.GET)
	public String logoutInfo(Model model, HttpSession session, SessionStatus status) {
		status.setComplete();
		session.removeAttribute("user");
		session.removeAttribute("check");

		return "redirect:/";
	}

	@RequestMapping(value = "/restaurant/login", method = RequestMethod.GET)
	public String restaurantLogin(Model model) {

		return "login";
	}

	@RequestMapping(value = "/restaurant/register", method = RequestMethod.GET)
	public String restaurantRegister(Model model) {

		return "register";
	}

}
