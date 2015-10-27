package br.com.dieta_saude.java_beans;

public class Dieta {
	private int periodo;
	private Refeicao[][] refeicao;
	private int qtdRefeicao;
	private int proxima;
	private int id = 0;
	public Dieta(int periodo, int qtdRefeicao, int id) {
		this.periodo = periodo;
		this.refeicao = new Refeicao[qtdRefeicao][periodo];
		this.proxima = 0;
		this.id++;
	}
	public void inserirRefeicao(Refeicao refeicoes){
		for(int i=0;i<6;i++){
			this.refeicao[this.proxima][i] = refeicoes;
		}
		this.proxima = this.proxima + 1;
		if(this.proxima == periodo){
			System.out.println("Você deseja mudar sua dieta?");
		}
	}
	public int getId(){
		return id;
	}
	public void setPeriodo(int periodo){
		this.periodo = periodo;
	}
}
