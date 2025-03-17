package org.JavaCar;

public class Cotxe extends Vehicle implements Llogable {
    private int nombrePlaces;

    public Cotxe(String matricula, String marca, String model, double preuBase, int nombrePlaces, Motor  motor, Roda[] rodes) {
        super(matricula, marca, model, preuBase, motor, rodes);
        this.nombrePlaces = nombrePlaces;
    }

    public int getNombrePlaces() {
        return nombrePlaces;
    }

    public void setNombrePlaces(int nombrePlaces) {
        this.nombrePlaces = nombrePlaces;
    }

    @Override
    public double calcularPreu(int dies) {
        return super.preuLloguer(dies);
    }
}
