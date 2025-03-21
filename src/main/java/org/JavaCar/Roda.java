package org.JavaCar;

public class Roda {
    private String marca;
    private double diametre;

    public Roda(String marca, double diametre) {
        this.marca = marca;
        this.diametre = diametre;
    }
    public Roda() {
        this("Desconocida", 0.0);
    }

    public String getMarca() {
        return marca;
    }

    public double getDiametre() {
        return diametre;
    }
}