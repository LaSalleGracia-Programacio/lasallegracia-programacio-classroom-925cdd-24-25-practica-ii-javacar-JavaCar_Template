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
    public double getCapacitatCarga() {
        return capacitatCarga;
    }

    @Override
    public double calcularPreu(int dies) {
        double preuTotal = preuBase * dies;
        if (capacitatCarga >= 1000) {
            preuTotal += 10 * dies; // Afegir un suplement de 10 € per dia si la càrrega >= 1000 kg
        }
        return preuTotal;
    }
}
