package br.com.dieta_saude.java_beans;

import java.util.ArrayList;

import br.com.dieta_saude.dados.RepositorioAlimento;

public class Refeicao {
	private int id = 0;
	private int qtdDeAlimentos;
	private ArrayList <Alimento> alimentos = new ArrayList<Alimento>();
	private int pontos;
	
	public Refeicao (int qtdDeAlimentos){
			this.qtdDeAlimentos = qtdDeAlimentos;
			this.pontos = 0;
			this.id++;
	}
	
	public int getId() {
		return id;
	}
	
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	
	public int getPontos(){
		return this.pontos;
	}
	
	private int calculoDePontosDeUmaRefeicao(Alimento a){
		int retorno = -1;
		this.pontos += a.getPontos();
		return retorno;
	}

	public void adicionarAlimentosNaRefeicao (Alimento a){
		calculoDePontosDeUmaRefeicao(a);
		
	}
	
	
}
