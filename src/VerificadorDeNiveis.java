import java.util.List;

public class VerificadorDeNiveis implements Verificador{

	@Override
	public List<Servidor> verificar() {
		for(Servidor serv : DadosDoSistema.getDados().getServidores()){
			System.out.println(serv.getNome());
		}
		return null;
	}

	@Override
	public List<Servidor> verificar(String nome) {
		return null;
	}

	@Override
	public List<Servidor> verificar(List<String> nomes) {
		return null;
	}

}
