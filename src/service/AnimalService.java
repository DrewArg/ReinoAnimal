package src.service;

import java.util.ArrayList;
import java.util.List;

import src.domain.Animal;
import src.domain.Jugador;
import src.inter.CartaInterface;

public class AnimalService {

    public Animal crearAnimalConEfecto(int id, String nombre, String efecto, int coste, int dano, String tipoMazo,
            boolean efectoManual, boolean efectoPasivo, boolean efectoDefensivo) {

        return new Animal(id, nombre, efecto, coste, dano, tipoMazo, efectoManual, efectoPasivo, efectoDefensivo);

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

    public boolean existeAnimalEnZonaPorNombre(List<CartaInterface> zonaABuscar, String nombreAnimal) {
        for (CartaInterface carta : zonaABuscar) {
            Animal animal = (Animal) carta;
            if (animal.getNombre().equalsIgnoreCase(nombreAnimal)) {
                return true;
            }
        }

        return false;
    }

    public int devolverCantidadAnimalesEnReposo(Jugador jugadorActual) {
        return jugadorActual.getAnimalesEnReposo().size();
    }

    public CartaInterface devolverPrimerAnimalEncontradoPorNombreEnZona(String nombreAnimal,
            List<CartaInterface> zona) {
        for (CartaInterface carta : zona) {
            Animal animal = (Animal) carta;
            if (animal.getNombre().equalsIgnoreCase(nombreAnimal)) {
                return animal;
            }
        }
        return null;
    }

    public List<Integer> devolverIdsAnimalesEnReposo(Jugador jugadorActual) {
        List<Integer> auxiliar = new ArrayList<Integer>();

        for (CartaInterface carta : jugadorActual.getAnimalesEnReposo()) {
            auxiliar.add(carta.getId());
        }

        return auxiliar;
    }

    public List<Integer> devolverIdsAnimalesConEfectoManualOfensivo(List<CartaInterface> zonaAnimal) {
        List<Integer> auxiliar = new ArrayList<Integer>();

        for (CartaInterface cartaInterface : zonaAnimal) {
            Animal animal = (Animal) cartaInterface;
            if (animal.isEfectoManual()) {
                if (!animal.isTieneEfectoDefensivo()) {
                    auxiliar.add(animal.getId());
                }

            }
        }
        return auxiliar;
    }

    public List<Integer> devolverIdsAnimalesConEfectoManualDefensivo(List<CartaInterface> zonaAnimal) {
        List<Integer> auxiliar = new ArrayList<Integer>();

        for (CartaInterface cartaInterface : zonaAnimal) {
            Animal animal = (Animal) cartaInterface;
            if (animal.isEfectoManual()) {
                if (animal.isTieneEfectoDefensivo()) {
                    auxiliar.add(animal.getId());
                }

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

    public String devolverAnimalesEnZonaComoMensajePorCosteMaximo(List<CartaInterface> zonaAInspeccionar,
            int costeMaximo) {

        if (zonaAInspeccionar.size() == 0) {
            return "Sin cartas";
        } else {

            String cartasInspeccionadas = "";

            for (int i = 1; i <= zonaAInspeccionar.size(); i++) {

                CartaInterface carta = zonaAInspeccionar.get(zonaAInspeccionar.size() - i);

                Animal animal = (Animal) carta;

                if (animal.getCoste() <= costeMaximo) {
                    cartasInspeccionadas = cartasInspeccionadas + "\n[" + animal.getId() + "]\n" + animal.getNombre()
                            + "\nCoste: " + animal.getCoste() + "\nDaño: " + animal.getDano() + "\nEfecto: "
                            + animal.getEfecto() + "\n-----------------------------------------------------";
                }
            }

            return cartasInspeccionadas;
        }

    }

    public List<Integer> devolverIDsAnimalesEnZonaPorCosteMaximo(List<CartaInterface> zonaAInspeccionar,
            int costeMaximo) {

        List<Integer> auxiliar = new ArrayList<Integer>();

        for (int i = 0; i < zonaAInspeccionar.size(); i++) {
            CartaInterface carta = zonaAInspeccionar.get(i);

            Animal animalActual = (Animal) carta;

            if (animalActual.getCoste() <= costeMaximo) {
                auxiliar.add(animalActual.getId());
            }

        }

        auxiliar.sort((a1, a2) -> (a1.compareTo(a2)));

        return auxiliar;
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

    public void activarEfectoTortugaMarinaManualmente(CartaInterface animalConEfectoManual, Jugador jugadorActual) {

        Animal tortugaMarina = (Animal) animalConEfectoManual;

        if (tortugaMarina.isEnReposo()) {
            tortugaMarina.setEnCementerio(true);
            tortugaMarina.setEnReposo(false);

        } else if (tortugaMarina.isEnBatalla()) {
            tortugaMarina.setEnCementerio(true);
            tortugaMarina.setEnBatalla(false);
        }

        jugadorActual.setPuedeAtacar(false);

    }

    public void activarEfectoPulpoManualmente(CartaInterface animalConEfectoManual, int danoAPerder,
            Jugador jugadorActual,
            List<CartaInterface> cartasParaMazo) {

        Animal pulpo = (Animal) animalConEfectoManual;

        pulpo.setDano(pulpo.getDano() - danoAPerder);

        for (int i = 0; i < jugadorActual.getCartasCementerio().size(); i++) {
            for (int j = 0; j < cartasParaMazo.size(); j++) {
                if (jugadorActual.getCartasCementerio().get(i).getId() == cartasParaMazo.get(j).getId()) {
                    jugadorActual.getCartasCementerio().get(i).setEnMazo(true);
                    jugadorActual.getCartasCementerio().get(i).setEnCementerio(false);
                }
            }
        }

        pulpo.setEfectoActivo(true);
    }

    public void activarEfectoCamaleonManualmente(CartaInterface animalConEfectoManual,
            CartaInterface animalEnemigoElegido) {
        Animal camaleon = (Animal) animalConEfectoManual;
        Animal animalEnemigo = (Animal) animalEnemigoElegido;

        camaleon.setDano(camaleon.getDanoOriginal() + animalEnemigo.getDano());
        camaleon.setEfectoActivo(true);
    }

    public void activarEfectoMantisOrquideaManualmente(CartaInterface animalConEfectoManual, Jugador jugadorActual,
            int alimentosAConsumir, AlimentoService alimentoService, List<CartaInterface> cartasARevivir) {

        Animal mantis = (Animal) animalConEfectoManual;

        alimentoService.consumirAlimentosEnReserva(jugadorActual, alimentosAConsumir);

        for (int i = 0; i < jugadorActual.getCartasCementerio().size(); i++) {
            for (int j = 0; j < cartasARevivir.size(); j++) {
                if (jugadorActual.getCartasCementerio().get(i).getId() == cartasARevivir.get(j).getId()) {

                    jugadorActual.getCartasCementerio().get(i).setEnMano(true);
                    jugadorActual.getCartasCementerio().get(i).setEnCementerio(false);

                }
            }

        }

        mantis.setEfectoActivo(true);

    }

    public void activarEfectoTiburonBlancoManualmente(CartaInterface tiburonSeleccionado,
            CartaInterface animalAliadoADevorar,
            CartaInterface animalEnemigoADevorar, Jugador jugadorActual, Jugador jugadorEnemigo) {

        Animal tiburon = (Animal) tiburonSeleccionado;
        Animal aliado = (Animal) animalAliadoADevorar;
        Animal enemigo = (Animal) animalEnemigoADevorar;

        aliado.setEnCementerio(true);
        aliado.setEnReposo(false);

        if (enemigo.isEnReposo()) {
            enemigo.setEnCementerio(true);
            enemigo.setEnReposo(false);

        } else if (enemigo.isEnBatalla()) {
            enemigo.setEnCementerio(true);
            enemigo.setEnBatalla(false);
        }

        tiburon.setDano(tiburon.getDanoOriginal() + enemigo.getDano());
        tiburon.setEfectoActivo(true);

    }

    public void reiniciarEfectosManualesDeAnimales(Jugador jugadorActual) {

        for (CartaInterface carta : jugadorActual.getAnimalesEnReposo()) {
            Animal animal = (Animal) carta;
            animal.setEfectoActivo(false);
        }

        reiniciarEfectoSobreDanoAnimal(jugadorActual);

    }

    private void reiniciarEfectoSobreDanoAnimal(Jugador jugadorActual) {
        for (CartaInterface carta : jugadorActual.getAnimalesEnReposo()) {
            Animal animal = (Animal) carta;

            if (animal.isEfectoManual()) {
                animal.setDano(animal.getDanoOriginal());

            }

        }
    }

}
