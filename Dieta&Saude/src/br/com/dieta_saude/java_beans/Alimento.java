package br.com.dieta_saude.java_beans;

public class Alimento {
	private String nome;
	private int pontos;
	private int id;
	public Alimento(String nome, int pontos, int id) {
		this.nome = nome;
		this.pontos = pontos;
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	
	public int getPontos() {
		return pontos;
	}
	
	public int getId(){
		return id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	
}
