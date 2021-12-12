package src;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import src.domain.Animal;
import src.domain.Habilidad;
import src.domain.Jugador;

import src.inter.CartaInterface;

import src.service.AlimentoService;
import src.service.AnimalService;
import src.service.CartaService;
import src.service.HabilidadService;
import src.service.HabitatService;
import src.service.JScrollPaneService;
import src.service.JugadorService;

public class Juego {

        private JugadorService jugadorService = new JugadorService();
        private CartaService cartaService = new CartaService();

        private AnimalService animalService = new AnimalService();
        private AlimentoService alimentoService = new AlimentoService();
        private HabilidadService habilidadService = new HabilidadService();
        private HabitatService habitatService = new HabitatService();

        private JScrollPaneService jScrollPaneService = new JScrollPaneService();

        public void iniciar() {

                String[] menuLogin = { "Ingresar 2", "Registrar 2", "Ingresar 1 y Registrar 1", "Salir" };
                int opcionElegida = JOptionPane.showOptionDialog(null, "¡Bienvenidos a la Batalla del Reino Animal!",
                                "Jugadores", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                                menuLogin, 0);

                boolean loginIniciado = false;

                while (opcionElegida != 3) {

                        if (!loginIniciado) {
                                loginIniciado = true;

                        } else {
                                opcionElegida = JOptionPane.showOptionDialog(null,
                                                "¡Bienvenidos a la Batalla del Reino Animal!", "Jugadores",
                                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                                                menuLogin, 0);
                        }

                        if (opcionElegida == 0) {
                                String nombreJugador1 = JOptionPane.showInputDialog(null,
                                                "Jugador 1, ingresa tu nombre de usuario.",
                                                "Ingresa tu nombre de usuario.");
                                String contrasenaJugador1 = JOptionPane.showInputDialog(null,
                                                "Jugador 1, ingresa tu contraseña", "Ingresa tu contraseña.");

                                String nombreJugador2 = JOptionPane.showInputDialog(null,
                                                "Jugador 2, ingresa tu nombre de usuario.",
                                                "Ingresa tu nombre de usuario.");

                                String contrasenaJugador2 = JOptionPane.showInputDialog(null,
                                                "Jugador 2, ingresa tu contraseña", "Ingresa tu contraseña.");

                                List<Jugador> jugadoresPartida = jugadorService.validarDosJugadores(nombreJugador1,
                                                contrasenaJugador1, nombreJugador2, contrasenaJugador2);

                                if (jugadoresPartida.size() < 2) {
                                        JOptionPane.showMessageDialog(null, "Uno o más datos ingresados son erróneos.",
                                                        "Error en el ingreso", JOptionPane.ERROR_MESSAGE);

                                } else {
                                        Jugador jugador1 = jugadorService.devolverJugadorValidado(nombreJugador1,
                                                        contrasenaJugador1);
                                        Jugador jugador2 = jugadorService.devolverJugadorValidado(nombreJugador2,
                                                        contrasenaJugador2);

                                        iniciarPartida(jugador1, jugador2);
                                }

                        } else if (opcionElegida == 1) {
                                String nombreJugador1 = JOptionPane.showInputDialog(null,
                                                "Jugador 1, ingresa tu nombre de usuario.",
                                                "Ingresa tu nombre de usuario.");
                                String contrasenaJugador1 = JOptionPane.showInputDialog(null,
                                                nombreJugador1 + ", ingresa tu contraseña", "Ingresa tu contraseña.");

                                String nombreJugador2 = JOptionPane.showInputDialog(null,
                                                "Jugador 2, ingresa tu nombre de usuario.",
                                                "Ingresa tu nombre de usuario.");

                                String contrasenaJugador2 = JOptionPane.showInputDialog(null,
                                                nombreJugador2 + ", ingresa tu contraseña", "Ingresa tu contraseña.");

                                if (jugadorService.nombresJugadoresDisponibles(nombreJugador1, nombreJugador2)) {
                                        String[] tiposMazo = { "Terrestre", "Acuatico" };

                                        int mazoElegidoJugador1 = JOptionPane.showOptionDialog(null,
                                                        nombreJugador1 + ", selecciona tu tipo de mazo.",
                                                        "Tipo de mazo", JOptionPane.DEFAULT_OPTION,
                                                        JOptionPane.QUESTION_MESSAGE, null, tiposMazo, 0);

                                        List<CartaInterface> mazoJugador1;
                                        List<CartaInterface> mazoJugador2;

                                        if (mazoElegidoJugador1 == 0) {

                                                mazoJugador1 = cartaService.seleccionarMazoCartas(tiposMazo[0],
                                                                animalService,
                                                                alimentoService, habilidadService, habitatService);
                                        } else {

                                                mazoJugador1 = cartaService.seleccionarMazoCartas(tiposMazo[1],
                                                                animalService,
                                                                alimentoService, habilidadService, habitatService);
                                        }

                                        int mazoElegidoJugador2 = JOptionPane.showOptionDialog(null,
                                                        nombreJugador2 + ", selecciona tu tipo de mazo.",
                                                        "Tipo de mazo", JOptionPane.DEFAULT_OPTION,
                                                        JOptionPane.QUESTION_MESSAGE, null, tiposMazo, 1);

                                        if (mazoElegidoJugador2 == 0) {

                                                mazoJugador2 = cartaService.seleccionarMazoCartas(tiposMazo[0],
                                                                animalService,
                                                                alimentoService, habilidadService, habitatService);

                                        } else {

                                                mazoJugador2 = cartaService.seleccionarMazoCartas(tiposMazo[1],
                                                                animalService,
                                                                alimentoService, habilidadService, habitatService);
                                        }

                                        Jugador jugador1 = jugadorService.crearJugadorGuardarloYDevolverlo(
                                                        nombreJugador1, contrasenaJugador1, mazoJugador1);
                                        Jugador jugador2 = jugadorService.crearJugadorGuardarloYDevolverlo(
                                                        nombreJugador2, contrasenaJugador2, mazoJugador2);

                                        iniciarPartida(jugador1, jugador2);

                                } else {
                                        JOptionPane.showMessageDialog(null,
                                                        "Alguno de los nombres ya existe en el sistema.",
                                                        "Nombre existente", JOptionPane.ERROR_MESSAGE);
                                }

                        } else if (opcionElegida == 2) {
                                String nombreJugadorRegistrado = JOptionPane.showInputDialog(null,
                                                "Jugador ya registrado, ingresa tu nombre de usuario.",
                                                "Ingresa tu nombre de usuario.");
                                String contrasenaJugadorRegistrado = JOptionPane.showInputDialog(null,
                                                nombreJugadorRegistrado + ", ingresa tu contraseña",
                                                "Ingresa tu contraseña.");

                                Jugador jugadorRegistrado = jugadorService.crearJugadorYDevolverlo(
                                                nombreJugadorRegistrado, contrasenaJugadorRegistrado);

                                if (jugadorService.validarJugador(nombreJugadorRegistrado,
                                                contrasenaJugadorRegistrado)) {

                                        jugadorRegistrado = jugadorService.validarJugadorYDevolverlo(
                                                        nombreJugadorRegistrado, contrasenaJugadorRegistrado);

                                        String nombreJugadorNuevo = JOptionPane.showInputDialog(null,
                                                        "Jugador nuevo, ingresa tu nombre de usuario.",
                                                        "Ingresa tu nombre de usuario.");
                                        String contrasenaJugadorNuevo = JOptionPane.showInputDialog(null,
                                                        nombreJugadorNuevo + ", ingresa tu contraseña",
                                                        "Ingresa tu contraseña.");

                                        if (jugadorService.nombreJugadorDisponible(nombreJugadorNuevo)) {

                                                String[] tiposMazo = { "Terrestre", "Acuatico" };

                                                int mazoElegido = JOptionPane.showOptionDialog(null,
                                                                nombreJugadorNuevo + ", selecciona tu tipo de mazo.",
                                                                "Tipo de mazo", JOptionPane.DEFAULT_OPTION,
                                                                JOptionPane.QUESTION_MESSAGE, null, tiposMazo, 0);

                                                List<CartaInterface> mazoJugadorNuevo = new ArrayList<CartaInterface>();

                                                if (mazoElegido == 0) {
                                                        mazoJugadorNuevo = cartaService.seleccionarMazoCartas(
                                                                        tiposMazo[0],
                                                                        animalService, alimentoService,
                                                                        habilidadService, habitatService);
                                                } else {
                                                        mazoJugadorNuevo = cartaService.seleccionarMazoCartas(
                                                                        tiposMazo[1],
                                                                        animalService, alimentoService,
                                                                        habilidadService, habitatService);
                                                }

                                                Jugador jugadorNuevo = jugadorService.crearJugadorGuardarloYDevolverlo(
                                                                nombreJugadorNuevo, contrasenaJugadorNuevo,
                                                                mazoJugadorNuevo);

                                                iniciarPartida(jugadorRegistrado, jugadorNuevo);

                                        } else {
                                                JOptionPane.showMessageDialog(null, "Ese nombre de usuario ya existe",
                                                                "Usuario ya existente", JOptionPane.WARNING_MESSAGE);
                                        }

                                } else {
                                        JOptionPane.showMessageDialog(null, "Uno o más datos ingresados son erróneos.",
                                                        "Error en el ingreso", JOptionPane.ERROR_MESSAGE);

                                }

                        }

                }
        }

        private void iniciarPartida(Jugador jugador1, Jugador jugador2) {

                jugador1.setTurno(1);
                jugador2.setTurno(1);

                cartaService.regresarTodasLasCartasAlMazo(jugador1);
                cartaService.regresarTodasLasCartasAlMazo(jugador2);

                jugador1.mezclarMazo();
                jugador2.mezclarMazo();

                JOptionPane.showMessageDialog(null,
                                "Ambos jugadores arracan con 25 cartas en su mazo, el jugador/a que se quede sin cartas en su mazo, perderá.",
                                "IMPORTANTE", JOptionPane.WARNING_MESSAGE);

                JOptionPane.showMessageDialog(null, "Ambos jugadores roban su mano inicial.", "Primer Turno",
                                JOptionPane.INFORMATION_MESSAGE);

                while (jugador1.tieneCartasElMazo() && jugador2.tieneCartasElMazo()) {
                        iniciarTurno(jugador1, jugador2);

                        if (!jugador2.tieneCartasElMazo()) {

                        } else {
                                iniciarTurno(jugador2, jugador1);

                        }

                }

                if (!jugador1.tieneCartasElMazo()) {
                        JOptionPane.showMessageDialog(null,
                                        "El jugador " + jugador1.getNombre() + " se ha quedado sin cartas.");
                        JOptionPane.showMessageDialog(null,
                                        "¡Felicitaciones " + jugador2.getNombre() + " has ganado esta partida!");

                } else if (!jugador2.tieneCartasElMazo()) {
                        JOptionPane.showMessageDialog(null,
                                        "El jugador " + jugador2.getNombre() + " se ha quedado sin cartas.");
                        JOptionPane.showMessageDialog(null,
                                        "¡Felicitaciones " + jugador1.getNombre() + " has ganado esta partida!");

                }

                JOptionPane.showMessageDialog(null,
                                "Si quieren jugar otra partida los 2, logueense. Sino pueden registrar a uno o más jugadores nuevos o salir.");
        }

        private void iniciarTurno(Jugador jugadorActual, Jugador jugadorEnemigo) {

                jugadorActual.setPuedeAtacar(true);

                if (jugadorActual.getTurno() == 1) {

                        iniciarPrimerTurno(jugadorActual);

                } else if (jugadorActual.getTurno() == 2) {
                        iniciarSegundoTurno(jugadorActual);

                } else {
                        iniciarTercerTurnoEnAdelante(jugadorActual, jugadorEnemigo);
                }

                jugadorActual.setTurno(jugadorActual.getTurno() + 1);

        }

