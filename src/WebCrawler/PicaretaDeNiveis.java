package webcrawler;

public class PicaretaDeNiveis extends Picareta{
	
	public PicaretaDeNiveis(){
		this.setBaseUrl("http://www.portaldatransparencia.gov.br/servidores/OrgaoLotacao-ListaServidores.asp?CodOrg=26243&Pagina=1");
	}
	
	@Override
	public boolean comp(String url)
    {
    	return url.equals("") || !url.contains("CodOrg=26243") || url.contains("Ordem=");
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
