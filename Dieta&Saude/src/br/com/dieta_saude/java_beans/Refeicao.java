package br.com.dieta_saude.java_beans;

public class Refeicao {
	private int id = 0;
	private Alimento[] alimentos;
	private int pontos;
	
	/*
	 * Pecisa v como vai ficar o funcionamento da classe, ja que foi feita a 
	 * altera��o indicada pelo professor.
	 * 
	 * No caso vamos ter um array simples de alimetos e na classe dieta o usu�rio
	 * vamos ter um array bidimencional com as dimen��es sendo [quantidade de refei��es (escolhida pelo usu�rio)] [periodo da dieta (tamb�m escolhido pelo usu�rio)]
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