        private void iniciarPrimerTurno(Jugador jugadorActual) {

                int manoInicial = 4;

                cartaService.robarCartasDelMazo(jugadorActual, manoInicial);
        }

        private void iniciarSegundoTurno(Jugador jugadorActual) {
                String[] opcionesTurno = { "Bajar una carta", "Activar un efecto", "Pasar" };

                int opcionElegida = JOptionPane.showOptionDialog(null,
                                "Turno" + jugadorActual.getTurno() + "- ¿" + jugadorActual.getNombre()
                                                + " qué deseas hacer?",
                                "Turno " + jugadorActual.getTurno(), JOptionPane.DEFAULT_OPTION,
                                JOptionPane.QUESTION_MESSAGE, null, opcionesTurno, 2);

                while (opcionElegida != 2) {
                        if (opcionElegida == 0) {
                                bajarUnaCartaAlTablero(jugadorActual);

                        } else if (opcionElegida == 1) {
                                JOptionPane.showMessageDialog(null, "Aún no codeado", "Aun no codeado",
                                                JOptionPane.ERROR_MESSAGE);
                        }

                        opcionElegida = JOptionPane.showOptionDialog(null,
                                        "Turno " + jugadorActual.getTurno() + ". ¿" + jugadorActual.getNombre()
                                                        + " que deseas hacer?",
                                        "Turno " + jugadorActual.getTurno(), JOptionPane.DEFAULT_OPTION,
                                        JOptionPane.QUESTION_MESSAGE, null, opcionesTurno, 2);
                }

                cartaService.robarCartasDelMazo(jugadorActual, 1);

                JOptionPane.showMessageDialog(null, jugadorActual.getNombre() + " haz robado 1 carta. \nFin de turno.");

        }

        private void iniciarTercerTurnoEnAdelante(Jugador jugadorActual, Jugador jugadorEnemigo) {

                animalService.pasarAnimalesEnBatallaAReposo(jugadorActual);
                alimentoService.pasarAlimentosConsumidosAReserva(jugadorActual);

                animalService.reiniciarEfectosManualesDeAnimales(jugadorActual);
                animalService.activarPasivamenteEfectoAnimal(jugadorActual, cartaService);

                animalService.descontarContadorTurnoDeHabilidades(jugadorActual);
                animalService.permitirAtaqueAnimal(jugadorActual);

                animalService.removerIndestructibleAnimal(jugadorActual);

                jugadorActual.setPuedeAtacar(true);

                String[] opcionesTurno = { "Bajar una carta", "Atacar", "Activar un efecto",
                                "Inspeccionar Zona de Juego", "Pasar" };

                int opcionElegida = JOptionPane.showOptionDialog(null,
                                "Turno " + jugadorActual.getTurno() + ". ¿" + jugadorActual.getNombre()
                                                + " qué deseas hacer?",
                                "Turno " + jugadorActual.getNombre(), JOptionPane.DEFAULT_OPTION,
                                JOptionPane.QUESTION_MESSAGE, null, opcionesTurno, 2);

                while (opcionElegida != 4) {
                        if (opcionElegida == 0) {
                                bajarUnaCartaAlTablero(jugadorActual);
                                animalService.activarPasivamenteEfectoAnimal(jugadorActual, cartaService);

                        } else if (opcionElegida == 1) {
                                if (jugadorActual.isPuedeAtacar()) {
                                        atacar(jugadorActual, jugadorEnemigo);
                                } else {
                                        JOptionPane.showMessageDialog(null,
                                                        "En este momento no puedes realizar ataques.",
                                                        "Ataque prohibido", JOptionPane.WARNING_MESSAGE);
                                }

                        } else if (opcionElegida == 2) {

                                String[] opcionesEfecto = { "Animal en Reposo", "Habilidad en Mano", "Habitat en Apoyo",
                                                "Volver" };

                                int opcionEfectoElegida = JOptionPane.showOptionDialog(null,
                                                "¿Dónde se encuentra el efecto que quieres activar?",
                                                "Activar Efecto", JOptionPane.DEFAULT_OPTION,
                                                JOptionPane.QUESTION_MESSAGE, null, opcionesEfecto, 0);

                                switch (opcionEfectoElegida) {
                                        case 0:
                                                activarEfectoAnimalEnReposo(jugadorActual, jugadorEnemigo);
                                                break;

                                        case 1:

                                                activarEfectoHabilidad(jugadorActual, jugadorEnemigo);

                                                break;

                                        case 2:
                                                // habitat

                                                break;

                                        default:
                                                break;
                                }

                        } else if (opcionElegida == 3) {
                                inspeccionarZonaJuego(jugadorActual, jugadorEnemigo);
                        }

                        opcionElegida = JOptionPane.showOptionDialog(null,
                                        "Turno " + jugadorActual.getTurno() + ". ¿" + jugadorActual.getNombre()
                                                        + " qué deseas hacer?",
                                        "Turno " + jugadorActual.getNombre(), JOptionPane.DEFAULT_OPTION,
                                        JOptionPane.QUESTION_MESSAGE, null, opcionesTurno, 2);

                }

                cartaService.robarCartasDelMazo(jugadorActual, 1);
                JOptionPane.showMessageDialog(null, jugadorActual.getNombre() + " te quedan: "
                                + jugadorActual.getCantidadCartasMazo() + " cartas en tu mazo.");
                JOptionPane.showMessageDialog(null, "Fin de turno " + jugadorActual.getTurno(), "Fin Turno",
                                JOptionPane.INFORMATION_MESSAGE, null);

        }

        private void bajarUnaCartaAlTablero(Jugador jugadorActual) {

                int alimentosDisponibles = alimentoService.devolverCantidadAlimentosReserva(jugadorActual);

                String descripcionCartasMano = cartaService
                                .devolverDescripcionCartasDisponiblesParaBajar(jugadorActual, alimentosDisponibles);

                JScrollPane descripcionCartasManoConScroll = jScrollPaneService
                                .instanciarJScrollPaneParaExpandirMensaje(new JTextArea(), descripcionCartasMano);

                if (descripcionCartasMano.equalsIgnoreCase("Sin cartas")) {
                        JOptionPane.showMessageDialog(null,
                                        "Actualmente no tienes cartas disponibles para bajar al tablero.",
                                        "Sin cartas disponibles", JOptionPane.WARNING_MESSAGE);
                } else {

                        List<Integer> idsCartasMano = cartaService.devolverIdsCartasDisponiblesParaBajar(jugadorActual,
                                        alimentosDisponibles);

                        Object[] arrayCartasMano = idsCartasMano.toArray();

                        Integer cartaElegida = JOptionPane.showOptionDialog(null, descripcionCartasManoConScroll,
                                        "Cartas disponibles para bajar al tablero",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                                        null, arrayCartasMano, 0);

                        for (Integer integer : idsCartasMano) {
                                if (arrayCartasMano[cartaElegida] == integer) {
                                        cartaService.bajarCartaAlTableroPorId(jugadorActual,
                                                        integer, alimentoService);

                                }
                        }
                }
        }

