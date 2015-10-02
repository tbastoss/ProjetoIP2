package controladorDeUsuario;

import br.com.dieta_saude.dados.RepositorioUsuario;
import br.com.dieta_saude.java_beans.Usuario;

public class ControladorDeUsuario {
	
	//private Usuario usuario;
	
	public ControladorDeUsuario()
	{
		//this.usuario = usuario;
	}

	public boolean verificaTipoDeUsuario(Usuario usuario)
	{
		if (usuario.getNivelUser() == 1){
			return true;
		}else{
			return false;
		}
		
	}
	
	public boolean verificaExistenciaDeUsuario(String nome,String senha, RepositorioUsuario repositorio)
	{
		boolean resultado = false;
		if (repositorio.procurar(nome, senha) != null)
			resultado = true;
		
		return resultado;
	}
	
		
	
}
