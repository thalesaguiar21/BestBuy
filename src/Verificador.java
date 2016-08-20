import java.util.List;

public interface Verificador {
	List<ServidorPublico> verificar();
	List<ServidorPublico> verificar(String nome);
	List<ServidorPublico> verificar(List<String> nomes);
}
