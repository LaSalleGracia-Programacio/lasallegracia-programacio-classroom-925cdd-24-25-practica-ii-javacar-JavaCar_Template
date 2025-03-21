package org.JavaCar;
import java.util.List;
public class Furgoneta extends Vehicle {
    private int capacitatCarga;

    public Furgoneta(String matricula, String marca, String model, double preuBase, int capacitatCarga, Motor motor, List<Roda> rodes) {
        super(matricula, marca, model, preuBase, motor, rodes);
        this.capacitatCarga = capacitatCarga;
    }

    public int getCapacitatCarga() {
        return capacitatCarga;
    }
    @Override
    public String toString() {
        return "Marca: " + marca + " | " +
                "Model: " + model + "\n" +
                "Matricula: " + matricula + " | " +
                "Any de matriculació: " + anyMatriculacio + "\n" +
                "Preu/dia: " + preuBase + " | " +
                "Capacitat de càrrega: " + capacitatCarga + "kg\n" +
                "Tipus de motor: " + motor.getTipus() + " | " +
                "Marca de roda: " + rodes.get(0).getMarca() + "\n";
    }

    @Override
    public double calcularPreu(int dies) {
        double preu = preuBase * dies;
        if (capacitatCarga > 1000) {
            preu += (preuBase * 0.10 * dies); // Extra del 10%
        }
        return preu;
    }


}