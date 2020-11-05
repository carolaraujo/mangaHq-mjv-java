package br.com.mjv.mangahq.exceptions;

public class ImpossibleInsertException extends Exception {

	private static final long serialVersionUID = 1L;

	public ImpossibleInsertException(String msg) {
		super(msg);
	}
}
