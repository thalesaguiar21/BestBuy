package Geral;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import db.mannager.*;

public class VerficadorDeBFamilia implements Verificador{
	
	public VerficadorDeBFamilia() {
		
	}
	
	@Override
	public List<Map<String, Object>> verificar() {
		List<Map<String, Object>> servIncoerentes = new ArrayList<Map<String, Object>>();
		servIncoerentes = DadosDoSistema.getDados().getMyDb().select("SELECT se.nome, se.cpf FROM BolsaFamilia bf, Servidor se" +
																	 "WHERE substring(se.cpf from 4 for 9) = substring(bf.cpf from 4 for 9)" +
																	 "ORDER BY se.nome, se.cpf;");
		return servIncoerentes;
	}

	@Override
	public List<ServidorPublico> verificar(String nome) {
		List<ServidorPublico> servIncoerentes = new ArrayList<ServidorPublico>();
		for(ServidorPublico serv : DadosDoSistema.getDados().getServidoresPublicos()){
			String servNome = serv.getNome().trim();
			if(serv.getbFamilia() & servNome.equalsIgnoreCase(nome)) servIncoerentes.add(serv);
		}
		return servIncoerentes;
	}

	@Override
	public List<ServidorPublico> verificar(List<String> nomes) {
		return null;
	}

}
