package Geral;
import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PicaretaDeServidor extends Picareta {
		
	private int cont;
	
	public PicaretaDeServidor(){
		cont = 0;
		this.setBaseUrl("http://www.portaldatransparencia.gov.br/servidores/OrgaoLotacao-ListaServidores.asp?CodOrg=26243&Pagina=1");
	}
	
	@Override
	public boolean crawl(String url)
    {
        try
        {
            Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
            Document htmlDocument = connection.get();
            this.htmlDocument = htmlDocument;
            if(connection.response().statusCode() == 200)
            {
                System.out.println("\nVisitando... recebida a seguinte página: " + url);
            }
            if(!connection.response().contentType().contains("text/html"))
            {
                System.out.println("**FALHA** algo que não é HTML foi retornado!");
                return false;
            }
            Elements linksOnPage = htmlDocument.select("a[href]");
            System.out.println("Found (" + linksOnPage.size() + ") links");
            for(Element link : linksOnPage)
            {
            	String nextUrl = link.absUrl("href");
            	if(nextUrl.equals("") || nextUrl.contains("Ordem")
            						  || !(nextUrl.contains("CodOrg=26243")) ){
            		continue;
            	}
            	else{
            		if(nextUrl.matches(".*Pagina=\\d*#")){
            			int pageIndex = nextUrl.lastIndexOf("=");
            			String prefix = nextUrl.substring(0, pageIndex + 1);
            			nextUrl = prefix + (Integer.parseInt(nextUrl.substring(pageIndex + 1, nextUrl.length() - 1)) + 1);
            		}
            		this.links.add(nextUrl);
            	}
            }
            return true;
        }
        catch(IOException ioe)
        {
        	System.out.println(ioe);
        	System.out.println("Tentando novamente");
        	cont++;
        	if(cont >= 5){
        		cont = 0;
        		System.out.println("Não foi possível acessar :" + url);
        		return false;
        	}
        	else{
        		cont = 0;
        		return crawl(url);
        	}
        }
    }
	
	@Override
	public float searchForWord()
	{
	    if(this.htmlDocument.body() == null)
	    {
	        System.out.println("**ERRO** Invoque crawl() antes de realizar a análise do documento!");
	        return -1f;
	    }
	    Elements rows = this.htmlDocument.select("#listagem > table > tbody > tr");
	    rows.remove(0);

	    for(Element row : rows){
	    	Elements cells = row.select("td");
	    	//						CPF 						NOME						ORGAO
	    	System.out.println(cells.get(0).text() + " " + cells.get(1).text() + "\t\t" + cells.get(2).text());
	    	DadosDoSistema.getDados().getMyDb().update("INSERT INTO Servidor(Institucao_idinstitucao, nome, cpf, remuneracao) VALUES "+
	    											   "(1,'" + cells.get(1) + "'," + cells.get(0) + ", 0.0)");
	    }
		return 1f;
	}
}
