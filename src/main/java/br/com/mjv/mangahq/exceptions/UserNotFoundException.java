package br.com.mjv.mangahq.exceptions;

public class UserNotFoundException extends Exception {
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String e) {
		super(e);
	}
}
