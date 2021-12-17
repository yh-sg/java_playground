package com.jbdc.jbdcprac;


public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	try {
    		ProductComponent comp = new ProductComponent();
    		
    		if(comp.tryConnection()) 
    			System.out.println("Connection was success");
    		else 
    			System.out.println("Connection was failure");
    		
    	}catch(Exception e) {
    		ExceptionHandler.handleException(e);
    	}
    }
}
