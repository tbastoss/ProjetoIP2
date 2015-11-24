package br.com.dieta_saude.dados;

import br.com.dieta_saude.java_beans.Dieta;

public class RepositorioDieta extends 
	RepositorioAbstrato implements InterfaceRepositorioDieta {

	//	private Dieta[] dieta;
    //	private int proxima;
	
	public RepositorioDieta(int tamanho) {
		super(tamanho);
//		this.dieta = new Dieta[tamanho];
//		this.proxima = 0;
		this.arrayDeDados = new Dieta[tamanho];
	}
	
	public void cadastrar(Dieta dieta) {
		this.arrayDeDados[this.proxima] = dieta;
		this.proxima = this.proxima + 1;
	}
	
	public int procurarIndice(int id) {
		int i = 0;
		boolean achou = false;
		while ((!achou) && (i < this.proxima)) {
			if (id == ( (Dieta) this.arrayDeDados[i] ).getId() ) {
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
			resultado = (Dieta) this.arrayDeDados[i];
		}
		return resultado;
	}
	
	
	// ccl
	public boolean atualizar(Object objeto){
		Dieta atualizador = (Dieta) objeto;
		int i = this.procurarIndice(atualizador.getId());
		if(i!= this.proxima){
			( (Dieta) this.arrayDeDados[i] ).setPeriodoEmDiasDaDieta(atualizador.getPeriodoEmDiasDaDieta());
			return true;
		}else{
			return false;
			//System.out.println("Dieta não existe.");
		}
	}
	
	public boolean remover(Dieta aRemover) {
		int id = aRemover.getId();
		int i = this.procurarIndice(id);
		if (i != this.proxima) {
			this.arrayDeDados[i] = this.arrayDeDados[this.proxima - 1];
			this.arrayDeDados[this.proxima - 1] = null;
			this.proxima = this.proxima - 1;
			return true;
			//System.out.println("Dieta com id: "+ this.dieta[i].getId() + " removida.");
		} else {
			return false;
			//System.out.println("Dieta não existe.");
		}
	}
}
