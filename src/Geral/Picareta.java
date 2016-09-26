package Geral;
import java.util.LinkedList;
import java.util.List;

import org.jsoup.nodes.Document;

/**
 * Classe abstrata, que representa a entidade respons�vel por procurar
 * os dados requeridos para a aplica��o funcionar
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
     * Respons�vel por fazer a requisi��o HTTP, checar resposta e reunir todos os links da p�gina.
     * Depois, faz a busca por palavras chave.
     * 
     * @param url
     *            - O url da p�gina que ser� visitada
     * @return Se a visita foi um sucesso ou n�o
     */
    public abstract boolean crawl(String url);


    /**
     * Faz uma busca por determinadas palavras no HTML e trata a string
     * retornando apenas o que � importante.
     * 
     * @return Se a palavra foi ou n�o encontrada
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
