package br.com.dieta_saude.java_beans;

import java.util.ArrayList;

import br.com.dieta_saude.dados.RepositorioAlimento;

public class Refeicao {
	private String nome;
	private int id = 0;
	private ArrayList <Alimento> alimentos = new ArrayList<Alimento>();
	private int pontos;
	private boolean isEmpty;
	
	public Refeicao (String nome){
		this.nome = nome;
		this.pontos = 0;
		this.id++;
		this.isEmpty = true;
	}
	
	public int getId() {
		return id;
	}
	
	public int getPontos(){
		return this.pontos;
	}
	
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getNome(){
		return this.nome;
	}

	private int calculoDePontosDeUmaRefeicao(Alimento a){
		int retorno = -1;
		this.pontos += a.getPontos();
		retorno = this.pontos;
		return retorno;
	}

	public void adicionarAlimentosNaRefeicao (Alimento a){
		this.alimentos.add(a);
		this.isEmpty = false;
		calculoDePontosDeUmaRefeicao(a);
	}
	
	private int atualizacaoDosPontosDeUmaRefeicao (Alimento a){
		int retorno = -1;
		this.pontos -= a.getPontos();
		retorno = this.pontos;
		return retorno;
	}
	
	public void removerAlimentoNaRefeicao (Alimento a){
		if (alimentos.contains(a)){
			alimentos.remove(a);
			atualizacaoDosPontosDeUmaRefeicao(a);
		}
	}

	@Override
	public String toString() {
		return "Refeicao [alimentos=" + alimentos.toString() + ", pontos=" + pontos + "]";
	}
	
	
	
}
