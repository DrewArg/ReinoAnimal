
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import domain.Jugador;
import inter.CartaInterface;
import repository.CartaRepository;
import service.JugadorService;

public class Main {

        public static void main(String[] args) {
                JugadorService jugadorService = new JugadorService();
                CartaRepository cartaRepository = new CartaRepository();

                String[] menuLogin = { "Ingresar 2", "Registrar 2", "Ingresar 1 y Registrar 1", "Salir" };
                int opcionElegida = JOptionPane.showOptionDialog(null, "¡Bienvenidos a la Batalla del Reino Animal!",
                                "Jugadores", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                                menuLogin, 0);

                while (opcionElegida != 3) {
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

                                Jugador jugador1 = jugadorService.crearJugador(nombreJugador1, contrasenaJugador1);

                                Jugador jugador2 = jugadorService.crearJugador(nombreJugador2, contrasenaJugador2);

                                List<Jugador> jugadoresPartida = jugadorService.ingresarDosJugadores(jugador1,
                                                jugador2);

                                if (jugadoresPartida.size() < 2) {
                                        JOptionPane.showMessageDialog(null, "Uno o más datos ingresados son erróneos.",
                                                        "Error en el ingreso", JOptionPane.ERROR_MESSAGE);
                                } else {
                                        // iniciarPartida(jugador1, jugador2);
                                }

                        } else if (opcionElegida == 1) {
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

                                if (jugadorService.nombresJugadoresDisponibles(nombreJugador1, nombreJugador2)) {
                                        String[] tiposMazo = { "Terrestre", "Acuatico" };

                                        int mazoElegidoJugador1 = JOptionPane.showOptionDialog(null,
                                                        "Jugador 1, selecciona tu tipo de mazo.", "Tipo de mazo",
                                                        JOptionPane.QUESTION_MESSAGE, JOptionPane.DEFAULT_OPTION, null,
                                                        tiposMazo, 0);

                                        List<CartaInterface> mazoJugador1 = new ArrayList<CartaInterface>();
                                        List<CartaInterface> mazoJugador2 = new ArrayList<CartaInterface>();

                                        if (mazoElegidoJugador1 == 0) {
                                                mazoJugador1 = cartaRepository.seleccionarMazo(tiposMazo[0]);
                                        } else {
                                                mazoJugador1 = cartaRepository.seleccionarMazo(tiposMazo[1]);
                                        }

                                        int mazoElegidoJugador2 = JOptionPane.showOptionDialog(null,
                                                        "Jugador 2, selecciona tu tipo de mazo.", "Tipo de mazo",
                                                        JOptionPane.QUESTION_MESSAGE, JOptionPane.DEFAULT_OPTION, null,
                                                        tiposMazo, 1);

                                        if (mazoElegidoJugador2 == 0) {
                                                mazoJugador2 = cartaRepository.seleccionarMazo(tiposMazo[0]);
                                        } else {
                                                mazoJugador2 = cartaRepository.seleccionarMazo(tiposMazo[1]);
                                        }

                                        jugadorService.crearJugador(nombreJugador1, contrasenaJugador1, mazoJugador1);
                                        jugadorService.crearJugador(nombreJugador2, contrasenaJugador2, mazoJugador2);

                                } else {
                                        JOptionPane.showMessageDialog(null,
                                                        "Alguno de los nombres ya existe en el sistema.",
                                                        "Nombre existente", JOptionPane.ERROR_MESSAGE);
                                }

                        }

                }

        }
}