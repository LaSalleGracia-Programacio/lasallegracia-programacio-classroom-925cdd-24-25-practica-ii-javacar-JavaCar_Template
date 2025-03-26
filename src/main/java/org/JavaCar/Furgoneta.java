package org.JavaCar;

import java.util.List;

class Furgoneta extends Vehicle {
    private double capacitatCarga;

    public Furgoneta(String matricula, String marca, String model, int anyFabricacio, String tipusCombustible, String etiquetaAmbiental, List <Roda> rodes, Motor motor, double capacitatCarga) {
        super(matricula, marca, model, anyFabricacio, tipusCombustible, etiquetaAmbiental, rodes, motor);
        this.capacitatCarga = capacitatCarga;
    }

    public double getCapacitatCarga() {
        return capacitatCarga;
    }

    @Override
    public double calcularPreu(int dies) {
        return 50.0*dies;
    }


}
