package src.repository;

import java.util.ArrayList;
import java.util.List;

import src.domain.Jugador;

public class JugadorRepository {

    private List<Jugador> jugadores = new ArrayList<Jugador>();

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public boolean validarJugador(String nombreJugador, String contrasena) {

        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equalsIgnoreCase(nombreJugador)
                    && jugador.getContrasena().equalsIgnoreCase(contrasena)) {
                return true;
            }
        }
        return false;
    }

    public Jugador devolverJugadorValidado(String nombreJugador, String contrasena) {
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equalsIgnoreCase(nombreJugador)
                    && jugador.getContrasena().equalsIgnoreCase(contrasena)) {
                return jugador;
            }
        }
        return null;
    }

    public boolean nombreJugadorDisponible(String nombreJugador) {
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equalsIgnoreCase(nombreJugador)) {
                return false;
            }
        }
        return true;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public int getCantidadJugadores() {
        return jugadores.size();
    }

}
