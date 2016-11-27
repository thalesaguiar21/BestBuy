package matchers;
import java.util.ArrayList;
import java.util.List;

import db.mannager.*;
import framework.match.Matcher;

public class BestBuyMathcer implements Matcher{
	
	public BestBuyMathcer() {
		
	}
	
	@Override
	public List<Product> allMatchs() {
		/*List<Map<String, Object>> servIncoerentes = new ArrayList<Map<String, Object>>();
		servIncoerentes = DadosGlobais.getDados().getMyDb().select("SELECT se.nome, se.cpf FROM BolsaFamilia bf, Servidor se\n" +
																	 "WHERE substring(se.cpf from 4 for 9) = substring(bf.cpf from 4 for 9)\n" +
																	 "ORDER BY se.nome, se.cpf;");*/
		List<Product> products = new ArrayList<Product>();
		
		/*for(int i = 0; i < servIncoerentes.size(); i++){
			Product newSe = new Product((String)servIncoerentes.get(i).get("nome"),
														(String)servIncoerentes.get(i).get("cpf"));
			servidores.add(newSe);
		}*/
		
		return products;
	}

	@Override
	public List<Product> matchByName(String nome) {
		List<Product> servIncoerentes = new ArrayList<Product>();
		/*for(Product serv : DadosGlobais.getDados().getServidoresPublicos()){
			String servNome = serv.getNome().trim();
			if(serv.getbFamilia() & servNome.equalsIgnoreCase(nome)) servIncoerentes.add(serv);
		}*/
		return servIncoerentes;
	}

	@Override
	public List<Product> matchByNames(List<String> nomes) {
		return null;
	}

}
