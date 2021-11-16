package service;

import domain.Animal;

public class AnimalService {

    public Animal crearAnimal(int id, String nombre, String efecto, int coste, int dano, boolean sePuedeBajarTablero,
            boolean enReposo, boolean enBatalla, boolean enCementerio, String tipoMazo) {

        return new Animal(id, nombre, efecto, coste, dano, sePuedeBajarTablero, enReposo, enBatalla, enCementerio,
                tipoMazo);

    }

}
