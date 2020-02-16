package org.atp.roman_numbers;

public class NotValidSymbolException extends Exception {
	private static final long serialVersionUID = 1L;

	public NotValidSymbolException(String message) {
		super(message);
	}
}
