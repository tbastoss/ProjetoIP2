package br.com.dieta_saude.dados;

import br.com.dieta_saude.java_beans.Alimento;

public interface InterfaceRepositorioAlimentos {

	void cadastrar(Alimento alimento);
	
	boolean remover(Alimento alimentoARemover);
	
	
}
