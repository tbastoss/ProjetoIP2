package br.com.dieta_saude.java_beans;

public class UsuarioAdm extends Usuario {
	public UsuarioAdm(){
		super();
	}
	public void cadastrarAdm(String nome, String senha, int nivelUser){
	    	this.nome = nome;
	    	this.senha = senha;
	    	this.nivelUser = nivelUser;
	    	this.id++;
	    }

}
