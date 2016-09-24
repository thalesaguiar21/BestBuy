package Geral;
import java.util.ArrayList;
import java.util.List;

import db.mannager.ServidorPublico;

public class VerficadorDeBFamilia implements Verificador{

	@Override
	public List<ServidorPublico> verificar() {
		List<ServidorPublico> servIncoerentes = new ArrayList<ServidorPublico>();
		for(ServidorPublico serv : DadosDoSistema.getDados().getServidoresPublicos()){
			if(serv.getbFamilia()) servIncoerentes.add(serv);
		}
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
