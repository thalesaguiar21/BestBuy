package db.mannager;
import java.sql.*;

public abstract class DBManager {
	
	protected static String JDBC_DRIVER;
	protected static String DB_URL;
	protected static String adm_user;
	protected static String adm_paswd;
	protected Connection connection;
	
	public abstract void openConnection();
	
	public abstract void closeConnection();
	
	public abstract void insert();
	
	public abstract void select();
	
	public abstract void update();
}