        private void atacar(Jugador jugadorActual, Jugador jugadorEnemigo) {
                int animalesReposoAtacante = cartaService
                                .devovlerCantidadCartasEnZona(jugadorActual.getAnimalesEnReposo());

                if (animalesReposoAtacante == 0) {
                        JOptionPane.showMessageDialog(null,
                                        jugadorActual.getNombre()
                                                        + " actualmente no tienes animales disponibles para atacar",
                                        "Sin animales reposando", JOptionPane.WARNING_MESSAGE);
                } else {

                        String descripcionAnimalesReposo = cartaService
                                        .devolverCartasEnZonaComoMensaje(jugadorActual.getAnimalesEnReposo());

                        JScrollPane descripcionAnimalesReposoConScroll = jScrollPaneService
                                        .instanciarJScrollPaneParaExpandirMensaje(new JTextArea(),
                                                        descripcionAnimalesReposo);

                        List<Integer> idsAnimalesReposo = animalService.devolverIdsAnimalesEnReposo(jugadorActual);

                        Object[] arrayIdsAnimalesEnReposo = idsAnimalesReposo.toArray();

                        Integer cartaElegida = JOptionPane.showOptionDialog(null, descripcionAnimalesReposoConScroll,
                                        "Animales para atacar",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                                        null, arrayIdsAnimalesEnReposo, 0);

                        CartaInterface animalAtacante = null;

                        for (Integer idAnimalEnReposo : idsAnimalesReposo) {
                                if (arrayIdsAnimalesEnReposo[cartaElegida] == idAnimalEnReposo) {
                                        animalAtacante = animalService.pasarYDevolverAnimalEnReposoABatallaPorId(
                                                        jugadorActual, idAnimalEnReposo);
                                }
                        }

                        Animal animal = (Animal) animalAtacante;

                        if (animal.isPuedeBatallar()) {
                                JOptionPane.showMessageDialog(null,
                                                jugadorEnemigo.getNombre() + ", el jugador "
                                                                + jugadorActual.getNombre()
                                                                + " ha decidido atacar con el siguiente animal.",
                                                "¡Te atacan!", JOptionPane.WARNING_MESSAGE);

                                String descripcionCarta = cartaService.devolverDescripcionCarta(animalAtacante);

                                JOptionPane.showMessageDialog(null, descripcionCarta, "Animal Atacante",
                                                JOptionPane.WARNING_MESSAGE);

                                String[] opcionesDefensa = { "Defender", "Activar efecto", "Dejar pasar daño"
                                };

                                int decisionDefensa = JOptionPane.showOptionDialog(null,
                                                "¿Vas a defender el ataque del atacante?", "Ataque entrante",
                                                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
                                                opcionesDefensa,
                                                0);

                                if (decisionDefensa == 0) {

                                        int cantidadAnimalesEnReposoDefensa = cartaService.devovlerCantidadCartasEnZona(
                                                        jugadorEnemigo.getAnimalesEnReposo());

                                        if (cantidadAnimalesEnReposoDefensa == 0) {
                                                JOptionPane.showMessageDialog(null, jugadorEnemigo.getNombre()
                                                                + " actualmente no tienes animales disponibles para defender",
                                                                "Sin animales reposando", JOptionPane.WARNING_MESSAGE);

                                                int dañoAnimalAtacante = animalService
                                                                .mandarCartasAlCementerioPorAnimalAtacanteYDevolverDano(
                                                                                jugadorEnemigo, animalAtacante);

                                                JOptionPane.showMessageDialog(null,
                                                                jugadorEnemigo.getNombre() + " ha botado "
                                                                                + dañoAnimalAtacante
                                                                                + " cartas de su mazo.\nLe quedan: "
                                                                                + jugadorEnemigo.getCantidadCartasMazo()
                                                                                + " cartas en su mazo.",
                                                                "Daño recibido", JOptionPane.WARNING_MESSAGE);

                                        } else {

                                                String descripcionAnimalesDefensoresReposo = cartaService
                                                                .devolverCartasEnZonaComoMensaje(
                                                                                jugadorEnemigo.getAnimalesEnReposo());

                                                List<Integer> idsAnimalesDefensoresReposo = animalService
                                                                .devolverIdsAnimalesEnReposo(jugadorEnemigo);

                                                Object[] arrayIdsAnimalesDefensoresEnReposo = idsAnimalesDefensoresReposo
                                                                .toArray();

                                                Integer cartaDefensoraElegida = JOptionPane.showOptionDialog(null,
                                                                descripcionAnimalesDefensoresReposo,
                                                                "Animales para defender",
                                                                JOptionPane.DEFAULT_OPTION,
                                                                JOptionPane.INFORMATION_MESSAGE,
                                                                null, arrayIdsAnimalesDefensoresEnReposo, 0);

                                                CartaInterface animalDefensor = null;

                                                for (Integer idAnimalDefensorEnReposo : idsAnimalesDefensoresReposo) {
                                                        if (arrayIdsAnimalesDefensoresEnReposo[cartaDefensoraElegida] == idAnimalDefensorEnReposo) {
                                                                animalDefensor = animalService
                                                                                .pasarYDevolverAnimalEnReposoABatallaPorId(
                                                                                                jugadorEnemigo,
                                                                                                idAnimalDefensorEnReposo);
                                                        }
                                                }

                                                int calculoDaño = animalService.calcularDañoCombate(animalAtacante,
                                                                animalDefensor);

                                                Animal atacante = (Animal) animalAtacante;
                                                Animal defensor = (Animal) animalDefensor;

                                                if (calculoDaño < 0) {
                                                        animalService.mandarCartasAlCementerioPorCalculoDaño(
                                                                        jugadorActual,
                                                                        Math.abs(calculoDaño));

                                                        if (!atacante.isIndestructible()) {
                                                                JOptionPane.showMessageDialog(null,
                                                                                jugadorActual.getNombre()
                                                                                                + " ha botado "
                                                                                                + Math.abs(calculoDaño)
                                                                                                + " cartas de su mazo.\nEl animal atacante ha sido destruido. \nLe quedan: "
                                                                                                + jugadorActual.getCantidadCartasMazo()
                                                                                                + " cartas en su mazo.",
                                                                                "Daño recibido",
                                                                                JOptionPane.ERROR_MESSAGE);
                                                        } else {
                                                                JOptionPane.showMessageDialog(null,
                                                                                jugadorActual.getNombre()
                                                                                                + " ha botado "
                                                                                                + Math.abs(calculoDaño)
                                                                                                + " cartas de su mazo.\nEl animal atacante no ha sido destruido por ser indestructible. \nLe quedan: "
                                                                                                + jugadorActual.getCantidadCartasMazo()
                                                                                                + " cartas en su mazo.",
                                                                                "Daño recibido",
                                                                                JOptionPane.ERROR_MESSAGE);
                                                        }

                                                } else if (calculoDaño == 0) {
                                                        if (!atacante.isIndestructible()
                                                                        && !defensor.isIndestructible()) {
                                                                JOptionPane.showMessageDialog(null,
                                                                                "El calculo de daño ha dado "
                                                                                                + calculoDaño
                                                                                                + " y por esta razón ninguno de los jugadores ha botado cartas de su mazo.\nAmbos animales han sido destruidos en la batalla.",
                                                                                "Daño igualado",
                                                                                JOptionPane.INFORMATION_MESSAGE);
                                                        } else if (atacante.isIndestructible()
                                                                        && !defensor.isIndestructible()) {
                                                                JOptionPane.showMessageDialog(null,
                                                                                "El calculo de daño ha dado "
                                                                                                + calculoDaño
                                                                                                + " y por esta razón ninguno de los jugadores ha botado cartas de su mazo.\nEl animal atacante no ha sido destruido por ser indestructible.\nEl animal defensor ha sido destruido.",
                                                                                "Daño igualado",
                                                                                JOptionPane.INFORMATION_MESSAGE);
                                                        } else if (!atacante.isIndestructible()
                                                                        && defensor.isIndestructible()) {
                                                                JOptionPane.showMessageDialog(null,
                                                                                "El calculo de daño ha dado "
                                                                                                + calculoDaño
                                                                                                + " y por esta razón ninguno de los jugadores ha botado cartas de su mazo.\nEl animal defensor no ha sido destruido por ser indestructible.\nEl animal atacante ha sido destruido.",
                                                                                "Daño igualado",
                                                                                JOptionPane.INFORMATION_MESSAGE);
                                                        } else if (atacante.isIndestructible()
                                                                        && defensor.isIndestructible()) {
                                                                JOptionPane.showMessageDialog(null,
                                                                                "El calculo de daño ha dado "
                                                                                                + calculoDaño
                                                                                                + " y por esta razón ninguno de los jugadores ha botado cartas de su mazo.\nNingún animal ha sido destruido por ser ambos indestructibles.",
                                                                                "Daño igualado",
                                                                                JOptionPane.INFORMATION_MESSAGE);
                                                        }

                                                } else if (calculoDaño > 0) {
                                                        animalService.mandarCartasAlCementerioPorCalculoDaño(
                                                                        jugadorEnemigo,
                                                                        calculoDaño);
                                                        JOptionPane.showMessageDialog(null,
                                                                        jugadorEnemigo.getNombre() + " ha botado "
                                                                                        + calculoDaño
                                                                                        + " cartas de su mazo.\nEl animal defensor ha sido destruido.\n Le quedan: "
                                                                                        + jugadorEnemigo.getCantidadCartasMazo()
                                                                                        + " cartas en su mazo.",
                                                                        "Daño recibido", JOptionPane.WARNING_MESSAGE);

                                                }

                                        }

                                } else if (decisionDefensa == 1) {

                                        String[] opcionesEfectos = { "Habilidad", "Animal", "Volver" };

                                        int opcionElegida = JOptionPane.showOptionDialog(null,
                                                        "¿En qué zona se encentra el efecto que quieres activar?",
                                                        "Activar un efecto", JOptionPane.DEFAULT_OPTION,
                                                        JOptionPane.QUESTION_MESSAGE, null, opcionesEfectos, 0);

                                        switch (opcionElegida) {
                                                case 0:

                                                        break;

                                                case 1:

                                                        String[] locacionEfecto = { "Línea de Reposo",
                                                                        "Línea de Batalla" };

                                                        int locacionAnimal = JOptionPane.showOptionDialog(null,
                                                                        "¿Dónde se encuentra el efecto animal que quieres activar?",
                                                                        "Efecto defensivo animal",
                                                                        JOptionPane.DEFAULT_OPTION,
                                                                        JOptionPane.QUESTION_MESSAGE, null,
                                                                        locacionEfecto, 0);

                                                        String descripcionAnimalEnemigo = "";

                                                        List<Integer> idsAnimalesConEfectoManualDefensivo = null;

                                                        switch (locacionAnimal) {
                                                                case 0:
                                                                        descripcionAnimalEnemigo = cartaService
                                                                                        .devolverCartasEnZonaComoMensaje(
                                                                                                        jugadorEnemigo.getAnimalesEnReposo());

                                                                        idsAnimalesConEfectoManualDefensivo = animalService
                                                                                        .devolverIdsAnimalesConEfectoManualDefensivo(
                                                                                                        jugadorEnemigo.getAnimalesEnReposo());
                                                                        break;

                                                                case 1:
                                                                        descripcionAnimalEnemigo = cartaService
                                                                                        .devolverCartasEnZonaComoMensaje(
                                                                                                        jugadorEnemigo.getAnimalesEnBatalla());

                                                                        idsAnimalesConEfectoManualDefensivo = animalService
                                                                                        .devolverIdsAnimalesConEfectoManualDefensivo(
                                                                                                        jugadorEnemigo.getAnimalesEnBatalla());

                                                                        break;

                                                                default:
                                                                        break;
                                                        }

                                                        JScrollPane descripcionAnimalEnemigoScroll = jScrollPaneService
                                                                        .instanciarJScrollPaneParaExpandirMensaje(
                                                                                        new JTextArea(),
                                                                                        descripcionAnimalEnemigo);

                                                        Object[] arrayAnimalesConEfectoManualDefensivo = idsAnimalesConEfectoManualDefensivo
                                                                        .toArray();

                                                        Integer animalDefensorElegido = JOptionPane.showOptionDialog(
                                                                        null,
                                                                        descripcionAnimalEnemigoScroll,
                                                                        "Activar efecto animal defensivo manualmente",
                                                                        JOptionPane.DEFAULT_OPTION,
                                                                        JOptionPane.INFORMATION_MESSAGE,
                                                                        null, arrayAnimalesConEfectoManualDefensivo, 0);

                                                        CartaInterface animalConEfectoManual = null;

                                                        for (Integer id : idsAnimalesConEfectoManualDefensivo) {

                                                                if (arrayAnimalesConEfectoManualDefensivo[animalDefensorElegido] == id) {

                                                                        if (locacionAnimal == 0) {
                                                                                animalConEfectoManual = animalService
                                                                                                .devolverAnimalSeleccionadoPorId(
                                                                                                                jugadorEnemigo.getAnimalesEnReposo(),
                                                                                                                id);
                                                                        } else if (locacionAnimal == 1) {
                                                                                animalConEfectoManual = animalService
                                                                                                .devolverAnimalSeleccionadoPorId(
                                                                                                                jugadorEnemigo.getAnimalesEnBatalla(),
                                                                                                                id);
                                                                        }

                                                                }
                                                        }

                                                        animalService.activarEfectoTortugaMarinaManualmente(
                                                                        animalConEfectoManual, jugadorActual);

                                                        int dañoAnimalAtacante = animalService
                                                                        .mandarCartasAlCementerioPorAnimalAtacanteYDevolverDano(
                                                                                        jugadorEnemigo, animalAtacante);

                                                        JOptionPane.showMessageDialog(null, jugadorEnemigo.getNombre() +
                                                                        " ha botado "
                                                                        + dañoAnimalAtacante
                                                                        + " cartas de su mazo.\nLe quedan: "
                                                                        + jugadorEnemigo.getCantidadCartasMazo()
                                                                        + " cartas en su mazo.",
                                                                        "Daño recibido", JOptionPane.WARNING_MESSAGE);

                                                        JOptionPane.showMessageDialog(null, "El jugador "
                                                                        + jugadorActual.getNombre()
                                                                        + " no puede atacar más por este turno.",
                                                                        "Cese de ataque", JOptionPane.WARNING_MESSAGE);

                                                        break;

                                                default:
                                                        break;
                                        }

                                } else if (decisionDefensa == 2) {

                                        int dañoAnimalAtacante = animalService
                                                        .mandarCartasAlCementerioPorAnimalAtacanteYDevolverDano(
                                                                        jugadorEnemigo, animalAtacante);
                                        JOptionPane.showMessageDialog(null, jugadorEnemigo.getNombre() +
                                                        " ha botado "
                                                        + dañoAnimalAtacante + " cartas de su mazo.\nLe quedan: "
                                                        + jugadorEnemigo.getCantidadCartasMazo()
                                                        + " cartas en su mazo.",
                                                        "Daño recibido", JOptionPane.WARNING_MESSAGE);
                                }
                        } else {
                                JOptionPane.showMessageDialog(null,
                                                "El animal seleccionado no puede atacar en este momento.\nLe quedan: "
                                                                + animal.getContador() + " turnos capturado. ",
                                                "Animal capturado", JOptionPane.WARNING_MESSAGE);
                        }

                }

        }

