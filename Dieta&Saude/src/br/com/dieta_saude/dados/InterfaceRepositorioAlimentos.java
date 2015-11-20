package br.com.dieta_saude.dados;

import br.com.dieta_saude.java_beans.Usuario;

public interface InterfaceRepositorioAlimentos {
	
	void cadastrar ( Object objeto );
	
	boolean atualizar( Object objeto);
	
	
	boolean remover(Object objeto);
	
	Object procurar(Object objeto);
}
