package org.young.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public Map<String, String> calc(String input, int cond) {
		
		Map<String, String> resultMap = new HashMap<String, String>();
		
		String regExNum = "[^\\d]";
	    String  strNum = sortStr(input.replaceAll(regExNum, ""));
	    String[] strNumArray = strNum.split("");
	    int numberLength = strNum.length();
	    
	    String regExNumChar = "[^\\w]";
	    String strNumChar = input.replaceAll(regExNumChar, "");
	    String regExNumR = "[^\\D]";
	    String strChar = sortStr(strNumChar.replaceAll(regExNumR, ""));
	    String[] strCharArray = strChar.split("");
	    int charLength = strChar.length();
	        
	    List<String> finalStringList = new ArrayList<String>();
	       
	    int maxLength = numberLength >= charLength ? numberLength : charLength;
	    
	    for(int i = 0 ; i < maxLength ; i++ ) {
	   	 if(charLength > i) finalStringList.add( strCharArray[i] );
	   	 if(numberLength > i) finalStringList.add( strNumArray[i] );
	    }
	    
	    String[] finalString = new String[ finalStringList.size() ];
	    finalStringList.toArray( finalString );
	    
	    String lastString = String.join("",finalString);
	    
	    int totalLength = numberLength + charLength;
	    
	    int rest = totalLength % cond;
	    
	    String resultQ = lastString.substring(0, totalLength-rest);
	    String resultM = lastString.substring(totalLength-rest, totalLength);
	    
	    resultMap.put("resultQ", resultQ);
	    resultMap.put("resultM", resultM);
	    
		return resultMap;
		
	}
	
	
}
