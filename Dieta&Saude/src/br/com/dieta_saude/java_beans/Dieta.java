package br.com.dieta_saude.java_beans;

import java.time.*;

public class Dieta {
	//USAR JAVA TIME
	private int periodoEmDiasDaDieta;
	private Refeicao[][] refeicao;
	private int qtdRefeicao;
	private int proximoDia;
	private int pontos;
	private int id = 0;
	
	public Dieta(int qtdRefeicao, int periodoEmDias) {
		this.periodoEmDiasDaDieta = periodoEmDias;
		this.refeicao = new Refeicao [periodoEmDias][qtdRefeicao];
		for (int i = 0; i< periodoEmDias; i++){
			for (int j = 0; j < qtdRefeicao; j++){
				this.refeicao[i][j] = null;
			}
		}
		this.proximoDia = 0;
		this.pontos = 0;
		this.id++;
	}

	public int getPeriodoEmDiasDaDieta() {
		return periodoEmDiasDaDieta;
	}

	public void setPeriodoEmDiasDaDieta(int periodoEmDiasDaDieta) {
		this.periodoEmDiasDaDieta = periodoEmDiasDaDieta;
	}

	public Refeicao[][] getRefeicao() {
		return refeicao;
	}

	public void setRefeicao(Refeicao[][] refeicao) {
		this.refeicao = refeicao;
	}

	public int getQtdRefeicao() {
		return qtdRefeicao;
	}

	public void setQtdRefeicao(int qtdRefeicao) {
		this.qtdRefeicao = qtdRefeicao;
	}

	public int getProximoDia() {
		return proximoDia;
	}

	public int getId() {
		return id;
	}
	
	public void inserirRefeicao(Refeicao refeicao){
		for(int i=0; i<this.qtdRefeicao ;i++){
			if (this.refeicao[this.proximoDia][i].equals(null)){
				this.refeicao[this.proximoDia][i] = refeicao;
				calculoDePontosDeUmaDieta(refeicao);
			}
			else if (i == this.qtdRefeicao - 1){
				i = 0;
				this.proximoDia++;
			}
		}
	}
	
	private int calculoDePontosDeUmaDieta(Refeicao refeicao){
		int retorno = -1;
		this.pontos += refeicao.getPontos();
		retorno = this.pontos;
		return retorno;
	}
	
	public void removerRefeicao(Refeicao refeicao){
		for (int i = 0; i < this.periodoEmDiasDaDieta; i++){
			for (int j = 0; j < this.qtdRefeicao; j++){
				if (this.refeicao[i][j].equals(refeicao)){
					this.refeicao = null;
					atualizacaoDosPontosDeUmaDieta(refeicao);
					break;
				}
			}
		}
	}
	
	private int atualizacaoDosPontosDeUmaDieta(Refeicao refeicao){
		int retorno = -1;
		this.pontos -= refeicao.getPontos();
		retorno = this.pontos;
		return retorno;
	}
	
	public void calculoDoPeriodoEmDias(/*Recebe uma a data do final da dieta*/){
		
	}
}
