package org.JavaCar;
import java.util.List;
import java.util.ArrayList;

public class Gestor_lloguer {
    public static double calcularIngressosTotals(List<Vehicle> vehicles, int dies) {
        double total = 0.0;
        for (Vehicle v : vehicles) {
            total += v.calcularPreu(dies);
        }
        return total;
    }
    public static List<Vehicle> filtrarPerPreu(List<Vehicle> vehicles, double preuMax) {
        List<Vehicle> vehiclesFiltrats = new ArrayList<>();
        for (Vehicle v : vehicles) {
            if (v.getPreuBase() <= preuMax) {
                vehiclesFiltrats.add(v);
            }
        }
        return vehiclesFiltrats;
    }
}
