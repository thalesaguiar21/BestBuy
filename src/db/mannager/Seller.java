package db.mannager;

import java.util.List;

public class Seller {
	
	private int id;
	private String sellName;
	private String sellAddr;
	private String sellCpf;
	private String sellContact;
	private List<Product> sellAnounces;
	
	public Seller (int id, String sellName, String sellAddr, String sellCpf, String sellContact, List<Product> sellAnounces){
		this.id			  = id;
		this.sellName     = sellName;
		this.sellAddr 	  = sellAddr;
		this.sellCpf      = sellCpf;
		this.sellContact  = sellContact;
		this.sellAnounces = sellAnounces;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSellName() {
		return sellName;
	}

	public void setSellName(String sellName) {
		this.sellName = sellName;
	}

	public String getSellAddr() {
		return sellAddr;
	}

	public void setSellAddr(String sellAddr) {
		this.sellAddr = sellAddr;
	}

	public String getSellCpf() {
		return sellCpf;
	}

	public void setSellCpf(String sellCpf) {
		this.sellCpf = sellCpf;
	}

	public String getSellContact() {
		return sellContact;
	}

	public void setSellContact(String sellContact) {
		this.sellContact = sellContact;
	}

	public List<Product> getSellAnounces() {
		return sellAnounces;
	}

	public void setSellAnounces(List<Product> sellAnounces) {
		this.sellAnounces = sellAnounces;
	}
}
