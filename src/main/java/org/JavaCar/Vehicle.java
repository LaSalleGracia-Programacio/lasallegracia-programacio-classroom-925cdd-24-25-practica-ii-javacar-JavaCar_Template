package org.JavaCar;

import java.util.ArrayList;
import java.util.List;

abstract class Vehicle implements Llogable {

    protected String matricula;
    protected String marca;
    protected String model;
    protected int anyFabricacio;
    protected String tipusCombustible;
    protected String etiquetaAmbiental;
    protected List<Roda> rodes;
    protected Motor motor;

    public Vehicle(String matricula, String marca, String model, int anyFabricacio, String tipusCombustible, String etiquetaAmbiental, List<Roda> rodes, Motor motor) {
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.anyFabricacio = anyFabricacio;
        this.tipusCombustible = tipusCombustible;
        this.etiquetaAmbiental = etiquetaAmbiental;
        this.rodes = rodes;
        this.motor = motor;
    }

    public String getMatricula() {
        return matricula;
    }

   public String getMarca() {
        return marca;
   }
   public String getModel() {
        return model;
   }

    public Motor getMotor() {
        return motor;
    }
   public int getAnyFabricacio() {
        return anyFabricacio;
   }
   public String getTipusCombustible() {
        return tipusCombustible;
   }
   public String getEtiquetaAmbiental() {
        return etiquetaAmbiental;
   }
   public List<Roda> getRodes(){
        return rodes;
   }
    public abstract double calcularPreu(int dies);


}
