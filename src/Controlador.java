
public class Controlador {
	
	// Para PicaretaDeNiveis -> "Remuneração básica bruta"

	public static void main(String[] args)
    {
        Minerador minerador = new Minerador();
        minerador.minerar("RITA", new PicaretaDeBFamilia());
    }
}
