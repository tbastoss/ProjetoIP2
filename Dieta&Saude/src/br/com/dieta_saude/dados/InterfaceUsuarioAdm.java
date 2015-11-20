package br.com.dieta_saude.dados;

import br.com.dieta_saude.java_beans.Usuario;
import br.com.dieta_saude.java_beans.UsuarioAdm;

public interface InterfaceUsuarioAdm {
	int procurarIndice(String nome, String senha);
	void cadastrar(UsuarioAdm usuario);
	UsuarioAdm procurar(String nome, String senha);
	boolean remover(String nome, String senha);
	
}
