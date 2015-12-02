package br.com.dieta_saude.dados;

import br.com.dieta_saude.java_beans.Alimento;

public class RepositorioAlimento extends RepositorioGenerico implements InterfaceRepositorioAlimentos {

	public RepositorioAlimento(int tamanho) {
		super((Object[]) new Alimento[tamanho]);
	}

	// ccl: codigo implementado pelo professor
	@Override
	public void cadastrar(Alimento alimento) {
		super.cadastrar(alimento);
	}

	
	public boolean remover(Alimento alimentoARemover) {
		String nome = alimentoARemover.getNome();
		int i = this.procurarIndiceComNome(nome);
		if (i != this.proxima) {
			this.arrayDeDados[i] = (Alimento) this.arrayDeDados[this.proxima - 1];
			this.arrayDeDados[this.proxima - 1] = null;
			this.proxima = this.proxima - 1;
			return true;
			// System.out.println(nome + " removido.");
		} else {
			return false;
			// System.out.println("Alimento não existe.");
		}
	}

	
	public boolean atualizar(Object objeto) {
		// String nome, int pontos
		Alimento atualizador = (Alimento) objeto;
		int i = this.procurarIndiceComNome(atualizador.getNome());
		if (i != this.proxima) {
			((Alimento) this.arrayDeDados[i]).setNome(atualizador.getNome());
			((Alimento) this.arrayDeDados[i]).setPontos(atualizador.getPontos());
			return true;
		} else {
			return false;
			// System.out.println("Alimento não existe.");
		}
	}

	
	public Object procurar(Object alimento) {
		String nomeAlimento = ((Alimento) alimento).getNome();
		int i = this.procurarIndiceComNome(nomeAlimento);
		Alimento resultado = null;
		if (i != this.proxima) {
			resultado = (Alimento) this.arrayDeDados[i];
		}
		return resultado;
	}

	
	public void mostrarAlimentos() {
		for (int i = 0; i < this.proxima; i++) {
			System.out.println("Nome: " + ((Alimento) arrayDeDados[i]).getNome() + ". Pontos: "
					+ ((Alimento) arrayDeDados[i]).getPontos() + ".");
		}
	}
	
	
	private int procurarIndiceComNome(String nome) {
		int i = 0;
		boolean achou = false;
		while ((!achou) && (i < this.proxima)) {
			if (nome.equals(((Alimento) this.arrayDeDados[i]).getNome())) {
				achou = true;
			} else {
				i = i + 1;
			}
		}
		return i;
	}

	// => Main de teste
	public static void main(String[] args) {

		RepositorioAlimento repositorioDeTeste = new RepositorioAlimento(3);

		// Testando cadastro de alimentos com interface
		System.out.println("\nTestando cadastro de alimentos com interface");

		Alimento a = new Alimento("Maçã", 10);

		repositorioDeTeste.cadastrar(a);

		a = new Alimento("Ervilha", 3);

		repositorioDeTeste.cadastrar(a);

		repositorioDeTeste.mostrarAlimentos();

		System.out.println("Testando remover:");

		repositorioDeTeste.remover(a);

		repositorioDeTeste.mostrarAlimentos();

		System.out.println("Testanto atualizar:");

		a = new Alimento("Maçã", 15);

		repositorioDeTeste.atualizar(a);

		repositorioDeTeste.mostrarAlimentos();

		System.out.println(repositorioDeTeste.procurar(a));

		// Testando atualizador de alimentos com interface

		// código de teste vai aqui

	}

}
