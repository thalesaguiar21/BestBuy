
public class Controlador {
	
	// Para PicaretaDeNiveis -> "Remuneração básica bruta"
	// Para PicaretaDeBFamilia -> "Total no Ano (R$) " **Com o espaço mesmo

	public static void main(String[] args)
    {
        Minerador minerador = new Minerador();
        minerador.minerar(new PicaretaDeBFamilia());
    }
}
