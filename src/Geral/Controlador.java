package Geral;
import db.mannager.DBManager;
import db.mannager.PostgreSQLJDBC;;

public class Controlador {
	public static void main(String[] args)
    {
		DBManager db = new PostgreSQLJDBC();
		db.openConnection();
		db.closeConnection();
        /*Minerador minerador = new Minerador();
        minerador.minerar(new PicaretaDeNiveis());*/
    }
}
