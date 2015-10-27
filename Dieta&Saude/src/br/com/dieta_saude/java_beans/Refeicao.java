package br.com.dieta_saude.java_beans;

public class Refeicao {
	private int id = 0;
	private Alimento[][] alimentos;
	private int pontos;
	
	public Refeicao (int periodo) {
		this.alimentos = new Alimento[periodo][];
		this.pontos = 0;
		this.id++;
	}
	
	public int getId() {
		return id;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	
	
	
}
