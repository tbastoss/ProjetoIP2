package br.com.dieta_saude.java_beans;

public class Sessao {
	private static Sessao instance;
	private Usuario usuario;
	
	private Sessao(){
		
	};
	public static Sessao getInstance() {
        if (instance == null)
            instance = new Sessao();
        return instance;
    }
	public void setUsuario(Usuario usuario){
		this.usuario = usuario;
	}
}
