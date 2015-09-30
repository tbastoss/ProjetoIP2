package br.com.dieta_saude.java_beans;

public class Alimento {
	private String nome;
	private int pontos;
	
	public Alimento(String nome, int pontos) {
		this.nome = nome;
		this.pontos = pontos;
	}

	public String getNome() {
		return nome;
	}
	
	public int getPontos() {
		return pontos;
	}

}
