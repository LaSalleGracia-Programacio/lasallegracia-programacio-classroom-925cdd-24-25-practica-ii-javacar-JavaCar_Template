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


}