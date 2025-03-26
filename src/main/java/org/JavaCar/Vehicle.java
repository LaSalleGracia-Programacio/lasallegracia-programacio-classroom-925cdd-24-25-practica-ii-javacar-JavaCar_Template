package org.JavaCar;

public abstract class Vehicle implements Llogable {
    protected String matricula;
    protected String marca;
    protected String model;
    protected double preuBase;
    protected Motor motor;
    protected Roda[] rodes;
    protected EtiquetaMedioAmbiental etiquetaMedioAmbiental;
    protected boolean disponibilidad = true;

    public Vehicle(String matricula, String marca, String model, double preuBase, Motor motor, Roda[] rodes) {
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.preuBase = preuBase;
        this.motor = motor;
        this.rodes = rodes;
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

    public EtiquetaMedioAmbiental getEtiquetaMedioAmbiental() {
        return etiquetaMedioAmbiental;
    }

    public void setEtiquetaMedioAmbiental(EtiquetaMedioAmbiental etiquetaMedioAmbiental) {
        this.etiquetaMedioAmbiental = etiquetaMedioAmbiental;
    }

    public double calcularPreu(int dies) {
        return this.preuBase * dies;
    }

    public String printVehicle() {
        String form = "Matricula: " + getMatricula() + "\n" +
                "Marca: " + getMarca() + "\n" +
                "Model: " + getModel() + "\n" +
                "PreuBase: " + getPreuBase() + "\n" +
                "Tipus(Motor): " + motor.getTipus() + "\n" +
                "Potencia(Motor): " + motor.getPotencia() + "\n";
        for (Roda i : rodes) {
            form += "Roda(marca): " + i.getMarca() + "\nRoda(Diametre): " + i.getDiametre() + "\n";
        }
        System.out.println(form);
        return form;
    }
}