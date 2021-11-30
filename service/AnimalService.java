package service;

import domain.Animal;
import domain.Jugador;
import inter.CartaInterface;

public class AnimalService {

    public Animal crearAnimal(int id, String nombre, String efecto, int coste, int dano, String tipoMazo) {

        return new Animal(id, nombre, efecto, coste, dano, tipoMazo);

    }

    public void pasarAnimalesEnBatallaAReposo(Jugador jugadorActual) {
        for (CartaInterface carta : jugadorActual.getAnimalesEnBatalla()) {
            Animal animal = (Animal) carta;
            animal.setEnBatalla(false);
            animal.setEnReposo(true);

        }
    }

    public void pasarAnimalesEnReposoABatalla(Jugador jugadorActual) {
        for (CartaInterface carta : jugadorActual.getAnimalesEnBatalla()) {
            Animal animal = (Animal) carta;
            animal.setEnReposo(false);
            animal.setEnBatalla(true);
        }
    }

    public int devolverCantidadAnimalesEnReposo(Jugador jugadorActual) {
        return jugadorActual.getAnimalesEnReposo().size();
    }

}
