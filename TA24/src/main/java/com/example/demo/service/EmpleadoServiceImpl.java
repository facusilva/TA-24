package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IEmpleadoDAO;
import com.example.demo.dto.Empleado;
import com.example.demo.dto.Trabajos;

@Service 
public class EmpleadoServiceImpl implements IEmpleadoService{

	@Autowired
	IEmpleadoDAO iEmpeladoDAO;
	
	@Override
	public List<Empleado> listarEmpleados() {
		// TODO Auto-generated method stub
		return iEmpeladoDAO.findAll();
	}

	@Override
	public Empleado guardarEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub
		String trabajo = empleado.getTrabajo();
		if(Trabajos.valueOf(trabajo).toString() != "") {//compruebo que el trabajo recibido forme parte del enumerable
			empleado.setSalario(trabajo);//le paso al método setsalario el trabajo del empleado para que le asigne un salario en función de este
			return iEmpeladoDAO.save(empleado); //guardo el nuevo empleado
		}else {
			return empleado;
		}
		
	}

	@Override
	public Empleado empleadoXID(Long id) {
		// TODO Auto-generated method stub
		return iEmpeladoDAO.findById(id).get();
	}

	@Override
	public List<Empleado> listarEmpleadoTrabajo(String trabajo) {
		// TODO Auto-generated method stub
		return iEmpeladoDAO.findByTrabajo(trabajo);
	}

	@Override
	public Empleado actualizarEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub
		return iEmpeladoDAO.save(empleado);
	}

	@Override
	public void eliminarEmpleado(Long id) {
		iEmpeladoDAO.deleteById(id);
		
	}

}
