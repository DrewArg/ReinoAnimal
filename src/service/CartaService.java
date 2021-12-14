package src.service;

import java.util.ArrayList;
import java.util.List;

import src.domain.Alimento;
import src.domain.Animal;
import src.domain.Habilidad;
import src.domain.Habitat;
import src.domain.Jugador;
import src.inter.CartaInterface;

import src.repository.CartaRepository;

public class CartaService {

    private CartaRepository cartaRepository = new CartaRepository();

    public CartaService() {

    }

    public List<CartaInterface> seleccionarMazoCartas(String tipoMazo, AnimalService animalService,
            AlimentoService alimentoService,
            HabilidadService habilidadService, HabitatService habitatService) {
        if (tipoMazo.equalsIgnoreCase("Terrestre")) {

            crearCartasMazoTerrestre(animalService, alimentoService, habilidadService, habitatService);
            return cartaRepository.getMazoTerrestre();
        } else {

            crearCartasMazoAcuatico(animalService, alimentoService, habilidadService, habitatService);
            return cartaRepository.getMazoAcuatico();
        }

    }

    private void crearCartasMazoTerrestre(AnimalService animalService, AlimentoService alimentoService,
            HabilidadService habilidadService, HabitatService habitatService) {
        String nombre;
        String tipoMazo;

        int cartasMazo = 30;
        int lobos = 3;
        int ratas = 3;
        int camaleon = 2;
        int mantisOrquideas = 1;
        int alimentos = 14;
        int orquidea = 1;
        int alcantarilla = 2;
        int aullido = 3;
        int camuflaje = 1;
        int hechizo = 1;

        for (int i = 100; i <= cartasMazo + 100; i++) {

            tipoMazo = "Terrestre";

            if (lobos > 0) {

                String efecto = "Este efecto es pasivo por lo que no tienes que activarlo manualmente. \nGana +1 de daño por cada Lobo Gris además de este en tu tablero.";
                int coste = 3;
                int dano = 2;
                boolean efectoManual = false;
                boolean efectoPasivo = true;
                boolean efectoDefensivo = false;

                nombre = "Lobo Gris";

                lobos--;

                cartaRepository
                        .agregarCartaMazoTerrestre(
                                animalService.crearAnimalConEfecto(i, nombre, efecto, coste, dano, tipoMazo,
                                        efectoManual, efectoPasivo, efectoDefensivo));

            } else if (ratas > 0) {
                nombre = "Rata";

                int coste = 1;
                int dano = 1;

                ratas--;

                cartaRepository
                        .agregarCartaMazoTerrestre(
                                animalService.crearAnimalSinEfecto(i, nombre, coste, dano, tipoMazo));

            } else if (camaleon > 0) {
                nombre = "Camaleón";
                String efecto = "Puede tomar el ataque de un enemigo en reposo y sumarlo al suyo hasta el final del turno.";

                int coste = 3;
                int dano = 1;
                boolean efectoManual = true;
                boolean efectoPasivo = false;
                boolean efectoDefensivo = false;

                camaleon--;

                cartaRepository
                        .agregarCartaMazoTerrestre(animalService.crearAnimalConEfecto(i, nombre, efecto, coste, dano,
                                tipoMazo, efectoManual, efectoPasivo, efectoDefensivo));

            } else if (mantisOrquideas > 0) {
                nombre = "Mantis Orquídea";
                String efecto = "Puedes pagar X alimentos para tomar X/2 cartas de tu cementerio y ponerlas en tu mano.\n El número X/2 se redondea al entero más cercano.\n Solo puedes activar este efecto una vez por turno.";

                int coste = 5;
                int dano = 4;
                boolean efectoManual = true;
                boolean efectoPasivo = false;
                boolean efectoDefensivo = false;

                mantisOrquideas--;

                cartaRepository
                        .agregarCartaMazoTerrestre(animalService.crearAnimalConEfecto(i, nombre, efecto, coste, dano,
                                tipoMazo, efectoManual, efectoPasivo, efectoDefensivo));

            } else if (alimentos > 0) {
                nombre = "Alimento";
                alimentos--;

                cartaRepository.agregarCartaMazoTerrestre(alimentoService.crearAlimento(i, nombre, tipoMazo));

            } else if (orquidea > 0) {
                nombre = "Orquídea";

                String efecto = "Si tienes una Mantis Orquídea en juego, puedes pagar 5 alimentos para que esta gana +1 de daño por cada animal en juego hasta tu próximo turno. \nSi Mantis Orquídea está en tu cementerio, puedes ponerla en juego pagando 5 alimentos.";
                int coste = 6;

                orquidea--;

                cartaRepository
                        .agregarCartaMazoTerrestre(habitatService.crearHabitat(i, nombre, efecto, coste, tipoMazo));

            } else if (alcantarilla > 0) {
                nombre = "Alcantarilla";

                String efecto = "Puedes revivir una Rata por turno pagando su coste y ponerla en tu línea de reposo.";
                int coste = 3;

                alcantarilla--;

                cartaRepository
                        .agregarCartaMazoTerrestre(habitatService.crearHabitat(i, nombre, efecto, coste, tipoMazo));

            } else if (aullido > 0) {
                nombre = "Aullido";
                String efecto = "Si tienes un Lobo Gris en juego, puedes jugar a otro desde tu mazo o cementerio sin pagar su coste.";
                int coste = 2;

                aullido--;

                cartaRepository
                        .agregarCartaMazoTerrestre(habilidadService.crearHabilidad(i, nombre, efecto, coste, tipoMazo));

            } else if (camuflaje > 0) {
                nombre = "Camuflaje";
                String efecto = "Si un Camaleón tuyo está en el cementerio, puedes activar esta habilidad y ponerlo en tu mano.";
                int coste = 3;

                camuflaje--;

                cartaRepository
                        .agregarCartaMazoTerrestre(habilidadService.crearHabilidad(i, nombre, efecto, coste, tipoMazo));

            } else if (hechizo > 0) {

                nombre = "Hechizo";
                String efecto = "Toma el control de un animal enemigo.";
                int coste = 6;

                hechizo--;
                cartaRepository
                        .agregarCartaMazoTerrestre(habilidadService.crearHabilidad(i, nombre, efecto, coste, tipoMazo));
            }

        }
    }

