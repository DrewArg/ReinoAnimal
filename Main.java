
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import domain.Jugador;
import inter.CartaInterface;
import service.CartaService;
import service.JugadorService;

public class Main {

        public static void main(String[] args) {
                JugadorService jugadorService = new JugadorService();
                CartaService cartaService = new CartaService();

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

                                List<Jugador> jugadoresPartida = jugadorService.ingresarDosJugadores(jugador1,
                                                jugador2);

                                if (jugadoresPartida.size() < 2) {
                                        JOptionPane.showMessageDialog(null, "Uno o más datos ingresados son erróneos.",
                                                        "Error en el ingreso", JOptionPane.ERROR_MESSAGE);

                                } else {
                                        JOptionPane.showMessageDialog(null, "Arranca la partida", "Inicio",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                        // iniciarPartida(jugador1, jugador2);
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

                                        jugadorService.crearJugadorYGuardarlo(nombreJugador1, contrasenaJugador1,
                                                        mazoJugador1);
                                        jugadorService.crearJugadorYGuardarlo(nombreJugador2, contrasenaJugador2,
                                                        mazoJugador2);

                                        List<Jugador> jugadores = jugadorService.getJugadores();

                                        for (Jugador jugador : jugadores) {
                                                JOptionPane.showMessageDialog(null,
                                                                "Ficha Jugador\n>Nombre: " + jugador.getNombre()
                                                                                + "\nContraseña: "
                                                                                + jugador.getContrasena()
                                                                                + "\nCartas en el mazo:       "
                                                                                + jugador.getMazo().size(),
                                                                "Ficha de jugador " + jugador.getNombre(),
                                                                JOptionPane.INFORMATION_MESSAGE);
                                        }

                                        JOptionPane.showMessageDialog(null, "Arranca la partida", "Inicio",
                                                        JOptionPane.INFORMATION_MESSAGE);

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

                                        jugadorRegistrado = jugadorService.ingresarJugador(jugadorRegistrado);

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

                                                jugadorService.crearJugadorYGuardarlo(nombreJugadorNuevo,
                                                                contrasenaJugadorNuevo, mazoJugadorNuevo);

                                                JOptionPane.showMessageDialog(null, "Arranca la partida", "Inicio",
                                                                JOptionPane.INFORMATION_MESSAGE);

                                        } else {
                                                JOptionPane.showMessageDialog(null, "Ese nombre de usuario ya existe.",
                                                                "Usuario ya existente", JOptionPane.WARNING_MESSAGE);
                                        }

                                } else {
                                        JOptionPane.showMessageDialog(null, "Uno o más datos ingresados son erróneos.",
                                                        "Error en el ingreso", JOptionPane.ERROR_MESSAGE);

                                }

                        }

                }

        }
}