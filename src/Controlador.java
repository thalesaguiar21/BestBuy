
public class Controlador {
	
	// Para PicaretaDeNiveis -> "Remunera��o b�sica bruta"
	// Para PicaretaDeBFamilia -> "Total�no�Ano�(R$) " **Com o espa�o mesmo

	public static void main(String[] args)
    {
        Minerador minerador = new Minerador();
        minerador.minerar(new PicaretaDeBFamilia());
    }
}
