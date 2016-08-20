import java.util.List;
/**
 * Classe Singleton para armazenar informações necessárias a todo o sistema,
 * garantindo assim que os dados acessados por uma classe A serão os mesmos
 * acessados pela classe B. 
 * @author Geovanni, Rafael, Thales 
 *
 */
public final class DadosDoSistema {
	
	private static final DadosDoSistema dadosSis = new DadosDoSistema();
	private List<List<Integer>> remPorNivel;
	private List<ServidorPublico> ServidorPublicoes;
	
	
	private DadosDoSistema(){
		this.remPorNivel = null;
		this.ServidorPublicoes = null;
	}
	
	public static DadosDoSistema getDados(){
		return dadosSis;
	}
	
	public List<List<Integer>> getRemPorNivel(){
		return this.remPorNivel;
	}
	
	public void setRemPorNivel(List<List<Integer>> remPorNivel){
		this.remPorNivel = remPorNivel;
	}
	
	public List<ServidorPublico> getServidorPublicoes(){
		return this.ServidorPublicoes;
	}
	
	public void setServidorPublicoes(List<ServidorPublico> ServidorPublicoes){
		this.ServidorPublicoes = ServidorPublicoes;
	}
}
