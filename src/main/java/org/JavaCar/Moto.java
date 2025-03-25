package org.JavaCar;
import java.util.List;

public class Moto extends Vehicle {

    private int cilindrada;

        public Moto(String matricula, String marca, String model, int anyFabricacio, String tipusCombustible,
                    String etiquetaAmbiental, List<Roda> rodes, Motor motor, int cilindrada) {
            super(matricula, marca, model, anyFabricacio, tipusCombustible, etiquetaAmbiental, rodes, motor);

            if (cilindrada <= 0) {
                throw new IllegalArgumentException("La cilindrada ha de ser un valor positiu.");
            }

            this.cilindrada = cilindrada;
        }

        public int getCilindrada() { return cilindrada; }

        public void setCilindrada(int cilindrada) {
            if (cilindrada <= 0) {
                throw new IllegalArgumentException("La cilindrada ha de ser un valor positiu.");
            }
            this.cilindrada = cilindrada;
        }

        @Override
        public double calcularPreu(int dies) {
            return 20.0 * dies;
        }
    }
