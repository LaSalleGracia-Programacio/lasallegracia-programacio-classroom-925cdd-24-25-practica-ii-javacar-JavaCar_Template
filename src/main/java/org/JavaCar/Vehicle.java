package org.JavaCar;

public abstract class Vehicle implements Llogable {
    protected String matricula;
    protected String marca;
    protected String model;
    protected double preuBase;
    protected Motor motor;
    protected Roda roda;
    protected String etiquetaAmbiental;

    public Vehicle (String matricula, String marca, String model, double preuBase, Motor motor, Roda roda ) {
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.preuBase = preuBase;
        this.motor = motor;
        this.roda = roda;
    }

    protected abstract double calcularPreu();
    protected abstract String calcularEtiquetaAmbiental();
}
