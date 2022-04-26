package dao;

import java.util.List;

import clases.Persona;

public interface DAOPersona {
	
	public void registrar(Persona p);
	public List<Persona> listar();
	public void conectar();
	public void desconectar();
	
	// Hacer un DAO por cada entidad que me interese modelar
	// Por cada tecnologia de almacenamiento tengo que tener una fabrica especifica
}
