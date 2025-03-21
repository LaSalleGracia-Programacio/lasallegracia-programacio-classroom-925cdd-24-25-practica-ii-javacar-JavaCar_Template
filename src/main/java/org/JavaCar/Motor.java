package org.JavaCar;

public class Motor {
    private String tipus;
    private int potencia;
    private int autonomia;

    public Motor(String tipus, int potencia, int autonomia) {
        this.tipus = tipus;
        this.potencia = potencia;
        this.autonomia = autonomia;
    }

    public String getTipus() {
        return tipus;
    }

    public int getPotencia() {
        return potencia;
    }

    public int getAutonomia() {
        return autonomia;
    }
}