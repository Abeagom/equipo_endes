package com.endes.entidad;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DesarrolladorTest {
	
	Desarrollador d;
	
	@BeforeEach
	void setUp() throws Exception {
		d = new Desarrollador("11111111H", "Juan", 1000.00, "Java");
	}

	@Test
	@DisplayName("Test del método getDNI")
	void testGetDNI() {
		String resutadoEsperado="11111111H";
		assertEquals(resutadoEsperado, d.getDni(),  "Los DNIs no coinciden");
	}
	
	@Test
	@DisplayName("Test del método getNombre")
	void testGetNombre() {
		String resutadoEsperado="Juan";
		assertEquals(resutadoEsperado, d.getNombre(),  "Los nombres no coinciden");
	}
	
	@Test
	@DisplayName("Test del método getSueldoBase")
	void testGetSueldoBase() {
		double resutadoEsperado=1000.00;
		assertEquals(resutadoEsperado, d.getSueldoBase(),  "Los sueldos no coinciden");
	}
	
	@Test
	@DisplayName("Test del método setSueldoBase")
	void testSetSueldoBase() {
		double resutadoEsperado=1500.00;
		d.setSueldoBase(1500);
		assertEquals(resutadoEsperado, d.getSueldoBase(),  "Los sueldos no coinciden");
	}
	
	@Test
	@DisplayName("Test del método getLenguajePrincipal")
	void testGetLenguajePrincipal() {
		String resutadoEsperado="Java";
		assertEquals(resutadoEsperado, d.getLenguajePrincipal(),  "El lenguaje principal no coincide");
	}
	
	@Test
	@DisplayName("Test del método calcularProductividad")
	void testCalcularProductividad() {
		
		//Prueba con Java
		double resutadoEsperado=1100;
		assertEquals(resutadoEsperado, d.calcularProductividad(),  "No coinciden");
		
		//Cambiamos el lenguaje a C++
		d.setLenguajePrincipal("C++");
		
		//Prueba con C++
		resutadoEsperado=1000;
		assertEquals(resutadoEsperado, d.calcularProductividad(),  "No coinciden");
	}

}