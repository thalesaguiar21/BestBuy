
public class Controlador {
	
	// Para PicaretaDeNiveis -> "Remunera��o b�sica bruta"

	public static void main(String[] args)
    {
        Minerador minerador = new Minerador();
        minerador.minerar("RITA", new PicaretaDeBFamilia());
    }
}
