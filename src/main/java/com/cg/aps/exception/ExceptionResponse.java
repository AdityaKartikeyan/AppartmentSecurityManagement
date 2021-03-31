/**
 * @author AMBARISH DATAR
 *
 */
package com.cg.aps.exception;

import java.time.LocalDateTime;

public class ExceptionResponse {
    private int status;				//Exception Status
    private String message;			//Exception Message
    private LocalDateTime time; 	// Exception Time
    
    public ExceptionResponse() {
        super();
    }
    public ExceptionResponse(int status, String message, LocalDateTime time) {
        super();
        this.status = status;
        this.message = message;
        this.time = time;
    }
    
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public LocalDateTime getTime() {
        return time;
    }
    public void setTime(LocalDateTime time) {
        this.time = time;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
}