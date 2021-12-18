package com.jbdc.jbdcprac;


public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	try {
    		ProductComponent comp = new ProductComponent();
    		
    		comp.tryConnection(50.0, 100.0); 
    		
    	}catch(Exception e) {
    		ExceptionHandler.handleException(e);
    	}
    }
}
