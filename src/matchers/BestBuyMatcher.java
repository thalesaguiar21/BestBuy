package matchers;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import db.mannager.*;
import framework.DadosGlobais;
import framework.match.Matcher;

public class BestBuyMatcher implements Matcher{
	
	public BestBuyMatcher() {
		
	}
	
	@Override
	public List<Product> allMatchs() {
		List<Map<String, Object>> produtos = new ArrayList<Map<String, Object>>();
		produtos = DadosGlobais.getDados().getMyDb().select("SELECT * FROM Product");
		
		List<Product> prod = new ArrayList<Product>();
		
		for(int i = 0; i < produtos.size(); i++){
			Product newSe = new Product((Integer)produtos.get(i).get("idproduct"),(Integer)produtos.get(i).get("seller_idseller"),(String)produtos.get(i).get("name"),(String)produtos.get(i).get("cost"),(String)produtos.get(i).get("tipo"),(String)produtos.get(i).get("descr"),(String)produtos.get(i).get("pusage"),(String)produtos.get(i).get("anouncelink"));
			prod.add(newSe);
		}
		
		return prod;
	}

	@Override
	public List<Product> matchByName(String nome) {
		List<Map<String, Object>> produtos = new ArrayList<Map<String, Object>>();
		String[] words = nome.split(" ");
		for(int i=0; i<words.length; i++){
			if(words[i]!="de"){
				produtos = DadosGlobais.getDados().getMyDb().select("SELECT * FROM Product " +
																	 "WHERE descr ILIKE '%"+ words[i] +"%' OR name ILIKE '%"+ words[i] +"%';");
			}
		}
		List<Product> prod = new ArrayList<Product>();
		
		for(int i = 0; i < produtos.size(); i++){
			Product newSe = new Product((Integer)produtos.get(i).get("idproduct"),(Integer)produtos.get(i).get("seller_idseller"),(String)produtos.get(i).get("name"),(String)produtos.get(i).get("cost"),(String)produtos.get(i).get("tipo"),(String)produtos.get(i).get("descr"),(String)produtos.get(i).get("pusage"),(String)produtos.get(i).get("anouncelink"));
			prod.add(newSe);
		}

		return prod;
	}

	@Override
	public List<Product> matchByNames(List<String> nomes) {
		return null;
	}

}