    private void crearCartasMazoAcuatico(AnimalService animalService, AlimentoService alimentoService,
            HabilidadService habilidadService, HabitatService habitatService) {
        String nombre;
        String tipoMazo;

        int cartasMazo = 30;
        int tortugas = 3;
        int pecesPayaso = 3;
        int pulpos = 2;
        int tiburonesBlancos = 1;
        int alimentos = 14;
        int costa = 1;
        int anemona = 2;
        int coraza = 3;
        int captura = 1;
        int olorASangre = 1;

        for (int i = 200; i <= cartasMazo + 200; i++) {
            tipoMazo = "Acuático";

            if (tortugas > 0) {
                String efecto = "Puede sacrificarse para evitar que el enemigo siga atcando este turno.";
                int coste = 3;
                int dano = 2;
                boolean efectoManual = true;
                boolean efectoPasivo = false;
                boolean efectoDefensivo = true;

                nombre = "Tortuga Marina";

                tortugas--;

                cartaRepository
                        .agregarCartaMazoAcuatico(animalService.crearAnimalConEfecto(i, nombre, efecto, coste, dano,
                                tipoMazo, efectoManual, efectoPasivo, efectoDefensivo));

            } else if (pecesPayaso > 0) {
                nombre = "Pez Payaso";

                int coste = 1;
                int dano = 1;

                pecesPayaso--;

                cartaRepository
                        .agregarCartaMazoAcuatico(animalService.crearAnimalSinEfecto(i, nombre, coste, dano, tipoMazo));

            } else if (pulpos > 0) {
                nombre = "Pulpo";
                String efecto = "Pulpo puede perder X puntos de daño hasta tu próximo turno para devolver X cartas del cementerio al mazo.";

                int coste = 4;
                int dano = 3;
                boolean efectoManual = true;
                boolean efectoPasivo = false;
                boolean efectoDefensivo = false;

                pulpos--;

                cartaRepository
                        .agregarCartaMazoAcuatico(animalService.crearAnimalConEfecto(i, nombre, efecto, coste, dano,
                                tipoMazo, efectoManual, efectoPasivo, efectoDefensivo));

            } else if (tiburonesBlancos > 0) {
                nombre = "Tiburón Blanco";
                String efecto = "Puede devorar a un aliado en reposo para devorar a un enemigo de coste 3 o menos y adicionar su fuerza a la suya hasta tu próximo turno.";

                int coste = 5;
                int dano = 4;
                boolean efectoManual = true;
                boolean efectoPasivo = false;
                boolean efectoDefensivo = false;

                tiburonesBlancos--;

                cartaRepository
                        .agregarCartaMazoAcuatico(animalService.crearAnimalConEfecto(i, nombre, efecto, coste, dano,
                                tipoMazo, efectoManual, efectoPasivo, efectoDefensivo));

            } else if (alimentos > 0) {
                nombre = "Alimento";

                alimentos--;

                cartaRepository.agregarCartaMazoAcuatico(alimentoService.crearAlimento(i, nombre, tipoMazo));

            } else if (costa > 0) {
                nombre = "Costa";
                // reveeer efecto
                String efecto = "Si tienes un Tiburón Blanco en juego, este gana +1 de daño por cada animal que haya devorado hasta ser destruido.Si tienes un Tiburón Blanco en juego, puedes consumir 5 alimentos para activar su efecto una segunda vez este turno";
                int coste = 6;

                costa--;

                cartaRepository
                        .agregarCartaMazoAcuatico(habitatService.crearHabitat(i, nombre, efecto, coste, tipoMazo));

            } else if (anemona > 0) {
                nombre = "Anemona";

                String efecto = "Puedes revivir un Pez Payaso por turno pagando su coste y ponerla en tu línea de reposo.";
                int coste = 3;

                anemona--;

                cartaRepository
                        .agregarCartaMazoAcuatico(habitatService.crearHabitat(i, nombre, efecto, coste, tipoMazo));

            } else if (coraza > 0) {
                nombre = "Coraza";
                String efecto = "Un animal pasa a ser indestructible por este turno.";
                int coste = 2;

                coraza--;

                cartaRepository
                        .agregarCartaMazoAcuatico(habilidadService.crearHabilidad(i, nombre, efecto, coste, tipoMazo));

            } else if (captura > 0) {
                nombre = "Captura";
                String efecto = "Evita que un enemigo pueda pasar a la linea de batalla por 2 turnos.";
                int coste = 3;

                captura--;

                cartaRepository
                        .agregarCartaMazoAcuatico(habilidadService.crearHabilidad(i, nombre, efecto, coste, tipoMazo));

            } else if (olorASangre > 0) {

                nombre = "Olor a Sangre";
                String efecto = "Si tienes un Tiburón Blanco en juego, este gana +3 de daño. \nSi tienes un Tiburón Blanco en tu cementerio, puedes ponerlo en reposo sin pagar su coste.";
                int coste = 6;

                olorASangre--;
                cartaRepository
                        .agregarCartaMazoAcuatico(habilidadService.crearHabilidad(i, nombre, efecto, coste, tipoMazo));
            }

        }
    }

