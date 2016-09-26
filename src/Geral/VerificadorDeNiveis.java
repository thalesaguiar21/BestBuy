package Geral;
import java.util.List;
import java.util.Map;

import db.mannager.ServidorPublico;

public class VerificadorDeNiveis implements Verificador{

	@Override
	public List<Map<String, Object>> verificar() {
		for(ServidorPublico serv : DadosDoSistema.getDados().getServidoresPublicos()){
			System.out.println(serv.getNome());
		}
		return null;
	}

	@Override
	public List<ServidorPublico> verificar(String nome) {
		return null;
	}

	@Override
	public List<ServidorPublico> verificar(List<String> nomes) {
		return null;
	}

}
