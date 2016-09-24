package Geral;
import java.util.List;

import db.mannager.ServidorPublico;

public interface Verificador {
	List<ServidorPublico> verificar();
	List<ServidorPublico> verificar(String nome);
	List<ServidorPublico> verificar(List<String> nomes);
}
