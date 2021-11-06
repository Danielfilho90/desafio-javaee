package br.com.datainfo.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnectionLocal {

	private static String banco = "jdbc:postgresql://localhost:5432/pitang?autoReconnect=true";
	private static String password = "1410";
	private static String user = "";
	private static Connection connection = null;
	
	static {
		conectar();
	}
	
	public SingleConnectionLocal() {
		conectar();
	}
	
	private static void conectar() {
		try {
			
			if(connection == null) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(banco, user, password);
				connection.setAutoCommit(false); // N�o salva automaticamento os dados no banco.				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}
	
}
