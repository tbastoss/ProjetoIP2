package br.com.dieta_saude.excecoes;

public class AlimentoInexistenteException extends Exception{
	public AlimentoInexistenteException(){
		super("Alimento inexistente ou dados incorretos! Insira novamente os dados.");
	}
}
