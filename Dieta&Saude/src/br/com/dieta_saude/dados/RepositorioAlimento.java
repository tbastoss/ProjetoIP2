package br.com.dieta_saude.dados;

import br.com.dieta_saude.java_beans.Alimento;

public class RepositorioAlimento extends RepositorioGenerico implements InterfaceRepositorioAlimentos {
	private static RepositorioAlimento instance;
	
	public RepositorioAlimento(int tamanho) {
		super((Object[]) new Alimento[tamanho]);
	}
	public static RepositorioAlimento getInstance(){
	      if (instance == null)
	         instance = new RepositorioAlimento(500);
	      return instance;
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

	
	public Alimento mostrarAlimentos(int pos) {
		/*for (int i = 0; i < this.proxima; i++) {
			System.out.println("Nome: " + ((Alimento) arrayDeDados[i]).getNome() + ". Pontos: "
					+ ((Alimento) arrayDeDados[i]).getPontos() + ".");
		}*/
		return (Alimento) arrayDeDados[pos];
	}
	public int tamanhoRepositorio(){
		return proxima;
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
}
