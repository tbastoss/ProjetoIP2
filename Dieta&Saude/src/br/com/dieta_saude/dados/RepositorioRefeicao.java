package br.com.dieta_saude.dados;

import br.com.dieta_saude.java_beans.Refeicao;

public class RepositorioRefeicao {
	private Refeicao[] refeicoes;
	private int proxima;
	
	public RepositorioRefeicao(int tamanho) {
		this.refeicoes = new Refeicao[tamanho];
		this.proxima = 0;
	}
	
	public void cadastrar(Refeicao refeicoes) {
		this.refeicoes[this.proxima] = refeicoes;
		this.proxima = this.proxima + 1;
	}
	
	private int procurarIndice(int id) {
		int i = 0;
		boolean achou = false;
		while ((!achou) && (i < this.proxima)) {
			if (id == this.refeicoes[i].getId()) {
				achou = true;
			} else {
				i = i + 1;
			}
		}
		return i;
	}
	
	public Refeicao procurar(int id) {
		int i = this.procurarIndice(id);
		Refeicao resultado = null;
		if (i != this.proxima) {
			resultado = this.refeicoes[i];
		}
		return resultado;
	}
	public boolean atualizar(int pontos, int id){
		int i = this.procurarIndice(id);
		if(i!= this.proxima){
			this.refeicoes[i].setPontos(pontos);
			return true;
		}else{
			return false;
		}
	}
	public boolean remover(int id) {
		int i = this.procurarIndice(id);
		if (i != this.proxima) {
			this.refeicoes[i] = this.refeicoes[this.proxima - 1];
			this.refeicoes[this.proxima - 1] = null;
			this.proxima = this.proxima - 1;
			return true;
			//System.out.println("Refeição com id: "+ this.refeicoes[i].getId() + " removida.");
		} else {
			return false;
			//System.out.println("Refeição não existe.");
		}
	}
}
