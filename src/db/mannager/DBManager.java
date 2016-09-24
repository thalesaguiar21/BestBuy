package db.mannager;
import java.sql.*;

public abstract class DBManager {
	
	protected static String JDBC_DRIVER;
	protected static String DB_URL;
	protected static String adm_user;
	protected static String adm_paswd;
	protected Connection connection;
	
	abstract void openConnection();
	
	abstract void closeConnection();
	
	abstract void insert();
	
	abstract void select();
	
	abstract void update();
}
