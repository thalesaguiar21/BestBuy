package Geral;
import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PicaretaDeBFamilia extends Picareta{
	
	int cont = 0;
	
	public PicaretaDeBFamilia(){
		this.setBaseUrl("http://www.portaldatransparencia.gov.br/PortalTransparenciaPesquisaAcaoFavorecido.asp?Exercicio=2016&textoPesquisa=&textoPesquisaAcao=&codigoAcao=8442&codigoFuncao=08&siglaEstado=RN&codigoMunicipio=1761&Pagina=1");
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
	    String searchWord = "Total no Ano (R$) ";
	    String bodyText = this.htmlDocument.body().text();
	    if(bodyText.contains(searchWord)){
	    	int i = bodyText.indexOf(searchWord) + searchWord.length();
	    	String str = bodyText.substring(i, bodyText.length());
	    	str = str.substring(0, str.indexOf(" Página"));
	    	String[] strs = str.split("(?<=\\d )");
	    	for(String s : strs){
	    		if(s.contains(",")){
	    			System.out.println(s.replaceAll("[\\d,.]", ""));
	    		}
	    		else{
	    			System.out.println(s);
	    		}
	    	}
	    	System.out.println();
	    	return 1f;
	    }
	    else{
	    	return -1f;
	    }
	}

	
}
