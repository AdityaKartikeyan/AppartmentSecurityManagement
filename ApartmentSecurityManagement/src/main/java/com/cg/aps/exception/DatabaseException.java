package com.cg.aps.exception;



public class DatabaseException  extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
    * @param msg
    *            : Error message
    */
   public DatabaseException(String msg) {
       super(msg);
   }
}

