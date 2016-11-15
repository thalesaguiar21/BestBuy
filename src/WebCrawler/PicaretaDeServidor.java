package WebCrawler;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Geral.DadosDoSistema;

public class PicaretaDeServidor extends Picareta {
	
	public PicaretaDeServidor(){
		cont = 0;
		this.setBaseUrl("http://www.portaldatransparencia.gov.br/servidores/OrgaoLotacao-ListaServidores.asp?CodOrg=26243&Pagina=1");
	}
	
	@Override
	public boolean comp(String url)
    {
		return url.equals("") || url.contains("Ordem") || !(url.contains("CodOrg=26243") || url.contains("CodOrgao=26243")) || url.contains("Mes=");
    }
	
	@Override
	public float searchForWord()
	{
	    if(this.htmlDocument.body() == null)
	    {
	        System.out.println("**ERRO** Invoque crawl() antes de realizar a análise do documento!");
	        return -1f;
	    }
	    if(!this.htmlDocument.text().contains("Ficha Cadastral» Remuneração")){
	    	return 1f;
	    }
	    Elements r = this.htmlDocument.select(".remuneracaodetalhe > .colunaValor");
	    //Elements r = this.htmlDocument.select(".remuneracaolinhatotalliquida > .colunaValor");
	    Elements r2 = this.htmlDocument.select("#resumo > table > tbody > tr > td");

	    if(r.size() > 2){
		    //System.out.println(r2.get(1).text() + " " + r2.get(3).text() + " " + r.get(2).text());
		    //System.out.println(r2.get(1).text() + " " + r2.get(3).text() + " " + r.get(0).text());
	    	DadosDoSistema.getDados().getMyDb().update("INSERT INTO Servidor(Institucao_idinstitucao, nome, cpf, remuneracao) VALUES "+
	    											   "(1,'" + r2.get(1).text() + "','" + r2.get(3).text() + "', " + r.get(2).text() +");");
	    }
		return 1f;
	}
}
