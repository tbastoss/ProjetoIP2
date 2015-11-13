package br.com.dieta_saude.java_beans;

public class Usuario {
	//TEESTEEEE
	protected String nome;
	protected String senha;
	protected int nivelUser;
	protected int id = 0;
	protected char sexo;
	protected double altura;
	protected double peso;
	protected int idade;
	protected int nivelDeSedentarismo; //Vai de 1 - 6, para o calculo do FA, em calcularPontos
	protected int pontos;
	protected Dieta dieta;
	protected static String codAdmin = "dieta123";
    
    public Usuario(){
    }
    
    public String getNome(){
    	return this.nome;
    }
    
    public int getId() {
		return id;
	}
    
	public int getPontos() {
		return pontos;
	}
	
	public Dieta getDieta() {
		return dieta;
	}
	
	public void setDieta(Dieta dieta) {
		this.dieta = dieta;
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
