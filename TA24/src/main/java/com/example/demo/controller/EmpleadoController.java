package com.example.demo.controller;

import java.util.List;
import com.example.demo.dto.Empleado;
import com.example.demo.service.EmpleadoServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmpleadoController {

	@Autowired
	EmpleadoServiceImpl empleadoServiceImpl;
	
	//listar todos los empleados
	@GetMapping("/empleados")
	public List<Empleado> listarEmpleados(){
		return empleadoServiceImpl.listarEmpleados();
	}
	
	//listar empelados por campo trabajo
	@GetMapping("empleados/trabajo/{trabajo}")
	public List<Empleado> listarEmpleadoTrabajo(@PathVariable(name="trabajo") String trabajo){
		return empleadoServiceImpl.listarEmpleadoTrabajo(trabajo);
	}
	
	//guardar un empleado
	@PostMapping("/empleados")
	public Empleado salvarEmpleado(@RequestBody Empleado empleado) {//los datos del empleado llegan en formato JSON desde el Request Body
		return empleadoServiceImpl.guardarEmpleado(empleado);
	}
	
	//muestro un empleado según el ID indicada
	@GetMapping("/empleados/{id}") 
	public Empleado empleadoXID(@PathVariable(name="id") Long id){ // el id del empleado llega desde la variable del path
		Empleado empleado_xid = new Empleado();//creo una instancia de la clase empleado
		
		empleado_xid=empleadoServiceImpl.empleadoXID(id);//busco el empleado según el ID y le asigno los datos a la instancia de la clase empleado
		
		System.out.println("Empleado XID: "+empleado_xid);
		
		return empleado_xid;//devuelvo el empleado en formato JSON
	}
	
	//Actualizo los datos de un empleado según el ID indicada
	@PutMapping("/empleados/{id}")
	public Empleado actualizarEmpleado(@PathVariable(name="id")Long id,@RequestBody Empleado empleado) {
		
		Empleado empleado_seleccionado= new Empleado();
		Empleado empleado_actualizado= new Empleado();
		
		empleado_seleccionado= empleadoServiceImpl.empleadoXID(id);
		
		empleado_seleccionado.setNombre(empleado.getNombre());
		empleado_seleccionado.setApellido(empleado.getApellido());
		empleado_seleccionado.setDireccion(empleado.getDireccion());
		empleado_seleccionado.setDni(empleado.getDni());
		empleado_seleccionado.setFecha(empleado.getFecha());
		empleado_seleccionado.setTrabajo(empleado.getTrabajo());
		empleado_seleccionado.setSalario(empleado.getTrabajo());
		
		empleado_actualizado = empleadoServiceImpl.actualizarEmpleado(empleado_seleccionado);
		
		System.out.println("El empleado actualizado es: "+ empleado_actualizado);
		
		return empleado_actualizado;
	}
	
	//borro el empleado indicado por el ID que llega en la variable del path
	@DeleteMapping("/empleados/{id}")
	public void eleiminarEmpleado(@PathVariable(name="id")Long id) {
		empleadoServiceImpl.eliminarEmpleado(id);
	}
}
