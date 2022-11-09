package com.example.demo.dto;

import java.util.Date;

import javax.persistence.*;

import com.example.demo.dto.Trabajos;

@Entity
@Table(name="empleado")
public class Empleado {

	//atributos de entidad
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String apellido;
	private String direccion;
	private int dni;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	private String trabajo;
	private int salario;
	
	//Constructores
	public Empleado() {

	}

	public Empleado(Long id, String nombre, String apellido, String direccion, int dni, Date fecha, String trabajo, int salario) {
		//super();
		System.out.println("construcotr con valores");
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.dni = dni;
		this.fecha = fecha;
		this.trabajo = Trabajos.valueOf(trabajo).toString();
		this.salario = salario;
	}

	//getters y setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(String trabajo) {
		this.trabajo = Trabajos.valueOf(trabajo).toString();//compruebo que el trabajo seteado forme parte del enum Trabajos
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(String trabajo) {
		//asigno el salario en función del trabajo que tiene el empleado
		switch(trabajo) {
		case "programador":
			this.salario = 1200;
			break;
		case "astronauta":
			this.salario = 1300;
			break;
		case "soldador":
			this.salario = 1100;
			break;
		case "profesor":
			this.salario = 1250;
			break;
		}
		
	}

	//Método de impresión de datos por consola
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion
				+ ", dni=" + dni + ", fecha=" + fecha + ", trabajo=" + trabajo + ", salario=" + salario + "]";
	}

	
	
	
	
	
	
}
