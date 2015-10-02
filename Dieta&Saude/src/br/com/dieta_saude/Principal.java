package br.com.dieta_saude;

import java.util.Scanner;

import br.com.dieta_saude.dados.RepositorioAlimento;
import br.com.dieta_saude.dados.RepositorioUsuario;
import br.com.dieta_saude.java_beans.Alimento;
import br.com.dieta_saude.java_beans.Usuario;
import controladorDeUsuario.ControladorDeAlimentos;
import controladorDeUsuario.ControladorDeUsuario;

public class Principal {
	public static void main(String []args){
		boolean quest= false;
		boolean quest2 = false;
		boolean quest3= false;
		boolean quest4= false;
		boolean quest5= false;
		boolean quest6= false;
		boolean quest7= false;
		Scanner scr = new Scanner(System.in);
		System.out.println("Bem-vindo ao Dieta&Vida!");
		RepositorioUsuario repositorio = new RepositorioUsuario(20);
		RepositorioAlimento repositorioAlimento = new RepositorioAlimento(50);
		ControladorDeUsuario controlador = new ControladorDeUsuario();
		ControladorDeAlimentos controladorAlimento = new ControladorDeAlimentos();
		while(!quest){
			System.out.println("Voc� deseja cadastrar ou logar?");
			String opcao = scr.nextLine();
			if(opcao.equals("cadastrar")){
				while(!quest2){
					System.out.println("Voc� � um usu�rio comum ou administrativo? Se comum, insira COMUM, se administrativo, insira o codigo: ");
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
						while(!quest3){
							System.out.println("Voc� � adm! O que deseja? OBS: Para mostrar os comandos dispon�veis, digite !comandos");
							String comando = scr.nextLine();
							if(comando.equals("!comandos")){
								System.out.println("!cadastrarAlimento, !atualizarAlimento, !removerAlimento");
							}else if(comando.equals("!cadastrarAlimento")){
								System.out.println("Nome do alimento:");
								String nomeAlimento = scr.nextLine();
								System.out.println("Pontos do alimento:");
								int pontosAlimento = scr.nextInt();
								controladorAlimento.adicionaAlimentos(nomeAlimento, pontosAlimento, repositorioAlimento);
								quest3= true;
							}else if(comando.equals("!atualizarAlimento")){
								System.out.println("Nome do alimento:");
								String nomeAlimento = scr.nextLine();
								System.out.println("Pontos do alimento:");
								int pontosAlimento = scr.nextInt();
								repositorioAlimento.atualizar(nomeAlimento, pontosAlimento);
								quest3= true;
							}else if(comando.equals("!removerAlimento")){
								System.out.println("Nome do alimento:");
								String nomeAlimento = scr.nextLine();
								repositorioAlimento.remover(nomeAlimento);
								quest3= true;
							}else{
								System.out.println("Insira o comando correto:");
								quest3 = false;
							}
						}
					}else{
						System.out.println("Voc� � comum!");
					}
				}else{
					System.out.println("Usuario n�o existe!");
				}
			}else if(opcao.equals("sair")){
				System.out.println("Volte sempre!");
				quest = true;
			}
		}
	}
}
