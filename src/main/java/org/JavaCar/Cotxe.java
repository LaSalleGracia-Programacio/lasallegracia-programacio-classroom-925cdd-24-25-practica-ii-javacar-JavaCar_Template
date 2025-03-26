package org.JavaCar;


        public int getNombrePlaces() {
            return nombrePlaces;
        }

        @Override
        public double calcularPreu(int dies) {
            return 30.0 * dies; // Corrección del espacio en el operador *
        }
    }

