
public class Controlador {

	public static void main(String[] args)
    {
        Minerador minerador = new Minerador();
        minerador.minerar("http://www.portaldatransparencia.gov.br/servidores/OrgaoLotacao-ListaServidores.asp?CodOrg=26243&Pagina=1", "Remuneração básica bruta", new PicaretaDeNiveis());
    }
}
