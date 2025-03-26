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
        this.etiquetaMedioAmbiental = getEtiquetaMedioAmbiental();
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

    private EtiquetaMedioAmbiental getEtiquetaMedioAmbiental() {
        if (motor.getTipus().equals(tipusVehicle.ELECTRIC.toString())) {
            return EtiquetaMedioAmbiental.ETIQUETA_0_EMISIONES;
        } else if (motor.getTipus().equals(tipusVehicle.HIBRID_GASOLINA.toString()) || motor.getTipus().equals(tipusVehicle.HIBRID_DIESEL.toString())) {
            if (getAnyMatricula() >= 2014) {
                return EtiquetaMedioAmbiental.ETIQUETA_ECO;
            } else {
                return EtiquetaMedioAmbiental.ETIQUETA_C;
            }
        } else if (motor.getTipus().equals(tipusVehicle.GASOLINA.toString())) {
            if (getAnyMatricula() >= 2006) {
                return EtiquetaMedioAmbiental.ETIQUETA_C;
            } else if (getAnyMatricula() >= 2001) {
                return EtiquetaMedioAmbiental.ETIQUETA_B;
            } else {
                return null;
            }
        } else if (motor.getTipus().equals(tipusVehicle.DIESEL.toString())) {
            if (getAnyMatricula() >= 2015) {
                return EtiquetaMedioAmbiental.ETIQUETA_C;
            } else if (getAnyMatricula() >= 2006) {
                return EtiquetaMedioAmbiental.ETIQUETA_B;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    private int getAnyMatricula() {
        String matricula = getMatricula();
        String any = matricula.substring(4, 8);
        return Integer.parseInt(any);
    }
}