package org.JavaCar;

public abstract class Vehicle implements Llogable {
    protected String matricula;
    protected String marca;
    protected String model;
    protected double preuBase;
    protected int any;
    protected Motor motor;
    protected Roda[] rodes;
    protected EtiquetaMedioAmbiental etiquetaMedioAmbiental;
    protected tipusVehicle tipus;

    public Vehicle(String matricula, String marca, String model, double preuBase, Motor motor, Roda[] rodes, int any, tipusVehicle tipus) {
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.preuBase = preuBase;
        this.motor = motor;
        this.rodes = rodes;
        this.tipus = tipus;
        this.any = any;
        this.etiquetaMedioAmbiental = determinarEtiqueta(any);
    }

    public EtiquetaMedioAmbiental getEtiquetaMedioAmbiental() {
        return etiquetaMedioAmbiental;
    }

    private EtiquetaMedioAmbiental determinarEtiqueta(int any) {
        String tipusCombustible = motor.getTipus(); // Obtener tipo de combustible

        // Lógica para determinar la etiqueta
        if (tipusCombustible.equalsIgnoreCase(tipusVehicle.ELECTRIC.getatr())) {
            return EtiquetaMedioAmbiental.ETIQUETA_0_EMISIONES;
        } else if (tipusCombustible.equalsIgnoreCase(tipusVehicle.HIBRID_GASOLINA.getatr()) && any >= 2018) {
            return EtiquetaMedioAmbiental.ETIQUETA_ECO;
        } else if (tipusCombustible.equalsIgnoreCase(tipusVehicle.GAS.getatr()) || (tipusCombustible.equalsIgnoreCase(tipusVehicle.HIBRID_DIESEL.getatr()) && any < 2018)) {
            return EtiquetaMedioAmbiental.ETIQUETA_ECO;
        } else if (tipusCombustible.equalsIgnoreCase(tipusVehicle.GASOLINA.getatr()) && (any >= 2006)) {
            return EtiquetaMedioAmbiental.ETIQUETA_C;
        } else if (tipusCombustible.equalsIgnoreCase(tipusVehicle.DIESEL.getatr()) && (any >= 2014)) {
            return EtiquetaMedioAmbiental.ETIQUETA_C;
        } else if (tipusCombustible.equalsIgnoreCase(tipusVehicle.GASOLINA.getatr()) && (any >= 2000)) {
            return EtiquetaMedioAmbiental.ETIQUETA_B;
        } else if (tipusCombustible.equalsIgnoreCase(tipusVehicle.DIESEL.getatr()) && (any >= 2005)) {
            return EtiquetaMedioAmbiental.ETIQUETA_B;
        } else {
            return null; // Sin etiqueta
        }
    }
    public int getAny(){
        return any;
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

    public double calcularPreu(int dies) {
        return this.preuBase * dies;
    }

    public String printVehicle() {
        String form = "Matricula: " + getMatricula() + "\n" +
                "Marca: " + getMarca() + "\n" +
                "Model: " + getModel() + "\n" +
                "PreuBase: " + getPreuBase() + "\n" +
                "Tipus(Motor): " + motor.getTipus() + "\n" +
                "Potencia(Motor): " + motor.getPotencia() + "\n" +
                "Etiqueta Medio Ambiental: " + (getEtiquetaMedioAmbiental() != null ? getEtiquetaMedioAmbiental().getNombre() : "Sin Etiqueta") + "\n"; // Añadir etiqueta ambiental

        for (Roda i : rodes) {
            form += "Roda(marca): " + i.getMarca() + "\nRoda(Diametre): " + i.getDiametre() + "\n";
        }
        System.out.println(form);
        return form;
    }
}