import java.util.List;

public final class DadosDoSistema {
	
	private static final DadosDoSistema dadosSis = new DadosDoSistema();
	private List<List<Integer>> remPorNivel;
	private List<Servidor> servidores;
	
	private DadosDoSistema(){
		this.remPorNivel = null;
		this.servidores = null;
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
	
	public List<Servidor> getServidores(){
		return this.servidores;
	}
	
	public void setServidores(List<Servidor> servidores){
		this.servidores = servidores;
	}
}