        private void inspeccionarZonaJuego(Jugador jugadorActual, Jugador jugadorEnemigo) {
                String[] zonasJuego = { "Mi mano", "Mi Tablero", "Tablero enemigo", "Volver" };

                int zonaElegida = JOptionPane.showOptionDialog(null, "¿Qué zona de juego quieres inspeccionar?",
                                "Zonas de Juego", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                                zonasJuego, 1);

                String descripcionCartasZona = "";

                switch (zonaElegida) {

                        case 0:
                                descripcionCartasZona = cartaService
                                                .devolverCartasEnZonaComoMensaje(jugadorActual.getCartasMano());
                                break;

                        case 1:
                                String[] zonasTableroAliado = { "Linea de Reposo", "Linea de Batalla", "Linea de Apoyo",
                                                "Cementerio", "Alimentos en Reserva", "Alimentos Consumidos",
                                                "Volver" };

                                int zonaTableroAliadoElegida = JOptionPane.showOptionDialog(null,
                                                "¿Qué parte de tu tablero quieres inspeccionar?", "Tablero",
                                                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                                                zonasTableroAliado, 0);

                                switch (zonaTableroAliadoElegida) {
                                        case 0:
                                                descripcionCartasZona = cartaService.devolverCartasEnZonaComoMensaje(
                                                                jugadorActual.getAnimalesEnReposo());
                                                break;

                                        case 1:
                                                descripcionCartasZona = cartaService.devolverCartasEnZonaComoMensaje(
                                                                jugadorActual.getAnimalesEnBatalla());
                                                break;

                                        case 2:
                                                descripcionCartasZona = cartaService.devolverCartasEnZonaComoMensaje(
                                                                jugadorActual.getHabitatsEnApoyo());

                                        case 3:
                                                descripcionCartasZona = cartaService.devolverCartasEnZonaComoMensaje(
                                                                jugadorActual.getCartasCementerio());
                                                break;

                                        case 4:
                                                descripcionCartasZona = cartaService.devolverCartasEnZonaComoMensaje(
                                                                jugadorActual.getAlimentosEnReserva());
                                                break;

                                        case 5:
                                                descripcionCartasZona = cartaService.devolverCartasEnZonaComoMensaje(
                                                                jugadorActual.getAlimentosConsumidos());
                                                break;

                                        default:
                                                break;
                                }
                                break;

                        case 2:
                                String[] zonasTableroEnemigo = { "Linea de Reposo", "Linea de Batalla",
                                                "Linea de Apoyo", "Cementerio", "Alimentos en Reserva",
                                                "Alimentos Consumidos", "Volver" };
                                int zonaTableroEnemigoElegida = JOptionPane.showOptionDialog(null,
                                                "¿Qué parte del tablero enemigo quieres inspeccionar?", "Tablero",
                                                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                                                zonasTableroEnemigo, 0);

                                switch (zonaTableroEnemigoElegida) {
                                        case 0:
                                                descripcionCartasZona = cartaService.devolverCartasEnZonaComoMensaje(
                                                                jugadorEnemigo.getAnimalesEnReposo());
                                                break;

                                        case 1:
                                                descripcionCartasZona = cartaService.devolverCartasEnZonaComoMensaje(
                                                                jugadorEnemigo.getAnimalesEnBatalla());
                                                break;

                                        case 2:
                                                descripcionCartasZona = cartaService.devolverCartasEnZonaComoMensaje(
                                                                jugadorEnemigo.getHabitatsEnApoyo());
                                                break;

                                        case 3:
                                                descripcionCartasZona = cartaService.devolverCartasEnZonaComoMensaje(
                                                                jugadorEnemigo.getCartasCementerio());

                                        case 4:
                                                descripcionCartasZona = cartaService.devolverCartasEnZonaComoMensaje(
                                                                jugadorEnemigo.getAlimentosEnReserva());
                                                break;

                                        case 5:
                                                descripcionCartasZona = cartaService.devolverCartasEnZonaComoMensaje(
                                                                jugadorEnemigo.getAlimentosConsumidos());
                                                break;

                                        default:
                                                break;
                                }
                                break;
                        default:
                                break;
                }

                if (descripcionCartasZona.equalsIgnoreCase("Sin cartas")) {
                        JOptionPane.showMessageDialog(null,
                                        "Actualmente no hay cartas en esta zona de juego.",
                                        "Zona vacia", JOptionPane.WARNING_MESSAGE);
                } else {

                        JScrollPane descripcionCartasZonaConScroll = jScrollPaneService
                                        .instanciarJScrollPaneParaExpandirMensaje(
                                                        new JTextArea(),
                                                        descripcionCartasZona);

                        JOptionPane.showMessageDialog(null, descripcionCartasZonaConScroll, "Cartas en esta zona",
                                        JOptionPane.INFORMATION_MESSAGE);

                }
        }

