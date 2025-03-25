package com.endes.entidad;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EquipoTest {

    private Equipo equipo;

    @BeforeEach
    void setUp() throws Exception {
        equipo = new Equipo();
    }

    @Test
    @DisplayName("Añadir un miembro con DNI único no lanza excepción; el duplicado sí")
    void testAñadirMiembroDuplicado() {
        Personal dev1 = new Desarrollador("123A", "Ana", 1000.0, "Java");
        Personal devDuplicado = new Desarrollador("123A", "OtroNombre", 1100.0, "Python");

        // Primer miembro → no debe lanzar excepción
        assertDoesNotThrow(() -> equipo.añadirMiembro(dev1),
            "No debería lanzarse excepción al añadir un miembro único");

        // Segundo miembro con mismo DNI → debe lanzar excepción
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> equipo.añadirMiembro(devDuplicado),
            "Se esperaba una excepción por DNI duplicado"
        );

    }
    
    
    /**
     * Debes implementar esta prueba para verificar que se puede
     * añadir un miembro correctamente a la lista del equipo.
     *
     * Sugerencias:
     * - Crea un objeto Desarrollador (u otro tipo de Personal).
     * - Añádelo con añadirMiembro().
     * - Comprueba que el tamaño de la lista es 1.
     * - Verifica que el miembro añadido es el esperado.
     */

    @Test
    @DisplayName("Añadir un miembro válido al equipo")
    void testAñadirMiembroValido() {
        Desarrollador d = new Desarrollador ("11111111H", "Juan", 1000.00, "Java");
        equipo.añadirMiembro(d);
        int resultadoEsperado=1;
        assertEquals(resultadoEsperado, equipo.getMiembros().size(), "El tamaño no es el esperado");
    }


    /**
     * Debes implementar esta prueba para verificar que el método
     * listarProductividades() devuelve los valores correctos.
     *
     * Sugerencias:
     * - Añade al menos dos miembros con sueldos conocidos.
     * - Usa un lenguaje como "Java" para que el bonus sea del 10%.
     * - Comprueba que la lista tiene el tamaño correcto.
     * - Verifica que los valores de productividad son los esperados.
     */

    @Test
    @DisplayName("Listar las productividades del equipo")
    void testListarProductividades() {
        Desarrollador d = new Desarrollador ("11111111H", "Juan", 1000.00, "Java");
        ResponsablePruebas r = new ResponsablePruebas("11111112H", "Pepe", 1000.00, 50);
        equipo.añadirMiembro(d);
        equipo.añadirMiembro(r);
        
        List<Double> productividades = equipo.listarProductividades();
        
        //Comprobar el tamaño de la lista
        int tamañoEsperado = 2;
        assertEquals(tamañoEsperado, productividades.size(), "Los tamaños no coinciden");
        
        //Comprobar la productividad del Desarrollador
        double productividadDesarrollador = 1100.00;
        assertEquals(productividadDesarrollador, productividades.get(0), "La productividad no coincide");
        
        //Comprobar la productividad del ResponsablePruebas
        double productividadResponsablePruebas = 2000.00;
        assertEquals(productividadResponsablePruebas, productividades.get(1), "La productividad no coincide");
    }

    /**
     * Verifica que un equipo nuevo se inicializa con la lista de miembros vacía.
     */
    @Test
    @DisplayName("El equipo debe comenzar con la lista de miembros vacía")
    void testEquipoInicialVacio() {
        assertNotNull(equipo.getMiembros(), "La lista de miembros no debe ser null");
        assertEquals(0, equipo.getMiembros().size(), "El equipo debe comenzar vacío");
    }

    /**
     * Verifica que no se puede añadir un miembro null al equipo.
     * Debe lanzarse IllegalArgumentException con el mensaje adecuado.
     */
    
    @Test
    @DisplayName("No se permite añadir un miembro null al equipo")
    void testAñadirMiembroNull() {
          String resultadoEsperado="El miembro no puede ser nulo.";
  		  Exception exception = assertThrows(IllegalArgumentException.class, () -> equipo.añadirMiembro(null), "");
          assertEquals(resultadoEsperado, exception.getMessage(), "El método permite añadir un miembro null");
    }
}
