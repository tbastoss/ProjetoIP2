package br.com.dieta_saude;

import java.util.Scanner;

import br.com.dieta_saude.dados.RepositorioUsuario;
import br.com.dieta_saude.java_beans.Usuario;
import controladorDeUsuario.ControladorDeUsuario;

public class Principal {
	public static void main(String []args){
		boolean quest= false;
		boolean quest2 = false;
		Scanner scr = new Scanner(System.in);
		System.out.println("Bem-vindo ao Dieta&Vida!");
		RepositorioUsuario repositorio = new RepositorioUsuario(20);
		ControladorDeUsuario controlador = new ControladorDeUsuario();
		while(!quest){
			System.out.println("Você deseja cadastrar ou logar?");
			String opcao = scr.nextLine();
			if(opcao.equals("cadastrar")){
				while(!quest2){
					System.out.println("Você é um usuário comum ou administrativo? Se comum, insira COMUM, se administrativo, insira o codigo: ");
					String codigo = scr.nextLine();
					if(codigo.equals("COMUM")){
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
						Usuario usuario = new Usuario();
						usuario.cadastroUsuario(nome, senha, sexo, altura, peso, idade, nivelDeSedentarismo, 0);
						usuario.calcularPontos();
						System.out.println(usuario.toString());
						repositorio.cadastrar(usuario);
						quest2 = true;
					}else if(codigo.equals(Usuario.getCodAdmin())){
						System.out.println("Nome:");
						String nome = scr.nextLine();
						System.out.println("Senha:");
						String senha = scr.nextLine();
						Usuario admin = new Usuario();
						admin.cadastrarAdm(nome, senha, 1);
						System.out.println(admin.toString());
						repositorio.cadastrar(admin);
						quest2 = true;
					}else{
						System.out.println("Comando invalido!");
						quest2 = false;
					}
				}
			}else if(opcao.equals("logar")){
				System.out.println("Insira seu nome:");
				String nome = scr.nextLine();
				System.out.println("Insira sua senha:");
				String senha = scr.nextLine();
				if(controlador.verificaExistenciaDeUsuario(nome, senha, repositorio)){
					if(controlador.verificaTipoDeUsuario(repositorio.procurar(nome, senha))){
						System.out.println("Você é adm!");
					}else{
						System.out.println("Você é comum!");
					}
				}else{
					System.out.println("Usuario não existe!");
				}
			}else if(opcao.equals("sair")){
				System.out.println("Volte sempre!");
				quest = true;
			}
		}
	}
}
