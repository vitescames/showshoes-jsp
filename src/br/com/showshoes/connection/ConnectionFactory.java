package br.com.showshoes.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static Connection connection = null;
	
	private ConnectionFactory() {}
	
	public static Connection conectar() throws ClassNotFoundException, SQLException {
		
		if(connection == null) {		
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/showshoes", "root", "iamarock");	    
		}
		
		return connection;
	}

}
