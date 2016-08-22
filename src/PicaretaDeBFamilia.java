import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PicaretaDeBFamilia extends Picareta{
	public float searchForWord(String searchWord){
		Integer ocorrencias = 0;
        String caminho = "C:\\Users\\Thales\\Desktop\\pag_bolsa.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))){
            String linhasDoArquivo = new String();
            System.out.println("Procurando...");
            while((linhasDoArquivo = br.readLine()) != null){
                //System.out.println(linhasDoArquivo);
                if(linhasDoArquivo.contains(searchWord)){
                	ocorrencias++;
                } 
            }
            if(ocorrencias > 0){
            	System.out.println("Foram encontradas " + ocorrencias + " ocorrências de " + searchWord);
            }
            else{
                System.out.println(searchWord + " não foi encontrado!");
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
        	System.out.println("Erro ao ler o arquivo: " + caminho);
        }
        return 0.0f;
	}
}
