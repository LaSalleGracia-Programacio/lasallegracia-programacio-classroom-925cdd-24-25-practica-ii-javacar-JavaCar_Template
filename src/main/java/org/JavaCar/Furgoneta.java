package org.JavaCar;

public class Furgoneta extends Vehicle{
    private double capacitatCarga;

    public Furgoneta(String matricula, String marca, String model, double preuBase, Motor motor, Roda roda) {
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
