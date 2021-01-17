package com.hcl.ecart.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {
	
	
	
	
	//for validating mobile number
	public static boolean mobileValid(String s) 
    { 
        
        Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}"); 
        Matcher m = p.matcher(s); 
        return (m.find() && m.group().equals(s)); 
    } 

}
