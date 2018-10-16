package com.apt.truyenmvc.utils;

import java.util.Collection;
import java.util.Random;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class WebUtils {

	public static String toString(User user) {
		StringBuilder sb = new StringBuilder();

		sb.append("UserName:").append(user.getUsername());

		Collection<GrantedAuthority> authorities = user.getAuthorities();
		if (authorities != null && !authorities.isEmpty()) {
			sb.append(" (");
			boolean first = true;
			for (GrantedAuthority a : authorities) {
				if (first) {
					sb.append(a.getAuthority());
					first = false;
				} else {
					sb.append(", ").append(a.getAuthority());
				}
			}
			sb.append(")");
		}
		return sb.toString();
	}
	
	public static boolean checkLongNumber(String number) {
		try {
			Long.parseLong(number);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public static boolean checkIntNumber(String number) {
		try {
			Integer.parseInt(number);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

    public static int getRandomNumber() {
        int randomInt = 0;
        Random randomGenerator = new Random();
        randomInt = randomGenerator.nextInt(ConstantsUtils.CHAR_LIST.length());
        if (randomInt - 1 == -1) {
            return randomInt;
        } else {
            return randomInt - 1;
        }
    }

    public static String randomPassword() {
        StringBuffer randStr = new StringBuffer();
        for (int i = 0; i < ConstantsUtils.RANDOM_STRING_LENGTH; i++) {
            int number = getRandomNumber();
            char ch = ConstantsUtils.CHAR_LIST.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }
}
