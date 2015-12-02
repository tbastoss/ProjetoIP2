package br.com.dieta_saude.dados;

import br.com.dieta_saude.java_beans.Refeicao;

public class RepositorioRefeicao extends RepositorioGenerico implements InterfaceRepositorioRefeicao {
	private static RepositorioRefeicao instance;
	public RepositorioRefeicao(int tamanho) {
		super((Object[]) new Refeicao[tamanho]);

	}

	public void cadastrar(Refeicao refeicao) {
		super.cadastrar(refeicao);
	}
	public static RepositorioRefeicao getInstance(){
	      if (instance == null)
	         instance = new RepositorioRefeicao(50);
	      return instance;
	}
	public boolean remover(Refeicao refeicaoARemover) {
		String nome = refeicaoARemover.getNome();
		int i = this.procurarIndice(nome);
		if (i != this.proxima) {
			this.arrayDeDados[i] = this.arrayDeDados[this.proxima - 1];
			this.arrayDeDados[this.proxima - 1] = null;
			this.proxima = this.proxima - 1;
			return true;
			// System.out.println("Refeição com id: "+ this.refeicoes[i].getId()
			// + " removida.");
		} else {
			return false;
			// System.out.println("Refeição não existe.");
		}
	}
	
	public int tamanhoRepositorio(){
		return proxima;
	}
	
	public Refeicao mostrarRefeicao(int pos){
		return (Refeicao) arrayDeDados[pos];
	}

	public boolean atualizar(Object objeto) {
		Refeicao atualizador = (Refeicao) objeto;
		int i = this.procurarIndice(atualizador.getNome());
		if (i != this.proxima) {
			((Refeicao) this.arrayDeDados[i]).setPontos(atualizador.getPontos());
			return true;
		} else {
			return false;
		}
	}

	public Refeicao procurar(String nome) {
		//Refeicao procurado = (Refeicao) refeicao;
		int i = this.procurarIndice(nome);
		Refeicao resultado = null;
		if (i != this.proxima) {
			resultado = (Refeicao) this.arrayDeDados[i];
		}
		return resultado;
	}

	private int procurarIndice(String nome) {
		int i = 0;
		boolean achou = false;
		while ((!achou) && (i < this.proxima)) {
			if (nome.equals(((Refeicao) this.arrayDeDados[i]).getNome())) {
				achou = true;
			} else {
				i = i + 1;
			}
		}
		return i;
	}

}
