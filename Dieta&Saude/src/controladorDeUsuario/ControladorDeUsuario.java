package controladorDeUsuario;

import br.com.dieta_saude.dados.RepositorioUsuario;
import br.com.dieta_saude.java_beans.Usuario;

public class ControladorDeUsuario {
	
	private Usuario usuario;
	
	public ControladorDeUsuario(Usuario usuario)
	{
		this.usuario = usuario;
	}

	public boolean verificaTipoDeUsuario(String senha)
	{
		boolean resultado = false;
		Usuario teste = new Usuario();
		if (senha.equals(teste.getCodAdmin()))
			resultado = true;
		
		return resultado;
		
	}
	
	public boolean verificaExistenciaDeUsuario(String nome, RepositorioUsuario repositorio)
	{
		boolean resultado = false;
		if (repositorio.procurar(nome) != null)
			resultado = true;
		
		return resultado;
	}
	
		
	
}
