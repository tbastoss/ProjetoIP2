package br.com.dieta_saude.dados;

import br.com.dieta_saude.java_beans.Dieta;

public class RepositorioDieta implements InterfaceRepositorio {
	private Dieta[] dieta;
	private int proxima;
	
	public RepositorioDieta(int tamanho) {
		this.dieta = new Dieta[tamanho];
		this.proxima = 0;
	}
	
	public void cadastrar(Object objeto) {
		Dieta dieta = (Dieta) objeto;
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
	
	
	// ccl
	public Object procurar(Object objeto) {
		Dieta procurado = (Dieta) objeto;
		int i = this.procurarIndice(procurado.getId());
		Dieta resultado = null;
		if (i != this.proxima) {
			resultado = this.dieta[i];
		}
		return resultado;
	}
	
	
	// ccl
	public boolean atualizar(Object objeto){
		Dieta atualizador = (Dieta) objeto;
		int i = this.procurarIndice(atualizador.getId());
		if(i!= this.proxima){
			this.dieta[i].setPeriodo(atualizador.getPeriodo());
			return true;
		}else{
			return false;
			//System.out.println("Dieta não existe.");
		}
	}
	
	public boolean remover(Object objeto) {
		int id = (int) objeto;
		int i = this.procurarIndice(id);
		if (i != this.proxima) {
			this.dieta[i] = this.dieta[this.proxima - 1];
			this.dieta[this.proxima - 1] = null;
			this.proxima = this.proxima - 1;
			return true;
			//System.out.println("Dieta com id: "+ this.dieta[i].getId() + " removida.");
		} else {
			return false;
			//System.out.println("Dieta não existe.");
		}
	}
}
