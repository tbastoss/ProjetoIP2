package br.com.dieta_saude.java_beans;

public class Dieta {
	private int periodo;
	private Refeicoes[][] refeicoes;
	private int proxima;
	private int id = 0;
	public Dieta(int periodo, int id) {
		this.periodo = periodo;
		this.refeicoes = new Refeicoes[periodo][6];
		this.proxima = 0;
		this.id++;
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
	public int getId(){
		return id;
	}
	public void setPeriodo(int periodo){
		this.periodo = periodo;
	}
}
