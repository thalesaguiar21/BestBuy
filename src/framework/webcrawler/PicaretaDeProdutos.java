package framework.webcrawler;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import db.mannager.Product;
import db.mannager.ProductDAO;

public class PicaretaDeProdutos extends Picareta {

	ProductDAO proddao;

	public PicaretaDeProdutos() {
		proddao = new ProductDAO();
		this.setBaseUrl("http://rn.olx.com.br/?o=1");
	}
	
	@Override
	public float searchForWord() {
	    if(this.htmlDocument.body() == null)
	    {
	        System.out.println("**ERRO** Invoque crawl() antes de realizar a análise do documento!");
	        return -1f;
	    }
	    Elements prods = this.htmlDocument.select(".list > .item > .OLXad-list-link");
	    for(Element e : prods){
			proddao.insert(
				new Product(							//argumentos
					Integer.parseInt(e.attr("id")),			//id
					0, 										//sId
					e.attr("name"),							//name
					e.select(".OLXad-list-price").text(),	//cost
					e.select(".detail-category").text(),	//tipo
					e.select(".OLXad-list-title").text(),	//descr
					e.select(".col-4 > .text").val(),		//pusage
					e.attr("href")							//anounceLink
				)
			);
	    	//System.out.println(e.select(query));
	    }
		return 1f;
	}

	@Override
	protected boolean comp(String url) {
		return !(url.startsWith("http://rn.olx.com.br/?o=") && !url.contains("#"));
	}

}
