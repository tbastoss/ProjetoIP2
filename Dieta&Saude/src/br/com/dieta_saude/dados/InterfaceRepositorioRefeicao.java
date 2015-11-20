package br.com.dieta_saude.dados;

public interface InterfaceRepositorioRefeicao {

	void cadastrar(Object objeto);
	
	boolean atualizar( Object objeto);
	
	int procurarIndice(int id);
	
	boolean remover(Object objeto);
	
	Object procurar(Object objeto);

}
