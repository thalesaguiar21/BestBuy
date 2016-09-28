package db.mannager;

public class ServidorPublico {
	private String nome;
	private String cpf;
	private Integer nivel;
	private Float remuneracao;
	private Boolean bFamilia;
	
	public ServidorPublico(){
		this.nome = null;
		this.cpf = null;
		this.nivel = null;
		this.remuneracao = null;
		this.bFamilia = null;
	}
	
	public ServidorPublico(String nome, String cpf){
		this.nome = nome;
		this.cpf = cpf;
		this.nivel = 0;
		this.remuneracao = 0f;
		this.bFamilia = false;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public Integer getNivel() {
		return nivel;
	}
	
	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Float getRemuneracao() {
		return remuneracao;
	}
	
	public void setRemuneracao(Float remuneracao) {
		this.remuneracao = remuneracao;
	}
	
	public Boolean getbFamilia() {
		return bFamilia;
	}
	
	public void setbFamilia(Boolean bFamilia) {
		this.bFamilia = bFamilia;
	}
}
