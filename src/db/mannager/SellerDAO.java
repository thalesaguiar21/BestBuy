package db.mannager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import framework.DadosGlobais;

public class SellerDAO {
	
	private ProductDAO pDao;
	
	public SellerDAO (){
		pDao = new ProductDAO();
	}
	
	public Seller get (int sellId) {
		String query = "SELECT * FROM Seller WHERE idSeller = '" + sellId + "';";
		List<Map<String, Object>> seller = DadosGlobais.getDados().getMyDb().select(query);
		String sName    = (String) seller.get(0).get("name");
		String sAddr    = (String) seller.get(0).get("addr");
		String sCpf     = (String) seller.get(0).get("cpf");
		String sContact = (String) seller.get(0).get("contact");
		
		String queryAnounces = "SELECT * From Product WHERE Seller_idSeller = " + sellId + ";";
		List<Product> sAnounces = new ArrayList<Product>();
		List<Map<String, Object>> selAnounces = DadosGlobais.getDados().getMyDb().select(queryAnounces);
		for (Map<String, Object> prod : selAnounces) {
			Integer pId          = (Integer) prod.get("idproduct");
			String pName         = (String) prod.get("name");
			String pCost         = (String) prod.get("cost");
			String pTipo         = (String) prod.get("tipo");
			String pDescr 		 = (String) prod.get("descr");
			String pUsage        = (String) prod.get("pusage");
			String pAnounceLink = (String) prod.get("anouncelink");
			sAnounces.add(new Product(pId, sellId, pName, pCost, pTipo, pDescr, pUsage, pAnounceLink));
		}
			
		return new Seller(sellId, sName, sAddr, sCpf, sContact, sAnounces);
	}
	
	public void insert (Seller seller) {
		// Insere o Seller no banco
		String query = "INSERT INTO Seller(name, addr, cpf, contact) "
				+ "VALUES ('" + seller.getName() + "', '" + seller.getAddr()
				+ "', '" + seller.getCpf() + "', '" + seller.getContact() + "');";
		DadosGlobais.getDados().getMyDb().update(query);
		
		// Insere os anúncios do Seller no banco
		String getInsertedSeller = "SELECT idSeller FROM Seller WHERE name = '" + seller.getName() + "';";
		List<Map<String, Object>> sellers = DadosGlobais.getDados().getMyDb().select(getInsertedSeller);
		Integer seller_id = (Integer) sellers.get(sellers.size()).get("idseller");
		for (Product prod : seller.getAnounces()) {
			prod.setsId(seller_id);
			pDao.insert(prod);
		}
	}
	
	public void remove (Seller seller) {
		String queryAnounce = "DELETE FROM Product WHERE Seller_idSeller = " + seller.getId() + ";";
		DadosGlobais.getDados().getMyDb().update(queryAnounce);
		String query = "DELETE FROM Seller WHERE idSeller = " + seller.getId() + " LIMIT 1;";
		DadosGlobais.getDados().getMyDb().update(query);
	}
	
	public void update (Seller oSeller, Seller nSeller) {
		String query = "UPDATE Seller SET name = '" + nSeller.getName() + "', addr = '"
				+ nSeller.getAddr() + "', cpf = '" + nSeller.getCpf() + "', contact = '" 
				+ nSeller.getContact() + "' WHERE idSeller = " + nSeller.getId() + ";";
		DadosGlobais.getDados().getMyDb().update(query);
	}
}
