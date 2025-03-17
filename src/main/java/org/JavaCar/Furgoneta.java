package org.JavaCar;

public class Furgoneta extends Vehicle{

    private double capacitatCarga;
    
    public Furgoneta(String matricula, String marca, String model, double preuBase, double motor, double rodes, String etiquetaAmbiental) {
        super(matricula, marca, model, preuBase, motor, rodes);
    }

    @Override
    public double preuLloguer(int dies) {
        if(capacitatCarga > 1000) {
            return super.preuLloguer(dies) + 10 * dies;
        } else {
            return super.preuLloguer(dies);
        }
    }
    public double getCapacitatCarga() {
        return capacitatCarga;
    }

    public void setCapacitatCarga(double capacitatCarga) {
        this.capacitatCarga = capacitatCarga;
    }
}
