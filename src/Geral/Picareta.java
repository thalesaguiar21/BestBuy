package Geral;
import java.util.LinkedList;
import java.util.List;

import org.jsoup.nodes.Document;

/**
 * Classe abstrata, que representa a entidade responsável por procurar
 * os dados requeridos para a aplicação funcionar
 * .
 * @author Geovanni Casemiro, Rafael Lucena, Thales Aguiar
 *
 */
public abstract class Picareta {

	private String baseUrl;
	protected static final String USER_AGENT =
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";
    protected List<String> links = new LinkedList<String>();
    protected Document htmlDocument;


    /**
     * Responsável por fazer a requisição HTTP, checar resposta e reunir todos os links da página.
     * Depois, faz a busca por palavras chave.
     * 
     * @param url
     *            - O url da página que será visitada
     * @return Se a visita foi um sucesso ou não
     */
    public abstract boolean crawl(String url);


    /**
     * Faz uma busca por determinadas palavras no HTML e trata a string
     * retornando apenas o que é importante.
     * 
     * @return Se a palavra foi ou não encontrada
     */
    public abstract float searchForWord();


    public List<String> getLinks()
    {
        return this.links;
    }
    
    public void esvaziarLinks(){
    	this.links.clear();
    }


	public String getBaseUrl() {
		return baseUrl;
	}


	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

}
