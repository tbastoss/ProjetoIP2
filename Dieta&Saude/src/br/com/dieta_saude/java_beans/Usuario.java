package br.com.dieta_saude.java_beans;

public class Usuario {

	protected String nome;
	protected String senha;
	protected int nivelUser;
	protected int id = 0;
	protected static String codAdmin = "dieta123";
	
    
    public Usuario(){
    }
    
    public String getNome(){
    	return this.nome;
    }
    
    public int getId() {
		return id;
	}
  
    
    public String getSenha() {
		return senha;
	}
    
	public static String getCodAdmin() {
		return codAdmin;
	}
	
	public int getNivelUser() {
		return nivelUser;
	}
}