    public void bajarCartaAlTableroPorId(Jugador jugadorActual, Integer idCarta, AlimentoService alimentoService) {
        for (CartaInterface carta : jugadorActual.getCartasMano()) {
            if (carta.getId() == idCarta) {
                if (carta.isSePuedeBajarTablero()) {

                    if (carta instanceof Alimento) {
                        Alimento alimento = (Alimento) carta;
                        alimento.setEnMano(false);
                        alimento.setEnReservaDeAlimentos(true);

                    } else if (carta instanceof Animal) {
                        Animal animal = (Animal) carta;
                        int costeAnimal = animal.getCoste();

                        if (animal.isEfectoPasivo()) {
                            animal.setEfectoActivo(true);
                        }

                        alimentoService.consumirAlimentosEnReserva(jugadorActual, costeAnimal);
                        animal.setEnMano(false);
                        animal.setEnReposo(true);

                    } else if (carta instanceof Habitat) {
                        Habitat habitat = (Habitat) carta;
                        int costeHabitat = habitat.getCoste();

                        alimentoService.consumirAlimentosEnReserva(jugadorActual, costeHabitat);
                        habitat.setEnMano(false);
                        habitat.setEnLineaApoyo(true);
                    }
                }
            }
        }

    }

    public void regresarTodasLasCartasAlMazo(Jugador jugadorActual) {

        for (CartaInterface carta : jugadorActual.getCartasMano()) {
            carta.setEnMazo(true);
            carta.setEnMano(false);

        }

        for (CartaInterface carta : jugadorActual.getCartasCementerio()) {
            carta.setEnMazo(true);
            carta.setEnCementerio(false);

        }

        for (CartaInterface carta : jugadorActual.getAlimentosConsumidos()) {
            Alimento alimento = (Alimento) carta;
            alimento.setEnMazo(true);
            alimento.setEnAlimentoConsumidos(false);

        }

        for (CartaInterface carta : jugadorActual.getAlimentosEnReserva()) {
            Alimento alimento = (Alimento) carta;
            alimento.setEnMazo(true);
            alimento.setEnReservaDeAlimentos(false);

        }

        for (CartaInterface carta : jugadorActual.getAnimalesEnBatalla()) {
            Animal animal = (Animal) carta;
            animal.setEnMazo(true);
            animal.setEnBatalla(false);

        }

        for (CartaInterface carta : jugadorActual.getAnimalesEnReposo()) {
            Animal animal = (Animal) carta;
            animal.setEnMazo(true);
            animal.setEnReposo(false);

        }

        for (CartaInterface carta : jugadorActual.getHabitatsEnApoyo()) {
            Habitat habitat = (Habitat) carta;
            habitat.setEnMazo(true);
            habitat.setEnLineaApoyo(false);

        }

    }

