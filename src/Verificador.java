import java.util.List;

public interface Verificador {
	List<Servidor> verificar();
	List<Servidor> verificar(String nome);
	List<Servidor> verificar(List<String> nomes);
}
