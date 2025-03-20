package org.JavaCar;

public abstract class Vehicle implements Llogable {
    protected String matricula;
    protected String marca;
    protected String model;
    private double preuBase;
    private Motor motor;
    private Roda[] rodes;
    private String etiquetaAmbiental;

    public Vehicle(String matricula, String marca, String model, double preuBase, Motor motor, Roda[] rodes) {
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.preuBase = preuBase;
        this.motor = motor;
        this.rodes = rodes;
        this.etiquetaAmbiental = calcularEtiquetaAmbiental();
    }

    public double preuLloguer(int dies) {
        return preuBase * dies;
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

    public double getPreuBase() {
        return preuBase;
    }

    public Motor getMotor() {
        return motor;
    }

    public Roda[] getRodes() {
        return rodes;
    }

    public String getEtiquetaAmbiental() {
        return etiquetaAmbiental;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
        this.etiquetaAmbiental = calcularEtiquetaAmbiental();
    }

    private String calcularEtiquetaAmbiental() {

        if (motor == null || motor.getTipus() == null) {
            etiquetaAmbiental = "Sense etiqueta";
            return etiquetaAmbiental;
        }

        String tipusMotor = motor.getTipus().toLowerCase();
        int potencia = motor.getPotencia();

        if (tipusMotor.contains("electric")) {
            return "ZERO";
        } else if (tipusMotor.contains("hibrid")) {
            return "ECO";
        } else if (tipusMotor.contains("gasolina") || tipusMotor.contains("diesel")) {
            if (potencia >= 90) {
                return "C";
            } else {
                return "B";
            }
        } else {
            return null;
        }
    }
}