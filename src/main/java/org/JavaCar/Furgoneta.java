package org.JavaCar;

public class Furgoneta extends Vehicle {
    private double capacitatCarga;

    // Constructor principal
    public Furgoneta(String matricula, String marca, String model, double preuBase, double capacitatCarga, Motor motor, Roda[] rodes, int mesMatriculacio, int anyMatriculacio) {
        super(matricula, marca, model, preuBase, motor, rodes, mesMatriculacio, anyMatriculacio);
        this.capacitatCarga = capacitatCarga;
    }

    // Constructor adicional para tests (sin mesMatriculacio y anyMatriculacio)
    public Furgoneta(String matricula, String marca, String model, double preuBase, double capacitatCarga, Motor motor, Roda[] rodes) {
        this(matricula, marca, model, preuBase, capacitatCarga, motor, rodes, 1, 2023); // Valores por defecto para mesMatriculacio y anyMatriculacio
    }

    @Override
    public double calcularPreu(int dies) {
        if (capacitatCarga > 1000) {
            return super.preuLloguer(dies) + 10 * dies;
        } else {
            return super.preuLloguer(dies);
        }
    }

    public double getCapacitatCarga() {
        return capacitatCarga;
    }

    public void setCapacitatCarga(double capacitatCarga) {
        this.capacitatCarga = capacitatCarga;
    }
}