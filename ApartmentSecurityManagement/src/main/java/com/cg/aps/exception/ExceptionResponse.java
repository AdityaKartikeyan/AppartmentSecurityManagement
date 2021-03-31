package com.cg.aps.exception;

import java.time.LocalDateTime;

/**
 * @author Vishal Rana
 *
 */
public class ExceptionResponse {

	private int status;
	private String message;
	private LocalDateTime time;

	public ExceptionResponse() {
		super();
	}

	/**
	 * @param status
	 * @param message
	 * @param time
	 */
	public ExceptionResponse(int status, String message, LocalDateTime time) {
		super();
		this.status = status;
		this.message = message;
		this.time = time;
	}

	/**
	 * @return
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return
	 */
	public LocalDateTime getTime() {
		return time;
	}

	/**
	 * @param time
	 */
	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	/**
	 * @return
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status
	 */
	public void setStatus(int status) {
		this.status = status;
	}
}