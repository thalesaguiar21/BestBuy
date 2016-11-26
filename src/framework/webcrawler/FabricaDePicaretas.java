package framework.webcrawler;

import webcrawler.PicaretaDeBFamilia;
import webcrawler.PicaretaDeNiveis;
import webcrawler.PicaretaDeServidor;

public class FabricaDePicaretas {
	
	public static Picareta criarPicareta(EnumPicaretas type){
		switch (type) {
		case B_FAMILIA:
			return new PicaretaDeBFamilia();
		case SERVIDOR:
			return new PicaretaDeServidor();
		case NIVEIS:
			return new PicaretaDeNiveis();
		default:
			System.out.println("Não existe uma Picareta para o numero " + type);
			return null;
		}
	}
}
