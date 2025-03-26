package org.JavaCar;



public abstract class Vehicle implements Llogable {
    // Atributs (protected per accés des de subclasses)
    protected String matricula;
    protected String marca;
    protected String model;
    protected double preuBase;
    protected Motor motor;
    protected Roda[] rodes; // Diàmetre de les rodes (totes iguals).
    protected EtiquetaAmbiental etiquetaAmbiental;
 //constructor
    public Vehicle(String matricula, String marca, String model, double preuBase, Motor motor, Roda[] rodes) {
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.preuBase = preuBase;
        this.motor = motor;
        this.rodes = rodes;
        this.etiquetaAmbiental = etiquetaAmbiental;
    }

    protected  EtiquetaAmbiental calcularEtiqueta() {
        if (motor == null) {
            return EtiquetaAmbiental.NONE; //el none es que no tiene etiqueta medioambiental
        }

        switch (motor.getTipus().toLowerCase()){
            case "electric":
                return EtiquetaAmbiental.ZERO;
            case "híbrid":
                return EtiquetaAmbiental.ECO;
            case "gasolina":
                return motor.getPotencia() >= 120 ? EtiquetaAmbiental.C : EtiquetaAmbiental.B;
            case "diesel":
                return motor.getPotencia() >= 100 ? EtiquetaAmbiental.B : EtiquetaAmbiental.NONE;
            default:
                return EtiquetaAmbiental.NONE;
        }
    }
    //getters
    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModel() {
        return model;
    }

    public double getPreuBase() {
        return preuBase;
    }

    public Motor getMotor() {
        return motor;
    }

    public Roda[] getRodes() {
        return rodes;
    }

    public EtiquetaAmbiental getEtiquetaAmbiental() {
        return etiquetaAmbiental;
    }
     //metodo abstracto que implenta las subclases
    public abstract double calcularPreu(int dies);

}

