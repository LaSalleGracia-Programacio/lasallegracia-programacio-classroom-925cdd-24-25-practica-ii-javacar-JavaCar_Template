package org.JavaCar;

public class Furgoneta extends Vehicle{
    public Furgoneta(String matricula, String marca, String model, double preuBase, double motor, double rodes, String etiquetaAmbiental) {
        super(matricula, marca, model, preuBase, motor, rodes);
    }
    private double capacitatCarga;

    public double getCapacitatCarga() {
        return capacitatCarga;
    }

    public void setCapacitatCarga(double capacitatCarga) {
        this.capacitatCarga = capacitatCarga;
    }
}
