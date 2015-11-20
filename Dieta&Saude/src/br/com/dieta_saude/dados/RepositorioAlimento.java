package br.com.dieta_saude.dados;

import java.util.Arrays;

import br.com.dieta_saude.java_beans.Alimento;

public class RepositorioAlimento implements InterfaceRepositorioAlimentos {
	private Alimento[] alimentos;
	private int proxima;
	
	public RepositorioAlimento(int tamanho) {
		this.alimentos = new Alimento[tamanho];
		this.proxima = 0;
	}
	
	@Override
	// ccl
	public void cadastrar(Object objeto) {
		Alimento alimento = (Alimento) objeto;
		this.alimentos[this.proxima] = alimento;
		this.proxima = this.proxima + 1;
	}
	
	
	private int procurarIndice(String nome) {
		int i = 0;
		boolean achou = false;
		while ((!achou) && (i < this.proxima)) {
			if (nome.equals(this.alimentos[i].getNome())) {
				achou = true;
			} else {
				i = i + 1;
			}
		}
		return i;
	}
	
	// ccl
	public boolean atualizar( Object objeto){
		// String nome, int pontos
		Alimento atualizador = (Alimento) objeto;
		int i = this.procurarIndice(atualizador.getNome());
		if(i!= this.proxima){
			this.alimentos[i].setNome(atualizador.getNome());
			this.alimentos[i].setPontos(atualizador.getPontos());
			return true;
		}else{
			return false;
			//System.out.println("Alimento não existe.");
		}
	}
	
	// verificar onde o resultado de procurar está sendo usado
	
	public Object procurar(Object objeto) {
		String nome = (String) objeto;
		int i = this.procurarIndice(nome);
		Alimento resultado = null;
		if (i != this.proxima) {
			resultado = this.alimentos[i];
		}
		return resultado;
	}
	
	public boolean remover(Object objeto) {
		String nome = (String) objeto;
		int i = this.procurarIndice(nome);
		if (i != this.proxima) {
			this.alimentos[i] = this.alimentos[this.proxima - 1];
			this.alimentos[this.proxima - 1] = null;
			this.proxima = this.proxima - 1;
			return true;
			//System.out.println(nome + " removido.");
		} else {
			return false;
			//System.out.println("Alimento não existe.");
		}
	}

	public void mostrarAlimentos(){
		for(int i=0; i<this.proxima ;i++){
			System.out.println("Nome: "+alimentos[i].getNome()+". Pontos: "+ alimentos[i].getPontos()+ ".");
		}
	}
	
	
	// => Main de teste
	public static void main(String[] args) {
		
		RepositorioAlimento repositorioDeTeste = new RepositorioAlimento(3);
		
		//Testando cadastro de alimentos com interface
		System.out.println("\nTestando cadastro de alimentos com interface");
		
		Alimento a = new Alimento("Maçã", 10);
		
		repositorioDeTeste.cadastrar(a);
		
		a = new Alimento("Ervilha", 3);
		
		repositorioDeTeste.cadastrar(a);
		
		repositorioDeTeste.mostrarAlimentos();
		
		//Testando atualizador de alimentos com interface
		
		// código de teste vai aqui
		
	}
}
