package src.service;

import java.util.ArrayList;
import java.util.List;

import src.domain.Animal;
import src.domain.Jugador;
import src.inter.CartaInterface;

public class AnimalService {

    public Animal crearAnimalConEfecto(int id, String nombre, String efecto, int coste, int dano, String tipoMazo,
            boolean efectoManual, boolean efectoPasivo) {

        return new Animal(id, nombre, efecto, coste, dano, tipoMazo, efectoManual, efectoPasivo);

    }

    public Animal crearAnimalSinEfecto(int id, String nombre, int coste, int dano, String tipoMazo) {
        return new Animal(id, nombre, coste, dano, tipoMazo);
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

    public List<Integer> devolverIdsAnimalesEnReposoConEfectoManual(Jugador jugadorActual) {
        List<Integer> auxiliar = new ArrayList<Integer>();

        for (CartaInterface cartaInterface : jugadorActual.getAnimalesEnReposo()) {
            Animal animal = (Animal) cartaInterface;
            if (animal.isEfectoManual()) {
                auxiliar.add(animal.getId());
            }
        }
        return auxiliar;
    }

    public CartaInterface devolverAnimalSeleccionadoPorId(List<CartaInterface> zonaAInspeccionar, Integer id) {

        for (CartaInterface carta : zonaAInspeccionar) {
            if (carta.getId() == id) {
                return carta;
            }
        }

        return null;
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

    public void activarPasivamenteEfectoAnimal(Jugador jugadorActual,
            CartaService cartaService) {

        for (CartaInterface carta : jugadorActual.getAnimalesEnReposo()) {
            Animal animal = (Animal) carta;
            if (animal.isEfectoPasivo()) {
                switch (animal.getNombre()) {
                    case "Lobo Gris":

                        int lobosBatalla = cartaService.devolverCantidadCopiasCartaPorZona(
                                jugadorActual.getAnimalesEnBatalla(),
                                animal);

                        int lobosReposo = cartaService.devolverCantidadCopiasCartaPorZona(
                                jugadorActual.getAnimalesEnReposo(),
                                animal);

                        int cantidadLobos = lobosBatalla + lobosReposo;

                        animal.setDano(animal.getDanoOriginal());

                        for (int i = 0; i < cantidadLobos; i++) {
                            animal.setDano(animal.getDano() + i);
                        }

                        break;

                    default:
                        break;
                }
            }

        }

    }

    public void activarEfectoCamaleonManualmente(CartaInterface camaleonElegido,
            CartaInterface animalEnemigoElegido,
            CartaService cartaService) {
        Animal camaleon = (Animal) camaleonElegido;
        Animal animalEnemigo = (Animal) animalEnemigoElegido;

        camaleon.setDano(camaleon.getDanoOriginal() + animalEnemigo.getDano());
        camaleon.setEfectoActivo(true);
    }

    public void activarEfectoMantisOrquideaManualmente(Jugador jugadorActual,
            int alimentosAConsumir, AlimentoService alimentoService, List<CartaInterface> cartasARevivir) {

        alimentoService.consumirAlimentosEnReserva(jugadorActual, alimentosAConsumir);

        for (int i = 1; i <= jugadorActual.getCartasCementerio().size(); i++) {

            for (int j = 1; j <= cartasARevivir.size(); j++) {
                if (jugadorActual.getCartasCementerio().get(i).getId() == cartasARevivir.get(j).getId()) {
                    jugadorActual.getCartasCementerio().get(i).setEnCementerio(false);
                    jugadorActual.getCartasCementerio().get(i).setEnMano(true);
                }
            }

        }

    }

    public void reiniciarEfectosManualesDeAnimales(Jugador jugadorActual) {
        reiniciarEfectoCamaleon(jugadorActual);
    }

    private void reiniciarEfectoCamaleon(Jugador jugadorActual) {
        for (CartaInterface carta : jugadorActual.getAnimalesEnReposo()) {
            Animal animal = (Animal) carta;

            if (animal.isEfectoManual()) {
                animal.setDano(animal.getDanoOriginal());
                animal.setEfectoActivo(false);
            }

        }
    }

    public void activarManualmenteEfectoAnimal(Jugador jugadorActual, CartaInterface animalConEfectoManual,
            CartaService cartaService) {
        Animal animal = (Animal) animalConEfectoManual;

        switch (animal.getNombre()) {

            case "Iguana":

                break;

            case "Mantis Orquídea":

                break;

            case "Tortuga Marina":
                break;

            case "Pulpo":
                break;

            case "Tiburón Blanco":
                break;

            default:
                break;
        }
    }
}
