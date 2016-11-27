package framework.match;
import java.util.List;

import db.mannager.Product;

public interface Matcher {
	List<Product> allMatchs();
	List<Product> matchByName(String nome);
	List<Product> matchByNames(List<String> nomes);
}
