package webCrawler;
import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PicaretaDeNiveis extends Picareta{
	
	public PicaretaDeNiveis(){
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
            	if(nextUrl.equals("") ||
            	  !(nextUrl.contains("CodOrg=26243") || nextUrl.contains("CodOrgao=26243")) ||
            	  nextUrl.contains("Ordem=")){
            		continue;
            	}
            	else{
            		if(nextUrl.matches(".*Pagina=\\d#")){
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
            return false;
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
	    String searchWord = "Remuneração básica bruta";
	    String bodyText = this.htmlDocument.body().text();
	    if(bodyText.contains(searchWord)){
	    	int i = bodyText.indexOf(searchWord) + searchWord.length();
	    	String str = bodyText.substring(i, i + 15);
	    	str = str.replaceAll("[^\\d,]", "");
	    	str = str.replace(",", ".");
	    	System.out.println("\"" + str + "\"");
	    	return Float.parseFloat(str);
	    }
	    else{
	    	return -1f;
	    }
	}
}
