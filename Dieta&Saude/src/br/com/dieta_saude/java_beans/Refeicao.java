package br.com.dieta_saude.java_beans;

public class Refeicao {
	private int id = 0;
	private Alimento[] alimentos;
	private int pontos;
	
	/*
	 * Pecisa v como vai ficar o funcionamento da classe, ja que foi feita a 
	 * alteração indicada pelo professor.
	 * 
	 * No caso vamos ter um array simples de alimetos e na classe dieta o usuário
	 * vamos ter um array bidimencional com as dimenções sendo [quantidade de refeições (escolhida pelo usuário)] [periodo da dieta (também escolhido pelo usuário)]
	 */
	
	public Refeicao (int tamanhoRepositorioDeAlimento) {
		this.alimentos = new Alimento[tamanhoRepositorioDeAlimento];
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
