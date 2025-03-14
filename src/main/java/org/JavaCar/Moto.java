package org.JavaCar;

public class Moto extends Vehicle {

    private double cilindrada;

    public Moto(String matricula, String marca, String model, double preuBase, double cilindrada, Motor motor, Roda rodes, String etiquetaAmbiental) {
        super(matricula, marca, model, preuBase, motor, rodes);
    }

    public double getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(double cilindrada) {
        this.cilindrada = cilindrada;
    }
}

