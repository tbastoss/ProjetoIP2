package br.com.dieta_saude.dados;
// Gravando objetos sequencialmente em um arquivo com a classe ObjectOutputStream.
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;




public class CreateSequentialFileToRepository {
	
	private ObjectOutputStream output; // gera saída dos dados no arquivo
	private RepositorioGenerico rep;
	
	// permite que o usuário especifique o nome do arquivo
	public void openFile(String caminhoOuNomeDoArquivo){
		
		try // abre o arquivo
		{
			output = new ObjectOutputStream (
					new FileOutputStream(caminhoOuNomeDoArquivo) );
		}
		catch ( IOException ioException)
		{
			System.err.println("Error opening file.");
		}
	}
	
	// adiciona repositório ao arquivo
	public void addRecords(RepositorioGenerico repositorioASalvarEmArquivo)
	{
			this.rep = repositorioASalvarEmArquivo;
			try // gera saída repositório para o arquivo
			{
				this.output.writeObject(rep); // gera a saída de registro
				
			}
			catch ( IOException ioException)
			{
				System.err.println("Error writing to file.");
				return;
			}
				
		
	}
	
	// fechar o arquivo e termina o aplicativo
	public void closeFile()
	{
		try
		{
			if (output != null )
				output.close();
		}
		catch ( IOException ioException)
		{
			System.err.println("Error closing file.");
			System.exit(1);
		}
	}

	public static void main(String[] args) {
		
		RepositorioDieta rep = new RepositorioDieta(150);
		RepositorioAlimento rep1 = RepositorioAlimento.getInstance();
		
		CreateSequentialFileToRepository app = new CreateSequentialFileToRepository();
		
		app.openFile("rep1.rep");
		app.addRecords(rep1);
		app.closeFile();
		System.out.println("Chegou ao fim");
		System.out.println(rep1);
		
	}
	
}
