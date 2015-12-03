package br.com.dieta_saude.excecoes;

public class CodigoInvalidoException extends Exception{
	public CodigoInvalidoException(){
		super("Insira comum para usuario comum ou o código administrativo!");
	}
}
