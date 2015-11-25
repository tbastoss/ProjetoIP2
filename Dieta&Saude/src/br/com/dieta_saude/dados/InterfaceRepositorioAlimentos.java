package br.com.dieta_saude.dados;

import br.com.dieta_saude.java_beans.Alimento;

public interface InterfaceRepositorioAlimentos extends InterfaceGenerica {

	void cadastrar(Alimento alimento);
	
	boolean remover(Alimento alimentoARemover);
	
	
}
