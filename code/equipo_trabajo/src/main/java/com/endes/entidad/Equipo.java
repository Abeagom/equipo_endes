package com.endes.entidad;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa un equipo de trabajo compuesto por personal.
 */
public class Equipo {
    private List<Personal> miembros;

    /**
     * Constructor que inicializa la lista de miembros.
     */
    public Equipo() {
        this.miembros = new ArrayList<>();
    }

    /**
     * Añade un nuevo miembro al equipo.
     *
     * @param p El objeto Personal a añadir
     */
    public void añadirMiembro(Personal p) {
        if (p == null) {
            throw new IllegalArgumentException("El miembro no puede ser nulo.");
        }
        if(miembros.contains(p)) {
    		throw new IllegalArgumentException("El miembro ya existe");
        }
        for(Personal persona: miembros) {
        	if(persona.getDni().equalsIgnoreCase(p.getDni())) {
        		throw new IllegalArgumentException("El dni no puede estar duplicado.");
        	}
        }
        miembros.add(p);
    }

    /**
     * Devuelve la lista de productividades de todos los miembros del equipo.
     *
     * @return Lista de productividades
     */
    public List<Double> listarProductividades() {
        List<Double> productividades = new ArrayList<>();
        for (Personal p : miembros) {
            productividades.add(p.calcularProductividad());
        }
        return productividades;
    }

    public List<Personal> getMiembros() {
        return miembros;
    }
}
