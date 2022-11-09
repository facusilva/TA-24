package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Empleado;

public interface IEmpleadoDAO extends JpaRepository<Empleado, Long>{
	
	//Listar empleados por campo trabajo
	public List<Empleado> findByTrabajo(String trabajo);
	
}
