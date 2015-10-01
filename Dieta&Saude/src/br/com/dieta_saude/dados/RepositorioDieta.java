package br.com.dieta_saude.dados;

import br.com.dieta_saude.java_beans.Dieta;

public class RepositorioDieta {
	private Dieta[] dieta;
	private int proxima;
	
	public RepositorioDieta(int tamanho) {
		this.dieta = new Dieta[tamanho];
		this.proxima = 0;
	}
	
	public void cadastrar(Dieta dieta) {
		this.dieta[this.proxima] = dieta;
		this.proxima = this.proxima + 1;
	}
	
	private int procurarIndice(int id) {
		int i = 0;
		boolean achou = false;
		while ((!achou) && (i < this.proxima)) {
			if (id == this.dieta[i].getId()) {
				achou = true;
			} else {
				i = i + 1;
			}
		}
		return i;
	}
	
	public Dieta procurar(int id) {
		int i = this.procurarIndice(id);
		Dieta resultado = null;
		if (i != this.proxima) {
			resultado = this.dieta[i];
		}
		return resultado;
	}
	
	public void remover(int id) {
		int i = this.procurarIndice(id);
		if (i != this.proxima) {
			this.dieta[i] = this.dieta[this.proxima - 1];
			this.dieta[this.proxima - 1] = null;
			this.proxima = this.proxima - 1;
			System.out.println("Dieta com id: "+ this.dieta[i].getId() + " removida.");
		} else {
			System.out.println("Dieta não existe.");
		}
	}
}
