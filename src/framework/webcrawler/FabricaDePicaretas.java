package framework.webcrawler;

public class FabricaDePicaretas {
	
	public static Picareta criarPicareta(EnumPicaretas type){
		switch (type) {
		case PROD:
			return null;
		case SELLER:
			return null;
		default:
			System.out.println("Não existe uma Picareta para o numero " + type);
			return null;
		}
	}
}
