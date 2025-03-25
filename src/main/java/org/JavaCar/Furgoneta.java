package org.JavaCar;
import java.util.List;

public class Furgoneta extends Vehicle {
    private double capacitatCarga;

    public Furgoneta(String matricula, String marca, String model, int anyFabricacio, String tipusCombustible,
                     String etiquetaAmbiental, List<Roda> rodes, Motor motor, double capacitatCarga) {
        super(matricula, marca, model, anyFabricacio, tipusCombustible, etiquetaAmbiental, rodes, motor);
        if (capacitatCarga < 0) {
            throw new IllegalArgumentException("La capacitat de càrrega no pot ser negativa.");
        }
        this.capacitatCarga = capacitatCarga;
    }

    public double getCapacitatCarga() {
        return capacitatCarga;
    }

    public void setCapacitatCarga(double capacitatCarga) {
        if (capacitatCarga < 0) {
            throw new IllegalArgumentException("La capacitat de càrrega no pot ser negativa.");
        }
        this.capacitatCarga = capacitatCarga;
    }

    @Override
    public double calcularPreu(int dies) {
        return 50.0 * dies;
    }
}
