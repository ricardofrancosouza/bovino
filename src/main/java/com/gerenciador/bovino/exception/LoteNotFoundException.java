package com.gerenciador.bovino.exception;
public class LoteNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoteNotFoundException(String mensagem) {
		super(mensagem);
	}
	
	public LoteNotFoundException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
