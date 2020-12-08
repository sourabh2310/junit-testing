package com.cognizant.junit.exception;

public class EmptyBasketException extends RuntimeException {
	public EmptyBasketException(String cause){
		super(cause);
	}
}
