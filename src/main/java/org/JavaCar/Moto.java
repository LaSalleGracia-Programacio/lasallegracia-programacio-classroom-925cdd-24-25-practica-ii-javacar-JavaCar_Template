package org.JavaCar;

public class Moto extends Vehicle implements Llogable {
    private int cilindrada;

    public Moto(String Matr, String Marca, String Model, double preu, int cilin, Motor Motor, Roda[] Rodes, int any, tipusVehicle tipus) {
        super(Matr, Marca, Model, preu, Motor, Rodes, any, tipus); // Llamada al constructor de Vehicle
        this.cilindrada = cilin;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    @Override
    public double calcularPreu(int dies) {
        if (cilindrada >= 500) {
            return (getPreuBase() + 5) * dies;
        } else {
            return getPreuBase() * dies;
        }
    }

    @Override
    public String printVehicle() {
        String form = super.printVehicle(); // Llamar al método de la clase padre
        form += "Cilindrada: " + getCilindrada() + "\n"; // Añadir información específica de la moto
        return form;
    }
}