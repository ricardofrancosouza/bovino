package com.gerenciador.bovino.exception;
public class LoteAlreadyExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoteAlreadyExistException(String mensagem) {
		super(mensagem);
	}
	
	public LoteAlreadyExistException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
