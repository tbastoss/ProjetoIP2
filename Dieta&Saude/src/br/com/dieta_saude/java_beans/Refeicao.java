package br.com.dieta_saude.java_beans;

public class Refeicao {
	private int id = 0;
	private Alimento[][] alimentos;
	//private Alimento[] lancheM;
	//private Alimento[] almoco;
	//private Alimento[] lancheT;
	//private Alimento[] jantar;
	//private Alimento[] lancheN;
	//private int pontos = 0;
	
	public Refeicao (int periodo) {
		this.alimentos = new Alimento[periodo][];
		this.id++;
	}
	public void calcularPontos(){
		for(int i=0;i<this.cafeDaManha.length;i++){
			this.pontos += this.cafeDaManha[i].getPontos();
		}
		for(int i=0;i<this.lancheM.length;i++){
			this.pontos += this.lancheM[i].getPontos();
		}
		for(int i=0;i<this.almoco.length;i++){
			this.pontos += this.almoco[i].getPontos();
		}
		for(int i=0;i<this.lancheT.length;i++){
			this.pontos += this.lancheT[i].getPontos();
		}
		for(int i=0;i<this.jantar.length;i++){
			this.pontos += this.jantar[i].getPontos();
		}
		for(int i=0;i<this.lancheN.length;i++){
			this.pontos += this.lancheN[i].getPontos();
		}
	}
	public int getId() {
		return id;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	
	
	
}