    public void robarCartasDelMazo(Jugador jugadorActual, int cantidadCartas) {

        if (cantidadCartas >= jugadorActual.getCantidadCartasMazo()) {
            System.out.println("robar cartas mayor o igual a cartas en mazo");

            for (CartaInterface carta : jugadorActual.getCartasMazo()) {
                carta.setEnMazo(false);
                carta.setEnMano(true);
            }
        } else {
            for (CartaInterface carta : jugadorActual.getCartasMazo()) {
                if (cantidadCartas > 0) {
                    cantidadCartas--;
                    carta.setEnMano(true);
                    carta.setEnMazo(false);
                }

            }
        }
    }

    public CartaInterface devolverPrimerCartaEncontradaEnZonaPorNombre(List<CartaInterface> zonaABuscar,
            String nombreCarta) {
        for (CartaInterface carta : zonaABuscar) {
            if (carta.getNombre().equalsIgnoreCase(nombreCarta)) {
                return carta;
            }
        }
        return null;
    }

    public int devolverCantidadCartasPorZona(List<CartaInterface> zona) {
        int contador = 0;
        for (int i = 0; i < zona.size(); i++) {
            contador++;
        }

        return contador;
    }

    public String devolverDescripcionCartasDisponiblesParaBajar(Jugador jugadorActual,
            int alimentosDisponibles) {

        for (CartaInterface carta : jugadorActual.getCartasMano()) {
            if (carta instanceof Alimento) {
                carta.setSePuedeBajarTablero(true);

            } else if (carta instanceof Animal) {
                Animal animal = (Animal) carta;
                if (animal.getCoste() <= alimentosDisponibles) {
                    animal.setSePuedeBajarTablero(true);
                }

            } else if (carta instanceof Habitat) {
                Habitat habitat = (Habitat) carta;
                if (habitat.getCoste() <= alimentosDisponibles) {
                    habitat.setSePuedeBajarTablero(true);
                }
            }
        }

        List<CartaInterface> cartasPosiblesBajar = new ArrayList<CartaInterface>();
        for (CartaInterface carta : jugadorActual.getCartasMano()) {
            if (carta.isSePuedeBajarTablero()) {
                cartasPosiblesBajar.add(carta);
            }
        }

        return devolverCartasEnZonaComoMensaje(cartasPosiblesBajar);
    }

    public String devolverDescripcionCarta(CartaInterface carta) {
        String descripcionCarta = "";

        if (carta instanceof Animal) {
            Animal animal = (Animal) carta;

            descripcionCarta = "[" + animal.getId() + "]\n" + animal.getNombre()
                    + "\nCoste: " + animal.getCoste() + "\nDaño: " + animal.getDano() + "\nEfecto: "
                    + animal.getEfecto() + "\n-----------------------------------------------------";

        } else if (carta instanceof Alimento) {

            Alimento alimento = (Alimento) carta;

            descripcionCarta = "[" + alimento.getId() + "]\n"
                    + alimento.getNombre() + "\n-----------------------------------------------------";

        } else if (carta instanceof Habilidad) {
            Habilidad habilidad = (Habilidad) carta;

            descripcionCarta = "[" + habilidad.getId() + "]\n"
                    + habilidad.getNombre() + "\nCoste: " + habilidad.getCoste() + "\nEfecto: "
                    + habilidad.getEfecto() + "\n-----------------------------------------------------";

        } else if (carta instanceof Habitat) {
            Habitat habitat = (Habitat) carta;

            descripcionCarta = "[" + habitat.getId() + "]\n" + habitat.getNombre()
                    + "\nCoste: " + habitat.getCoste() + "\nEfecto: " + habitat.getEfecto()
                    + "\n-----------------------------------------------------";

        }

        return descripcionCarta;
    }

