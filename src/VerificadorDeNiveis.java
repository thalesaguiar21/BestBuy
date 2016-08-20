import java.util.List;

public class VerificadorDeNiveis implements Verificador{

	@Override
	public List<ServidorPublico> verificar() {
		for(ServidorPublico serv : DadosDoSistema.getDados().getServidorPublicoes()){
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
