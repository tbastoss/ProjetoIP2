package br.com.dieta_saude.dados;
// lendo um arquivo de Objetos sequencialmente com ObjectInputStream
// e exibe cada registro
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;



public class ReadSequentialFile {
	
	private ObjectInputStream input;
	
	// permite que o usuário selecione o arquivo a abrir
	public void openFile(String caminhoOuNomeDoArquivo)
	{
		try // abre o arquivo
		{
			input = new ObjectInputStream(
					new FileInputStream(caminhoOuNomeDoArquivo) );
		}
		catch ( IOException ioException){
			System.err.println("Error opening file.");
		}
	}

	
	// lê o registro do arquivo
	public Object readRecords(){
		
		RepositorioGenerico record=null;
		
		
		try // insere os valores do arquivo
		{
			record = (RepositorioGenerico) input.readObject();
		}
		catch ( EOFException eofException)
		{
			System.err.println("EOFException"); // fim do arquivo foi alcançado
		}
		catch ( ClassNotFoundException classNotFoundException)
		{
			System.err.println("Unable to create object.");
		}
		catch ( IOException ioException)
		{
			System.err.println("Error during read from file.");
		}
		
		return record;
		
	}
	
	// fecha o arquivo e termina o aplicativo
	public void closeFile()
	{
		try // fecha o arquivo e encerra
		{
			if ( input != null )
				input.close();
		}
		catch ( IOException ioException){
			
			System.err.println("Error closing file.");
			System.exit(1);
		}
	}
	
	
	public static void main(String[] args) {
		
		ReadSequentialFile app = new ReadSequentialFile();
		
		app.openFile("rep1.rep");
		RepositorioAlimento rep1 = (RepositorioAlimento) app.readRecords();
		app.closeFile();
		System.out.println(rep1.toString());
		
	}
}
