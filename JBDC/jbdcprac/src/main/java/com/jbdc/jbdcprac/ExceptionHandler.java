package com.jbdc.jbdcprac;

import java.sql.SQLException;

public class ExceptionHandler {
	public static void handleException(Exception e) {
		if(e instanceof SQLException) {
			SQLException sqlErr = (SQLException) e;
			System.out.println("Err code: " + sqlErr.getErrorCode());
			System.out.println("SQL State: " + sqlErr.getSQLState());
		}
		System.out.println("Exception message: " + e.getMessage());
		System.out.println("Stacktraces: ");
		e.printStackTrace();
	}
}
