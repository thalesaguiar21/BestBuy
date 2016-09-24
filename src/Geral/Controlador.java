package Geral;

import db.mannager.DBManager;
import db.mannager.PostgreSQLJDBC;;

public class Controlador {
	public static void main(String[] args)
    {
		DBManager db = new PostgreSQLJDBC();
		db.openConnection();
		db.update("INSERT INTO BolsaFamilia VALUES (1, 'Ritinha', '123456');");
		db.closeConnection();
        /*Minerador minerador = new Minerador();
        minerador.minerar(new PicaretaDeNiveis());*/
    }
}
