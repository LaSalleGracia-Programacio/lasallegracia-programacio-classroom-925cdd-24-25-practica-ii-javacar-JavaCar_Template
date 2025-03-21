package org.JavaCar;

public class Moto extends Vehicle {

    private double cilindrada;

    public Moto(String matricula, String marca, String model, double preuBase, double cilindrada, Motor motor, Roda[] rodes, int mesMatriculacio, int anyMatriculacio) {
        super(matricula, marca, model, preuBase, motor, rodes, mesMatriculacio, anyMatriculacio);
        this.cilindrada = cilindrada;
    }

    @Override
    public double calcularPreu(int dies) {
        if (cilindrada > 500) {
            return super.preuLloguer(dies) + 5 * dies;
        } else {
            return super.preuLloguer(dies);
        }
    }

    public double getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(double cilindrada) {
        this.cilindrada = cilindrada;
    }
}