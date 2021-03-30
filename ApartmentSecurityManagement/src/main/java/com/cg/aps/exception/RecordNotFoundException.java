package com.cg.aps.exception;

/**
 * @author Vishal Rana
 *
 */
public class RecordNotFoundException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param msg
	 *            error message
	 */
	public RecordNotFoundException(String msg) {
		super(msg);

	}
}