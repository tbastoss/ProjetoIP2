package br.com.dieta_saude.java_beans;

import java.time.*;
import java.util.Arrays;

public class Dieta {
	private int periodoEmDiasDaDieta;
	private Refeicao[][] refeicao;
	private int qtdRefeicao;
	private int proximoDia;
	private int pontos;
	private int id = 0;
	private LocalDate InicioDieta;
	private LocalDate FimDieta;
	
	public Dieta(int qtdRefeicao, int periodoEmDiasDaDieta) {
		this.periodoEmDiasDaDieta = periodoEmDiasDaDieta;
		this.refeicao = new Refeicao [periodoEmDiasDaDieta][qtdRefeicao];
		for (int i = 0; i < this.periodoEmDiasDaDieta; i++){
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

	public void setPontos(int pontos) {
		this.pontos = this.pontos + pontos;
	}

	public int getId() {
		return id;
	}
	
	public LocalDate getInicioDieta() {
		return InicioDieta;
	}

	public void setInicioDieta(LocalDate inicioDieta) {
		InicioDieta = inicioDieta;
	}

	public LocalDate getFimDieta() {
		return FimDieta;
	}

	public void setFimDieta(LocalDate fimDieta) {
		FimDieta = fimDieta;
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

	@Override
	public String toString() {
		String nomeRefeicoes = " ";
		for(int i = 0; i < periodoEmDiasDaDieta; i++){
			for (int j = 0; j < qtdRefeicao; j++){
				nomeRefeicoes = refeicao[i][j].getNome();
				nomeRefeicoes = nomeRefeicoes + " ";
			}
			nomeRefeicoes = nomeRefeicoes + "\n";
		}
			
		
		return "Dieta [periodoEmDiasDaDieta=" + periodoEmDiasDaDieta
				+ ", Quantidade de Refeições=" + this.qtdRefeicao +  
				", pontos=" + pontos + ", InicioDieta="
				+ InicioDieta + ", FimDieta=" + FimDieta + "\n" +
				", refeicoes da dieta=\n";
				
				};
	
	
	
}
