package verificadores;

public class FabricaDeVerificadores {
	
	public static Verificador criarVerificador(EnumVerificadores type){
		switch (type) {
		case V_B_FAMILIA:
			return new VerificadorDeBFamilia();
		case V_NIVEIS:
			return new VerificadorDeNiveis();
		default:
			System.out.println("N�o existe um verificador para o numero " + type);
			return null;
		}
	}

}