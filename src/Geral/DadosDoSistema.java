package Geral;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.mannager.DBManager;
import db.mannager.PostgreSQLJDBC;
import db.mannager.ServidorPublico;

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
	private List<ServidorPublico> ServidoresPublicos;
	private DBManager myDb;
	
	
	public DBManager getMyDb() {
		return myDb;
	}

	public void setMyDb(DBManager myDb) {
		this.myDb = myDb;
	}

	private DadosDoSistema(){
		this.remPorNivel = new HashMap<Integer, ArrayList<Float>>();
		this.ServidoresPublicos = new ArrayList<ServidorPublico>();
		this.myDb = new PostgreSQLJDBC();
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
	
	public List<ServidorPublico> getServidoresPublicos(){
		return this.ServidoresPublicos;
	}
	
	public void setServidoresPublicos(List<ServidorPublico> ServidoresPublicos){
		this.ServidoresPublicos = ServidoresPublicos;
	}
}
