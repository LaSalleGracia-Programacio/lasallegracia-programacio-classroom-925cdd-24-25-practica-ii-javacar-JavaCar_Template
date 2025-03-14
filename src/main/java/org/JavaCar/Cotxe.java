package org.JavaCar;

public class Cotxe extends Vehicle implements Llogable {
    private int nombrePlaces;

    public Cotxe(String matricula, String marca, String model, double preuBase, int nombrePlaces, int  motor, double rodes, String etiquetaAmbiental) {
        super(matricula, marca, model, preuBase, motor, rodes, etiquetaAmbiental);
    }

    public int getNombrePlaces() {
        return nombrePlaces;
    }

    public void setNombrePlaces(int nombrePlaces) {
        this.nombrePlaces = nombrePlaces;
    }
}
