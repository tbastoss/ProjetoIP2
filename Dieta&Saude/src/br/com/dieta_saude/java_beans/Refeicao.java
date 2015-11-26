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
	
	public int getQtdDeAlimentos(){
		return this.qtdDeAlimentos;
	}
	
	public int getPontos(){
		return this.pontos;
	}
	
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	private int calculoDePontosDeUmaRefeicao(Alimento a){
		int retorno = -1;
		this.pontos += a.getPontos();
		retorno = this.pontos;
		return retorno;
	}

	public void adicionarAlimentosNaRefeicao (Alimento a){
		this.alimentos.add(a);
		calculoDePontosDeUmaRefeicao(a);
	}
	
	private int atualizacaoDosPontosDeUmaRefeicao (Alimento a){
		int retorno = -1;
		this.pontos -= a.getPontos();
		retorno = this.pontos;
		return retorno;
	}
	
	public void removerAlimentoDaRefeicao (Alimento a){
		if (alimentos.contains(a)){
			alimentos.remove(a);
			atualizacaoDosPontosDeUmaRefeicao(a);
		}
	}

	@Override
	public String toString() {
		return "Refeicao [id=" + id + ", qtdDeAlimentos=" + qtdDeAlimentos
				+ ", alimentos=" + alimentos + ", pontos=" + pontos + "]";
	}
	
	
	
}
