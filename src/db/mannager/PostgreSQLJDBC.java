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
			System.out.println("Já exite uma conexão aberta!");
			return;
		}
		System.out.println("Abrindo conexão com o PostgreSQL...");
		try{
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, adm_user, adm_paswd);
		} catch (Exception e) {
			System.out.println("Deu ruim!");
	        e.printStackTrace();
	        System.err.println(e.getClass().getName()+": "+e.getMessage());
	        System.exit(0);
	    }
	    System.out.println("A conexão foi realizada com sucesso!");
	}

	@Override
	public void closeConnection() {
		if(connection == null){
			System.out.println("Não conexões estabelecidas!");
			return;
		}
		System.out.println("Fechando a conexão com o banco...");
		try {
			connection.close();
		} catch (SQLException e) {
			System.err.println("Não foi possível fechar a conexão!");
			e.printStackTrace();
		}
		System.out.println("Conexão encerrada com sucesso!");
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
