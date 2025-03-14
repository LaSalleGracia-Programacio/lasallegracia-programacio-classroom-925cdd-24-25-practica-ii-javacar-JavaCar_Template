package org.JavaCar;

public class Cotxe extends Vehicle {
    private int nombrePlaces;

    public Cotxe(String matricula, String marca, String model, double preuBase, String motor, int rodes, String etiquetaAmbiental, int nombrePlaces) {
        super(matricula, marca, model, preuBase, motor, rodes, etiquetaAmbiental);
        this.nombrePlaces = nombrePlaces;
    }

    public int getNombrePlaces() {
        return nombrePlaces;
    }

    @Override
    public double calculateRentalPrice(int days) {
        return getPreuBase() * days;
    }

    @Override
    public String getPollutionSticker() {
        return getEtiquetaAmbiental();
    }
}