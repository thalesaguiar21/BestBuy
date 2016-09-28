package WebCrawler;


public class FabricaDePicaretas {
	
	public static Picareta criarPicareta(int type){
		switch (type) {
		case 1:
			return new PicaretaDeBFamilia();
		case 2:
			return new PicaretaDeServidor();
		case 3:
			return new PicaretaDeNiveis();
		default:
			System.out.println("N�o existe uma Picareta para o numero " + type);
			return null;
		}
	}
}
