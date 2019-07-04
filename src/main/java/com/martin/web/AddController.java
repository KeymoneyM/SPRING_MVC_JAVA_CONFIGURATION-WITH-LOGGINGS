package com.martin.web;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddController {
private static final Logger loger = Logger.getLogger(Log.class.getName());
	
	public static void stpLogs()
	{
		LogManager.getLogManager().reset();
		loger.setLevel(Level.ALL);
		
		try
		{
			FileHandler fh = new FileHandler("MLogs.txt");
			fh.setLevel(Level.FINE);
			loger.addHandler(fh);
		}
		catch(Exception e)
		{
			loger.log(Level.SEVERE, "Could not work!", e);
		}
	}
	
	@RequestMapping("add")
    public ModelAndView add(@RequestParam("value1")int num1, @RequestParam("value2")int num2) {
		//return null;
		
		ModelAndView mv = new ModelAndView();
		Log.stpLogs();
		loger.severe("Num1: "+ Integer.toString(num1));
		loger.severe("Num2: "+ Integer.toString(num2));
		
//		lg.stpLogs();
//		loger.severe("Testing");
		int k = num1 + num2;
		loger.severe("Result: "+ Integer.toString(k));
//		loger.severe(n);
		mv.addObject("result", k);
		mv.setViewName("result.jsp");
		
		return mv;
		
    	
    }
}
