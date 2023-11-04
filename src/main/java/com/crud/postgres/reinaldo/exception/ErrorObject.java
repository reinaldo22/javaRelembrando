package com.crud.postgres.reinaldo.exception;

public class ErrorObject {

	private int status;
	private String mensagem;

	public ErrorObject(String message, int status) {
		this.mensagem = message;
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
