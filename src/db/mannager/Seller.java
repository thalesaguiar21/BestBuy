package db.mannager;

import java.util.List;

public class Seller {
	
	private int id;
	private String name;
	private String addr;
	private String cpf;
	private String contact;
	private List<Product> anounces;
	
	public Seller (int id, String name, String addr, String cpf, String contact, List<Product> anounces){
		this.id			  = id;
		this.name     = name;
		this.addr 	  = addr;
		this.cpf      = cpf;
		this.contact  = contact;
		this.anounces = anounces;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public List<Product> getAnounces() {
		return anounces;
	}

	public void setAnounces(List<Product> anounces) {
		this.anounces = anounces;
	}
}
