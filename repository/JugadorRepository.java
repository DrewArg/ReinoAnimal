package repository;

import java.util.ArrayList;
import java.util.List;

import domain.Jugador;

public class JugadorRepository {

    private List<Jugador> jugadores = new ArrayList<Jugador>();

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public void eliminarJugador(Jugador jugador) {
        jugadores.remove(jugador);
    }

    public boolean validarJugador(Jugador jugadorActual) {

        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equalsIgnoreCase(jugadorActual.getNombre())
                    && jugador.getContrasena().equalsIgnoreCase(jugadorActual.getContrasena())) {
                return true;
            }
        }
        return false;
    }

    public Jugador devolverJugadorValidado(Jugador jugadorActual) {
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equalsIgnoreCase(jugadorActual.getNombre())
                    && jugador.getContrasena().equalsIgnoreCase(jugadorActual.getContrasena())) {
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


    //este metodo hay que repensarlo
    public int getCantidadJugadores() {
        return jugadores.size();
    }

}
