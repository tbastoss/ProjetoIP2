package br.com.dieta_saude.excecoes;

public class CampoVazioException extends Exception{
	public CampoVazioException(){
		super("Complete todos os campos corretamente!");
	}
}
