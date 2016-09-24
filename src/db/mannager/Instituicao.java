package db.mannager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * Classe criada para representar as intituicoes p�blicas dentro do projeto,
 * al�m disso, representa tamb�m a tabela de mesmo nome no banco de dados. 
 * Possui um nome, um HashMap de remunera��es e uma lista de servidores.
 *
 * @author Thales
 *
 */
public class Instituicao {
	
	private String nome;
	private Map<Integer, Double> remuneracoes;	// Representa��o da tabela Remunera��es
	private List<ServidorPublico> servidores;
	
	/**
	 * Inicializa uma nova institui��o com um atributos sem elementos.
	 */
	public Instituicao() {
		this.remuneracoes = new HashMap<Integer, Double>();
		this.servidores = new ArrayList<ServidorPublico>();
	}
	
	/**
	 * Adiciona um novo servidor ao final de 'servidores'.
	 * 
	 * @param servidor
	 */
	public void addServidor(ServidorPublico servidor){
		if(servidor != null){
			this.servidores.add(servidor);
		}else
			System.out.println("Servidor null!");
	}
	
	/**
	 * Adiciona uma lista de servidores ao final de 'servidores'.
	 * @param servidores
	 */
	public void addServidores(ArrayList<ServidorPublico> servidores){
		if(servidores != null){
			this.servidores.addAll(servidores);
		}else
			System.out.println("N�o foi poss�vell adicionar, lista de servidores vazia!");
	}
	
	/**
	 * Adiona uma nova remunera��o de n�vel 'nivel' e remunera��o 'rem'.
	 * @param nivel
	 * @param rem
	 */
	public void addRemuneracao(int nivel, double rem){
		if(nivel < 0 || rem < 0){
			System.out.println("Erro! O n�vel e a remunera��o devem ser positivos!");
		}else{
			this.remuneracoes.put(nivel, rem);
		}	
	}
	
	/**
	 * Adiciona os elementos da entrada ao final de 'remuneracoes'
	 * na ordem em que forem dados.
	 * @param remuneracoes
	 */
	public void addRemuneracoes(HashMap<Integer, Double> remuneracoes){
		Set<Integer> keys = remuneracoes.keySet();
		for(Integer key : keys){
			addRemuneracao(key.intValue(),  remuneracoes.get(key).doubleValue());
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Map<Integer, Double> getRemuneracoes() {
		return remuneracoes;
	}

	public void setRemuneracoes(Map<Integer, Double> remuneracoes) {
		this.remuneracoes = remuneracoes;
	}

	public List<ServidorPublico> getServidores() {
		return servidores;
	}

	public void setServidores(List<ServidorPublico> servidores) {
		this.servidores = servidores;
	}
}
