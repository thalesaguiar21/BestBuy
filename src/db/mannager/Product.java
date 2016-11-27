package db.mannager;

public class Product {
	
	private int id;
	private int sId;
	private String prodName;
	private String prodCost;
	private String prodTipo;
	private String prodDescr;
	private String prodUsage;
	private String anounceLink;
	
	public Product (int id, int sId, String prodName, String prodCost, String prodTipo, 
			String prodDescr, String prodUsage, String anounceLink){
		this.id          = id;
		this.sId         = sId;
		this.prodName    = prodName;
		this.prodCost    = prodCost;
		this.prodTipo    = prodTipo;
		this.prodDescr   = prodDescr;
		this.prodUsage   = prodUsage;
		this.anounceLink = anounceLink;
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdCost() {
		return prodCost;
	}

	public void setProdCost(String prodCost) {
		this.prodCost = prodCost;
	}

	public String getProdTipo() {
		return prodTipo;
	}

	public void setProdTipo(String prodTipo) {
		this.prodTipo = prodTipo;
	}

	public String getProdDescr() {
		return prodDescr;
	}

	public void setProdDescr(String prodDescr) {
		this.prodDescr = prodDescr;
	}

	public String getProdUsage() {
		return prodUsage;
	}

	public void setProdUsage(String prodUsage) {
		this.prodUsage = prodUsage;
	}

	public String getAnounceLink() {
		return anounceLink;
	}

	public void setAnounceLink(String anounceLink) {
		this.anounceLink = anounceLink;
	}
}
