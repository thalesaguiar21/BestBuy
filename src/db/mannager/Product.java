package db.mannager;

public class Product {
	
	private int id;
	private int sId;
	private String name;
	private String cost;
	private String tipo;
	private String descr;
	private String pusage;
	private String anounceLink;
	
	public Product (int id, int sId, String name, String cost, String tipo, 
			String descr, String pusage, String anounceLink){
		this.id          = id;
		this.sId         = sId;
		this.name        = name;
		this.cost        = cost;
		this.tipo        = tipo;
		this.descr       = descr;
		this.pusage      = pusage;
		this.anounceLink = anounceLink;
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getPusage() {
		return pusage;
	}

	public void setPusage(String pusage) {
		this.pusage = pusage;
	}

	public String getAnounceLink() {
		return anounceLink;
	}

	public void setAnounceLink(String anounceLink) {
		this.anounceLink = anounceLink;
	}

	public int getId() {
		return id;
	}
	
}
