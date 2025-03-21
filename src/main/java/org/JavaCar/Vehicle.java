package org.JavaCar;

import java.util.ArrayList;

abstract class Vehicle implements Llogable {
    protected String matricula;
    protected String marca;
    protected String modelo;
    protected List<Roda> rodes;
    protected Motor motor;
    protected String tipusCombustible;
    protected String etiquetaAmbiental;

    public Vehicle(String matricula, String marca, String model, Motor motor, String tipusCombustible, String etiquetaAmbiental) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.rodes = new ArrayList<>();
        this.motor = motor;
        this.tipusCombustible = tipusCombustible;
        this.etiquetaAmbiental = etiquetaAmbiental;

    }
    public String getMatricula() {
        return matricula;
    }

   public String getMarca() {
        return marca;
   }
   public String getModelo() {
        return modelo;
   }

    public Motor getMotor() {
        return motor;
    }
    public void addRoda(Roda roda){
        rodes.add(roda);
    }
    public abstract double calcularPreu(int dies);


}
