import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Classe Singleton para armazenar informações necessárias a todo o sistema,
 * garantindo assim que os dados acessados por uma classe A serão os mesmos
 * acessados pela classe B. 
 * @author Geovanni, Rafael, Thales 
 *
 */
public final class DadosDoSistema {
	
	private static final DadosDoSistema dadosSis = new DadosDoSistema();
	private Map<Integer, ArrayList<Float>> remPorNivel;
	private List<ServidorPublico> ServidorPublicoes;
	
	
	private DadosDoSistema(){
		this.remPorNivel = new HashMap<Integer, ArrayList<Float>>();
		this.ServidorPublicoes = new ArrayList<ServidorPublico>();
	}
	
	public static DadosDoSistema getDados(){
		return dadosSis;
	}
	
	public Map<Integer, ArrayList<Float>> getRemPorNivel(){
		return this.remPorNivel;
	}
	
	public void setRemPorNivel(Map<Integer, ArrayList<Float>> remPorNivel){
		this.remPorNivel = remPorNivel;
	}
	
	public List<ServidorPublico> getServidorPublicoes(){
		return this.ServidorPublicoes;
	}
	
	public void setServidorPublicoes(List<ServidorPublico> ServidorPublicoes){
		this.ServidorPublicoes = ServidorPublicoes;
	}
}
