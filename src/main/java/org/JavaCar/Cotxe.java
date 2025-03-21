package org.JavaCar;

public class Cotxe extends Vehicle implements Llogable {
    private int nombrePlaces;

    // Constructor principal
    public Cotxe(String matricula, String marca, String model, double preuBase, int nombrePlaces, Motor motor, Roda[] rodes, int mesMatriculacio, int anyMatriculacio) {
        super(matricula, marca, model, preuBase, motor, rodes, mesMatriculacio, anyMatriculacio);
        this.nombrePlaces = nombrePlaces;
    }

    // Constructor adicional para tests (sin mesMatriculacio y anyMatriculacio)
    public Cotxe(String matricula, String marca, String model, double preuBase, int nombrePlaces, Motor motor, Roda[] rodes) {
        this(matricula, marca, model, preuBase, nombrePlaces, motor, rodes, 1, 2023); // Valores por defecto para mesMatriculacio y anyMatriculacio
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