package br.com.dieta_saude.dados;

import br.com.dieta_saude.java_beans.Refeicao;

public interface InterfaceRepositorioRefeicao extends InterfaceAbstrata {

	void cadastrar(Refeicao refeicao);
	
	boolean remover(Refeicao refeicaoARemover);

}
