package Geral;
import java.util.List;
import java.util.Map;

import db.mannager.ServidorPublico;

public interface Verificador {
	List<Map<String, Object>> verificar();
	List<ServidorPublico> verificar(String nome);
	List<ServidorPublico> verificar(List<String> nomes);
}
