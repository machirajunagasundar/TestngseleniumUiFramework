package com.optum.automation.coreframework.utils;

import java.util.ArrayList;

import java.util.Scanner;

public class SpellCheck {

    private Dictionary dict;
    final static String filePath = System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\Dictionary.txt";
   

    public SpellCheck() {
        dict = new Dictionary();
        dict.build(filePath);

    }

    public String getSpellError(String input)
	{
    		
    	String word="";
        
           
            if (!(dict.contains(input))) 
            {
            
            word=input;
            }
            return word;
    }
    
}
