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
		return url.equals("") || url.contains("Ordem") || !(url.contains("CodOrg=26243"));
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
	    if(rows.size() > 0){
	    	rows.remove(0);//nome das colunas
	    }

	    for(Element row : rows){
	    	Elements cells = row.select("td");
	    	//						CPF 						NOME						ORGAO
	    	//System.out.println(cells.get(0).text() + " " + cells.get(1).text() + "\t\t" + cells.get(2).text());
	    	DadosDoSistema.getDados().getMyDb().update("INSERT INTO Servidor(Institucao_idinstitucao, nome, cpf, remuneracao) VALUES "+
	    											   "(1,'" + cells.get(1).text() + "','" + cells.get(0).text() + "', 0.0);");
	    }
		return 1f;
	}
}
