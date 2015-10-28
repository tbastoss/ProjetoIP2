package br.com.dieta_saude.dados;

import br.com.dieta_saude.java_beans.Usuario;

public interface Repositorio {
	
	void cadastrar ( Object objeto );
	
	// int procurarIndice();
	
	boolean atualizar();
	
	Object procurar();
	
	boolean remover();
}
