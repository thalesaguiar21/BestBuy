import java.util.ArrayList;
import java.util.List;

public class VerficadorDeBFamilia implements Verificador{

	@Override
	public List<Servidor> verificar() {
		List<Servidor> servIncoerentes = new ArrayList<Servidor>();
		for(Servidor serv : DadosDoSistema.getDados().getServidores()){
			if(serv.getbFamilia()) servIncoerentes.add(serv);
		}
		return servIncoerentes;
	}

	@Override
	public List<Servidor> verificar(String nome) {
		List<Servidor> servIncoerentes = new ArrayList<Servidor>();
		for(Servidor serv : DadosDoSistema.getDados().getServidores()){
			String servNome = serv.getNome().trim();
			if(serv.getbFamilia() & servNome.equalsIgnoreCase(nome)) servIncoerentes.add(serv);
		}
		return servIncoerentes;
	}

	@Override
	public List<Servidor> verificar(List<String> nomes) {
		return null;
	}

}
