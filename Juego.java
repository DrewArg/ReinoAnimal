import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import domain.Jugador;
import inter.CartaInterface;
import service.CartaService;
import service.JugadorService;

public class Juego {
        JugadorService jugadorService = new JugadorService();
        CartaService cartaService = new CartaService();

        public void iniciar() {
                mostrarMenuLogin();
        }

        private void mostrarMenuLogin() {
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

                                        List<CartaInterface> mazoJugador1 = new ArrayList<CartaInterface>();
                                        List<CartaInterface> mazoJugador2 = new ArrayList<CartaInterface>();

                                        if (mazoElegidoJugador1 == 0) {
                                                mazoJugador1 = cartaService.seleccionarMazo(tiposMazo[0]);
                                        } else {
                                                mazoJugador1 = cartaService.seleccionarMazo(tiposMazo[1]);
                                        }

                                        int mazoElegidoJugador2 = JOptionPane.showOptionDialog(null,
                                                        nombreJugador2 + ", selecciona tu tipo de mazo.",
                                                        "Tipo de mazo", JOptionPane.DEFAULT_OPTION,
                                                        JOptionPane.QUESTION_MESSAGE, null, tiposMazo, 1);

                                        if (mazoElegidoJugador2 == 0) {
                                                mazoJugador2 = cartaService.seleccionarMazo(tiposMazo[0]);

                                        } else {
                                                mazoJugador2 = cartaService.seleccionarMazo(tiposMazo[1]);
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
                                                        mazoJugadorNuevo = cartaService.seleccionarMazo(tiposMazo[0]);
                                                } else {
                                                        mazoJugadorNuevo = cartaService.seleccionarMazo(tiposMazo[1]);
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
                regresarTodasLasCartasAlMazoYBarajar(jugador1, jugador2);

                JOptionPane.showMessageDialog(null,
                                "Ambos jugadores arracan con 25 cartas en su mazo, el jugador/a que se quede sin cartas en su mazo, perderá.",
                                "IMPORTANTE", JOptionPane.WARNING_MESSAGE);

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
                JOptionPane.showMessageDialog(null, "Primer turno de " + jugadorActual.getNombre(),
                                "Comienzo de partida", JOptionPane.INFORMATION_MESSAGE);

                JOptionPane.showMessageDialog(null, jugadorActual.getNombre() + " has robado tu mano inicial.",
                                "Mano Inicial", 1);

                int manoInicial = 4;

                jugadorActual.robarCartas(manoInicial);
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

                jugadorActual.robarCartas(1);
                JOptionPane.showMessageDialog(null, jugadorActual.getNombre() + " te quedan: "
                                + jugadorActual.getCartasMazo().size() + " cartas en tu mazo.");
                JOptionPane.showMessageDialog(null, "Fin de turno " + jugadorActual.getTurno(), "Fin Turno",
                                JOptionPane.INFORMATION_MESSAGE, null);
        }

        private void iniciarTercerTurnoEnAdelante(Jugador jugadorActual, Jugador jugadorEnemigo) {

                jugadorService.pasarAnimalesEnBatallaAReposo(jugadorActual);
                jugadorService.pasarAnimalesEnBatallaAReposo(jugadorActual);
                // jugadorActual.setAlimentosBajadosAlTablero(0);

                String[] opcionesTurno = { "Bajar una carta", "Atacar", "Activar un efecto",
                                "Inspeccionar Zona de Juego", "Pasar" };

                int opcionElegida = JOptionPane.showOptionDialog(null,
                                "Turno " + jugadorActual.getTurno() + ". ¿" + jugadorActual.getNombre()
                                                + " qué deseas hacer?",
                                "Turno " + jugadorActual.getNombre(), JOptionPane.DEFAULT_OPTION,
                                JOptionPane.QUESTION_MESSAGE, null, opcionesTurno, 2);

                while (opcionElegida != 4) {
                        if (opcionElegida == 0) {
                                // bajarUnaCarta(jugadorActual);

                        } else if (opcionElegida == 1) {
                                // atacar(jugadorActual, jugadorEnemigo);

                        } else if (opcionElegida == 2) {
                                // activarUnEfecto(jugadorActual);

                        } else if (opcionElegida == 3) {
                                // inspeccionarZonaJuego(jugadorActual, jugadorEnemigo);

                        }

                        opcionElegida = JOptionPane.showOptionDialog(null,
                                        "Turno " + jugadorActual.getTurno() + ". ¿" + jugadorActual.getNombre()
                                                        + " qué deseas hacer?",
                                        "Turno " + jugadorActual.getNombre(), JOptionPane.DEFAULT_OPTION,
                                        JOptionPane.QUESTION_MESSAGE, null, opcionesTurno, 2);

                }

                jugadorActual.robarCartas(1);
                JOptionPane.showMessageDialog(null, jugadorActual.getNombre() + " te quedan: "
                                + jugadorActual.getCartasMazo().size() + " cartas en tu mazo.");
                JOptionPane.showMessageDialog(null, "Fin de turno " + jugadorActual.getTurno(), "Fin Turno",
                                JOptionPane.INFORMATION_MESSAGE, null);

        }

        private void regresarTodasLasCartasAlMazoYBarajar(Jugador jugador1, Jugador jugador2) {
                jugador1.regresarTodasLasCartasAlMazoYBarajar();
                jugador2.regresarTodasLasCartasAlMazoYBarajar();
        }

}
