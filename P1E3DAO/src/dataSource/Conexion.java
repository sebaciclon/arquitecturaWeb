package dataSource;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	protected Connection conn;
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String URI = "jdbc:mysql://localhost:3306/exampledb";
	private final String USER = "root";
	private final String PASS = "";
	
	public void conectar() {
		try {
			Class.forName(DRIVER).getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e1) {
			e1.printStackTrace();
			System.exit(1);
		}
		
		try {
			conn = DriverManager.getConnection(URI, USER, PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void desconectar() {
		if(conn != null) {
			try {
				if(!conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
