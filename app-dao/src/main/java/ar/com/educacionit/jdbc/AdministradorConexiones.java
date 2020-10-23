package ar.com.educacionit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AdministradorConexiones {

	public static Connection obtenerConexion() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		String driver="com.mysql.cj.jdbc.driver";
		
		String dbConnectionString="jdbc:mysql://localhost:3306/jsweb-septiembre?serverTimezone=UTC";
		
		String username = "root";
		
		String password = "";
		
		Class.forName(driver).newInstance();
		
		Connection con= DriverManager.getConnection(dbConnectionString, username, password);
		
		return con;
	}
	
	
	
}
