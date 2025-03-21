package org.JavaCar;

public abstract class Vehicle implements Llogable {
    // Atributs (protected per accés des de subclasses)
    protected String matricula;
    protected String marca;
    protected String model;
    protected double preuBase;
    protected Motor motor;
    protected Roda[] rodes; // Diàmetre de les rodes (totes iguals).
    protected EtiquetaAmbiental etiquetaAmbiental;
 //constructor
}
