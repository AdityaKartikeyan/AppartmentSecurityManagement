package com.cg.aps.exception;

/**
 * @author Anshul Joshi
 *
 */
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