package org.JavaCar;

public class cotxe extends Vehicle {

    private int nombrePlaces;

    public Cotxe(String matricula, String marca, String model, int anyFabricacio, String tipusCombustible, String etiquetaAmbiental, List<Roda> rodes, Motor motor, int nombrePlaces) {
        super(matricula, marca, model, anyFabricacio, tipusCombustible, etiquetaAmbiental, rodes, motor);
        this.nombrePlaces = nombrePlaces;
    }


}
