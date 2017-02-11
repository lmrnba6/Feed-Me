package com.journaldev.spring.util;

import java.util.List;

import com.journaldev.spring.model.RestRating;
import com.journaldev.spring.model.User;

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

}
