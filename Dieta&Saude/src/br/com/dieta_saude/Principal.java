package br.com.dieta_saude;

import java.util.Scanner;

public class Principal {
	public static void main(String []args){
		boolean quest= false;
		Scanner scr = new Scanner(System.in);
		System.out.println("Bem-vindo ao Dieta&Vida!");
		while(!quest){
			System.out.println("Você deseja cadastrar ou logar?");
			String opcao = scr.nextLine();
			if(opcao.equals("cadastrar")){
				System.out.println("Você é um usuário comum ou administrativo? Se comum, insira COMUM, se administrativo, insira a senha: ");
				//verificação
				if(/*usuario for comum*/){
					System.out.println("Nome:");
					String nome = scr.nextLine();
					System.out.println("Senha:");
					String senha = scr.nextLine();
					System.out.println("Sexo: M ou F");
					char sexo = scr.nextLine().charAt(0);
					System.out.println("Altura:");
					double altura = scr.nextDouble();
					System.out.println("Peso:");
					double peso = scr.nextDouble();
					System.out.println("idade:");
					int idade = scr.nextInt();
					System.out.println("Nivel de sedentarismo:");
					int nivelDeSedentarismo = scr.nextInt();
				}else{
					System.out.println("Nome:");
					String nome = scr.nextLine();
					System.out.println("Senha:");
					String senha = scr.nextLine();
					System.out.println("Sexo: M ou F");
					char sexo = scr.nextLine().charAt(0);
					System.out.println("idade:");
					int idade = scr.nextInt();
				}
				quest = true;
			}else if(opcao.equals("logar")){
				System.out.println("Insira seu nome:");
				String nome = scr.nextLine();
				System.out.println("Insira sua senha:");
				String senha = scr.nextLine();
				quest = true;
			}else{
				System.out.println("Comando errado! Digite novamente:");
			}
		}
	}
}
