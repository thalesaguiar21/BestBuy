package WebCrawler;

import Geral.DadosDoSistema;

public class PicaretaDeBFamilia extends Picareta{
	
	public PicaretaDeBFamilia(){
		cont = 0;
		this.setBaseUrl("http://www.portaldatransparencia.gov.br/PortalTransparenciaPesquisaAcaoFavorecido.asp?Exercicio=2016&textoPesquisa=&textoPesquisaAcao=&codigoAcao=8442&codigoFuncao=08&siglaEstado=RN&codigoMunicipio=1761&Pagina=1");
	}
	
	@Override
	public boolean comp(String url)
    {
		return url.equals("") || url.contains("Ordem")
				  || url.contains("codFavorecido=")
				  || !(url.contains("codigoAcao=8442")) 
				  || !(url.contains("codigoMunicipio=1761"));
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
	    	String aux = "";
	    	for(String s : strs){
	    		if(s.contains(",")){
	    			s = s.replaceAll("[\\d,.]", "").trim(); //Nome
	    			DadosDoSistema.getDados().getMyDb().update("INSERT INTO BolsaFamilia(nome, cpf) VALUES ('" + s + "', '" + aux + "');");
	    		}
	    		else{
	    			aux = s.replaceAll("[.-]", "");
	    			aux = aux.substring(0, 3) + "." + aux.substring(3, 6) + "." + aux.substring(6, 9) + "-" + aux.substring(9);
	    			System.out.println(aux); //CPF
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
