package com.example.SpringSecurityUsers.Utils;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;

import java.util.function.Predicate;
import java.util.regex.Pattern;

@Component
public class EmailValidator implements Predicate<String> {

	@Override
	public boolean test(String s) {
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(s);
		
		return matcher.find();
	}

}
