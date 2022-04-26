package seba.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity		// Decimos que Persona es una entidad
public class Persona {
	@Id		// Decimos que esta variable es el id de la entidad
	private int id;
	@Column(nullable=false)		// Decimos que esta variable es una columna de la entidad
	private String nombre;
	@Column(name="anios")	// Esto se hace para que en la bd esta columna se llame anios y no edad
	private int edad;
	@ManyToOne		// Muchas personas pueden vivir en un domicilio
	private Direccion domicilio;
	
	public Persona(int id, String nombre, int edad, Direccion domicilio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.domicilio = domicilio;
	}

	public Persona() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Direccion getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Direccion domicilio) {
		this.domicilio = domicilio;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", domicilio=" + domicilio + "]";
	}
	
	
}
