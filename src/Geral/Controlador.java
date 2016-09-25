package Geral;

import db.mannager.DBManager;
import db.mannager.PostgreSQLJDBC;

public class Controlador {
	public static void main(String[] args)
    {
        Minerador minerador = new Minerador();
        minerador.minerar(new PicaretaDeServidor());
    }
}
