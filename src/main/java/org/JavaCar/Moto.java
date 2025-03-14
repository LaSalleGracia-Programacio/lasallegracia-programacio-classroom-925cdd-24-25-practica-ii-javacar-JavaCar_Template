package org.JavaCar;

public class Moto extends Vehicle {
    private int cilindrada;

    public Moto(String matricula, String marca, String model, double preuBase, String motor, int rodes, String etiquetaAmbiental, int cilindrada) {
        super(matricula, marca, model, preuBase, motor, rodes, etiquetaAmbiental);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    @Override
    public double calculateRentalPrice(int days) {
        return getPreuBase() * days * 0.8;
    }

    @Override
    public String getPollutionSticker() {
        return getEtiquetaAmbiental();
    }
}