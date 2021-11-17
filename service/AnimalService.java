package service;

import java.util.ArrayList;
import java.util.List;

import domain.Animal;
import inter.CartaInterface;

public class AnimalService {

    public Animal crearAnimal(int id, String nombre, String efecto, int coste, int dano, String tipoMazo) {

        return new Animal(id, nombre, efecto, coste, dano, tipoMazo);

    }

    public List<CartaInterface> devolverAnimalesEnReposo(List<CartaInterface> cartasTablero) {
        List<CartaInterface> auxiliar = new ArrayList<CartaInterface>();

        for (CartaInterface carta : cartasTablero) {
            if (carta instanceof Animal) {
                Animal animal = (Animal) carta;
                if (animal.isEnReposo()) {
                    auxiliar.add(animal);
                }
            }
        }

        return auxiliar;
    }

    public List<CartaInterface> devolverAnimalesEnBatalla(List<CartaInterface> cartasTablero) {
        List<CartaInterface> auxiliar = new ArrayList<CartaInterface>();

        for (CartaInterface carta : cartasTablero) {
            if (carta instanceof Animal) {
                Animal animal = (Animal) carta;
                if (animal.isEnBatalla()) {
                    auxiliar.add(animal);
                }
            }
        }

        return auxiliar;
    }

    public void pasarAnimalesEnBatallaAReposo(List<CartaInterface> cartasTablero) {
        for (CartaInterface carta : cartasTablero) {
            if (carta instanceof Animal) {
                Animal animal = (Animal) carta;
                if (animal.isEnBatalla()) {
                    animal.setEnBatalla(false);
                    animal.setEnReposo(true);
                }
            }
        }
    }

}
