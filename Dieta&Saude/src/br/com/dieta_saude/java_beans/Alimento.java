package br.com.dieta_saude.java_beans;

public class Alimento {
	private String nome;
	private int pontos;
	private int id = 0;
	public Alimento(String nome, int pontos) {
		this.nome = nome;
		this.pontos = pontos;
		this.id++;
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
