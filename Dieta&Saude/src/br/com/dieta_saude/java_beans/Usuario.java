package br.com.dieta_saude.java_beans;

public class Usuario {
	private String nome;
	private int id = 0;
    private char sexo;
    private double altura;
    private double peso;
    private int idade;
    private int nivelDeSedentarismo; //Vai de 1 - 6, para o calculo do FA, em calcularPontos
    private int pontos;
    private Dieta dieta;
    
    
    public Usuario(String nome, char sexo, double altura, double peso, int idade,int nivelDeSedentarismo){
            this.nome=nome;
            this.id=id;
            this.id++;
            this.sexo=sexo;
            this.altura=altura;
            this.peso=peso;
            this.idade=idade;
            this.nivelDeSedentarismo=nivelDeSedentarismo;
            }
    
    public int getId() {
		return id;
	}
    
	public int getPontos() {
		return pontos;
	}
	
	public Dieta getDieta() {
		return dieta;
	}
	
	public void setDieta(Dieta dieta) {
		this.dieta = dieta;
	}
    
    /*
     * The method below (calcularPontos) is responsible for the calculation 
     * of the points, through the informations given, that will be use 
     * as a limit while the user is selecting the aliments. 
     * Every user have their own points. 
     */
    public int calcularPontos(char sexo, double altura, double peso, int idade,int nivelDeSedentarismo){
    	int pontos = 0;
    	double tmb = 0; //TAIXA DE METABOLISMO BASAL
    	double fa = 0;  //FATOR DE ATIVIDADE
    	double imc = 0; //INDICE DE MASSA CORPÓREA
    	
    	//Calculo IMC
    	imc = peso/(altura*altura);
    	
    	//Calculo da TMB e FA
    	if (sexo =='f' || sexo =='F' ){
    		if(idade>=10 && idade<=18)
    			tmb = (12.2 * peso) + 746;
    		else if (idade>18 && idade<=30)
    			tmb = (14.7 * peso) + 496;
    		else if (idade>30 && idade<=60)
    			tmb = (8.7 * peso) + 829;
    		else
    			tmb = (10.5 * peso) + 596;
    		
    		switch (nivelDeSedentarismo)
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
    		
    		//Calculo de pontos
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
    	
    	else if (sexo =='m' || sexo =='M' ){
    		if(idade>=10 && idade<=18)
    			tmb = (17.5 * peso) + 651;
    		else if (idade>18 && idade<=30)
    			tmb = (15.3 * peso) + 679;
    		else if (idade>30 && idade<=60)
    			tmb = (8.7 * peso) + 879;
    		else
    			tmb = (13.5 * peso)  + 487;
    		
    		switch (nivelDeSedentarismo)
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
    		
    		//Calculo de pontos
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
    	
    	return pontos;
    }    

}
