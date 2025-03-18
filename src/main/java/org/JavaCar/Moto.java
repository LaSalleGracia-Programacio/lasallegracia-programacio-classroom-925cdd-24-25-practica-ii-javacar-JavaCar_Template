// Archivo: Moto.java
package org.JavaCar;

/**
 * Classe que representa una moto de lloguer.
 */
public class Moto extends Vehicle {
    private int cilindrada;

    // Constructor
    public Moto(String matricula, String marca, String model, double preuBase, int cilindrada, Motor motor, Roda[] rodes) {
        super(matricula, marca, model, preuBase, motor, rodes);
        this.cilindrada = cilindrada;
    }
    public int getCilindrada() {
        return cilindrada;
    }

    @Override
    public double calcularPreu(int dies) {
        double preuTotal = preuBase * dies;
        if (cilindrada >= 600) {
            preuTotal += 5 * dies; // Afegir un suplement de 5 € per dia si la cilindrada >= 600
        }
        return preuTotal;
    }
}
