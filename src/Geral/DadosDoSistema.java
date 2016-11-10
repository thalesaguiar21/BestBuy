package Geral;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.mannager.DBManager;
import db.mannager.PostgreSQLJDBC;
import db.mannager.ServidorPublico;
import verificadores.EnumVerificadores;
import verificadores.FabricaDeVerificadores;
import verificadores.Verificador;
import webCrawler.Minerador;

/**
 * Classe Singleton para armazenar informações necessárias a todo o sistema,
 * garantindo assim que os dados acessados por uma classe A serão os mesmos
 * acessados pela classe B. 
 * @author Geovanni, Rafael, Thales 
 *
 */
public final class DadosDoSistema {
	
	private static DadosDoSistema dadosSis;
	private Map<Integer, ArrayList<Float>> remPorNivel;
	private List<ServidorPublico> ServidoresPublicos;
	private Minerador miner;
	private Verificador verif;
	private DBManager myDb;
	

	private DadosDoSistema(){
		this.remPorNivel = new HashMap<Integer, ArrayList<Float>>();
		this.ServidoresPublicos = new ArrayList<ServidorPublico>();
		this.miner = new Minerador();
		this.verif = null;
		this.myDb = new PostgreSQLJDBC();
	}
	
	public static DadosDoSistema getDados(){
		if(dadosSis == null){
			dadosSis = new DadosDoSistema();
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
	
	public Verificador getVerif(){
		return this.verif;
	}
	
	public void setVerif(EnumVerificadores type){
		this.verif = FabricaDeVerificadores.criarVerificador(type);
	}
	
	public DBManager getMyDb() {
		return myDb;
	}
	
	public void setMyDb(DBManager myDb) {
		this.myDb = myDb;
	}
}
