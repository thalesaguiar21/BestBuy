package verificadores;

public class FabricaDeVerificadores {
	
	public static Verificador criarVerificador(int type){
		switch (type) {
		case 1:
			return new VerificadorDeBFamilia();
		case 2:
			return new VerificadorDeNiveis();
		default:
			System.out.println("Não existe um verificador para o numero " + type);
			return null;
		}
	}

}
