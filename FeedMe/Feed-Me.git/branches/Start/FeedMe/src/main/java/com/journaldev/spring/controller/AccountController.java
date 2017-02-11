package com.journaldev.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.journaldev.spring.model.CreditCard;
import com.journaldev.spring.model.User;
import com.journaldev.spring.service.CreditCardService;
import com.journaldev.spring.service.UserService;
import com.journaldev.spring.util.SecurePassword;

@Controller
@SessionAttributes({ "user", "cart" })
public class AccountController {

	@Autowired
	private UserService userService;
	@Autowired
	private CreditCardService creditCardService;

	@RequestMapping(value = "/account/method", method = RequestMethod.GET)
	public String paymentMethod(@ModelAttribute("user") User user, Model model) {
		
		CreditCard card = creditCardService.getByName(user.getUserId().toString());
		model.addAttribute("card",card);
		return "paymentMethod";
	}

	@RequestMapping(value = "/account/cart", method = RequestMethod.GET)
	public String homeCart(Model model, HttpServletRequest request) {

		return "shoppingCart";
	}

	@RequestMapping(value = "/account/method/save", method = RequestMethod.GET)
	public String paymentMethodSave(@RequestParam("number") String number, @RequestParam("cvv") String cvv,
			@RequestParam("year") String year, @RequestParam("month") String month, Model model,
			HttpServletRequest request, RedirectAttributes attribute) {

		User user = (User) request.getSession().getAttribute("user");
		if (user == null)
			return "redirect:/login";

		CreditCard card = creditCardService.getByName(user.getUserId().toString());
		if (card == null) {
			card = new CreditCard();
			card.setUser(user);
			creditCardService.add(card);
		}
		card.setCvv(Integer.valueOf(cvv));
		card.setNumber(Long.valueOf(number));
		card.setMonth(Integer.valueOf(month));
		card.setYear(Integer.valueOf(year));
		creditCardService.update(card);
		attribute.addFlashAttribute("message", "Information saved!");
		return "redirect:/account/method";
	}

	@RequestMapping(value = "/account/info", method = RequestMethod.GET)
	public String paymentMethodSave(Model model, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null)
			return "redirect:/login";
		return "accountInfo";
	}

	@RequestMapping(value = "/account/balance", method = RequestMethod.GET)
	public String accountBalance(Model model) {

		return "balance";
	}

	@RequestMapping(value = "/account/info/saveName", method = RequestMethod.GET)
	public String accountInfoSaveName(@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, Model model, RedirectAttributes att,
			HttpServletRequest request) {

		User user = (User) request.getSession().getAttribute("user");
		if (user == null)
			return "redirect:/login";

		user.setFirstName(firstName);
		user.setLastName(lastName);
		userService.update(user);
		att.addFlashAttribute("messageSuccess", "Thank you! Your account information has been updated.");
		return "redirect:/account/info";
	}

	@RequestMapping(value = "/account/info/saveAddress", method = RequestMethod.GET)
	public String accountInfoSaveAddress(@RequestParam("address") String address, Model model, RedirectAttributes att,
			HttpServletRequest request) {

		User user = (User) request.getSession().getAttribute("user");
		if (user == null)
			return "redirect:/login";

		user.setAddress(address);
		userService.update(user);
		att.addFlashAttribute("messageSuccess", "Thank you! Your account information has been updated.");
		return "redirect:/account/info";
	}

	@RequestMapping(value = "/account/info/saveZip", method = RequestMethod.GET)
	public String accountInfoSaveZip(@RequestParam("zip") String zip, @RequestParam("city") String city,
			@RequestParam("state") String state, Model model, RedirectAttributes att, HttpServletRequest request) {

		User user = (User) request.getSession().getAttribute("user");
		System.out.println(user.getLastName());
		if (user == null)
			return "redirect:/login";

		user.setCity(city);
		user.setState(state);
		user.setZip(zip);
		userService.update(user);
		att.addFlashAttribute("messageSuccess", "Thank you! Your account information has been updated.");
		return "redirect:/account/info";
	}

	@RequestMapping(value = "/account/info/saveEmail", method = RequestMethod.GET)
	public String accountInfoSaveEmail(@RequestParam("email") String email, @RequestParam("mobile") String mobile,
			Model model, RedirectAttributes att, HttpServletRequest request) {

		User user = (User) request.getSession().getAttribute("user");
		if (user == null)
			return "redirect:/login";

		user.setMobile(Long.valueOf(mobile));
		user.setEmail(email);
		userService.update(user);
		att.addFlashAttribute("messageSuccess", "Thank you! Your account information has been updated.");
		return "redirect:/account/info";
	}

	@RequestMapping(value = "/account/info/savePassword", method = RequestMethod.GET)
	public String accountInfoSavePassword(@RequestParam("newPassword") String newPassword,
			@RequestParam("oldPassword") String oldPassword, Model model, HttpServletRequest request,
			RedirectAttributes att) {

		User user = (User) request.getSession().getAttribute("user");
		System.out.println(user.getLastName());
		if (user == null)
			return "redirect:/login";

		boolean check = true;
		String message = null;
		oldPassword = SecurePassword.getSecurePassword(oldPassword);

		if (!oldPassword.equals(user.getUserPassword())) {
			System.out.println(oldPassword + " " + user.getUserPassword());
			check = false;
			message = "Passwords don't match";

		}

		if (check) {
			newPassword = SecurePassword.getSecurePassword(newPassword);
			user.setUserPassword(newPassword);
			userService.update(user);
			att.addFlashAttribute("messageSuccess", "Thank you! Your account information has been updated.");
			return "redirect:/account/info";
		} else {
			att.addFlashAttribute("messageFailed", message);
			return "redirect:/account/info";
		}

	}

	@RequestMapping(value = "/account/logout", method = RequestMethod.GET)
	public String logoutInfo(Model model, HttpSession session, SessionStatus status) {
		status.setComplete();
		session.removeAttribute("user");
		session.removeAttribute("check");

		return "redirect:/";
	}

}
