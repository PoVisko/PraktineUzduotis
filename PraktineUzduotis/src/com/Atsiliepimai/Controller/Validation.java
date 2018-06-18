package com.Atsiliepimai.Controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

	private static final String VALID_ID_REGEX ="^[0-9]{1,7}$";
	private static final String VALID_NAME_REGEX ="^[-A-Za-z ]{1,30}$";
	private static final String VALID_CITY_REGEX ="^[A-Za-z]{3,30}$";
	private static final String VALID_EMAIL_REGEX = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String VALID_REVIEW_REGEX ="^.{0,280}$";
	
	public static boolean isValidId(String id){
		Pattern idPattern = Pattern.compile(VALID_ID_REGEX);
		Matcher idMatcher = idPattern.matcher(id);
		return idMatcher.find();
	}
	
	public static boolean isValidName(String vardas){
		Pattern namePattern = Pattern.compile(VALID_NAME_REGEX);
		Matcher nameMatcher = namePattern.matcher(vardas);
		return nameMatcher.find();
	}
	
	public static boolean isValidCity(String miestas){
		Pattern cityPattern = Pattern.compile(VALID_CITY_REGEX);
		Matcher cityMatcher = cityPattern.matcher(miestas);
		return cityMatcher.find();
	}
	
	public static boolean isValidEmail(String email){
		Pattern emailPattern = Pattern.compile(VALID_EMAIL_REGEX);
		Matcher emailMatcher = emailPattern.matcher(email);
		return emailMatcher.find();
	}
	
	public static boolean isValidReview(String review){
		Pattern reviewPattern = Pattern.compile(VALID_REVIEW_REGEX);
		Matcher reviewMatcher = reviewPattern.matcher(review);
		return reviewMatcher.find();
	}
}
