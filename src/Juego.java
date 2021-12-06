package src;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import src.domain.Jugador;

import src.inter.CartaInterface;

import src.service.AlimentoService;
import src.service.AnimalService;
import src.service.CartaService;
import src.service.HabilidadService;
import src.service.HabitatService;
import src.service.JugadorService;

public class Juego {

        private JugadorService jugadorService = new JugadorService();
        private CartaService cartaService = new CartaService();

        private AnimalService animalService = new AnimalService();
        private AlimentoService alimentoService = new AlimentoService();
        private HabilidadService habilidadService = new HabilidadService();
        private HabitatService habitatService = new HabitatService();

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

                                Jugador jugador1 = jugadorService.crearJugadorYDevolverlo(nombreJugador1,
                                                contrasenaJugador1);

                                Jugador jugador2 = jugadorService.crearJugadorYDevolverlo(nombreJugador2,
                                                contrasenaJugador2);

                                List<Jugador> jugadoresPartida = jugadorService.validarDosJugadores(jugador1, jugador2);

                                if (jugadoresPartida.size() < 2) {
                                        JOptionPane.showMessageDialog(null, "Uno o más datos ingresados son erróneos.",
                                                        "Error en el ingreso", JOptionPane.ERROR_MESSAGE);

                                } else {

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

                                if (jugadorService.validarJugador(jugadorRegistrado)) {

                                        jugadorRegistrado = jugadorService.validarJugadorYDevolverlo(jugadorRegistrado);

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

                animalService.reiniciarEfectosAnimalesManuales(jugadorActual);
                animalService.activarPasivamenteEfectoAnimal(jugadorActual, cartaService);

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
                                atacar(jugadorActual, jugadorEnemigo);

                        } else if (opcionElegida == 2) {

                                String[] opcionesEfecto = { "Animal en Reposo", "Habilidad en Mano", "Habitat en Apoyo",
                                                "Volver" };

                                int opcionEfectoElegida = JOptionPane.showOptionDialog(null,
                                                "¿Dónde se encuentra el efecto que quieres activar?",
                                                "Activar Efecto", JOptionPane.DEFAULT_OPTION,
                                                JOptionPane.QUESTION_MESSAGE, null, opcionesEfecto, 0);

                                switch (opcionEfectoElegida) {
                                        case 0:
                                                String descripcionAnimalesReposoConEfectoManual = cartaService
                                                                .devolverDescripcionAnimalesEnReposoConEfectoManual(
                                                                                jugadorActual.getAnimalesEnReposo());

                                                List<Integer> idsAnimalesReposoConEfectoManual = animalService
                                                                .devolverIdsAnimalesEnReposoConEfectoManual(
                                                                                jugadorActual);

                                                Object[] arrayAnimalesEnReposoConEfectoManual = idsAnimalesReposoConEfectoManual
                                                                .toArray();

                                                Integer cartaElegida = JOptionPane.showOptionDialog(null,
                                                                "¿De qué animal deseas activar el efecto? \n"
                                                                                + descripcionAnimalesReposoConEfectoManual,
                                                                "Activar Efecto Animal Manualmente",
                                                                JOptionPane.DEFAULT_OPTION,
                                                                JOptionPane.INFORMATION_MESSAGE,
                                                                null, arrayAnimalesEnReposoConEfectoManual, 0);

                                                CartaInterface animalConEfectoManual = null;

                                                for (Integer id : idsAnimalesReposoConEfectoManual) {

                                                        if (arrayAnimalesEnReposoConEfectoManual[cartaElegida] == id) {
                                                                animalConEfectoManual = animalService
                                                                                .devolverAnimalSeleccionadoPorId(
                                                                                                jugadorActual.getAnimalesEnReposo(),
                                                                                                id);
                                                        }
                                                }

                                                switch (animalConEfectoManual.getNombre()) {

                                                        case "Iguana":
                                                            // String efecto = "Puede tomar el ataque de un enemigo y sumarlo al suyo hasta
                                                            // el final del turno.";

                                                            String descripcionAnimalesEnemigosEnReposo = cartaService.devolverCartasEnZonaComoMensaje(jugadorEnemigo.getAnimalesEnReposo());

                                                            List<Integer> idsAnimalesEnemigosEnReposo = animalService.devolverIdsAnimalesEnReposo(jugadorEnemigo);

                                                            Object[] arrayAnimalesEnemigosEnReposo = idsAnimalesEnemigosEnReposo.toArray();

                                                            Integer animalSeleccionado = JOptionPane.showOptionDialog(null, "¿De qué animal quieres tomar el ataque? \n" + descripcionAnimalesEnemigosEnReposo, "Activar efecto Iguana", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, arrayAnimalesEnemigosEnReposo, 0);

                                                            CartaInterface animalEnemigoElegido = null;

                                                            for(Integer id: idsAnimalesEnemigosEnReposo){
                                                                    if(arrayAnimalesEnemigosEnReposo[animalSeleccionado] == id){
                                                                       animalService.activarEfectoIguanaManualmente(animalConEfectoManual, animalEnemigoElegido, cartaService);
                                                                    }
                                                            }
                                            
                                                            
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

                                               

                                                break;

                                        case 1:
                                                // habilidad
                                                break;

                                        case 2:
                                                // habitat
                                                break;

                                        case 3:
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

                if (descripcionCartasMano.equalsIgnoreCase("Sin cartas")) {
                        JOptionPane.showMessageDialog(null,
                                        "Actualmente no tienes cartas disponibles para bajar al tablero.",
                                        "Sin cartas disponibles", JOptionPane.WARNING_MESSAGE);
                } else {

                        List<Integer> idsCartasMano = cartaService.devolverIdsCartasDisponiblesParaBajar(jugadorActual,
                                        alimentosDisponibles);

                        Object[] arrayCartasMano = idsCartasMano.toArray();

                        Integer cartaElegida = JOptionPane.showOptionDialog(null, descripcionCartasMano,
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
                int animalesReposoAtacante = animalService.devolverCantidadAnimalesEnReposo(jugadorActual);

                if (animalesReposoAtacante == 0) {
                        JOptionPane.showMessageDialog(null,
                                        jugadorActual.getTurno()
                                                        + " actualmente no tienes animales disponibles para atacar",
                                        "Sin animales reposando", JOptionPane.WARNING_MESSAGE);
                } else {

                        String descripcionAnimalesReposo = animalService
                                        .devolverDescripcionesAnimalesEnReposo(jugadorActual, cartaService);

                        List<Integer> idsAnimalesReposo = animalService.devolverIdsAnimalesEnReposo(jugadorActual);

                        Object[] arrayIdsAnimalesEnReposo = idsAnimalesReposo.toArray();

                        Integer cartaElegida = JOptionPane.showOptionDialog(null, descripcionAnimalesReposo,
                                        "Cartas disponibles para bajar al tablero",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                                        null, arrayIdsAnimalesEnReposo, 0);

                        CartaInterface animalAtacante = null;

                        for (Integer idAnimalEnReposo : idsAnimalesReposo) {
                                if (arrayIdsAnimalesEnReposo[cartaElegida] == idAnimalEnReposo) {
                                        animalAtacante = animalService.pasarYDevolverAnimalEnReposoABatallaPorId(
                                                        jugadorActual, idAnimalEnReposo);
                                }
                        }

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

                                int cantidadAnimalesEnReposoDefensa = animalService
                                                .devolverCantidadAnimalesEnReposo(jugadorEnemigo);

                                if (cantidadAnimalesEnReposoDefensa == 0) {
                                        JOptionPane.showMessageDialog(null, jugadorEnemigo.getNombre()
                                                        + " actualmente no tienes animales disponibles para defender",
                                                        "Sin animales reposando", JOptionPane.WARNING_MESSAGE);

                                        int dañoAnimalAtacante = animalService
                                                        .mandarCartasAlCementerioPorAnimalAtacante(
                                                                        jugadorEnemigo, animalAtacante);

                                        JOptionPane.showMessageDialog(null,
                                                        jugadorEnemigo.getNombre() + " ha botado " + dañoAnimalAtacante
                                                                        + " cartas de su mazo.\nLe quedan: "
                                                                        + jugadorEnemigo.getCantidadCartasMazo()
                                                                        + " cartas en su mazo.",
                                                        "Daño recibido", JOptionPane.WARNING_MESSAGE);

                                } else {

                                        String descripcionAnimalesDefensoresReposo = animalService
                                                        .devolverDescripcionesAnimalesEnReposo(jugadorEnemigo,
                                                                        cartaService);

                                        List<Integer> idsAnimalesDefensoresReposo = animalService
                                                        .devolverIdsAnimalesEnReposo(jugadorEnemigo);

                                        Object[] arrayIdsAnimalesDefensoresEnReposo = idsAnimalesDefensoresReposo
                                                        .toArray();

                                        Integer cartaDefensoraElegida = JOptionPane.showOptionDialog(null,
                                                        descripcionAnimalesDefensoresReposo,
                                                        "Cartas disponibles para bajar al tablero",
                                                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
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

                                        if (calculoDaño < 0) {
                                                animalService.mandarCartasAlCementerioPorCalculoDaño(jugadorActual,
                                                                Math.abs(calculoDaño));

                                                JOptionPane.showMessageDialog(null,
                                                                jugadorActual.getNombre() + " ha botado "
                                                                                + Math.abs(calculoDaño)
                                                                                + " cartas de su mazo.\nEl animal atacante ha sido destruido. \nLe quedan: "
                                                                                + jugadorActual.getCantidadCartasMazo()
                                                                                + " cartas en su mazo.",
                                                                "Daño recibido", JOptionPane.ERROR_MESSAGE);

                                        } else if (calculoDaño == 0) {
                                                JOptionPane.showMessageDialog(null, "El calculo de daño ha dado "
                                                                + calculoDaño
                                                                + " y por esta razón ninguno de los jugadores ha botado cartas de su mazo.\nAmbos animales han sido destruidos en la batalla.",
                                                                "Daño igualado", JOptionPane.INFORMATION_MESSAGE);

                                        } else if (calculoDaño > 0) {
                                                animalService.mandarCartasAlCementerioPorCalculoDaño(jugadorEnemigo,
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
                                JOptionPane.showMessageDialog(null, "Aún no codeado", "Aun no codeado",
                                                JOptionPane.ERROR_MESSAGE);
                        } else if (decisionDefensa == 2) {

                                int dañoAnimalAtacante = animalService.mandarCartasAlCementerioPorAnimalAtacante(
                                                jugadorEnemigo, animalAtacante);
                                JOptionPane.showMessageDialog(null, jugadorEnemigo.getNombre() +
                                                " ha botado "
                                                + dañoAnimalAtacante + " cartas de su mazo.\nLe quedan: "
                                                + jugadorEnemigo.getCantidadCartasMazo() + " cartas en su mazo.",
                                                "Daño recibido", JOptionPane.WARNING_MESSAGE);
                        }

                }

        }

        private void inspeccionarZonaJuego(Jugador jugadorActual, Jugador jugadorEnemigo) {
                String[] zonasJuego = { "Mi mano", "Mi Tablero", "Tablero enemigo" };

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
                                                "Cementerio", "Alimentos en Reserva", "Alimentos Consumidos" };
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
                                                "Alimentos Consumidos" };
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

                        JOptionPane.showMessageDialog(null, descripcionCartasZona, "Cartas en esta zona",
                                        JOptionPane.INFORMATION_MESSAGE);

                }
        }

}
