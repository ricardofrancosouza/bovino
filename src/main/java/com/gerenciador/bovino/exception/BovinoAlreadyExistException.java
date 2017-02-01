package com.gerenciador.bovino.exception;
public class BovinoAlreadyExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BovinoAlreadyExistException(String mensagem) {
		super(mensagem);
	}
	
	public BovinoAlreadyExistException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
