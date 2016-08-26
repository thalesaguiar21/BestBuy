import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PicaretaDeBFamilia extends Picareta{
	
	PicaretaDeBFamilia(){
		this.baseUrl = "http://www.portaldatransparencia.gov.br/PortalTransparenciaPesquisaAcaoFavorecido.asp?Exercicio=2016&textoPesquisa=&textoPesquisaAcao=&codigoAcao=8442&codigoFuncao=08&siglaEstado=RN&codigoMunicipio=1761&Pagina=1";
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
                System.out.println("\n**Visiting** Received web page at " + url);
            }
            if(!connection.response().contentType().contains("text/html"))
            {
                System.out.println("**Failure** Retrieved something other than HTML");
                return false;
            }
            Elements linksOnPage = htmlDocument.select("a[href]");
            System.out.println("Found (" + linksOnPage.size() + ") links");
            for(Element link : linksOnPage)
            {
            	String nextUrl = link.absUrl("href");
            	if(nextUrl.equals("") || nextUrl.contains("codFavorecido=")
            						  || !(nextUrl.contains("codigoAcao=8442")) 
            						  || !(nextUrl.contains("codigoMunicipio=1761"))){
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
        	System.out.println(ioe); // We were not successful in our HTTP request
            return false;
        }
    }
	
	@Override
	public float searchForWord(String searchWord)
	{
	    if(this.htmlDocument.body() == null)
	    {
	        System.out.println("ERROR! Call crawl() before performing analysis on the document");
	        return -1f;
	    }
	    System.out.println("Searching for the word " + searchWord + "...");
	    String bodyText = this.htmlDocument.body().text();
	    if(bodyText.contains(searchWord)){
	    	int i = bodyText.indexOf(searchWord) + searchWord.length();
	    	String str = bodyText.substring(i, bodyText.length());
	    	str = str.substring(0, str.indexOf(" Página"));
	    	System.out.println(str);
	    	return 1f;
	    }
	    else{
	    	return -1f;
	    }
	}

	
}
