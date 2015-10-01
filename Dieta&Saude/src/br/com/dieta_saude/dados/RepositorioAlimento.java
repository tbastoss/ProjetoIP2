package br.com.dieta_saude.dados;

import br.com.dieta_saude.java_beans.Alimento;

public class RepositorioAlimento {
	private Alimento[] alimentos;
	private int proxima;
	
	public RepositorioAlimento(int tamanho) {
		this.alimentos = new Alimento[tamanho];
		this.proxima = 0;
	}
	
	public void cadastrar(Alimento alimento) {
		this.alimentos[this.proxima] = alimento;
		this.proxima = this.proxima + 1;
	}
	
	private int procurarIndice(String nome) {
		int i = 0;
		boolean achou = false;
		while ((!achou) && (i < this.proxima)) {
			if (nome.equals(this.alimentos[i].getNome())) {
				achou = true;
			} else {
				i = i + 1;
			}
		}
		return i;
	}
	
	public Alimento procurar(String nome) {
		int i = this.procurarIndice(nome);
		Alimento resultado = null;
		if (i != this.proxima) {
			resultado = this.alimentos[i];
		}
		return resultado;
	}
	
	public void remover(String nome) {
		int i = this.procurarIndice(nome);
		if (i != this.proxima) {
			this.alimentos[i] = this.alimentos[this.proxima - 1];
			this.alimentos[this.proxima - 1] = null;
			this.proxima = this.proxima - 1;
			System.out.println(nome + " removido.");
		} else {
			System.out.println("Alimento não existe.");
		}
	}
	
}
