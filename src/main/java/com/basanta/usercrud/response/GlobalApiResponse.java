package com.basanta.usercrud.response;

import java.io.Serializable;

import com.basanta.usercrud.Enum.ResponseStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GlobalApiResponse implements Serializable {
	
	private ResponseStatus status;
	private String message;
	private Object data;
	
	
	public void setResponse(ResponseStatus status, String message, Object data) {
		
		this.status = status;
		this.message = message;
		this.data = data;
	}


	public ResponseStatus getStatus() {
		return status;
	}


	public void setStatus(ResponseStatus status) {
		this.status = status;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Object getData() {
		return data;
	}


	public void setData(Object data) {
		this.data = data;
	}
	
	
	
	
	

}
