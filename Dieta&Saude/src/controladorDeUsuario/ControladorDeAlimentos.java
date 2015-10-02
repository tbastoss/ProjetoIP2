package controladorDeUsuario;

import br.com.dieta_saude.dados.RepositorioAlimento;
import br.com.dieta_saude.dados.RepositorioUsuario;
import br.com.dieta_saude.java_beans.Alimento;
import br.com.dieta_saude.java_beans.Usuario;

public class ControladorDeAlimentos {
	
	public ControladorDeAlimentos()
	{
		
	}
	
	
	public boolean verificaExistenciaDeAlimento(String nome, RepositorioAlimento repositorio)
	{
		boolean resultado = false;
		if (repositorio.procurar(nome) != null)
			resultado = true;
		
		return resultado;
	}
	
	
	public boolean adicionaAlimentos(String nome, int pontos, 
			RepositorioAlimento repositorio)
	{
		boolean resultado = false;
		boolean verificador = verificaExistenciaDeAlimento(nome, repositorio);
		Alimento teste = new Alimento(nome, pontos);
	
		if (verificador == false){
			repositorio.cadastrar(teste);
			resultado = true;
		}
		
		return resultado;
	}
	
	
	
	
}
