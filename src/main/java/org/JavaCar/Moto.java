package org.JavaCar;

import java.util.List;

class Moto extends Vehicle {

    private int cilindrada;

    public Moto(String matricula, String marca, String model, int anyFabricacio, String tipusCombustible, String etiquetaAmbiental, List<Roda> rodes, Motor motor, int cilindrada) {
        super();
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public double calcularPreu() {
        return calcularPreu(0);
    }


    public double calcularPreu(int dies) {
        return 20.0*dies;
    }




}
