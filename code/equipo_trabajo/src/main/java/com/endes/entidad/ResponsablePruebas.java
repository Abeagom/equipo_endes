package com.endes.entidad;
/**
 * Clase ResponsablePruebas
 */

public class ResponsablePruebas extends Personal {
    private int bugsDetectados;

    /**
     * Crea un objeto ResponsablePruebas
     * @param dni El dni
     * @param nombre EL nombre
     * @param sueldoBase EL sueldo base
     * @param bugsDetectados Los bugs detectados
     */
    public ResponsablePruebas(String dni, String nombre, double sueldoBase, int bugsDetectados) {
        super(dni, nombre, sueldoBase);
        setBugsDetectados(bugsDetectados);
    }
    
    /**
     * Obtiene los bugs detectados
     * @return El número de bugs
     */
    public int getBugsDetectados() {
        return bugsDetectados;
    }

    /**
     * Establece los bugs
     * @param bugsDetectados nuevos bugs detectados
     */
    public void setBugsDetectados(int bugsDetectados) {
        if (bugsDetectados < 0) {
            throw new IllegalArgumentException("El número de bugs detectados no puede ser negativo.");
        }
        this.bugsDetectados = bugsDetectados;
    }
   
    /**
     * Calcula la productividad
     */
    @Override
    public double calcularProductividad() {
        return getSueldoBase() * (1 + 0.02 * bugsDetectados);
    }
}
