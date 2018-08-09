package org.young.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/calc")
public class CalcController {
	
	private static final Logger logger = LoggerFactory.getLogger(CalcController.class);
	
	public String sortStr(String str){
	    String[] array = str.split("");
	    Arrays.sort(array);
	    return  String.join("",array);
	  }
	
	@PostMapping
	@ResponseBody
	public void calc(String input, int cond) {
		
		 logger.info(input);
		 logger.info("" + cond);
		 
		 String match = "[^\\d]";
	     String  str = sortStr(input.replaceAll(match, ""));
	     String[] str_1 = str.split("");
	     
	     logger.info(str); // 숫자만
	     
	     int numberLength = str.length();
	     
	     logger.info(""+numberLength);
	     
	     String match2 = "[^\\w$]";
	     String str2 = input.replaceAll(match2, "");
	     String match3 = "[^\\D]";
	     String str3 = sortStr(str2.replaceAll(match3, ""));
	     String[] str3_1 = str3.split("");

	     logger.info(str3); //알파벳만 
	     
	     int charLength = str3.length();
	     
	     logger.info(""+charLength);
	         
	     List<String> where = new ArrayList<String>();
	    
	        
	     int maxLength = numberLength >= charLength ? numberLength : charLength;
	     
	     logger.info(""+maxLength);
	     
	     for(int i = 0 ; i < maxLength ; i++ ) {
	    	 if(charLength > i) where.add( str3_1[i] );
	    	 if(numberLength > i) where.add( str_1[i] );
	     }
	     
	     logger.info(""+ where);
	     
	     String[] simpleArray = new String[ where.size() ];
	     where.toArray( simpleArray );
	     
	     logger.info( String.join("",simpleArray));
	     
		
	}
	

	
	
	
	
}