        private void activarEfectoAnimalEnReposo(Jugador jugadorActual, Jugador jugadorEnemigo) {

                if (jugadorActual.getAnimalesEnReposo().size() == 0) {
                        JOptionPane.showMessageDialog(null,
                                        "Actualmente no hay cartas en esta zona de juego.",
                                        "Zona vacia", JOptionPane.WARNING_MESSAGE);
                } else if (animalService.devolverCantidadAnimalesConEfectoManual(jugadorActual) == 0) {

                        JOptionPane.showMessageDialog(null,
                                        "Actualmente no tienes animales con efecto manual en esta zona de juego.",
                                        "Zona vacia", JOptionPane.WARNING_MESSAGE);
                } else {

                        String descripcionAnimalesReposoConEfectoManualOfensivo = cartaService
                                        .devolverDescripcionAnimalesEnReposoConEfectoManualOfensivo(
                                                        jugadorActual.getAnimalesEnReposo());

                        JScrollPane descripcionConScrollPane = jScrollPaneService
                                        .instanciarJScrollPaneParaExpandirMensaje(
                                                        new JTextArea(),
                                                        descripcionAnimalesReposoConEfectoManualOfensivo);

                        List<Integer> idsAnimalesReposoConEfectoManualOfensivo = animalService
                                        .devolverIdsAnimalesConEfectoManualOfensivo(
                                                        jugadorActual.getAnimalesEnReposo());

                        Object[] arrayAnimalesEnReposoConEfectoManualOfensivo = idsAnimalesReposoConEfectoManualOfensivo
                                        .toArray();

                        Integer cartaElegida = JOptionPane.showOptionDialog(null,
                                        descripcionConScrollPane,
                                        "Activar Efecto Animal Manualmente",
                                        JOptionPane.DEFAULT_OPTION,
                                        JOptionPane.INFORMATION_MESSAGE,
                                        null, arrayAnimalesEnReposoConEfectoManualOfensivo, 0);

                        CartaInterface animalConEfectoManualOfensivo = null;

                        for (Integer id : idsAnimalesReposoConEfectoManualOfensivo) {

                                if (arrayAnimalesEnReposoConEfectoManualOfensivo[cartaElegida] == id) {
                                        animalConEfectoManualOfensivo = animalService
                                                        .devolverAnimalSeleccionadoPorId(
                                                                        jugadorActual.getAnimalesEnReposo(),
                                                                        id);
                                }
                        }

                        switch (animalConEfectoManualOfensivo.getNombre()) {

                                case "Camaleón":

                                        String descripcionAnimalesEnemigosEnReposo = cartaService
                                                        .devolverCartasEnZonaComoMensaje(
                                                                        jugadorEnemigo.getAnimalesEnReposo());

                                        List<Integer> idsAnimalesEnemigosEnReposo = animalService
                                                        .devolverIdsAnimalesEnReposo(
                                                                        jugadorEnemigo);

                                        Object[] arrayAnimalesEnemigosEnReposo = idsAnimalesEnemigosEnReposo
                                                        .toArray();

                                        Integer animalSeleccionado = JOptionPane
                                                        .showOptionDialog(null,
                                                                        "¿De qué animal enemigo en reposo quieres tomar el ataque? \n"
                                                                                        + descripcionAnimalesEnemigosEnReposo,
                                                                        "Activar efecto Camaleón",
                                                                        JOptionPane.DEFAULT_OPTION,
                                                                        JOptionPane.QUESTION_MESSAGE,
                                                                        null,
                                                                        arrayAnimalesEnemigosEnReposo,
                                                                        0);

                                        CartaInterface animalEnemigoElegido = null;

                                        for (Integer id : idsAnimalesEnemigosEnReposo) {
                                                if (arrayAnimalesEnemigosEnReposo[animalSeleccionado] == id) {
                                                        animalEnemigoElegido = animalService
                                                                        .devolverAnimalSeleccionadoPorId(
                                                                                        jugadorEnemigo.getAnimalesEnReposo(),
                                                                                        id);
                                                        animalService.activarEfectoCamaleonManualmente(
                                                                        animalConEfectoManualOfensivo,
                                                                        animalEnemigoElegido);
                                                }
                                        }

                                        break;

                                case "Mantis Orquídea":
                                        int cantidadAlimentosActuales = alimentoService
                                                        .devolverCantidadAlimentosReserva(
                                                                        jugadorActual);

                                        if (cantidadAlimentosActuales < 2) {
                                                JOptionPane.showMessageDialog(null,
                                                                "Actualmente no tienes la cantidad de alimentos disponibles para activar esta habilidad");
                                        } else {

                                                List<Integer> listaAlimentosAConsumir = new ArrayList<Integer>();

                                                for (int i = 2; i <= cantidadAlimentosActuales; i++) {
                                                        listaAlimentosAConsumir.add(i);
                                                }

                                                Object[] arrayAlimentosAConsumir = listaAlimentosAConsumir.toArray();

                                                int alimentosAConsumir = JOptionPane.showOptionDialog(null,
                                                                "Actualmente tienes "
                                                                                + cantidadAlimentosActuales
                                                                                + " alimentos en tu reserva. ¿Qué cantidad deseas consumir?",
                                                                "Alimentos a Consumir", JOptionPane.DEFAULT_OPTION,
                                                                JOptionPane.QUESTION_MESSAGE, null,
                                                                arrayAlimentosAConsumir, 0);

                                                alimentosAConsumir += 2;

                                                if (alimentosAConsumir <= cantidadAlimentosActuales) {
                                                        int cantidadCartasARevivir = cartaService
                                                                        .devolverCantidadCartasARevivirPorCantidadAlimentos(
                                                                                        alimentosAConsumir);

                                                        JOptionPane.showMessageDialog(null,
                                                                        "Con esta cantidad de alimentos, vas a poder revivir "
                                                                                        + cantidadCartasARevivir
                                                                                        + " cartas de tu cementerio.");

                                                        List<CartaInterface> cartasARevivir = new ArrayList<CartaInterface>();
                                                        List<Integer> idsCartasARevivir = new ArrayList<Integer>();

                                                        for (int i = 0; i < cantidadCartasARevivir; i++) {

                                                                if (cartasARevivir.size() > 0) {
                                                                        for (CartaInterface carta : cartasARevivir) {
                                                                                idsCartasARevivir.add(carta.getId());
                                                                        }
                                                                }
                                                                String descripcionCartasEnCementerio = cartaService
                                                                                .devolverCartasEnZonaComoMensaje(
                                                                                                jugadorActual.getCartasCementerio());

                                                                JScrollPane descripcionCartasEnCementerioConScroll = jScrollPaneService
                                                                                .instanciarJScrollPaneParaExpandirMensaje(
                                                                                                new JTextArea(),
                                                                                                descripcionCartasEnCementerio);

                                                                List<Integer> listIdsCartasCementerio = cartaService
                                                                                .devolverIDsCartasEnZona(
                                                                                                jugadorActual.getCartasCementerio());

                                                                listIdsCartasCementerio.removeAll(idsCartasARevivir);

                                                                Object[] arrayIdsCartasCementerio = listIdsCartasCementerio
                                                                                .toArray();

                                                                Integer cartaSeleccionada = JOptionPane
                                                                                .showOptionDialog(null,
                                                                                                descripcionCartasEnCementerioConScroll,
                                                                                                "Cartas en tu cementerio",
                                                                                                JOptionPane.DEFAULT_OPTION,
                                                                                                JOptionPane.QUESTION_MESSAGE,
                                                                                                null,
                                                                                                arrayIdsCartasCementerio,
                                                                                                0);

                                                                for (Integer id : listIdsCartasCementerio) {
                                                                        if (arrayIdsCartasCementerio[cartaSeleccionada] == id) {
                                                                                CartaInterface cartaActual = cartaService
                                                                                                .devolverCartaSeleccionadoPorId(
                                                                                                                jugadorActual.getCartasCementerio(),
                                                                                                                id);
                                                                                cartasARevivir.add(cartaActual);

                                                                        }
                                                                }

                                                        }

                                                        animalService.activarEfectoMantisOrquideaManualmente(
                                                                        animalConEfectoManualOfensivo,
                                                                        jugadorActual,
                                                                        alimentosAConsumir, alimentoService,
                                                                        cartasARevivir);

                                                } else {
                                                        JOptionPane.showMessageDialog(null,
                                                                        "Actualmente no tienes esa cantidad de alimentos para consumir. ");
                                                }
                                        }
                                        break;

                                case "Pulpo":

                                        Animal pulpo = (Animal) animalConEfectoManualOfensivo;

                                        List<Integer> opcionesDanoPulpo = new ArrayList<Integer>();
                                        for (int i = 1; i <= pulpo.getDano(); i++) {
                                                opcionesDanoPulpo.add(i);
                                        }

                                        Object[] arrayOpcionesPulpo = opcionesDanoPulpo.toArray();

                                        int danoAPerder = JOptionPane.showOptionDialog(null, "Tu Pulpo tiene: "
                                                        + pulpo.getDano()
                                                        + " puntos de daño actualmente."
                                                        + ". \n¿Cuántos puntos de daños deseas que pierda?",
                                                        "Daño Pulpo", JOptionPane.DEFAULT_OPTION,
                                                        JOptionPane.QUESTION_MESSAGE, null, arrayOpcionesPulpo, 0);

                                        danoAPerder += 1;

                                        List<CartaInterface> cartasParaMazo = new ArrayList<CartaInterface>();
                                        List<Integer> idsCartasParaMazo = new ArrayList<Integer>();

                                        for (int i = 0; i < danoAPerder; i++) {

                                                if (cartasParaMazo.size() > 0) {
                                                        for (CartaInterface carta : cartasParaMazo) {
                                                                idsCartasParaMazo.add(carta.getId());
                                                        }
                                                }
                                                String descripcionCartasEnCementerio = cartaService
                                                                .devolverCartasEnZonaComoMensaje(
                                                                                jugadorActual.getCartasCementerio());

                                                JScrollPane descripcionCartasEnCementerioConScroll = jScrollPaneService
                                                                .instanciarJScrollPaneParaExpandirMensaje(
                                                                                new JTextArea(),
                                                                                descripcionCartasEnCementerio);

                                                List<Integer> listIdsCartasCementerio = cartaService
                                                                .devolverIDsCartasEnZona(
                                                                                jugadorActual.getCartasCementerio());

                                                listIdsCartasCementerio.removeAll(idsCartasParaMazo);

                                                Object[] arrayIdsCartasCementerio = listIdsCartasCementerio
                                                                .toArray();

                                                Integer cartaSeleccionada = JOptionPane
                                                                .showOptionDialog(null,
                                                                                descripcionCartasEnCementerioConScroll,
                                                                                "Cartas en tu cementerio",
                                                                                JOptionPane.DEFAULT_OPTION,
                                                                                JOptionPane.QUESTION_MESSAGE,
                                                                                null,
                                                                                arrayIdsCartasCementerio,
                                                                                0);

                                                for (Integer id : listIdsCartasCementerio) {
                                                        if (arrayIdsCartasCementerio[cartaSeleccionada] == id) {
                                                                CartaInterface cartaActual = cartaService
                                                                                .devolverCartaSeleccionadoPorId(
                                                                                                jugadorActual.getCartasCementerio(),
                                                                                                id);
                                                                cartasParaMazo.add(cartaActual);

                                                        }
                                                }

                                        }

                                        animalService.activarEfectoPulpoManualmente(animalConEfectoManualOfensivo,
                                                        danoAPerder,
                                                        jugadorActual, cartasParaMazo);

                                        jugadorActual.mezclarMazo();

                                        break;

                                case "Tiburón Blanco":

                                        String descripcionAnimalesReposo = cartaService.devolverCartasEnZonaComoMensaje(
                                                        jugadorActual.getAnimalesEnReposo());

                                        JScrollPane descripcionAnimalesReposoConScroll = jScrollPaneService
                                                        .instanciarJScrollPaneParaExpandirMensaje(
                                                                        new JTextArea(),
                                                                        descripcionAnimalesReposo);

                                        List<Integer> listIdsAnimalesReposo = cartaService
                                                        .devolverIDsCartasEnZona(
                                                                        jugadorActual.getAnimalesEnReposo());

                                        Object[] arrayIdsAnimalesReposo = listIdsAnimalesReposo
                                                        .toArray();

                                        JOptionPane.showMessageDialog(null,
                                                        "¿Qué animal aliado en reposo quieres devorar? ",
                                                        "Animal aliado a devorar", JOptionPane.QUESTION_MESSAGE);

                                        Integer cartaSeleccionada = JOptionPane
                                                        .showOptionDialog(null, descripcionAnimalesReposoConScroll,
                                                                        "Animales aliados en Reposo",
                                                                        JOptionPane.DEFAULT_OPTION,
                                                                        JOptionPane.QUESTION_MESSAGE,
                                                                        null,
                                                                        arrayIdsAnimalesReposo,
                                                                        0);

                                        CartaInterface animalAliadoADevorar = null;
                                        for (Integer id : listIdsAnimalesReposo) {
                                                if (arrayIdsAnimalesReposo[cartaSeleccionada] == id) {
                                                        animalAliadoADevorar = cartaService
                                                                        .devolverCartaSeleccionadoPorId(
                                                                                        jugadorActual.getAnimalesEnReposo(),
                                                                                        id);

                                                }
                                        }

                                        CartaInterface animalEnemigoADevorar = null;

                                        String[] opcionesDevorar = { "Línea de Reposo", "Línea de Ataque" };

                                        int zonaElegida = JOptionPane.showOptionDialog(null,
                                                        "¿El animal enemigo está en la línea de reposo o en la línea de batalla?",
                                                        "Animal enemigo a devorar", JOptionPane.DEFAULT_OPTION,
                                                        JOptionPane.QUESTION_MESSAGE, null, opcionesDevorar, 0);

                                        int costeMaximo = 3;

                                        switch (zonaElegida) {
                                                case 0:

                                                        String descripcionEnemigosReposo = animalService
                                                                        .devolverAnimalesEnZonaComoMensajePorCosteMaximo(
                                                                                        jugadorEnemigo.getAnimalesEnReposo(),
                                                                                        costeMaximo);

                                                        JScrollPane descripcionEnemigosReposoConScroll = jScrollPaneService
                                                                        .instanciarJScrollPaneParaExpandirMensaje(
                                                                                        new JTextArea(),
                                                                                        descripcionEnemigosReposo);

                                                        List<Integer> listIdsAnimalesEnemigosReposo = animalService
                                                                        .devolverIDsAnimalesEnZonaPorCosteMaximo(
                                                                                        jugadorEnemigo.getAnimalesEnReposo(),
                                                                                        costeMaximo);

                                                        Object[] arrayIdsAnimalesEnemigosReposo = listIdsAnimalesEnemigosReposo
                                                                        .toArray();

                                                        JOptionPane.showMessageDialog(null,
                                                                        "¿Qué animal enemigo en reposo de coste 3 o menos quieres devorar?",
                                                                        "Animales enemigos en reposo",
                                                                        JOptionPane.QUESTION_MESSAGE);

                                                        Integer animalEnemigoReposoSeleccionado = JOptionPane
                                                                        .showOptionDialog(null,
                                                                                        descripcionEnemigosReposoConScroll,
                                                                                        "Animales enemigos en Reposo",
                                                                                        JOptionPane.DEFAULT_OPTION,
                                                                                        JOptionPane.QUESTION_MESSAGE,
                                                                                        null,
                                                                                        arrayIdsAnimalesEnemigosReposo,
                                                                                        0);

                                                        for (Integer id : listIdsAnimalesEnemigosReposo) {
                                                                if (arrayIdsAnimalesEnemigosReposo[animalEnemigoReposoSeleccionado] == id) {
                                                                        animalEnemigoADevorar = cartaService
                                                                                        .devolverCartaSeleccionadoPorId(
                                                                                                        jugadorEnemigo.getAnimalesEnReposo(),
                                                                                                        id);

                                                                }
                                                        }

                                                        break;

                                                case 1:

                                                        String descripcionEnemigosBatalla = animalService
                                                                        .devolverAnimalesEnZonaComoMensajePorCosteMaximo(
                                                                                        jugadorEnemigo.getAnimalesEnBatalla(),
                                                                                        costeMaximo);

                                                        JScrollPane descripcionEnemigosBatallaConScroll = jScrollPaneService
                                                                        .instanciarJScrollPaneParaExpandirMensaje(
                                                                                        new JTextArea(),
                                                                                        descripcionEnemigosBatalla);

                                                        List<Integer> listIdsAnimalesEnemigosBatalla = animalService
                                                                        .devolverIDsAnimalesEnZonaPorCosteMaximo(
                                                                                        jugadorEnemigo.getAnimalesEnReposo(),
                                                                                        costeMaximo);

                                                        Object[] arrayIdsAnimalesEnemigosBatalla = listIdsAnimalesEnemigosBatalla
                                                                        .toArray();

                                                        JOptionPane.showMessageDialog(null,
                                                                        "¿Qué animal enemigo en batalla de coste 3 o menos quieres devorar?",
                                                                        "Animales enemigos en batalla",
                                                                        JOptionPane.QUESTION_MESSAGE);
                                                        Integer animalEnemigoBatallaSeleccionado = JOptionPane
                                                                        .showOptionDialog(null,
                                                                                        descripcionEnemigosBatallaConScroll,
                                                                                        "Animales enemigos en batalla",
                                                                                        JOptionPane.DEFAULT_OPTION,
                                                                                        JOptionPane.QUESTION_MESSAGE,
                                                                                        null,
                                                                                        arrayIdsAnimalesEnemigosBatalla,
                                                                                        0);

                                                        for (Integer id : listIdsAnimalesEnemigosBatalla) {
                                                                if (arrayIdsAnimalesEnemigosBatalla[animalEnemigoBatallaSeleccionado] == id) {
                                                                        animalEnemigoADevorar = cartaService
                                                                                        .devolverCartaSeleccionadoPorId(
                                                                                                        jugadorEnemigo.getAnimalesEnBatalla(),
                                                                                                        id);

                                                                }
                                                        }
                                                        break;

                                        }

                                        animalService.activarEfectoTiburonBlancoManualmente(
                                                        animalConEfectoManualOfensivo, animalAliadoADevorar,
                                                        animalEnemigoADevorar, jugadorActual, jugadorEnemigo);

                                        break;

                        }

                }

        }

