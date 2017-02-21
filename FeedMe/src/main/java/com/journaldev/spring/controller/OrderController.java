package com.journaldev.spring.controller;

import java.util.Date;
import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.journaldev.spring.model.Meal;
import com.journaldev.spring.model.Order;
import com.journaldev.spring.model.Restaurant;
import com.journaldev.spring.model.ShoppingCart;
import com.journaldev.spring.model.User;
import com.journaldev.spring.service.OrderService;
import com.journaldev.spring.service.ShoppingCartService;

@Controller
@SessionAttributes({ "user", "cart","restaurant", "menu","rating","starsOn" })
public class OrderController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private ShoppingCartService cartService;

	@RequestMapping(value = "/addOrder/{id}", method = RequestMethod.GET)
	public String addOrder(@PathVariable("id") Long id, Model model) {
		
	return "";
	
	}
	
	@RequestMapping(value = "/saveOrder", method = RequestMethod.GET)
	public String saveOrder(Model model, HttpServletRequest request) {
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		User user = (User) request.getSession().getAttribute("user");
		Order order = new Order();
		order.setDate(new java.sql.Date(new Date().getTime()));
		order.setMeals(cart.getMeals());
		order.setPrice(cart.getPrice());
		order.setUser(user);
		order.setStatus("Pending");
		orderService.add(order);
		cart.setMeals(new HashSet<Meal>());
		cart.setPrice(0d);
		cart.setSize(0);		
		model.addAttribute("cart", cart);
		
		return "shoppingCart";
	
	}


		

}
