
public class Servidor {
	private String nome;
	private String cpf;
	private Integer nivel;
	private Float remuneracao;
	private Boolean bFamilia;
	
	Servidor(String nome, String cpf, Integer nivel, Float remuneracao, Boolean bFamilia){
		this.nome = nome;
		this.cpf = cpf;
		this.nivel = nivel;
		this.remuneracao = remuneracao;
		this.bFamilia = bFamilia;
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
