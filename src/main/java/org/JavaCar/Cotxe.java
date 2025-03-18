package org.JavaCar;

/**
 * Classe que representa un cotxe de lloguer.
 */
public class Cotxe extends Vehicle {
    private int nombrePlaces;

    // Constructor
    public Cotxe(String matricula, String marca, String model, double preuBase, int nombrePlaces, Motor motor, Roda[] rodes) {
        super(matricula, marca, model, preuBase, motor, rodes);
        this.nombrePlaces = nombrePlaces;
    }
    public int getNombrePlaces() {
        return nombrePlaces;
    }

    @Override
    public double calcularPreu(int dies) {
        return preuBase * dies;
    }
}