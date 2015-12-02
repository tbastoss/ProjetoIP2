package br.com.dieta_saude.controladores;

import br.com.dieta_saude.dados.RepositorioAlimento;
import br.com.dieta_saude.dados.RepositorioUsuario;
import br.com.dieta_saude.java_beans.Alimento;
import br.com.dieta_saude.java_beans.Usuario;

public class ControladorDeAlimentos {
	
	public ControladorDeAlimentos()
	{
		
	}
	
	 public boolean verificar(Alimento alimento)
		{
			if (RepositorioAlimento.getInstance().procurar(alimento.getNome()) != null)
				return true;
			
			return false;
		}
	
	public boolean adicionar(Alimento alimento)
	{
		boolean verificador = verificar(alimento);
	
		if (verificador == false){
			RepositorioAlimento.getInstance().cadastrar(alimento);
			return true;
		}
		return false;
	}
	
	public boolean remover(Alimento alimento){
		boolean verificador = verificar(alimento);
		if(verificador == true){
			RepositorioAlimento.getInstance().remover(alimento);
			return true;
		}
		return false;
	}
	
	public boolean atualizar(Alimento alimento){
		boolean verificador = verificar(alimento);
		if(verificador == true){
			RepositorioAlimento.getInstance().atualizar(alimento);
			return true;
		}
		return false;
	}
	
	
	
}
