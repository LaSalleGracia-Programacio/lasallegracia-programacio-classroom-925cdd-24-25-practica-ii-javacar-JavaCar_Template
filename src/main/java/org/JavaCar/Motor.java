package org.JavaCar;

public class Motor {
    private String tipus;  // Tipo de motor (Gasolina, Diesel, etc.)
    private int potencia;  // Potencia del motor

    public Motor(String tipus, int potencia) {
        this.tipus = tipus;
        this.potencia = potencia;
    }
    public String getTipus() {
        return tipus;
    }

    public int getPotencia() {
        return potencia;
    }
}