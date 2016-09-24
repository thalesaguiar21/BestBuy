package Geral;
import java.util.List;

import db.mannager.ServidorPublico;

public class VerificadorDeNiveis implements Verificador{

	@Override
	public List<ServidorPublico> verificar() {
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
