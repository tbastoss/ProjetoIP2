package br.com.dieta_saude.dados;

import java.util.Arrays;

import br.com.dieta_saude.java_beans.Alimento;

public class RepositorioAlimento implements Repositorio {
	private Alimento[] alimentos;
	private int proxima;
	
	public RepositorioAlimento(int tamanho) {
		this.alimentos = new Alimento[tamanho];
		this.proxima = 0;
	}
	
	@Override
	public void cadastrar(Object objeto) {
		Alimento alimento = (Alimento) objeto;
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
	public boolean atualizar(String nome, int pontos){
		int i = this.procurarIndice(nome);
		if(i!= this.proxima){
			this.alimentos[i].setNome(nome);
			this.alimentos[i].setPontos(pontos);
			return true;
		}else{
			return false;
			//System.out.println("Alimento não existe.");
		}
	}
	public Alimento procurar(String nome) {
		int i = this.procurarIndice(nome);
		Alimento resultado = null;
		if (i != this.proxima) {
			resultado = this.alimentos[i];
		}
		return resultado;
	}
	
	public boolean remover(String nome) {
		int i = this.procurarIndice(nome);
		if (i != this.proxima) {
			this.alimentos[i] = this.alimentos[this.proxima - 1];
			this.alimentos[this.proxima - 1] = null;
			this.proxima = this.proxima - 1;
			return true;
			//System.out.println(nome + " removido.");
		} else {
			return false;
			//System.out.println("Alimento não existe.");
		}
	}

	public void mostrarAlimentos(){
		for(int i=0;i<this.proxima;i++){
			System.out.println("Nome: "+alimentos[i].getNome()+". Pontos: "+ alimentos[i].getPontos()+ ".");
		}
	}
	
}
