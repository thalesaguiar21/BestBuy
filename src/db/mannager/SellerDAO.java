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
	
	public List<Seller> getSellers (String sellName) {
		List<Seller> fSellers = new ArrayList<Seller>();
		String query = "SELECT * FROM Seller WHERE sellName = '" + sellName + "';";
		List<Map<String, Object>> sellers = DadosGlobais.getDados().getMyDb().select(query);
		for (Map<String, Object> seller : sellers) {
			Integer sId     = (Integer) seller.get("idseller");
			String sName    = (String) seller.get("sellname");
			String sAddr    = (String) seller.get("selladdr");
			String sCpf     = (String) seller.get("sellcpf");
			String sContact = (String) seller.get("sellcontact");
			String queryAnounces = "SELECT * From Product WHERE Seller_idSeller = " + sId + ";";
			List<Product> sAnounces = new ArrayList<Product>();
			List<Map<String, Object>> selAnounces = DadosGlobais.getDados().getMyDb().select(queryAnounces);
			for (Map<String, Object> prod : selAnounces) {
				Integer pId          = (Integer) prod.get("idproduct");
				String pName         = (String) prod.get("prodname");
				String pCost         = (String) prod.get("prodcost");
				String pTipo         = (String) prod.get("prodtipo");
				String pDescr 		 = (String) prod.get("proddescr");
				String pUsage        = (String) prod.get("produsage");
				String pAnounceLink = (String) prod.get("anouncelink");
				sAnounces.add(new Product(pId, sId, pName, pCost, pTipo, pDescr, pUsage, pAnounceLink));
			}
			fSellers.add(new Seller(sId, sName, sAddr, sCpf, sContact, sAnounces));
			sAnounces.clear();
		}
		return fSellers;
	}
	
	public void insertSeller (Seller seller) {
		// Insere o Seller no banco
		String query = "INSERT INTO Seller(sellName, sellAddr, sellCpf, sellContact) "
				+ "VALUES ('" + seller.getSellName() + "', '" + seller.getSellAddr()
				+ "', '" + seller.getSellCpf() + "', '" + seller.getSellContact() + "');";
		DadosGlobais.getDados().getMyDb().update(query);
		
		// Insere os anúncios do Seller no banco
		String getInsertedSeller = "SELECT idSeller FROM Seller WHERE sellName = '" +seller.getSellName() + "';";
		List<Map<String, Object>> sellers = DadosGlobais.getDados().getMyDb().select(getInsertedSeller);
		Integer seller_id = (Integer) sellers.get(sellers.size()).get("idseller");
		for (Product prod : seller.getSellAnounces()) {
			pDao.insertProduct(prod, seller_id);
		} 
	}
	
	public void removeSeller (Seller seller) {
		String queryAnounce = "DELETE FROM Product WHERE Seller_idSeller = " + seller.getId() + ";";
		DadosGlobais.getDados().getMyDb().update(queryAnounce);
		String query = "DELETE FROM Seller WHERE idSeller = " + seller.getId() + " LIMIT 1;";
		DadosGlobais.getDados().getMyDb().update(query);
	}
	
	public void updateSeller (Seller oSeller, Seller nSeller) {
		String query = "UPDATE Seller SET sellName = '" + nSeller.getSellName() + "', sellAddr = '"
				+ nSeller.getSellAddr() + "', sellCpf = '" + nSeller.getSellCpf() + "', sellContact = '" 
				+ nSeller.getSellContact() + "' WHERE idSeller = " + nSeller.getId() + ";";
		DadosGlobais.getDados().getMyDb().update(query);
	}
}
