package org.JavaCar;

public class Cotxe extends Vehicle {
    private int nombre_Places;

    public Cotxe(String matricula, String marca, String model, double preuBase, int nombre_Places, String motor, int rodes) {
        super(matricula, marca, model, preuBase, nombre_Places, motor, rodes);
        this.nombre_Places = nombre_Places;
    }

    public int getNombrePlaces() {
        return nombre_Places;
    }

    @Override
    public double calculateRentalPrice(int days) {
        return getPreuBase() * days;
    }

    @Override
    public double calcularPreu(int dies) {
        return 0;
    }

    @Override
    public String getPollutionSticker() {
        return getEtiquetaAmbiental();
    }
}