package br.com.dieta_saude;

import java.util.Scanner;

import br.com.dieta_saude.dados.RepositorioAlimento;
import br.com.dieta_saude.dados.RepositorioUsuario;
import br.com.dieta_saude.java_beans.Alimento;
import br.com.dieta_saude.java_beans.Usuario;
import br.com.dieta_saude.java_beans.UsuarioAdm;
import br.com.dieta_saude.java_beans.UsuarioComum;
import br.com.dieta_saude.controladores.ControladorDeAlimentos;
import br.com.dieta_saude.controladores.ControladorDeUsuario;

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
		
		/*
		 * Colocar os dados relacionados a arquivos aqui.
		 * @Cristovao
		 */
		
		//try{
		while(!quest){
			System.out.println("Você deseja cadastrar, logar ou sair?");
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
						UsuarioComum usuario = new UsuarioComum();
						usuario.cadastroUsuario(nome, senha, sexo, altura, peso, idade, nivelDeSedentarismo, 0);
						usuario.calcularPontos();
						repositorio.cadastrar(usuario);
						opcao = null;
						quest2 = true;
					}else if(codigo.equals(Usuario.getCodAdmin())){
						System.out.println("Nome:");
						String nome = scr.nextLine();
						System.out.println("Senha:");
						String senha = scr.nextLine();
						UsuarioAdm admin = new UsuarioAdm();
						admin.cadastrarAdm(nome, senha, 1);
						repositorio.cadastrar(admin);
						opcao = null;
						quest2 = true;
					}/*else{
						System.out.println("Comando invalido!");
					}*/
				}
				quest2 = false;
			}else if(opcao.equals("logar")){
				System.out.println("Insira seu nome:");
				String nome = scr.nextLine();
				System.out.println("Insira sua senha:");
				String senha = scr.nextLine();
				
				if(controlador.verificaExistenciaDeUsuario(nome, senha, repositorio)){
					Usuario usuario = repositorio.procurar(nome, senha);
					opcao = null;
					if(controlador.verificaTipoDeUsuario(usuario)){
						while(!quest3){
							
							System.out.println("Você é adm! O que deseja? OBS: Para mostrar os comandos disponíveis, digite !comandos");
							String comando = scr.nextLine();
							if(comando.equals("!comandos")){
								System.out.println("!cadastrarAlimento, !atualizarAlimento, !removerAlimento, !sair");
							}else if(comando.equals("!cadastrarAlimento")){
								System.out.println("Nome do alimento:");
								String nomeAlimento = scr.nextLine();
								System.out.println("Pontos do alimento:");
								int pontosAlimento = scr.nextInt();
								Alimento aCadastrar = new Alimento(nomeAlimento, pontosAlimento);
								controladorAlimento.adicionaAlimentos(aCadastrar, repositorioAlimento);
							}else if(comando.equals("!atualizarAlimento")){
								System.out.println("Nome do alimento:");
								String nomeAlimento = scr.nextLine();
								System.out.println("Pontos do alimento:");
								int pontosAlimento = scr.nextInt();
								// ISugestao
								Alimento atualizador = new Alimento(nomeAlimento, pontosAlimento);
								// FSugestao
								// if(controladorAlimento.verificaExistenciaDeAlimento(nomeAlimento, repositorioAlimento)){
									// ISugestao
								if(controladorAlimento.verificaExistenciaDeAlimento(atualizador, repositorioAlimento)){
									// FSugestao
									repositorioAlimento.atualizar(atualizador);
								}else{
									System.out.println("Alimento não existe!");
								}
							}else if(comando.equals("!removerAlimento")){
								System.out.println("Nome do alimento:");
								String nomeAlimento = scr.nextLine();
								Alimento aRemover = new Alimento(nomeAlimento, 0);
								if(controladorAlimento.verificaExistenciaDeAlimento(aRemover, repositorioAlimento)){
									repositorioAlimento.remover(aRemover);
								}else{
									System.out.println("Alimento não existe!");
								}
							}else if(comando.equals("!sair")){
								System.out.println("Obrigado!");
								quest3= true;
							}
							
						}
						quest3 = false;
					}else{
						System.out.println("Cadastre sua dieta! Você tem "+usuario.getPontos()+"pontos disponíveis!");
						repositorioAlimento.mostrarAlimentos();
					}
				}else{
					System.out.println("Usuario não existe!");
					opcao = null;
				}
			}else if(opcao.equals("sair")){
				System.out.println("Volte sempre!");
				quest = true;
			}
		}
		/*}catch(Exception e){ 
	    	System.out.println("Comando inválido! Tente novamente!");
	    }*/
	}
	 
}
