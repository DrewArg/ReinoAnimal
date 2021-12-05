package service;

import java.util.ArrayList;
import java.util.List;

import domain.Alimento;
import domain.Animal;
import domain.Habilidad;
import domain.Habitat;
import domain.Jugador;

import inter.CartaInterface;

import repository.CartaRepository;

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

        int cartasMazo = 25;
        int lobos = 3;
        int ratas = 3;
        int iguanas = 2;
        int mantisOrquideas = 1;
        int alimentos = 9;
        int orquidea = 1;
        int alcantarilla = 2;
        int aullido = 3;
        int camuflaje = 1;
        int enamoramiento = 1;

        for (int i = 100; i < cartasMazo + 100; i++) {

            tipoMazo = "Terrestre";

            if (lobos > 0) {

                String efecto;
                int coste;
                int dano;

                nombre = "Lobo Gris";
                efecto = "Gana +1 de daño por cada Lobo Gris en tu tablero.";
                coste = 3;
                dano = 2;

                lobos--;

                cartaRepository
                        .agregarCartaMazoTerrestre(animalService.crearAnimal(i, nombre, efecto, coste, dano, tipoMazo));

            } else if (ratas > 0) {
                nombre = "Rata";
                String efecto = "Sin efecto.";
                int coste = 1;
                int dano = 1;

                ratas--;

                cartaRepository
                        .agregarCartaMazoTerrestre(animalService.crearAnimal(i, nombre, efecto, coste, dano, tipoMazo));

            } else if (iguanas > 0) {
                nombre = "Iguana";
                String efecto = "Puede copiar el ataque de un enemigo y sumarlo al suyo hasta el final del turno.";
                ;
                int coste = 3;
                int dano = 1;

                iguanas--;

                cartaRepository
                        .agregarCartaMazoTerrestre(animalService.crearAnimal(i, nombre, efecto, coste, dano, tipoMazo));

            } else if (mantisOrquideas > 0) {
                nombre = "Mantis Orquídea";
                String efecto = "Puedes pagar 1 alimento para tomar una carta de tu cementerio y ponerla en tu mano.";
                ;
                int coste = 5;
                int dano = 4;

                mantisOrquideas--;

                cartaRepository
                        .agregarCartaMazoTerrestre(animalService.crearAnimal(i, nombre, efecto, coste, dano, tipoMazo));

            } else if (alimentos > 0) {
                nombre = "Alimento";
                alimentos--;

                cartaRepository.agregarCartaMazoTerrestre(alimentoService.crearAlimento(i, nombre, tipoMazo));

            } else if (orquidea > 0) {
                nombre = "Orquidea";

                String efecto = "Si tienes una Mantis Orquídea en juego, esta gana +1 de daño por cada animal aliado en juego. Si Mantis Orquídea está en tu cementerio, puedes revivirla pagando su coste.";
                int coste = 6;

                orquidea--;

                cartaRepository
                        .agregarCartaMazoTerrestre(habitatService.crearHabitat(i, nombre, efecto, coste, tipoMazo));

            } else if (alcantarilla > 0) {
                nombre = "Alcantarilla";

                String efecto = "Puedes revivir una Rata por turno pagando su coste.";
                int coste = 3;

                alcantarilla--;

                cartaRepository
                        .agregarCartaMazoTerrestre(habitatService.crearHabitat(i, nombre, efecto, coste, tipoMazo));

            } else if (aullido > 0) {
                nombre = "Aullido";
                String efecto = "Si tienes un Lobo Gris en juego, puedes jugar a otro desde tu mazo o mano sin pagar su coste.";
                int coste = 2;

                aullido--;

                cartaRepository
                        .agregarCartaMazoTerrestre(habilidadService.crearHabilidad(i, nombre, efecto, coste, tipoMazo));

            } else if (camuflaje > 0) {
                nombre = "Camuflaje";
                String efecto = "Si tienes una Iguana en juego, esta se vuelve indestructible por este turno.";
                int coste = 3;

                camuflaje--;

                cartaRepository
                        .agregarCartaMazoTerrestre(habilidadService.crearHabilidad(i, nombre, efecto, coste, tipoMazo));

            } else if (enamoramiento > 0) {

                nombre = "Enamoramiento";
                String efecto = "Toma el control de un animal enemigo hasta el fin de este turno.";
                int coste = 6;

                enamoramiento--;
                cartaRepository
                        .agregarCartaMazoTerrestre(habilidadService.crearHabilidad(i, nombre, efecto, coste, tipoMazo));
            }

        }
    }

    private void crearCartasMazoAcuatico(AnimalService animalService, AlimentoService alimentoService,
            HabilidadService habilidadService, HabitatService habitatService) {
        String nombre;
        String tipoMazo;

        int cartasMazo = 25;
        int tortugas = 3;
        int pecesPayaso = 3;
        int pulpos = 2;
        int tiburonesBlancos = 1;
        int alimentos = 9;
        int costa = 1;
        int anemona = 2;
        int coraza = 3;
        int captura = 1;
        int fortalecimiento = 1;

        for (int i = 200; i < cartasMazo + 200; i++) {
            tipoMazo = "Acuático";

            if (tortugas > 0) {
                String efecto;
                int coste;
                int dano;

                nombre = "Tortuga Marina";
                efecto = "Puede sacrificarse para evitar que el enemigo siga atacando este turno.";
                coste = 3;
                dano = 2;

                tortugas--;

                cartaRepository
                        .agregarCartaMazoAcuatico(animalService.crearAnimal(i, nombre, efecto, coste, dano, tipoMazo));

            } else if (pecesPayaso > 0) {
                nombre = "Pez Payaso";
                String efecto = "Sin efecto.";
                int coste = 1;
                int dano = 1;

                pecesPayaso--;

                cartaRepository
                        .agregarCartaMazoAcuatico(animalService.crearAnimal(i, nombre, efecto, coste, dano, tipoMazo));

            } else if (pulpos > 0) {
                nombre = "Pulpo";
                String efecto = "Puede perder X puntos de daño permanentemente para devolver X cartas del cementerio al mazo.";
                ;
                int coste = 4;
                int dano = 3;

                pulpos--;

                cartaRepository
                        .agregarCartaMazoAcuatico(animalService.crearAnimal(i, nombre, efecto, coste, dano, tipoMazo));

            } else if (tiburonesBlancos > 0) {
                nombre = "Tiburón Blanco";
                String efecto = "Puede devorar a un aliado para devorar a un enemigo de coste 3 o menos y adicionar su fuerza a la suya hasta el final del turno.";
                ;
                int coste = 5;
                int dano = 4;

                tiburonesBlancos--;

                cartaRepository
                        .agregarCartaMazoAcuatico(animalService.crearAnimal(i, nombre, efecto, coste, dano, tipoMazo));

            } else if (alimentos > 0) {
                nombre = "Alimento";

                alimentos--;

                cartaRepository.agregarCartaMazoAcuatico(alimentoService.crearAlimento(i, nombre, tipoMazo));

            } else if (costa > 0) {
                nombre = "Costa";

                String efecto = "Si tienes un Tiburón Blanco en juego, este gana +1 de daño por cada animal devorado hasta ser destruido.";
                int coste = 6;

                costa--;

                cartaRepository
                        .agregarCartaMazoAcuatico(habitatService.crearHabitat(i, nombre, efecto, coste, tipoMazo));

            } else if (anemona > 0) {
                nombre = "Anemona";

                String efecto = "Puedes duplicar un Pez Payaso en juego pagando su coste hasta el final del turno.";
                int coste = 3;

                anemona--;

                cartaRepository
                        .agregarCartaMazoAcuatico(habitatService.crearHabitat(i, nombre, efecto, coste, tipoMazo));

            } else if (coraza > 0) {
                nombre = "Coraza";
                String efecto = "Evita que un animal aliado muera este turno.";
                int coste = 2;

                coraza--;

                cartaRepository
                        .agregarCartaMazoAcuatico(habilidadService.crearHabilidad(i, nombre, efecto, coste, tipoMazo));

            } else if (captura > 0) {
                nombre = "Captura";
                String efecto = "Evita que un enemigo pueda atacar o defender por 2 turnos.";
                int coste = 3;

                captura--;

                cartaRepository
                        .agregarCartaMazoAcuatico(habilidadService.crearHabilidad(i, nombre, efecto, coste, tipoMazo));

            } else if (fortalecimiento > 0) {

                nombre = "Fortalecimiento";
                String efecto = "Si tienes un Tiburón Blanco en juego, este gana +3 de daño. Si tienes un Tiburón Blanco en tu cementerio, puedes revivirlo sin pagar su coste.";
                int coste = 6;

                fortalecimiento--;
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

                        alimentoService.consumirAlimentosEnReserva(jugadorActual, costeAnimal);
                        animal.setEnMano(false);
                        animal.setEnReposo(true);

                    } else if (carta instanceof Habilidad) {
                        Habilidad habilidad = (Habilidad) carta;
                        int costeHabilidad = habilidad.getCoste();

                        alimentoService.consumirAlimentosEnReserva(jugadorActual, costeHabilidad);
                        habilidad.setEnMano(false);
                        habilidad.setEnCementerio(true);

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

        for (CartaInterface carta : jugadorActual.getTodasLasCartas()) {

            carta.setEnMazo(true);

            carta.setEnMano(false);
            carta.setEnCementerio(false);

            if (carta instanceof Animal) {
                Animal animal = (Animal) carta;
                animal.setEnBatalla(false);
                animal.setEnReposo(false);

            } else if (carta instanceof Alimento) {
                Alimento alimento = (Alimento) carta;
                alimento.setEnAlimentoConsumidos(false);
                alimento.setEnReservaDeAlimentos(false);

            } else if (carta instanceof Habitat) {
                Habitat habitat = (Habitat) carta;
                habitat.setEnLineaApoyo(false);

            }

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

            } else if (carta instanceof Habilidad) {
                Habilidad habilidad = (Habilidad) carta;
                if (habilidad.getCoste() <= alimentosDisponibles) {
                    habilidad.setSePuedeBajarTablero(true);
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

            } else if (carta instanceof Habilidad) {
                Habilidad habilidad = (Habilidad) carta;
                if (habilidad.getCoste() <= alimentosDisponibles) {
                    auxiliar.add(habilidad.getId());
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

                }
            }

            return cartasInspeccionadas;
        }

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

}
