package com.hcl.ecart.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
	
	
		private static final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";

		// static Pattern object, since pattern is fixed
		private static Pattern pattern;

		// non-static Matcher object because it's created from the input String
		private static Matcher matcher;

		public EmailValidator() {
			// initialize the Pattern object
			pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
		}

		
		public static boolean validateEmail(String email) {
			matcher = pattern.matcher(email);
			return matcher.matches();
		}
	

}
