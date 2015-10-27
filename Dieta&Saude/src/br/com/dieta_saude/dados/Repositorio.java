package br.com.dieta_saude.dados;

import br.com.dieta_saude.java_beans.Usuario;

abstract class Repositorio {
	
	abstract public void cadastrar ();
	
	abstract int procurarIndice();
	
	abstract boolean atualizar();
	
	abstract Object procurar();
	
	abstract boolean remover();
}
