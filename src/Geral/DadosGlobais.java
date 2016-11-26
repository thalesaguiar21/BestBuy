package Geral;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.mannager.DBManager;
import db.mannager.PostgreSQLJDBC;
import db.mannager.ServidorPublico;
import matchers.EnumMatchers;
import matchers.FabricaDeMatchers;
import matchers.Matcher;
import webcrawler.Minerador;

/**
 * Classe Singleton para armazenar informa��es necess�rias a todo o sistema,
 * garantindo assim que os dados acessados por uma classe A ser�o os mesmos
 * acessados pela classe B. 
 * @author Geovanni, Rafael, Thales 
 *
 */
public final class DadosGlobais {
	
	private static DadosGlobais dadosSis;
	private Map<Integer, ArrayList<Float>> remPorNivel;
	private List<ServidorPublico> ServidoresPublicos;
	private Minerador miner;
	private Matcher matcher;
	private DBManager myDb;
	

	private DadosGlobais(){
		this.remPorNivel        = new HashMap<Integer, ArrayList<Float>>();
		this.ServidoresPublicos = new ArrayList<ServidorPublico>();
		this.miner              = new Minerador();
		this.matcher            = null;
		this.myDb               = new PostgreSQLJDBC();
	}
	
	public static DadosGlobais getDados(){
		if(dadosSis == null){
			dadosSis = new DadosGlobais();
		}
		return dadosSis;
	}
	
	public Map<Integer, ArrayList<Float>> getRemPorNivel(){
		return this.remPorNivel;
	}
	
	public void setRemPorNivel(Map<Integer, ArrayList<Float>> remPorNivel){
		this.remPorNivel = remPorNivel;
	}
	
	public List<ServidorPublico> getServidoresPublicos(){
		return this.ServidoresPublicos;
	}
	
	public void setServidoresPublicos(List<ServidorPublico> ServidoresPublicos){
		this.ServidoresPublicos = ServidoresPublicos;
	}
	
	public Minerador getMiner(){
		return this.miner;
	}
	
	public Matcher getMatcher(){
		return this.matcher;
	}
	
	public void setMatcher(EnumMatchers type){
		this.matcher = FabricaDeMatchers.criarMatcher(type);
	}
	
	public DBManager getMyDb() {
		return myDb;
	}
	
	public void setMyDb(DBManager myDb) {
		this.myDb = myDb;
	}
}