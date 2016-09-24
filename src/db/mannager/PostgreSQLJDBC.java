package db.mannager;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostgreSQLJDBC extends DBManager{
	
	public PostgreSQLJDBC() {
		JDBC_DRIVER = "org.postgresql.Driver";
		DB_URL = "jdbc:postgresql://localhost:5432/minerDB";
		adm_user = "postgres";
		adm_paswd = "12122014";
		connection = null;
		stmt = null;
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
			connection.setAutoCommit(false);
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
	public void update(String sql) {
		if(connection != null) openConnection();
		System.out.println("Executando a atualiza��o " + sql + " ...");
		try{
			stmt = connection.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
			connection.commit();
		}catch(Exception e){
			System.err.println("Erro ao executar atualiza��o!");
			e.printStackTrace();
	        System.err.println(e.getClass().getName()+": "+e.getMessage());
	        System.exit(0);
		}
	}

	@Override
	public List<Map<String, Object>> select(String sql) {
		List<Map<String, Object>> resultList = new  ArrayList<Map<String, Object>>();
		Map<String, Object> linha = null;
		
		try{
			if(connection.isClosed()) openConnection();
			stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery(sql);
			
			ResultSetMetaData metaData = result.getMetaData();
		    Integer columnCount = metaData.getColumnCount();
			
		    while (result.next()) {
		        linha = new HashMap<String, Object>();
		        for (int i = 1; i <= columnCount; i++) {
		        	linha.put(metaData.getColumnName(i), result.getObject(i));
		        }
		        resultList.add(linha);
		    }
			stmt.close();
		}catch(Exception e){
			System.err.println("Erro ao executar inser��o!");
			e.printStackTrace();
	        System.err.println(e.getClass().getName()+": "+e.getMessage());
	        System.exit(0);
		}finally{
			closeConnection();
		}
		return resultList;
	}

}