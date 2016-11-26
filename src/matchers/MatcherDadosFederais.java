package matchers;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import db.mannager.*;
import framework.DadosGlobais;
import framework.match.Matcher;

public class MatcherDadosFederais implements Matcher{
	
	public MatcherDadosFederais() {
		
	}
	
	@Override
	public List<ServidorPublico> allMatchs() {
		List<Map<String, Object>> servIncoerentes = new ArrayList<Map<String, Object>>();
		servIncoerentes = DadosGlobais.getDados().getMyDb().select("SELECT se.nome, se.cpf FROM BolsaFamilia bf, Servidor se\n" +
																	 "WHERE substring(se.cpf from 4 for 9) = substring(bf.cpf from 4 for 9)\n" +
																	 "ORDER BY se.nome, se.cpf;");
		List<ServidorPublico> servidores = new ArrayList<ServidorPublico>();
		
		for(int i = 0; i < servIncoerentes.size(); i++){
			ServidorPublico newSe = new ServidorPublico((String)servIncoerentes.get(i).get("nome"),
														(String)servIncoerentes.get(i).get("cpf"));
			servidores.add(newSe);
		}
		
		return servidores;
	}

	@Override
	public List<ServidorPublico> matchByName(String nome) {
		List<ServidorPublico> servIncoerentes = new ArrayList<ServidorPublico>();
		for(ServidorPublico serv : DadosGlobais.getDados().getServidoresPublicos()){
			String servNome = serv.getNome().trim();
			if(serv.getbFamilia() & servNome.equalsIgnoreCase(nome)) servIncoerentes.add(serv);
		}
		return servIncoerentes;
	}

	@Override
	public List<ServidorPublico> matchByNames(List<String> nomes) {
		return null;
	}

}
