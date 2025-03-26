package org.JavaCar;

import java.util.List;

        public int getNombrePlaces() {
            return nombrePlaces;
        }
public class Cotxe {
    private int nombrePlaces;

        @Override
        public double calcularPreu(int dies) {
            return 30.0 * dies; // Corrección del espacio en el operador *
        }
    public Cotxe(String matricula, String marca, String model, int anyFabricacio,
                 String tipusCombustible, String etiquetaAmbiental, List<Roda> rodes,
                 Motor motor, int nombrePlaces) {
        super(matricula, marca, model, anyFabricacio, tipusCombustible, etiquetaAmbiental, rodes, motor);
        this.nombrePlaces = nombrePlaces;
    }

