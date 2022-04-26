package dao;

import java.util.List;

public interface DAO<T> {
	
	public void insertar(T t);
	public List<T> listar();
	
	// Parametrizo en T
	// Aca puedo hacer el crud
}
