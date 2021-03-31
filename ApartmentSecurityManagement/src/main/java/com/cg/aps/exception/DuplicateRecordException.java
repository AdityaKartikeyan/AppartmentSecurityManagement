package com.cg.aps.exception;

/**
 * @author Vishal Rana
 *
 */
public class DuplicateRecordException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param msg error message
	 */
	public DuplicateRecordException(String msg) {
		super(msg);
	}
}
