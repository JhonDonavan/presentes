package com.presentes.exceptions;


import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class PresentesExceptionsNotFound extends RuntimeException {

	private static final long serialVersionUID = -3963834820587237093L;

	@NonNull
	private String id;
	private String message;
	
	public PresentesExceptionsNotFound(long id) {
		
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
 
}
