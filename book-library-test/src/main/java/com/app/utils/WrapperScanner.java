package com.app.utils;

import java.util.Scanner;

public class WrapperScanner {
	
	private static WrapperScanner instance;
	private  Scanner  sc = new Scanner(System.in);

	private WrapperScanner() {
	}

	private boolean isIntegerValue(String s){	
		for(int i=0;i<s.length();i++){
			if(i==0 && s.charAt(i) == '-') continue;
		    if( !Character.isDigit(s.charAt(i)) ) return false;
		 }
		 return true;
	}

	private boolean isDoubleValue(String input) {
	    try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
	}
	
	public static WrapperScanner getInstance(){
		if(instance == null)
			synchronized (WrapperScanner.class) {
				if(instance == null)
					instance = new WrapperScanner();
			}
		return instance;
	}

	public  int nextInt() {		
		String input = null;	
		while(true){
			
			input = sc.next();
			if(isIntegerValue(input))
				return new Integer(input);	
			else{
				System.out.println("Error input! Try again");
			}
		}		
	}
	
	public  double nextDouble() {		
		String input = null;	
		while(true){
			
			input = sc.next();
			if(isDoubleValue(input))
				return new Double(input);	
			else{
				System.out.println("Error input! Try again");
			}
		}		
	}
	
	public void closeScanner(){
		sc.close();
	}
}