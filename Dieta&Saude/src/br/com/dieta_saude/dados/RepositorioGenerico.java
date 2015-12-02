package br.com.dieta_saude.dados;


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

	public abstract boolean atualizar(Object objeto);

	//public abstract Object procurar(Object objeto);

}