        private void activarEfectoHabilidad(Jugador jugadorActual, Jugador jugadorEnemigo) {
                int habilidadesEnMano = habilidadService
                                .devolverCantidadHabilidadesPorZona(jugadorActual.getCartasMano());

                if (habilidadesEnMano == 0) {
                        JOptionPane.showMessageDialog(null, "Actualmente no tienes ninguna habilidad en tu mano.",
                                        "Sin habilidades", JOptionPane.WARNING_MESSAGE);
                } else {

                        String descripcionHabilidadesEnMano = habilidadService
                                        .devolverDescripcionHabilidadesPorZona(jugadorActual.getCartasMano());

                        JScrollPane descripcionHabilidadesEnManoConScroll = jScrollPaneService
                                        .instanciarJScrollPaneParaExpandirMensaje(new JTextArea(),
                                                        descripcionHabilidadesEnMano);

                        List<Integer> idsHabilidadesEnMano = habilidadService
                                        .devolverIdsHabilidadesEnZona(jugadorActual.getCartasMano());

                        Object[] arrayHabilidadesEnMano = idsHabilidadesEnMano.toArray();

                        JOptionPane.showMessageDialog(null, "¿Qué habilidad deseas activar?", "Selección de habilidad",
                                        JOptionPane.QUESTION_MESSAGE);

                        Integer habilidadSeleccionada = JOptionPane
                                        .showOptionDialog(null, descripcionHabilidadesEnManoConScroll,
                                                        "Cartas en tu mano",
                                                        JOptionPane.DEFAULT_OPTION,
                                                        JOptionPane.QUESTION_MESSAGE,
                                                        null,
                                                        arrayHabilidadesEnMano,
                                                        0);

                        CartaInterface habilidadElegida = null;

                        for (Integer id : idsHabilidadesEnMano) {
                                if (arrayHabilidadesEnMano[habilidadSeleccionada] == id) {
                                        habilidadElegida = cartaService.devolverCartaSeleccionadoPorId(
                                                        jugadorActual.getCartasMano(), id);
                                }
                        }

                        int alimentosDisponibles = alimentoService.devolverCantidadAlimentosReserva(jugadorActual);

                        Habilidad habilidad = (Habilidad) habilidadElegida;

                        if (habilidad.getCoste() <= alimentosDisponibles) {
                                alimentoService.consumirAlimentosEnReserva(jugadorActual, habilidad.getCoste());

                                switch (habilidad.getNombre()) {
                                        case "Aullido":
                                                String nombreLobo = "Lobo Gris";
                                                boolean existeLoboReposo = animalService.existeAnimalEnZonaPorNombre(
                                                                jugadorActual.getAnimalesEnReposo(), nombreLobo);
                                                boolean existeLoboBatalla = animalService.existeAnimalEnZonaPorNombre(
                                                                jugadorActual.getAnimalesEnBatalla(), nombreLobo);

                                                if (existeLoboBatalla || existeLoboReposo) {

                                                        CartaInterface cartaAContar = null;
                                                        if (existeLoboReposo) {
                                                                cartaAContar = animalService
                                                                                .devolverPrimerAnimalEncontradoPorNombreEnZona(
                                                                                                nombreLobo,
                                                                                                jugadorActual.getAnimalesEnReposo());
                                                        } else {
                                                                cartaAContar = animalService
                                                                                .devolverPrimerAnimalEncontradoPorNombreEnZona(
                                                                                                nombreLobo,
                                                                                                jugadorActual.getAnimalesEnBatalla());
                                                        }

                                                        int lobosMazo = cartaService.devolverCantidadCopiasCartaPorZona(
                                                                        jugadorActual.getCartasMazo(),
                                                                        cartaAContar);

                                                        int lobosCementerio = cartaService
                                                                        .devolverCantidadCopiasCartaPorZona(
                                                                                        jugadorActual.getCartasCementerio(),
                                                                                        cartaAContar);

                                                        JOptionPane.showMessageDialog(null,
                                                                        "Lobos Grises disponibles: \nEn mazo: "
                                                                                        + lobosMazo
                                                                                        + ".\nEn cementerio: "
                                                                                        + lobosCementerio
                                                                                        + ".",
                                                                        nombreLobo + " disponible",
                                                                        JOptionPane.INFORMATION_MESSAGE);

                                                        CartaInterface cartaSeleccionada = null;

                                                        if (lobosMazo > 0) {
                                                                if (lobosCementerio > 0) {

                                                                        List<String> seleccionZona = new ArrayList<String>();

                                                                        seleccionZona.add("En mazo");
                                                                        seleccionZona.add("En cementerio");

                                                                        Object[] arraySeleccionZona = seleccionZona
                                                                                        .toArray();

                                                                        int zonaSeleccionada = JOptionPane
                                                                                        .showOptionDialog(
                                                                                                        null,
                                                                                                        "¿De qué zona quieres llamar al Lobo Gris?",
                                                                                                        "Selección de Zona",
                                                                                                        JOptionPane.DEFAULT_OPTION,
                                                                                                        JOptionPane.QUESTION_MESSAGE,
                                                                                                        null,
                                                                                                        arraySeleccionZona,
                                                                                                        0);
                                                                        if (zonaSeleccionada == 0) {

                                                                                cartaSeleccionada = animalService
                                                                                                .devolverPrimerAnimalEncontradoPorNombreEnZona(
                                                                                                                nombreLobo,
                                                                                                                jugadorActual.getCartasMazo());

                                                                                Animal loboSeleccionado = (Animal) cartaSeleccionada;
                                                                                loboSeleccionado.setEnMazo(false);
                                                                                loboSeleccionado.setEnReposo(true);

                                                                        } else {

                                                                                cartaSeleccionada = animalService
                                                                                                .devolverPrimerAnimalEncontradoPorNombreEnZona(
                                                                                                                nombreLobo,
                                                                                                                jugadorActual.getCartasCementerio());

                                                                                Animal loboSeleccionado = (Animal) cartaSeleccionada;
                                                                                loboSeleccionado.setEnCementerio(false);
                                                                                loboSeleccionado.setEnReposo(true);
                                                                        }

                                                                } else {
                                                                        cartaSeleccionada = animalService
                                                                                        .devolverPrimerAnimalEncontradoPorNombreEnZona(
                                                                                                        nombreLobo,
                                                                                                        jugadorActual.getCartasMazo());

                                                                        Animal loboSeleccionado = (Animal) cartaSeleccionada;
                                                                        loboSeleccionado.setEnMazo(false);
                                                                        loboSeleccionado.setEnReposo(true);

                                                                }
                                                        } else {
                                                                cartaSeleccionada = animalService
                                                                                .devolverPrimerAnimalEncontradoPorNombreEnZona(
                                                                                                nombreLobo,
                                                                                                jugadorActual.getCartasCementerio());

                                                                Animal loboSeleccionado = (Animal) cartaSeleccionada;
                                                                loboSeleccionado.setEnCementerio(false);
                                                                loboSeleccionado.setEnReposo(true);
                                                        }
                                                        habilidad.setEnCementerio(true);
                                                        habilidad.setEnMano(false);

                                                        animalService.activarPasivamenteEfectoAnimal(jugadorActual,
                                                                        cartaService);
                                                } else {
                                                        JOptionPane.showMessageDialog(null,
                                                                        "Actualmente no tienes ningún Lobo Gris en juego.",
                                                                        "Ausencia de Lobos",
                                                                        JOptionPane.WARNING_MESSAGE);
                                                }

                                                break;

                                        case "Camuflaje":
                                                String nombreCamaleon = "Camaleón";

                                                boolean existeCamaleonCementerio = animalService
                                                                .existeAnimalEnZonaPorNombre(
                                                                                jugadorActual.getCartasCementerio(),
                                                                                nombreCamaleon);

                                                if (existeCamaleonCementerio) {
                                                        CartaInterface camaleonARevivir = animalService
                                                                        .devolverPrimerAnimalEncontradoPorNombreEnZona(
                                                                                        nombreCamaleon,
                                                                                        jugadorActual.getCartasCementerio());

                                                        camaleonARevivir.setEnMano(true);
                                                        camaleonARevivir.setEnCementerio(false);

                                                        JOptionPane.showMessageDialog(null,
                                                                        "Has revivido un camaleón y ahora está en tu mano.",
                                                                        "Resurrección",
                                                                        JOptionPane.INFORMATION_MESSAGE);

                                                        habilidad.setEnCementerio(true);
                                                        habilidad.setEnMano(false);

                                                } else {
                                                        JOptionPane.showMessageDialog(null,
                                                                        "Actualmente no hay ningún Camaleón en tu cementerio.",
                                                                        "Camaleones faltantes",
                                                                        JOptionPane.INFORMATION_MESSAGE);
                                                }

                                                break;

                                        case "Hechizo":

                                                int cantidadEnemigosReposo = cartaService.devovlerCantidadCartasEnZona(
                                                                jugadorEnemigo.getAnimalesEnReposo());

                                                int cantidadEnemigosBatalla = cartaService.devovlerCantidadCartasEnZona(
                                                                jugadorEnemigo.getAnimalesEnBatalla());

                                                if (cantidadEnemigosReposo > 0) {
                                                        if (cantidadEnemigosBatalla > 0) {
                                                                String descripcionEnemigosReposo = cartaService
                                                                                .devolverCartasEnZonaComoMensaje(
                                                                                                jugadorEnemigo
                                                                                                                .getAnimalesEnReposo());

                                                                JScrollPane descripcionEnemigosReposoConScroll = jScrollPaneService
                                                                                .instanciarJScrollPaneParaExpandirMensaje(
                                                                                                new JTextArea(),
                                                                                                descripcionEnemigosReposo);

                                                                JOptionPane.showMessageDialog(null,
                                                                                descripcionEnemigosReposoConScroll,
                                                                                "Animales enemigos en Reposo.",
                                                                                JOptionPane.INFORMATION_MESSAGE);

                                                                String descripcionEnemigosBatalla = cartaService
                                                                                .devolverCartasEnZonaComoMensaje(
                                                                                                jugadorEnemigo
                                                                                                                .getAnimalesEnBatalla());

                                                                JScrollPane descripcionEnemigosBatallaConScroll = jScrollPaneService
                                                                                .instanciarJScrollPaneParaExpandirMensaje(
                                                                                                new JTextArea(),
                                                                                                descripcionEnemigosBatalla);

                                                                JOptionPane.showMessageDialog(null,
                                                                                descripcionEnemigosBatallaConScroll,
                                                                                "Animales enemigos en Batalla.",
                                                                                JOptionPane.INFORMATION_MESSAGE);

                                                                String[] seleccionZona = { "En reposo", "En batalla" };

                                                                int seleccion = JOptionPane.showOptionDialog(null,
                                                                                "¿En dónde se encuentra el animal enemigo que quieres hechizar?",
                                                                                "Hechizo", JOptionPane.DEFAULT_OPTION,
                                                                                JOptionPane.QUESTION_MESSAGE, null,
                                                                                seleccionZona, 0);

                                                                CartaInterface enemigoHechizado = null;

                                                                switch (seleccion) {
                                                                        case 0:
                                                                                List<Integer> idsAnimalesReposoEnemigos = cartaService
                                                                                                .devolverIDsCartasEnZona(
                                                                                                                jugadorEnemigo.getAnimalesEnReposo());

                                                                                Object[] arrayAnimalesReposoEnemigos = idsAnimalesReposoEnemigos
                                                                                                .toArray();

                                                                                int enemigoElegido = JOptionPane
                                                                                                .showOptionDialog(null,
                                                                                                                descripcionEnemigosReposoConScroll,
                                                                                                                "Enemigos en reposo",
                                                                                                                JOptionPane.DEFAULT_OPTION,
                                                                                                                JOptionPane.QUESTION_MESSAGE,
                                                                                                                null,
                                                                                                                arrayAnimalesReposoEnemigos,
                                                                                                                0);

                                                                                for (Integer id : idsAnimalesReposoEnemigos) {
                                                                                        if (arrayAnimalesReposoEnemigos[enemigoElegido] == id) {
                                                                                                enemigoHechizado = animalService
                                                                                                                .devolverAnimalSeleccionadoPorId(
                                                                                                                                jugadorEnemigo.getAnimalesEnReposo(),
                                                                                                                                id);
                                                                                        }
                                                                                }

                                                                                jugadorActual.getAnimalesEnReposo()
                                                                                                .add(enemigoHechizado);
                                                                                jugadorEnemigo.getAnimalesEnReposo()
                                                                                                .remove(enemigoHechizado);

                                                                                break;

                                                                        case 1:
                                                                                List<Integer> idsAnimalesBatallaEnemigos = cartaService
                                                                                                .devolverIDsCartasEnZona(
                                                                                                                jugadorEnemigo.getAnimalesEnBatalla());

                                                                                Object[] arrayAnimalesBatallaEnemigos = idsAnimalesBatallaEnemigos
                                                                                                .toArray();

                                                                                int enemigoBatallaElegido = JOptionPane
                                                                                                .showOptionDialog(null,
                                                                                                                descripcionEnemigosBatallaConScroll,
                                                                                                                "Enemigos en reposo",
                                                                                                                JOptionPane.DEFAULT_OPTION,
                                                                                                                JOptionPane.QUESTION_MESSAGE,
                                                                                                                null,
                                                                                                                arrayAnimalesBatallaEnemigos,
                                                                                                                0);

                                                                                for (Integer id : idsAnimalesBatallaEnemigos) {
                                                                                        if (arrayAnimalesBatallaEnemigos[enemigoBatallaElegido] == id) {
                                                                                                enemigoHechizado = animalService
                                                                                                                .devolverAnimalSeleccionadoPorId(
                                                                                                                                jugadorEnemigo.getAnimalesEnReposo(),
                                                                                                                                id);
                                                                                        }
                                                                                }

                                                                                jugadorActual.getAnimalesEnReposo()
                                                                                                .add(enemigoHechizado);
                                                                                jugadorEnemigo.getAnimalesEnBatalla()
                                                                                                .remove(enemigoHechizado);

                                                                                break;

                                                                }

                                                        } else {

                                                                String descripcionEnemigosReposo = cartaService
                                                                                .devolverCartasEnZonaComoMensaje(
                                                                                                jugadorEnemigo
                                                                                                                .getAnimalesEnReposo());

                                                                JScrollPane descripcionEnemigosReposoConScroll = jScrollPaneService
                                                                                .instanciarJScrollPaneParaExpandirMensaje(
                                                                                                new JTextArea(),
                                                                                                descripcionEnemigosReposo);

                                                                List<Integer> idsAnimalesReposoEnemigos = cartaService
                                                                                .devolverIDsCartasEnZona(
                                                                                                jugadorEnemigo.getAnimalesEnReposo());

                                                                Object[] arrayAnimalesReposoEnemigos = idsAnimalesReposoEnemigos
                                                                                .toArray();

                                                                int enemigoElegido = JOptionPane
                                                                                .showOptionDialog(null,
                                                                                                descripcionEnemigosReposoConScroll,
                                                                                                "Enemigos en reposo",
                                                                                                JOptionPane.DEFAULT_OPTION,
                                                                                                JOptionPane.QUESTION_MESSAGE,
                                                                                                null,
                                                                                                arrayAnimalesReposoEnemigos,
                                                                                                0);
                                                                CartaInterface enemigoHechizado = null;
                                                                for (Integer id : idsAnimalesReposoEnemigos) {
                                                                        if (arrayAnimalesReposoEnemigos[enemigoElegido] == id) {
                                                                                enemigoHechizado = animalService
                                                                                                .devolverAnimalSeleccionadoPorId(
                                                                                                                jugadorEnemigo.getAnimalesEnReposo(),
                                                                                                                id);
                                                                        }
                                                                }

                                                                jugadorActual.getAnimalesEnReposo()
                                                                                .add(enemigoHechizado);
                                                                jugadorEnemigo.getAnimalesEnReposo()
                                                                                .remove(enemigoHechizado);

                                                        }
                                                } else {
                                                        String descripcionEnemigosBatalla = cartaService
                                                                        .devolverCartasEnZonaComoMensaje(jugadorEnemigo
                                                                                        .getAnimalesEnBatalla());

                                                        JScrollPane descripcionEnemigosBatallaConScroll = jScrollPaneService
                                                                        .instanciarJScrollPaneParaExpandirMensaje(
                                                                                        new JTextArea(),
                                                                                        descripcionEnemigosBatalla);

                                                        List<Integer> idsAnimalesBatallaEnemigos = cartaService
                                                                        .devolverIDsCartasEnZona(
                                                                                        jugadorEnemigo.getAnimalesEnBatalla());

                                                        Object[] arrayAnimalesBatallaEnemigos = idsAnimalesBatallaEnemigos
                                                                        .toArray();

                                                        int enemigoBatallaElegido = JOptionPane
                                                                        .showOptionDialog(null,
                                                                                        descripcionEnemigosBatallaConScroll,
                                                                                        "Enemigos en reposo",
                                                                                        JOptionPane.DEFAULT_OPTION,
                                                                                        JOptionPane.QUESTION_MESSAGE,
                                                                                        null,
                                                                                        arrayAnimalesBatallaEnemigos,
                                                                                        0);

                                                        CartaInterface enemigoHechizado = null;

                                                        for (Integer id : idsAnimalesBatallaEnemigos) {
                                                                if (arrayAnimalesBatallaEnemigos[enemigoBatallaElegido] == id) {
                                                                        enemigoHechizado = animalService
                                                                                        .devolverAnimalSeleccionadoPorId(
                                                                                                        jugadorEnemigo.getAnimalesEnBatalla(),
                                                                                                        id);
                                                                }
                                                        }

                                                        jugadorActual.getAnimalesEnReposo()
                                                                        .add(enemigoHechizado);
                                                        jugadorEnemigo.getAnimalesEnBatalla()
                                                                        .remove(enemigoHechizado);

                                                }

                                                habilidad.setEnCementerio(true);
                                                habilidad.setEnMano(false);

                                                break;

                                        case "Olor a Sangre":

                                                String nombreTiburon = "Tiburón Blanco";
                                                boolean tiburonReposo = animalService.existeAnimalEnZonaPorNombre(
                                                                jugadorActual.getAnimalesEnReposo(), nombreTiburon);
                                                boolean tiburonBatalla = animalService.existeAnimalEnZonaPorNombre(
                                                                jugadorActual.getAnimalesEnBatalla(), nombreTiburon);

                                                boolean tiburonCementerio = animalService.existeAnimalEnZonaPorNombre(
                                                                jugadorActual.getCartasCementerio(), nombreTiburon);

                                                CartaInterface tiburonActual = null;
                                                if (tiburonCementerio) {
                                                        tiburonActual = cartaService
                                                                        .devolverPrimerCartaEncontradaEnZonaPorNombre(
                                                                                        jugadorActual.getCartasCementerio(),
                                                                                        nombreTiburon);

                                                        Animal tiburon = (Animal) tiburonActual;

                                                        tiburon.setEnReposo(true);
                                                        tiburon.setEnCementerio(false);

                                                } else if (tiburonReposo || tiburonBatalla) {
                                                        if (tiburonReposo) {
                                                                tiburonActual = cartaService
                                                                                .devolverPrimerCartaEncontradaEnZonaPorNombre(
                                                                                                jugadorActual.getAnimalesEnReposo(),
                                                                                                nombreTiburon);
                                                        } else {
                                                                tiburonActual = cartaService
                                                                                .devolverPrimerCartaEncontradaEnZonaPorNombre(
                                                                                                jugadorActual.getAnimalesEnBatalla(),
                                                                                                nombreTiburon);
                                                        }

                                                        Animal tiburon = (Animal) tiburonActual;

                                                        tiburon.setDano(tiburon.getDano() + 3);

                                                }

                                                habilidad.setEnCementerio(true);
                                                habilidad.setEnMano(false);
                                                break;

                                        case "Captura":

                                                int cantidadEnemigosEnReposo = cartaService
                                                                .devovlerCantidadCartasEnZona(
                                                                                jugadorEnemigo.getAnimalesEnReposo());

                                                int cantidadEnemigosEnBatalla = cartaService
                                                                .devovlerCantidadCartasEnZona(
                                                                                jugadorEnemigo.getAnimalesEnBatalla());

                                                if (cantidadEnemigosEnReposo > 0) {
                                                        if (cantidadEnemigosEnBatalla > 0) {
                                                                String descripcionEnemigosReposo = cartaService
                                                                                .devolverCartasEnZonaComoMensaje(
                                                                                                jugadorEnemigo
                                                                                                                .getAnimalesEnReposo());

                                                                JScrollPane descripcionEnemigosReposoConScroll = jScrollPaneService
                                                                                .instanciarJScrollPaneParaExpandirMensaje(
                                                                                                new JTextArea(),
                                                                                                descripcionEnemigosReposo);

                                                                JOptionPane.showMessageDialog(null,
                                                                                descripcionEnemigosReposoConScroll,
                                                                                "Animales enemigos en Reposo.",
                                                                                JOptionPane.INFORMATION_MESSAGE);

                                                                String descripcionEnemigosBatalla = cartaService
                                                                                .devolverCartasEnZonaComoMensaje(
                                                                                                jugadorEnemigo
                                                                                                                .getAnimalesEnBatalla());

                                                                JScrollPane descripcionEnemigosBatallaConScroll = jScrollPaneService
                                                                                .instanciarJScrollPaneParaExpandirMensaje(
                                                                                                new JTextArea(),
                                                                                                descripcionEnemigosBatalla);

                                                                JOptionPane.showMessageDialog(null,
                                                                                descripcionEnemigosBatallaConScroll,
                                                                                "Animales enemigos en Batalla.",
                                                                                JOptionPane.INFORMATION_MESSAGE);

                                                                String[] seleccionZona = { "En reposo", "En batalla" };

                                                                int seleccion = JOptionPane.showOptionDialog(null,
                                                                                "¿En dónde se encuentra el animal enemigo que quieres capturar?",
                                                                                "Captura", JOptionPane.DEFAULT_OPTION,
                                                                                JOptionPane.QUESTION_MESSAGE, null,
                                                                                seleccionZona, 0);

                                                                CartaInterface enemigoCapturado = null;

                                                                switch (seleccion) {
                                                                        case 0:
                                                                                List<Integer> idsAnimalesReposoEnemigos = cartaService
                                                                                                .devolverIDsCartasEnZona(
                                                                                                                jugadorEnemigo.getAnimalesEnReposo());

                                                                                Object[] arrayAnimalesReposoEnemigos = idsAnimalesReposoEnemigos
                                                                                                .toArray();

                                                                                int enemigoElegido = JOptionPane
                                                                                                .showOptionDialog(null,
                                                                                                                descripcionEnemigosReposoConScroll,
                                                                                                                "Enemigos en reposo",
                                                                                                                JOptionPane.DEFAULT_OPTION,
                                                                                                                JOptionPane.QUESTION_MESSAGE,
                                                                                                                null,
                                                                                                                arrayAnimalesReposoEnemigos,
                                                                                                                0);

                                                                                for (Integer id : idsAnimalesReposoEnemigos) {
                                                                                        if (arrayAnimalesReposoEnemigos[enemigoElegido] == id) {
                                                                                                enemigoCapturado = animalService
                                                                                                                .devolverAnimalSeleccionadoPorId(
                                                                                                                                jugadorEnemigo.getAnimalesEnReposo(),
                                                                                                                                id);
                                                                                        }
                                                                                }

                                                                                break;

                                                                        case 1:
                                                                                List<Integer> idsAnimalesBatallaEnemigos = cartaService
                                                                                                .devolverIDsCartasEnZona(
                                                                                                                jugadorEnemigo.getAnimalesEnBatalla());

                                                                                Object[] arrayAnimalesBatallaEnemigos = idsAnimalesBatallaEnemigos
                                                                                                .toArray();

                                                                                int enemigoBatallaElegido = JOptionPane
                                                                                                .showOptionDialog(null,
                                                                                                                descripcionEnemigosBatallaConScroll,
                                                                                                                "Enemigos en reposo",
                                                                                                                JOptionPane.DEFAULT_OPTION,
                                                                                                                JOptionPane.QUESTION_MESSAGE,
                                                                                                                null,
                                                                                                                arrayAnimalesBatallaEnemigos,
                                                                                                                0);

                                                                                for (Integer id : idsAnimalesBatallaEnemigos) {
                                                                                        if (arrayAnimalesBatallaEnemigos[enemigoBatallaElegido] == id) {
                                                                                                enemigoCapturado = animalService
                                                                                                                .devolverAnimalSeleccionadoPorId(
                                                                                                                                jugadorEnemigo.getAnimalesEnReposo(),
                                                                                                                                id);
                                                                                        }
                                                                                }

                                                                                break;

                                                                }

                                                                animalService.prohibirAtaqueAnimalPorCantidadTurnos(
                                                                                enemigoCapturado, 2);

                                                                habilidad.setEnCementerio(true);
                                                                habilidad.setEnMano(false);

                                                        } else {

                                                                String descripcionEnemigosReposo = cartaService
                                                                                .devolverCartasEnZonaComoMensaje(
                                                                                                jugadorEnemigo
                                                                                                                .getAnimalesEnReposo());

                                                                JScrollPane descripcionEnemigosReposoConScroll = jScrollPaneService
                                                                                .instanciarJScrollPaneParaExpandirMensaje(
                                                                                                new JTextArea(),
                                                                                                descripcionEnemigosReposo);

                                                                List<Integer> idsAnimalesReposoEnemigos = cartaService
                                                                                .devolverIDsCartasEnZona(
                                                                                                jugadorEnemigo.getAnimalesEnReposo());

                                                                Object[] arrayAnimalesReposoEnemigos = idsAnimalesReposoEnemigos
                                                                                .toArray();

                                                                int enemigoElegido = JOptionPane
                                                                                .showOptionDialog(null,
                                                                                                descripcionEnemigosReposoConScroll,
                                                                                                "Enemigos en reposo",
                                                                                                JOptionPane.DEFAULT_OPTION,
                                                                                                JOptionPane.QUESTION_MESSAGE,
                                                                                                null,
                                                                                                arrayAnimalesReposoEnemigos,
                                                                                                0);
                                                                CartaInterface enemigoCapturado = null;

                                                                for (Integer id : idsAnimalesReposoEnemigos) {
                                                                        if (arrayAnimalesReposoEnemigos[enemigoElegido] == id) {
                                                                                enemigoCapturado = animalService
                                                                                                .devolverAnimalSeleccionadoPorId(
                                                                                                                jugadorEnemigo.getAnimalesEnReposo(),
                                                                                                                id);
                                                                        }
                                                                }

                                                                animalService.prohibirAtaqueAnimalPorCantidadTurnos(
                                                                                enemigoCapturado, 2);

                                                                habilidad.setEnCementerio(true);
                                                                habilidad.setEnMano(false);

                                                        }
                                                } else {
                                                        String descripcionEnemigosBatalla = cartaService
                                                                        .devolverCartasEnZonaComoMensaje(jugadorEnemigo
                                                                                        .getAnimalesEnBatalla());

                                                        JScrollPane descripcionEnemigosBatallaConScroll = jScrollPaneService
                                                                        .instanciarJScrollPaneParaExpandirMensaje(
                                                                                        new JTextArea(),
                                                                                        descripcionEnemigosBatalla);

                                                        List<Integer> idsAnimalesBatallaEnemigos = cartaService
                                                                        .devolverIDsCartasEnZona(
                                                                                        jugadorEnemigo.getAnimalesEnBatalla());

                                                        Object[] arrayAnimalesBatallaEnemigos = idsAnimalesBatallaEnemigos
                                                                        .toArray();

                                                        int enemigoBatallaElegido = JOptionPane
                                                                        .showOptionDialog(null,
                                                                                        descripcionEnemigosBatallaConScroll,
                                                                                        "Enemigos en reposo",
                                                                                        JOptionPane.DEFAULT_OPTION,
                                                                                        JOptionPane.QUESTION_MESSAGE,
                                                                                        null,
                                                                                        arrayAnimalesBatallaEnemigos,
                                                                                        0);

                                                        CartaInterface enemigoCapturado = null;

                                                        for (Integer id : idsAnimalesBatallaEnemigos) {
                                                                if (arrayAnimalesBatallaEnemigos[enemigoBatallaElegido] == id) {
                                                                        enemigoCapturado = animalService
                                                                                        .devolverAnimalSeleccionadoPorId(
                                                                                                        jugadorEnemigo.getAnimalesEnReposo(),
                                                                                                        id);
                                                                }
                                                        }

                                                        animalService.prohibirAtaqueAnimalPorCantidadTurnos(
                                                                        enemigoCapturado, 2);

                                                        habilidad.setEnCementerio(true);
                                                        habilidad.setEnMano(false);
                                                }

                                                break;

                                        case "Coraza":

                                                int cantidadAnimalesReposo = cartaService
                                                                .devovlerCantidadCartasEnZona(
                                                                                jugadorActual.getAnimalesEnReposo());

                                                int cantidadAnimalesEnBatalla = cartaService
                                                                .devovlerCantidadCartasEnZona(
                                                                                jugadorActual.getAnimalesEnBatalla());

                                                if (cantidadAnimalesReposo > 0) {
                                                        if (cantidadAnimalesEnBatalla > 0) {
                                                                String descripcionAnimalesReposo = cartaService
                                                                                .devolverCartasEnZonaComoMensaje(
                                                                                                jugadorActual
                                                                                                                .getAnimalesEnReposo());

                                                                JScrollPane descripcionAnimalesReposoConScroll = jScrollPaneService
                                                                                .instanciarJScrollPaneParaExpandirMensaje(
                                                                                                new JTextArea(),
                                                                                                descripcionAnimalesReposo);

                                                                JOptionPane.showMessageDialog(null,
                                                                                descripcionAnimalesReposoConScroll,
                                                                                "Animales aliados en Reposo.",
                                                                                JOptionPane.INFORMATION_MESSAGE);

                                                                String descripcionAnimalesBatalla = cartaService
                                                                                .devolverCartasEnZonaComoMensaje(
                                                                                                jugadorActual
                                                                                                                .getAnimalesEnBatalla());

                                                                JScrollPane descripcionAnimalesBatallaConScroll = jScrollPaneService
                                                                                .instanciarJScrollPaneParaExpandirMensaje(
                                                                                                new JTextArea(),
                                                                                                descripcionAnimalesBatalla);

                                                                JOptionPane.showMessageDialog(null,
                                                                                descripcionAnimalesBatallaConScroll,
                                                                                "Animales aliados en Batalla.",
                                                                                JOptionPane.INFORMATION_MESSAGE);

                                                                String[] seleccionZona = { "En reposo", "En batalla" };

                                                                int seleccion = JOptionPane.showOptionDialog(null,
                                                                                "¿En dónde se encuentra el animal que quieres hacer indestructible?",
                                                                                "Protección",
                                                                                JOptionPane.DEFAULT_OPTION,
                                                                                JOptionPane.QUESTION_MESSAGE, null,
                                                                                seleccionZona, 0);

                                                                CartaInterface animalProtegido = null;

                                                                switch (seleccion) {
                                                                        case 0:
                                                                                List<Integer> idsAnimalesReposo = cartaService
                                                                                                .devolverIDsCartasEnZona(
                                                                                                                jugadorActual.getAnimalesEnReposo());

                                                                                Object[] arrayAnimalesReposo = idsAnimalesReposo
                                                                                                .toArray();

                                                                                int animalElegido = JOptionPane
                                                                                                .showOptionDialog(null,
                                                                                                                descripcionAnimalesBatallaConScroll,
                                                                                                                "Enemigos en reposo",
                                                                                                                JOptionPane.DEFAULT_OPTION,
                                                                                                                JOptionPane.QUESTION_MESSAGE,
                                                                                                                null,
                                                                                                                arrayAnimalesReposo,
                                                                                                                0);

                                                                                for (Integer id : idsAnimalesReposo) {
                                                                                        if (arrayAnimalesReposo[animalElegido] == id) {
                                                                                                animalProtegido = animalService
                                                                                                                .devolverAnimalSeleccionadoPorId(
                                                                                                                                jugadorActual.getAnimalesEnReposo(),
                                                                                                                                id);
                                                                                        }
                                                                                }

                                                                                break;

                                                                        case 1:
                                                                                List<Integer> idsAnimalesBatalla = cartaService
                                                                                                .devolverIDsCartasEnZona(
                                                                                                                jugadorActual.getAnimalesEnBatalla());

                                                                                Object[] arrayAnimalesBatalla = idsAnimalesBatalla
                                                                                                .toArray();

                                                                                int animalBatallaElegido = JOptionPane
                                                                                                .showOptionDialog(null,
                                                                                                                descripcionAnimalesBatallaConScroll,
                                                                                                                "Animales en reposo",
                                                                                                                JOptionPane.DEFAULT_OPTION,
                                                                                                                JOptionPane.QUESTION_MESSAGE,
                                                                                                                null,
                                                                                                                arrayAnimalesBatalla,
                                                                                                                0);

                                                                                for (Integer id : idsAnimalesBatalla) {
                                                                                        if (arrayAnimalesBatalla[animalBatallaElegido] == id) {
                                                                                                animalProtegido = animalService
                                                                                                                .devolverAnimalSeleccionadoPorId(
                                                                                                                                jugadorActual.getAnimalesEnReposo(),
                                                                                                                                id);
                                                                                        }
                                                                                }

                                                                                break;

                                                                }

                                                                animalService.hacerAnimalIndestructible(
                                                                                animalProtegido);

                                                                habilidad.setEnCementerio(true);
                                                                habilidad.setEnMano(false);
                                                        } else {

                                                                String descripcionAnimalesReposo = cartaService
                                                                                .devolverCartasEnZonaComoMensaje(
                                                                                                jugadorActual
                                                                                                                .getAnimalesEnReposo());

                                                                JScrollPane descripcionAnimalesReposoConScroll = jScrollPaneService
                                                                                .instanciarJScrollPaneParaExpandirMensaje(
                                                                                                new JTextArea(),
                                                                                                descripcionAnimalesReposo);

                                                                List<Integer> idsAnimalesReposo = cartaService
                                                                                .devolverIDsCartasEnZona(
                                                                                                jugadorActual.getAnimalesEnReposo());

                                                                Object[] arrayAnimalesReposo = idsAnimalesReposo
                                                                                .toArray();

                                                                int animalElegido = JOptionPane
                                                                                .showOptionDialog(null,
                                                                                                descripcionAnimalesReposoConScroll,
                                                                                                "Enemigos en reposo",
                                                                                                JOptionPane.DEFAULT_OPTION,
                                                                                                JOptionPane.QUESTION_MESSAGE,
                                                                                                null,
                                                                                                arrayAnimalesReposo,
                                                                                                0);
                                                                CartaInterface animalProtegido = null;

                                                                for (Integer id : idsAnimalesReposo) {
                                                                        if (arrayAnimalesReposo[animalElegido] == id) {
                                                                                animalProtegido = animalService
                                                                                                .devolverAnimalSeleccionadoPorId(
                                                                                                                jugadorActual.getAnimalesEnReposo(),
                                                                                                                id);
                                                                        }
                                                                }

                                                                animalService.hacerAnimalIndestructible(
                                                                                animalProtegido);

                                                                habilidad.setEnCementerio(true);
                                                                habilidad.setEnMano(false);

                                                        }
                                                } else {
                                                        String descripcionAnimalesBatalla = cartaService
                                                                        .devolverCartasEnZonaComoMensaje(jugadorActual
                                                                                        .getAnimalesEnBatalla());

                                                        JScrollPane descripcionAnimalesBatallaConScroll = jScrollPaneService
                                                                        .instanciarJScrollPaneParaExpandirMensaje(
                                                                                        new JTextArea(),
                                                                                        descripcionAnimalesBatalla);

                                                        List<Integer> idsAnimalesBatalla = cartaService
                                                                        .devolverIDsCartasEnZona(
                                                                                        jugadorActual.getAnimalesEnBatalla());

                                                        Object[] arrayAnimalesBatalla = idsAnimalesBatalla
                                                                        .toArray();

                                                        int animalBatallaElegido = JOptionPane
                                                                        .showOptionDialog(null,
                                                                                        descripcionAnimalesBatallaConScroll,
                                                                                        "Enemigos en reposo",
                                                                                        JOptionPane.DEFAULT_OPTION,
                                                                                        JOptionPane.QUESTION_MESSAGE,
                                                                                        null,
                                                                                        arrayAnimalesBatalla,
                                                                                        0);

                                                        CartaInterface animalProtegido = null;

                                                        for (Integer id : idsAnimalesBatalla) {
                                                                if (arrayAnimalesBatalla[animalBatallaElegido] == id) {
                                                                        animalProtegido = animalService
                                                                                        .devolverAnimalSeleccionadoPorId(
                                                                                                        jugadorActual.getAnimalesEnReposo(),
                                                                                                        id);
                                                                }
                                                        }

                                                        animalService.hacerAnimalIndestructible(animalProtegido);
                                                        habilidad.setEnCementerio(true);
                                                        habilidad.setEnMano(false);
                                                }

                                                break;
                                        default:
                                                break;
                                }

                        } else {
                                JOptionPane.showMessageDialog(null,
                                                "Actualmente no tienes la cantidad de alimentos necesarios para activar esta habilidad.",
                                                "Sin Alimentos", JOptionPane.WARNING_MESSAGE);
                        }

                }
        }
}
