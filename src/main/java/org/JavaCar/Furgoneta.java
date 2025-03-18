package org.JavaCar;

/**
 * Classe que representa una furgoneta de lloguer.
 */
public class Furgoneta extends Vehicle {
    private double capacitatCarga;

    // Constructor
    public Furgoneta(String matricula, String marca, String model, double preuBase, double capacitatCarga, Motor motor, Roda[] rodes) {
        super(matricula, marca, model, preuBase, motor, rodes);
        this.capacitatCarga = capacitatCarga;
    }
