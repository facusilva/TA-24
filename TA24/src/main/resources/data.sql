DROP TABLE IF EXISTS empleado;

CREATE TABLE empleado(
	id INT AUTO_INCREMENT PRIMARY KEY,
	nombre varchar(250),
	apellido varchar(250),
	direccion varchar(250),
	dni INT,
	fecha DATE,
	trabajo varchar(255),
	salario INT
);

INSERT INTO empleado (nombre, apellido, direccion, dni, fecha, trabajo, salario) VALUES ('Pepe', 'Martínez', 'calle falsa 23', 55666777, '2022-09-09', 'soldador', 1200);
INSERT INTO empleado (nombre, apellido, direccion, dni, fecha, trabajo, salario) VALUES ('Juan', 'Gómez', 'calle falsa 72', 44888666, '2022-09-09', 'profesor', 1400);