package org.JavaCar;

public class Cotxe extends Vehicle {
    private int nombrePlaces;

    public Cotxe(String matricula, String marca, String model, double preuBase, Motor motor, Roda roda) {
        super(matricula, marca, model, preuBase, motor, roda);
    }

    @Override
    protected String calcularEtiquetaAmbiental() {
        return "";
    }

    @Override
    public double calcularPreu(int dies) {
        return 0;
    }
}
