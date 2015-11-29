package br.com.dieta_saude.dados;

import br.com.dieta_saude.java_beans.Usuario;
import br.com.dieta_saude.java_beans.UsuarioAdm;
import br.com.dieta_saude.java_beans.UsuarioComum;


// public class RepositorioUsuario implements InterfaceRepositorio {

public class RepositorioUsuario implements InterfaceUsuario {

	private Usuario[] usuarios;
	private int proximo;
	private static RepositorioUsuario instance;
	
	public  RepositorioUsuario (int tamanho){
		this.usuarios = new Usuario[tamanho];
		this.proximo = 0;
		
	}

	public static RepositorioUsuario getInstance(){
	      if (instance == null)
	         instance = new RepositorioUsuario(50);
	      return instance;
	}
	/*
=======
	@Override
>>>>>>> branch 'master' of https://github.com/wallsmanBR/ProjetoIP2.git
	public void cadastrar (Usuario usuario){
		this.usuarios[this.proximo] = usuario;
		this.proximo++;
	}
<<<<<<< HEAD
	*/

	@Override

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
	
	/*
	 * Nao muda o nome, pois eh o nome de usuário e ja vai ser feita a verificação, pelo controlador de
	 * usuários, para saber se o nome ja foi usado.  
	 */
	@Override
	public boolean atualizar(String nome, String senha, double altura, double peso, int idade, int nivelDeSedentarismo){
		boolean retorno = false;
		int i = this.procurarIndice(nome, senha);
		if (i != this.proximo){
			((UsuarioComum) this.usuarios[i]).setAltura(altura);
			((UsuarioComum) this.usuarios[i]).setPeso(peso);
			((UsuarioComum) this.usuarios[i]).setIdade(idade);
			((UsuarioComum) this.usuarios[i]).setNivelDeSedentarismo(nivelDeSedentarismo);
			retorno = true;
		}
		return retorno;
	}
	@Override
	public Usuario procurar(String nome, String senha){
		int i = this.procurarIndice(nome, senha);
		Usuario resultado = null;
		if (i != this.proximo){
			resultado = this.usuarios[i];			
		}
		return resultado;
		
	}
	@Override
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


	
	public void cadastrar(Usuario usuario) {
		if(usuario instanceof UsuarioAdm){
			UsuarioAdm usuarioAdm = (UsuarioAdm) usuario;
			this.usuarios[this.proximo] = usuarioAdm;
		}else if(usuario instanceof UsuarioComum){
			UsuarioComum usuarioComum = (UsuarioComum) usuario;
			this.usuarios[this.proximo] = usuarioComum;
		}
		this.proximo++;
		
	}
/*
	@Override
	int procurarIndice() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	boolean atualizar() {
		// TODO Auto-generated method stub
		return false;
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
=======
>>>>>>> branch 'master' of https://github.com/wallsmanBR/ProjetoIP2.git
*/
}