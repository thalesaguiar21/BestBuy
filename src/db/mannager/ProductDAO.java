package db.mannager;

import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import framework.DadosGlobais;

public class ProductDAO {

	public Product get (int id) {
		String query = "SELECT * FROM Product WHERE idProc = " + id + ";";
		Map<String, Object> prod = DadosGlobais.getDados().getMyDb().select(query).get(0);
		
		Integer mId        = (Integer) prod.get("idprod");
		Integer sId        = (Integer) prod.get("seller_idseller");
		String name        = (String) prod.get("name");
		String cost        = (String) prod.get("cost");
		String tipo        = (String) prod.get("tipo");
		String descr       = (String) prod.get("descr");
		String pusage      = (String) prod.get("pusage");
		String anounceLink = (String) prod.get("anouncelink");
		
		return new Product(mId, sId, name, cost, tipo, descr, pusage, anounceLink);
	}
	
	public List<Product> getByCondition (String condition){
		String query = "SELECT * FROM Product WHERE " + condition;
		List<Product> products =  new ArrayList<Product>();
		List<Map<String, Object>> prod = DadosGlobais.getDados().getMyDb().select(query);
		
		for(Map<String, Object> myProd : prod){
			Integer mId        = (Integer) myProd.get("idprod");
			Integer sId        = (Integer) myProd.get("seller_idseller");
			String name        = (String) myProd.get("name");
			String cost        = (String) myProd.get("cost");
			String tipo        = (String) myProd.get("tipo");
			String descr       = (String) myProd.get("descr");
			String pusage      = (String) myProd.get("pusage");
			String anounceLink = (String) myProd.get("anouncelink");
			products.add(new Product(mId, sId, name, cost, tipo, descr, pusage, anounceLink));
		}
		
		return products;
	}
	
	public void insert (Product prod) {
		String ins = "INSERT INTO Product (seller_idSeller, name, cost, tipo, descr"
				+ ", pusage, anounceLink) VALUES (" + prod.getsId() + ", '" + prod.getName() + "', '"
				+ prod.getCost() + "', '" + prod.getDescr() + "', '" + prod.getPusage() + "', '"
				+ prod.getAnounceLink() + "');";
		DadosGlobais.getDados().getMyDb().update(ins);
	}  
	
	public void remove (int id) {
		String rm = "DELETE FROM Product WHERE idProd = " + id + ";";
		DadosGlobais.getDados().getMyDb().update(rm);
	}
	
	public void removeByCondition(String condition) {
		String rm = "DELETE FROM Product WHERE " + condition;
		DadosGlobais.getDados().getMyDb().update(rm);
	}
	
	public void update (int id, Product nProd) {
		String updt = "UPDATE Product SET seller_idSeller = " + nProd.getsId() + ", name = '"
				+ nProd.getName() + "', cost = '" + nProd.getCost() + "', tipo = '"
				+ nProd.getTipo() + "', descr = '" + nProd.getPusage() + "', anounceLink = '"
				+ nProd.getAnounceLink() + "') WHERE idProd =" + id + ";";
		DadosGlobais.getDados().getMyDb().update(updt);
	}
}
