package service;

import java.util.ArrayList;
import java.util.List;

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

    public CartaInterface pasarYDevolverAnimalEnReposoABatallaPorId(Jugador jugadorActual, Integer idAnimalEnReposo) {

        for (CartaInterface carta : jugadorActual.getAnimalesEnReposo()) {

            if (carta.getId() == idAnimalEnReposo) {

                Animal animal = (Animal) carta;

                animal.setEnReposo(false);
                animal.setEnBatalla(true);
                return animal;

            }

        }
        return null;

    }

    public int devolverCantidadAnimalesEnReposo(Jugador jugadorActual) {
        return jugadorActual.getAnimalesEnReposo().size();
    }

    public List<Integer> devolverIdsAnimalesEnReposo(Jugador jugadorActual) {
        List<Integer> auxiliar = new ArrayList<Integer>();

        for (CartaInterface carta : jugadorActual.getAnimalesEnReposo()) {
            auxiliar.add(carta.getId());
        }

        return auxiliar;
    }

    public String devolverDescripcionesAnimalesEnReposo(Jugador jugadorActual, CartaService cartaService) {
        return cartaService.devolverCartasEnZonaComoMensaje(jugadorActual.getAnimalesEnReposo());
    }

    public int mandarCartasAlCementerioPorAnimalAtacante(Jugador jugador, CartaInterface animalAtacante) {
        Animal animal = (Animal) animalAtacante;

        if (animal.getDano() >= jugador.getCantidadCartasMazo()) {
            System.out.println("daño animal atacante mayor o igual a cartas en mazo");
            for (CartaInterface carta : jugador.getCartasMazo()) {
                carta.setEnMazo(false);
                carta.setEnCementerio(true);
            }

        } else {

            for (int i = 1; i <= animal.getDano(); i++) {
                jugador.getCartasMazo().get(jugador.getCartasMazo().size() - i).setEnMazo(false);
                jugador.getCartasMazo().get(jugador.getCartasMazo().size() - i).setEnCementerio(true);

            }

        }

        return animal.getDano();
    }

    public void mandarCartasAlCementerioPorCalculoDaño(Jugador jugador, int calculoDaño) {

        if (calculoDaño >= jugador.getCantidadCartasMazo()) {
            System.out.println("calculo de daño mayor o igual a cartas en mazo");
            jugador.getCartasMazo().clear();

        } else {

            for (int i = 1; i <= calculoDaño; i++) {
                jugador.getCartasMazo().get(jugador.getCartasMazo().size() - i).setEnMazo(false);
                jugador.getCartasMazo().get(jugador.getCartasMazo().size() - i).setEnCementerio(true);

            }

        }
    }

    public int calcularDañoCombate(CartaInterface animalAtacante, CartaInterface animalDefensor) {
        Animal atacante = (Animal) animalAtacante;
        Animal defensor = (Animal) animalDefensor;

        if (atacante.getDano() == defensor.getDano()) {

            atacante.setEnBatalla(false);
            atacante.setEnCementerio(true);

            defensor.setEnBatalla(false);
            defensor.setEnCementerio(true);

        } else if (atacante.getDano() < defensor.getDano()) {

            atacante.setEnBatalla(false);
            atacante.setEnCementerio(true);

        } else if (atacante.getDano() > defensor.getDano()) {

            defensor.setEnBatalla(false);
            defensor.setEnCementerio(true);
        }

        return atacante.getDano() - defensor.getDano();
    }
}
