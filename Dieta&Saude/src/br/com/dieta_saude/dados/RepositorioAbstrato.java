package br.com.dieta_saude.dados;


public abstract class RepositorioAbstrato {
	
	protected Object[] arrayDeDados;
	protected int proxima;
	
	public RepositorioAbstrato(int tamanho) {
		this.arrayDeDados = new Object[tamanho];
		this.proxima = 0;
	}

	
}
