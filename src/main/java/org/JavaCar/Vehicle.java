package org.JavaCar;

public abstract class Vehicle implements Llogable {
    protected String matricula;
    protected String marca;
    protected String model;
    protected double preuBase;
    protected Motor motor;
    protected Roda[] rodes;
    protected String etiquetaAmbiental;
    protected boolean llogat;
    protected int mesMatriculacio;
    protected int anyMatriculacio;

    public Vehicle(String matricula, String marca, String model, double preuBase, Motor motor, Roda[] rodes, int mesMatriculacio, int anyMatriculacio) {
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.preuBase = preuBase;
        this.motor = motor;
        this.rodes = rodes;
        this.mesMatriculacio = mesMatriculacio;
        this.anyMatriculacio = anyMatriculacio;
        this.etiquetaAmbiental = calcularEtiquetaAmbiental();
        this.llogat = false;
    }

    public double preuLloguer(int dies) {
        return preuBase * dies;
    }

    public boolean isLlogat() {
        return llogat;
    }

    public void setLlogat(boolean llogat) {
        this.llogat = llogat;
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
            return "Sense distintiu";
        }

        String tipusMotor = motor.getTipus();
        int autonomia = motor.getAutonomia();

        if ((anyMatriculacio >= 2001 && tipusMotor.equals("Gasolina")) ||
                (anyMatriculacio >= 2006 && tipusMotor.equals("Diesel"))) {
            return "B";
        }
        else if ((anyMatriculacio >= 2006 && tipusMotor.equals("Gasolina")) ||
                (anyMatriculacio >= 2015 && mesMatriculacio >= 9 && tipusMotor.equals("Diesel"))) {
            return "C";
        }
        else if ((tipusMotor.equals("HEV") || tipusMotor.equals("GLP") || tipusMotor.equals("GNL") || tipusMotor.equals("GNC")) && autonomia < 40) {
            return "Eco";
        }
        else if ((tipusMotor.equals("BEV") || tipusMotor.equals("REEV") || tipusMotor.equals("PHEV")) && autonomia >= 40) {
            return "Zero Emissions";
        }
        else {
            return "Sense etiqueta";
        }
    }
}