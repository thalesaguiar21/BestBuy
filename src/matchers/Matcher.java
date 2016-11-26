package matchers;
import java.util.List;

import db.mannager.ServidorPublico;

public interface Matcher {
	List<ServidorPublico> allMatchs();
	List<ServidorPublico> matchByName(String nome);
	List<ServidorPublico> matchByNames(List<String> nomes);
}
