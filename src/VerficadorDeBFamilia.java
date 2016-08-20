import java.util.ArrayList;
import java.util.List;

public class VerficadorDeBFamilia implements Verificador{

	@Override
	public List<ServidorPublico> verificar() {
		List<ServidorPublico> servIncoerentes = new ArrayList<ServidorPublico>();
		for(ServidorPublico serv : DadosDoSistema.getDados().getServidorPublicoes()){
			if(serv.getbFamilia()) servIncoerentes.add(serv);
		}
		return servIncoerentes;
	}

	@Override
	public List<ServidorPublico> verificar(String nome) {
		List<ServidorPublico> servIncoerentes = new ArrayList<ServidorPublico>();
		for(ServidorPublico serv : DadosDoSistema.getDados().getServidorPublicoes()){
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
