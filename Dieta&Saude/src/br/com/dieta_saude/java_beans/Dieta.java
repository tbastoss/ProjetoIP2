package br.com.dieta_saude.java_beans;

public class Dieta {
	private int periodo;
	private Refeicoes[][] refeicoes;
	private int proxima;
	public Dieta(int periodo) {
		this.periodo = periodo;
		this.refeicoes = new Refeicoes[periodo][6];
		this.proxima = 0;
	}
	public void inserirRefeicoes(Refeicoes refeicoes){
		for(int i=0;i<6;i++){
			this.refeicoes[this.proxima][i] = refeicoes;
		}
		this.proxima = this.proxima + 1;
		if(this.proxima == periodo){
			System.out.println("Você deseja mudar sua dieta?");
		}
	}
}
