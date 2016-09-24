package db.mannager;
import java.sql.*;

public class PostgreSQLJDBC extends DBManager{
	
	public PostgreSQLJDBC() {
		JDBC_DRIVER = "org.postgresql.Driver";
		DB_URL = "jdbc:postgresql://localhost:5432/minerDB";
		adm_user = "postgres";
		adm_paswd = "12122014";
		connection = null;
	}

	@Override
	public void openConnection() {
		if(connection != null){
			System.out.println("J� exite uma conex�o aberta!");
			return;
		}
		System.out.println("Abrindo conex�o com o PostgreSQL...");
		try{
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, adm_user, adm_paswd);
		} catch (Exception e) {
			System.out.println("Deu ruim!");
	        e.printStackTrace();
	        System.err.println(e.getClass().getName()+": "+e.getMessage());
	        System.exit(0);
	    }
	    System.out.println("A conex�o foi realizada com sucesso!");
	}

	@Override
	public void closeConnection() {
		if(connection == null){
			System.out.println("N�o conex�es estabelecidas!");
			return;
		}
		System.out.println("Fechando a conex�o com o banco...");
		try {
			connection.close();
		} catch (SQLException e) {
			System.err.println("N�o foi poss�vel fechar a conex�o!");
			e.printStackTrace();
		}
		System.out.println("Conex�o encerrada com sucesso!");
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void select() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
