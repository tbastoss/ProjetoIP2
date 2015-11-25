package br.com.dieta_saude.dados;

import br.com.dieta_saude.java_beans.Alimento;

public abstract class RepositorioGenerico {
	
	protected Object[] arrayDeDados;
	protected int proxima;
	
	public RepositorioGenerico(Object[] generico) {
		this.arrayDeDados = generico;
		this.proxima = 0;
	}

	public void cadastrar(Object obj) {
		this.arrayDeDados[this.proxima] = obj;
		this.proxima = this.proxima + 1;
	}
	
}
