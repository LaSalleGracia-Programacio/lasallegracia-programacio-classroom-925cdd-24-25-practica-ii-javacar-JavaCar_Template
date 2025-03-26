package org.JavaCar;

public class Furgoneta extends Vehicle implements Llogable {
    private int capacitatCarga;

    public Furgoneta(String Matr, String Marca, String Model, double preu, int Carga, Motor Motor, Roda[] Rodes, int any, tipusVehicle tipus) {
        super(Matr, Marca, Model, preu, Motor, Rodes, any, tipus); // Llamada al constructor de Vehicle
        this.capacitatCarga = Carga;
    }

    public int getCapacitatCarga() {
        return capacitatCarga;
    }

    @Override
    public double calcularPreu(int dies) {
        if (capacitatCarga >= 1000) {
            return (getPreuBase() + 10) * dies; // Precio adicional para furgonetas con alta capacidad
        } else {
            return getPreuBase() * dies;
        }
    }

    @Override
    public String printVehicle() {
        String form = super.printVehicle(); // Llamar al método de la clase padre
        form += "Capacidad de Carga: " + getCapacitatCarga() + "\n"; // Añadir información específica de la furgoneta
        return form;
    }
}