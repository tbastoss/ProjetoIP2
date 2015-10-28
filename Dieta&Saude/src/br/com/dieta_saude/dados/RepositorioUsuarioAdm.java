package br.com.dieta_saude.dados;

import br.com.dieta_saude.java_beans.Usuario;
import br.com.dieta_saude.java_beans.UsuarioAdm;

public class RepositorioUsuarioAdm implements Repositorio {
	private UsuarioAdm[] usuarios;
	private int proximo;
	
	public  RepositorioUsuarioAdm (int tamanho){
		this.usuarios = new UsuarioAdm[tamanho];
		this.proximo = 0;
		
	}

	public void cadastrar (UsuarioAdm usuario){
		this.usuarios[this.proximo] = usuario;
		this.proximo++;
	}
	
	private int procurarIndice(String nome, String senha){
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
		Usuario resultado = null;
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

	@Override
	public void cadastrar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	int procurarIndice() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	Object procurar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	boolean remover() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int procurarIndice(String nome, String senha) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void cadastrar(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario procurar(String nome, String senha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean atualizar(String nome, String senha, double altura,
			double peso, int idade, int nivelDeSedentarismo) {
		// TODO Auto-generated method stub
		return false;
	}

}