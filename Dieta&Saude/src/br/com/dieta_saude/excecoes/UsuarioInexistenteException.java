package br.com.dieta_saude.excecoes;

public class UsuarioInexistenteException extends Exception{
	public UsuarioInexistenteException(){
		super("Usu�rio inexistente ou dados incorretos! Insira novamente login e senha.");
	}
}
