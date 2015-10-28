package br.com.dieta_saude.dados;

import br.com.dieta_saude.java_beans.Usuario;

public interface Repositorio {
	
	int procurarIndice(String nome, String senha);
	void cadastrar(Usuario usuario);
	Usuario procurar(String nome, String senha);
	boolean remover(String nome, String senha);
	boolean atualizar(String nome, String senha, double altura, double peso, int idade, int nivelDeSedentarismo);
	
}
