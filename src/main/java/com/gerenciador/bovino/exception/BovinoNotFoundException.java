package com.gerenciador.bovino.exception;
public class BovinoNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BovinoNotFoundException(String mensagem) {
		super(mensagem);
	}
	
	public BovinoNotFoundException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
