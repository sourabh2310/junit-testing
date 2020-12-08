package com.cognizant.junit.exception;

public class ItemNotFoundException extends RuntimeException {
	public ItemNotFoundException(String cause){
		super(cause);
	}
}