    public List<Integer> devolverIdsCartasDisponiblesParaBajar(Jugador jugadorActual, int alimentosDisponibles) {

        List<Integer> auxiliar = new ArrayList<Integer>();

        for (CartaInterface carta : jugadorActual.getCartasMano()) {
            if (carta instanceof Alimento) {
                auxiliar.add(carta.getId());

            } else if (carta instanceof Animal) {
                Animal animal = (Animal) carta;
                if (animal.getCoste() <= alimentosDisponibles) {
                    auxiliar.add(animal.getId());
                }

            } else if (carta instanceof Habitat) {
                Habitat habitat = (Habitat) carta;
                if (habitat.getCoste() <= alimentosDisponibles) {
                    auxiliar.add(habitat.getId());
                }

            }
        }

        auxiliar.sort((a1, a2) -> (a1.compareTo(a2)));

        return auxiliar;

    }

    public List<Integer> devolverIDsCartasEnZona(List<CartaInterface> zonaAInspeccionar) {

        List<Integer> auxiliar = new ArrayList<Integer>();

        for (int i = 0; i < zonaAInspeccionar.size(); i++) {
            auxiliar.add(zonaAInspeccionar.get(i).getId());
        }

        auxiliar.sort((a1, a2) -> (a1.compareTo(a2)));

        return auxiliar;
    }

    public String devolverCartasEnZonaComoMensaje(List<CartaInterface> zonaAInspeccionar) {

        if (zonaAInspeccionar.size() == 0) {
            return "Sin cartas";
        } else {

            String cartasInspeccionadas = "";

            for (int i = 1; i <= zonaAInspeccionar.size(); i++) {

                CartaInterface carta = zonaAInspeccionar.get(zonaAInspeccionar.size() - i);

                if (carta instanceof Animal) {
                    Animal animal = (Animal) carta;

                    cartasInspeccionadas = cartasInspeccionadas + "\n[" + animal.getId() + "]\n" + animal.getNombre()
                            + "\nCoste: " + animal.getCoste() + "\nDaño: " + animal.getDano() + "\nEfecto: "
                            + animal.getEfecto() + "\n-----------------------------------------------------";

                } else if (carta instanceof Alimento) {

                    Alimento alimento = (Alimento) carta;

                    cartasInspeccionadas = cartasInspeccionadas + "\n[" + alimento.getId() + "]\n"
                            + alimento.getNombre() + "\n-----------------------------------------------------";

                } else if (carta instanceof Habilidad) {
                    Habilidad habilidad = (Habilidad) carta;

                    cartasInspeccionadas = cartasInspeccionadas + "\n[" + habilidad.getId() + "]\n"
                            + habilidad.getNombre() + "\nCoste: " + habilidad.getCoste() + "\nEfecto: "
                            + habilidad.getEfecto() + "\n-----------------------------------------------------";

                } else if (carta instanceof Habitat) {
                    Habitat habitat = (Habitat) carta;

                    cartasInspeccionadas = cartasInspeccionadas + "\n[" + habitat.getId() + "]\n" + habitat.getNombre()
                            + "\nCoste: " + habitat.getCoste() + "\nEfecto: " + habitat.getEfecto()
                            + "\n-----------------------------------------------------";

                } else {

                }
            }

            return cartasInspeccionadas;
        }

    }

    public int devolverCantidadCartasEnZona(List<CartaInterface> zonaAInspeccionar) {
        return zonaAInspeccionar.size();
    }

    public int devolverCantidadCopiasCartaPorZona(List<CartaInterface> zonaAInspeccionar, CartaInterface cartaAContar) {
        int copiasCarta = 0;
        for (CartaInterface cartaActual : zonaAInspeccionar) {
            if (cartaActual.getNombre().equalsIgnoreCase(cartaAContar.getNombre())) {
                copiasCarta++;
            }
        }
        return copiasCarta;
    }

    public int devolverCantidadCartasARevivirPorCantidadAlimentos(int alimentosAConsumir) {
        return Math.round(alimentosAConsumir / 2);
    }

    public CartaInterface devolverCartaSeleccionadaPorId(List<CartaInterface> zonaAInspeccionar, Integer id) {

        for (CartaInterface carta : zonaAInspeccionar) {
            if (carta.getId() == id) {
                return carta;
            }
        }

        return null;
    }

}
