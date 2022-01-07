package com.desafio.desafiotesting.exception;

/***
 * Repository Exception
 */
public class RepositoryException extends RuntimeException{
	/***
	 * serial Version UID
	 */
	private static final long serialVersionUID = -7012775922197850149L;

	/***
	 * construtor
	 * @param mensagem mensagem de erro
	 */
	public RepositoryException(String mensagem) {
		super(mensagem);
	}
	
}
