package br.com.dieta_saude.dados;
import br.com.dieta_saude.java_beans.Alimento;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class ReadTextFile {

	private Scanner input;
	
	// permite ao usuário abrir o arquivo
	public void openFile(){
		
		try{
			input = new Scanner( new File("dadosAlimentos.txt") );
		}
		catch( FileNotFoundException fileNotFoundException){
			System.err.println("Erro opening file.");
			System.exit(1);
		}
	}
	
	
	// Lê o registro no arquivo
	public void readRecords(RepositorioAlimento repositorio){
		
		// objeto a ser gravado na tela
		
		
				
		try // lê os registros no arquivo utilizando o objeto Scanner
		{
			while( input.hasNext())
			{
				Alimento record = new Alimento("",0);
				record.setNome(input.next());
				record.setPontos(input.nextInt());
				repositorio.cadastrar(record);
			}
		}
		catch ( NoSuchElementException elementException)
		{
			System.err.println("File improperly formed");
			input.close();
			System.exit(1);
		}
		catch ( IllegalStateException stateException)
		{
			System.err.println("Error reading from file.");
			System.exit(1);
		}
	}// fim do método readRecords
	
	// fecha o arquivo e termina o aplicativo
	public void closeFile(){
		
		if ( input != null )
			input.close(); // fecha arquivo
	}
	
	public static void main(String[] args) {
		ReadTextFile application = new ReadTextFile();
		RepositorioAlimento repositorio = RepositorioAlimento.getInstance();
		
		application.openFile();
		application.readRecords(repositorio);
		application.closeFile();
		
		
	}
}
