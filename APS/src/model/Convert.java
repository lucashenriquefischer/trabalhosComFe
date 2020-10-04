/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author fischer
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Convert {
	public Convert() {
	
	}
	
	public boolean isNumber(String numberString) {
		if (numberString == null) {
	        return false;
	    }
	    try {
	     Double number = Double.parseDouble(numberString);
	     if(number < 0.0) {
	    	 return false;
	     }
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	public boolean isOnlyString(String stringNumber) {
		Pattern r = Pattern.compile("[0-9]+");

	      // Now create matcher object.
	      Matcher m = r.matcher(stringNumber);
	      
	      if (m.find( )) {
	         return false;
	      } else {
	         return true;
	      }
	}
        
        public boolean isVazio(String campoVazio){
            if(campoVazio.isBlank()){
                return true;
            }else{
                return false;
            }
            
        }
}
