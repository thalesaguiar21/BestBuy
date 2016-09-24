package db.mannager;

/**
 * Classe criada para representar dentro do projeto a tabela de BolsaFamilia,
 * a qual armazena os nomes e cpfs dos beneficiados.
 * @author Thales
 *
 */
public class BolsaFamilia {
	
	private String nome;
	private String cpf;
	
	public BolsaFamilia(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
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

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
