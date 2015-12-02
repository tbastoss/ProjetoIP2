package br.com.dieta_saude.java_beans;

import java.time.LocalDate;

public class UsuarioComum extends Usuario {
	private char sexo;
	private double altura;
	private double peso;
	private int idade;
	private int nivelDeSedentarismo; //Vai de 1 - 6, para o calculo do FA, em calcularPontos
	private int pontos;
	private Dieta dieta;
	private LocalDate inicio;
	private LocalDate fim;
	
	public UsuarioComum(String nome, String senha, char sexo, double altura, double peso, int idade, int nivelDeSedentarismo, int nivelUser, LocalDate inicio, LocalDate fim){
		super();
		this.nome = nome;
    	this.senha = senha;
    	this.sexo = sexo;
    	this.altura = altura;
    	this.peso = peso;
    	this.idade = idade;
    	this.nivelDeSedentarismo = nivelDeSedentarismo;
    	this.id++;
    	this.nivelUser = nivelUser;
	}
	
	public Dieta getDieta() {
		return dieta;
	}
	
	public void setDieta(Dieta dieta) {
		this.dieta = dieta;
	}
	
	public void setAltura(double altura) {
		this.altura = altura;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public void setNivelDeSedentarismo(int nivelDeSedentarismo) {
		this.nivelDeSedentarismo = nivelDeSedentarismo;
	}
	
	public int getPontos() {
		return pontos;
	}
	
	/*
     * The method below (calcularPontos) is responsible for the calculation 
     * of the points, through the informations given, that will be used 
     * as a limit while the user is selecting the aliments. 
     * Every user have their own points. 
     */
    public void calcularPontos(){
    	int pontos = 0;
    	double tmb = 0; //TAIXA DE METABOLISMO BASAL
    	double fa = 0;  //FATOR DE ATIVIDADE
    	double imc = 0; //INDICE DE MASSA CORPÓREA
    	
    	//IMC CALCULATION
    	imc = this.peso/(this.altura*this.altura);
    	
    	//TMB and FA Calculation
    	if (this.sexo =='f' || this.sexo =='F' ){
    		if(this.idade>=10 && this.idade<=18)
    			tmb = (12.2 * peso) + 746;
    		else if (this.idade>18 && this.idade<=30)
    			tmb = (14.7 * peso) + 496;
    		else if (this.idade>30 && this.idade<=60)
    			tmb = (8.7 * this.peso) + 829;
    		else
    			tmb = (10.5 * this.peso) + 596;
    		
    		switch (this.nivelDeSedentarismo)
    		{
    		case 1:
    			fa = 1.2;
    			break;
    		case 2:
    			fa = 1.3;
    			break;
    		case 3:
    			fa = 1.35;
    			break;
    		case 4:
    			fa = 1.45;
    			break;
    		case 5:
    			fa = 1.5;
    			break;
    		case 6:
    			fa = 1.7;
    			break;
    		}
    		
    		//Points calculations
    		pontos = (int) ((tmb * fa) / 3.6);
    		if (imc >= 25 && imc < 30)
    			pontos -= 175;
    		else if (imc >= 30 && imc < 35)
    			pontos -= 200;
    		else if (imc >= 35 && imc < 40)
    			pontos -= 250;
    		else 
    			pontos -= 300;
    	}
    	
    	//TMB and FA Calculation
    	else if (this.sexo =='m' || this.sexo =='M' ){
    		if(this.idade>=10 && this.idade<=18)
    			tmb = (17.5 * this.peso) + 651;
    		else if (this.idade>18 && this.idade<=30)
    			tmb = (15.3 * this.peso) + 679;
    		else if (this.idade>30 && this.idade<=60)
    			tmb = (8.7 * this.peso) + 879;
    		else
    			tmb = (13.5 * this.peso)  + 487;
    		
    		switch (this.nivelDeSedentarismo)
    		{
    		case 1:
    			fa = 1.2;
    			break;
    		case 2:
    			fa = 1.3;
    			break;
    		case 3:
    			fa = 1.4;
    			break;
    		case 4:
    			fa = 1.5;
    			break;
    		case 5:
    			fa = 1.6;
    			break;
    		case 6:
    			fa = 1.8;
    			break;
    		}
    		
    		//Points calculations
    		pontos = (int) ((tmb * fa) / 3.6);
    		if (imc >= 25 && imc < 30)
    			pontos -= 200;
    		else if (imc >= 30 && imc < 35)
    			pontos -= 225;
    		else if (imc >= 35 && imc < 40)
    			pontos -= 275;
    		else 
    			pontos -= 325;
    	}    	
    	
    	this.pontos = pontos;
    }

	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", senha=" + senha + ", nivelUser=" + nivelUser + ", id=" + id + ", sexo="
				+ sexo + ", altura=" + altura + ", peso=" + peso + ", idade=" + idade + ", nivelDeSedentarismo="
				+ nivelDeSedentarismo + ", pontos=" + pontos + ", dieta=" + dieta + "]";
	}    


}
