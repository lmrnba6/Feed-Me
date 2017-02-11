package com.journaldev.spring.controller;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.journaldev.spring.model.Meal;
import com.journaldev.spring.model.Restaurant;
import com.journaldev.spring.model.ShoppingCart;
import com.journaldev.spring.model.User;
import com.journaldev.spring.service.MealRatingService;
import com.journaldev.spring.service.MealService;
import com.journaldev.spring.service.MenuService;
import com.journaldev.spring.service.RestRatingService;
import com.journaldev.spring.service.RestaurantService;
import com.journaldev.spring.service.ShoppingCartService;
import com.journaldev.spring.service.UserService;
import com.journaldev.spring.util.SecurePassword;
import com.journaldev.spring.util.Utils;

@Controller
@SessionAttributes({ "user", "cart" })
public class HomeController {

	@Autowired
	private UserService userService;
	@Autowired
	private ShoppingCartService cartService;
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


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main(Model model, HttpServletRequest request) {

		return "main";
	}

	@RequestMapping(value = {"/login","/restaurant/main/login","restaurant/login","account/login"},method = RequestMethod.GET)
	public String login(Model model,RedirectAttributes att) {
		
		return "login";
	}

	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String homeCart(Model model, HttpServletRequest request) {
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		if (cart == null) {
			cart = new ShoppingCart();

		}
		model.addAttribute("cart", cart);
		
		return "shoppingCart";
	}
	
	@RequestMapping(value = "/cart/delete/{id}", method = RequestMethod.GET)
	public String carteDelete(@PathVariable("id") Long id,Model model, HttpServletRequest request) {
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		cart.getMeals().remove(mealService.getById(id));
		for (Iterator<Meal> iterator = cart.getMeals().iterator(); iterator.hasNext();) {
		    Meal s =  iterator.next();
		    if (s.getMeal_id() == id) {
		        iterator.remove();
		        break;
		    }       
		}
		cart.setPrice(Utils.setCartPrice(cart));
		cart.setSize(cart.getSize()-1);
		model.addAttribute("cart", cart);
		
		return "shoppingCart";
	}
	
	@RequestMapping(value = "/cart/refresh/{id}", method = RequestMethod.GET)
	public String carteRefresh(@PathVariable("id") Long id,Model model, HttpServletRequest request) {
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		cart.getMeals().remove(mealService.getById(id));
		
		model.addAttribute("cart", cart);
		
		return "shoppingCart";
	}

	@SuppressWarnings("null")
	@RequestMapping(value = "/logged", method = RequestMethod.POST)
	public String loginUser(@RequestParam("userName") String userName, @RequestParam("password") String password,
			Model model, HttpServletRequest request) {

		boolean check = this.userService.checkLogin(userName, password);
		
		User user = null;
		if (!check) {
			return "redirect:/denied";
		} else {
			user = userService.getByName(userName);
			model.addAttribute("user", user);
			ShoppingCart cart = new ShoppingCart();
			cart.setSize(0);
			model.addAttribute("cart", cart);
			return "redirect:/";
		}

	}
	
	@SuppressWarnings("null")
	@RequestMapping(value = "/loggedMenu/{id}", method = RequestMethod.POST)
	public String loginUserMenu(@PathVariable("id") Long id, @RequestParam("userName") String userName, @RequestParam("password") String password,
			Model model, HttpServletRequest reques, RedirectAttributes attribute) {
		
		boolean check = this.userService.checkLogin(userName, password);
		User user = null;
		if (!check) {
			return "redirect:/denied";
		} else {
			user = userService.getByName(userName);
			model.addAttribute("user", user);
			Utils.restaurantInfoToModel(id, menuService, mealRatingService, model, restaurantService, restRatingService,attribute);
			return "restaurant";
		}

	}


	@RequestMapping(value = "/registered", method = RequestMethod.POST)
	public String registred(@RequestParam("userName") String userName, @RequestParam("password") String password,
			@RequestParam("email") String email, @RequestParam("lastName") String lastName,
			@RequestParam("firstName") String firstName, @RequestParam("password2") String password2, Model model)
			throws NoSuchAlgorithmException, NoSuchProviderException {

		boolean check = true;
		String message = null;
		List<User> userList = this.userService.list();

		for (User u : userList) {

			if (u.getUserName().equals(userName)) {
				check = false;
				message = "Username exist already";
				break;
			} else if (u.getEmail().equals(email)) {
				check = false;
				message = "Email exist already";
				model.addAttribute("userName", userName);
				break;
			}

		}

		if (!password.equals(password2)) {
			check = false;
			message = "passwords dont match";
			model.addAttribute("email", email);
		}

		if (check) {
			User user = new User();
			user.setUserName(userName);
			password = SecurePassword.getSecurePassword(password);
			user.setUserPassword(password);
			user.setEmail(email);
			user.setLastName(lastName);
			user.setFirstName(firstName);
			user.setEntryDate(new Date(new java.util.Date().getTime()));
			userService.add(user);
			ShoppingCart cart = new ShoppingCart();
			cart.setUser(user);
			cart.setPrice(0d);
			cart.setSize(0);
			cartService.add(cart);
			model.addAttribute("message", "Thank you you're registered !");
			return "login";
		} else {
			model.addAttribute("message", message);
			model.addAttribute("firstName", firstName);
			model.addAttribute("lastName", lastName);
			model.addAttribute("userName", userName);
			model.addAttribute("email", email);
			return "register";
		}

	}

	@RequestMapping(value ={"/logout","/account/logout","/restaurant/addCart/logout"}, method = RequestMethod.GET)
	public String logout(Model model, HttpSession session, SessionStatus status) {
		status.setComplete();
		session.removeAttribute("user");
		session.removeAttribute("cart");

		return "redirect:/";
	}

	@RequestMapping(value = {"/register","/restaurant/main/register","restaurant/register"}, method = RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("message", "");
		return "register";
	}

	@RequestMapping(value = "/denied", method = RequestMethod.GET)
	public String denied() {
		return "denied";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "test";
	}

}
