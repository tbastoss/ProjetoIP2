package br.com.dieta_saude.dados;

import br.com.dieta_saude.java_beans.Usuario;
import br.com.dieta_saude.java_beans.UsuarioAdm;

public class RepositorioUsuarioAdm implements InterfaceUsuarioAdm {
	private UsuarioAdm[] usuarios;
	private int proximo;
	private static RepositorioUsuarioAdm instance;
	
	public  RepositorioUsuarioAdm (int tamanho){
		this.usuarios = new UsuarioAdm[tamanho];
		this.proximo = 0;
		
	}

	public void cadastrar (UsuarioAdm usuario){
		this.usuarios[this.proximo] = usuario;
		this.proximo++;
	}
	
	public static RepositorioUsuarioAdm getInstance(){
	      if (instance == null)
	         instance = new RepositorioUsuarioAdm(50);
	      return instance;
	}
	
	public int procurarIndice(String nome, String senha){
		int i = 0;
		boolean achou = false;
		while ((!achou) && (i < this.proximo)){
			if (nome.equals(this.usuarios[i].getNome()) && senha.equals(this.usuarios[i].getSenha()))
				achou = true;
			else 
				i++;
		}
		return i;		
	}
	
	public UsuarioAdm procurar(String nome, String senha){
		int i = this.procurarIndice(nome, senha);
		UsuarioAdm resultado = null;
		if (i != this.proximo){
			resultado = this.usuarios[i];			
		}
		return resultado;
		
	}
	
	public boolean remover(String nome, String senha){
		int i = this.procurarIndice(nome, senha);
		boolean resultado = false;
		if (i != this.proximo){
			this.usuarios[i] = this.usuarios[this.proximo - 1];
			this.usuarios[this.proximo - 1] = null;
			this.proximo = this.proximo - 1;
			resultado = true;
		}
		return resultado;
		
	}


}