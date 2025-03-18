package org.JavaCar;

/**
 * Classe abstracta que representa un vehicle de lloguer.
 */
public abstract class Vehicle implements Lloguer {

    // Atributs (protected per accés des de subclasses)
    protected String matricula;
    protected String marca;
    protected String model;
    protected double preuBase;
    protected Motor motor;
    protected int roda; // Diàmetre de les rodes (totes iguals).
    protected EtiquetaAmbiental etiquetaAmbiental;

    // Constructor
    public Vehicle(String matricula, String marca, String model, double preuBase, Motor motor, Roda[] rodes) {
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.preuBase = preuBase;
        this.motor = motor; // Accepta null
        this.rodes = rodes; // Accepta null
        this.etiquetaAmbiental = calcularEtiqueta();
    }
}
