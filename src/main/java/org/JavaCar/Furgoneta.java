package org.JavaCar;

import java.util.List;

class Furgoneta{
    private double capacitatCarga;

    public Furgoneta(String matricula, String marca, String model, int anyFabricacio, String tipusCombustible, String etiquetaAmbiental, List <Roda> rodes, Motor motor, double capacitatCarga) {
        super();
        this.capacitatCarga = capacitatCarga;
    }

    public double getCapacitatCarga() {
        return capacitatCarga;
    }


}
