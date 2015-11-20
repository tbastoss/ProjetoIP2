package br.com.dieta_saude.dados;

import br.com.dieta_saude.java_beans.Refeicao;

public class RepositorioRefeicao implements InterfaceRepositorioRefeicao {
	private Refeicao[] refeicoes;
	private int proxima;
	
	public RepositorioRefeicao(int tamanho) {
		this.refeicoes = new Refeicao[tamanho];
		this.proxima = 0;
	}
	@Override
	public void cadastrar(Object objeto) {
		Refeicao refeicoes = (Refeicao) objeto;
		this.refeicoes[this.proxima] = refeicoes;
		this.proxima = this.proxima + 1;
	}
	
	public int procurarIndice(int id) {
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
	
	// ccl
	public Object procurar(Object objeto){
		Refeicao procurado = (Refeicao) objeto;
		int i = this.procurarIndice(procurado.getId());
		Refeicao resultado = null;
		if (i != this.proxima) {
			resultado = this.refeicoes[i];
		}
		return resultado;
	}
	
	// ccl
	public boolean atualizar(Object objeto){
		Refeicao atualizador = (Refeicao) objeto;
		int i = this.procurarIndice(atualizador.getId());
		if(i!= this.proxima){
			this.refeicoes[i].setPontos(atualizador.getPontos());
			return true;
		}else{
			return false;
		}
	}
	
	public boolean remover(Object objeto) {
		int id = (int) objeto;
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
