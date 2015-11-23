package br.com.dieta_saude.java_beans;

import java.time.*;

public class Dieta {
	//USAR JAVA TIME
	private int periodoEmDiasDaDieta;
	private Refeicao[][] refeicao;
	private int qtdRefeicao;
	private int proximoDia;
	private int id = 0;
	
	public Dieta(int qtdRefeicao, int periodo) {
		this.periodoEmDiasDaDieta = periodo;
		this.refeicao = new Refeicao [periodo][qtdRefeicao];
		this.proximoDia = 0;
		this.id++;
	}
	
	public void inserirRefeicao(Refeicao refeicao){
		for(int i=0; i<this.qtdRefeicao ;i++){
			this.refeicao[this.proximoDia][i] = refeicao;
		}
		this.proximoDia = this.proximoDia + 1;
		
		//TRATAMENTO COM JAVA.TIME 		
		/*
		if(this.proxima == periodo){
			System.out.println("Você deseja mudar sua dieta?");
		}*/
	}
	public int getId(){
		return id;
	}
	public void setPeriodo(int periodo){
		this.periodoEmDiasDaDieta = periodo;
	}
	
	public int getPeriodo()
	{
		return this.periodoEmDiasDaDieta;
	}
}
