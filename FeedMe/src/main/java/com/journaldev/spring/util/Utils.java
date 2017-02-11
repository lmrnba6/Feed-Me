package com.journaldev.spring.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.journaldev.spring.model.Meal;
import com.journaldev.spring.model.MealRating;
import com.journaldev.spring.model.Menu;
import com.journaldev.spring.model.RestRating;
import com.journaldev.spring.model.Restaurant;
import com.journaldev.spring.model.ShoppingCart;
import com.journaldev.spring.model.User;
import com.journaldev.spring.service.MealRatingService;
import com.journaldev.spring.service.MealService;
import com.journaldev.spring.service.MenuService;
import com.journaldev.spring.service.RestRatingService;
import com.journaldev.spring.service.RestaurantService;
import com.journaldev.spring.service.ShoppingCartService;

public final class Utils {

	public static boolean checkUser(User u, List<User> s, String f, String checkable) {

		if (checkable.equals("email")) {
			for (User user : s) {
				if ((user.getEmail().equals(f)) && (user.getUserId() != u.getUserId())) {
					return true;
				}
			}
		} else {
			for (User user : s) {
				if ((user.getUserName().equals(f)) && (user.getUserId() != u.getUserId())) {
					return true;
				}
			}
		}
		return false;
	}

	public static int starsNumber(List<RestRating> l) {
		int rate = 0;
		for (int i = 0; i < l.size(); i++) {
			rate += l.get(i).getRatingValue();
		}
		if (l.size() != 0)
			rate /= l.size();
		return rate;
	}
	
	public static List<MealRating> mealRatingById(List<MealRating> l, Long id) {

		List<MealRating> rate = new ArrayList<MealRating>();
		for (MealRating mealRating : l) {
			
			if(mealRating.getMeal().getMeal_id()== id){
				
				rate.add(mealRating);
			}
			
		}
	
		return rate;
	}

	public static int mealRating(List<MealRating> l, Long id) {
		int rate=0;
		for (int i = 0; i < l.size(); i++) {
			if(l.get(i).getMeal().getMeal_id()== id){
				
				rate += l.get(i).getRatingValue();
				
			}
			
		}
		if (l.size() != 0)
			rate /= l.size();
		return rate;
	}

	public static void restaurantInfoToModel(Long restId, MenuService menuService, MealRatingService mealRatingService,
			Model model, RestaurantService restaurantService, RestRatingService restRatingService,
			RedirectAttributes att) {
		Restaurant restaurant = restaurantService.getById(restId);
		List<RestRating> ratings = restRatingService.listRestRatingsByRestWithRating(restId);
		List<RestRating> comment = restRatingService.listRestRatingsByRestWithComment(restId);
		int stars = Utils.starsNumber(ratings);
		model.addAttribute("restaurant", restaurant);
		att.addFlashAttribute("restaurant", restaurant);
		model.addAttribute("rating", comment);
		model.addAttribute("starsOn", stars);
		Menu menu = menuService.getByName(String.valueOf(restaurant.getRestId()));
		model.addAttribute("menu", menu.getMeal());
		//model.addAttribute("mealRating", Utils.mealRating(mealRatingService.list()));
	}

	public static void addRestRate(Long id, User user, int rate, RestaurantService restaurantService,
			RestRatingService restRatingService) {
		RestRating rating = new RestRating();
		rating.setRateDate(new java.sql.Date(new Date().getTime()));
		rating.setRatingValue(rate);
		rating.setRestaurant(restaurantService.getById(id));
		rating.setUser(user);
		restRatingService.add(rating);
	}

	public static void addMealRate(Long id, User user, int rate, MealService m, MealRatingService mealRatingService) {
		MealRating rating = new MealRating();
		rating.setRateDate(new java.sql.Date(new Date().getTime()));
		rating.setRatingValue(rate);
		rating.setMeal(m.getById(id));
		rating.setUser(user);
		mealRatingService.add(rating);
	}
	
	public static double setCartPrice(ShoppingCart cart){
		double price=0;
		for (Meal meal : cart.getMeals()) {
			price+=meal.getPrice();
		}
		return price;
	}
}
