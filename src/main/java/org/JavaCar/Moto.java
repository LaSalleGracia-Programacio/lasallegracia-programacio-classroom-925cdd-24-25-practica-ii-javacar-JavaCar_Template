package org.JavaCar;

public class Moto extends Vehicle {

    public Moto(String matricula, String marca, String model, double preuBase, double motor, double rodes, String etiquetaAmbiental) {
        super(matricula, marca, model, preuBase, motor, rodes, etiquetaAmbiental);
    }
    private double cilindrada;

    public double getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(double cilindrada) {
        this.cilindrada = cilindrada;
    }
}

