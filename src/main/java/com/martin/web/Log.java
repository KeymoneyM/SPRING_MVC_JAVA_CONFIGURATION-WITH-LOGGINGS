package com.martin.web;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Log {
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

}
