package dataSource;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import clases.Persona;
import dao.DAOPersona;

public class DAOPersonaMysqlImpl implements DAOPersona{
	
	protected Connection conn;
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String URI = "jdbc:mysql://localhost:3306/exampledb";
	private final String USER = "root";
	private final String PASS = "";
	
	@Override
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
	
	@Override
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

	@Override
	public void registrar(Persona p) {
		conectar();
		String insert = "INSERT INTO persona (id, nombre, edad) VALUES (?, ?, ?)"; 
		try {
			PreparedStatement ps = conn.prepareStatement(insert);
			ps.setInt(1, p.getId());
			ps.setString(2, p.getNombre());
			ps.setInt(3, p.getEdad());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		desconectar();
	}


	@Override
	public List<Persona> listar() {
		List<Persona> salida = new ArrayList<Persona>();
		String select = "SELECT * FROM persona";
		
		conectar();
		try {
			PreparedStatement ps = this.conn.prepareStatement(select);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Persona per = new Persona();
				per.setId(rs.getInt("id"));
				per.setNombre(rs.getString("nombre"));
				per.setEdad(rs.getInt("edad"));
				salida.add(per);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		desconectar();
		return salida;
	}
	
}
