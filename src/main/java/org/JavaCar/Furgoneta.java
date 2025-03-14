package org.JavaCar;

public class Furgoneta extends Vehicle {
    private double capacitatCarga;

    public Furgoneta(String matricula, String marca, String model, double preuBase, String motor, int rodes, String etiquetaAmbiental, double capacitatCarga) {
        super(matricula, marca, model, preuBase, motor, rodes, etiquetaAmbiental);
        this.capacitatCarga = capacitatCarga;
    }

    public double getCapacitatCarga() {
        return capacitatCarga;
    }

    @Override
    public double calculateRentalPrice(int days) {
        return getPreuBase() * days * 1.2;
    }

    @Override
    public String getPollutionSticker() {
        return getEtiquetaAmbiental();
    }
}