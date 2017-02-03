package com.journaldev.spring.controller;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.journaldev.spring.model.Meal;
import com.journaldev.spring.model.ShoppingCart;
import com.journaldev.spring.model.User;
import com.journaldev.spring.service.ShoppingCartService;
import com.journaldev.spring.service.UserService;
import com.journaldev.spring.util.SecurePassword;

@Controller
@SessionAttributes({ "user", "cart" })
public class HomeController {

	@Autowired
	private UserService userService;
	@Autowired
	private ShoppingCartService cartService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main(Model model) {
		
		return "main";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		
		return "login";
	}

	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String homeCart(Model model, HttpServletRequest request) {
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		if (cart == null){
			cart = new ShoppingCart(); 
			
		}
		model.addAttribute("cart",cart);
		return "shoppingCart";
	}

	@SuppressWarnings("null")
	@RequestMapping(value = "/logged", method = RequestMethod.POST)
	public String loginUser(@RequestParam("userName") String userName, @RequestParam("password") String password,
			Model model, RedirectAttributes att, HttpServletRequest request) {

		boolean check = this.userService.checkLogin(userName, password);
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		User user = null;
		if (!check) {
			return "redirect:/denied";
		} else {
			user = userService.getByName(userName);
			model.addAttribute("user", user);
			if (cart != null) {
				Set<Meal> userMeals = cart.getMeals();
				cart = cartService.getByUser(user);
				if (cart != null) {
					for (Meal m : userMeals) {
						cart.getMeals().add(m);
					}
				} else {
					cart.setUser(user);
				}

			} else {
				cart = cartService.getByUser(user);

			}
			model.addAttribute("cart", cart);
			return "redirect:/";
		}

	}

	@RequestMapping(value = "/registered", method = RequestMethod.POST)
	public String registred(@RequestParam("userName") String userName, @RequestParam("password") String password,
			@RequestParam("email") String email,
			@RequestParam("password2") String password2, Model model)
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
			return "register";
		}

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model, HttpSession session, SessionStatus status) {
		status.setComplete();
		session.removeAttribute("user");
		session.removeAttribute("cart");

		return "redirect:/";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
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
