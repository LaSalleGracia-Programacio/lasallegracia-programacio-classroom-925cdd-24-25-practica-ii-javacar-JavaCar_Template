package org.JavaCar;

public class Motor {
    private String tipus;
    private int potencia;
    private int autonomia;

    // Constructor principal
    public Motor(String tipus, int potencia, int autonomia) {
        this.tipus = tipus;
        this.potencia = potencia;
        this.autonomia = autonomia;
    }

    // Constructor adicional para tests (sin autonomia)
    public Motor(String tipus, int potencia) {
        this(tipus, potencia, 0); // Autonomia por defecto (0)
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