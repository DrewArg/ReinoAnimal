package service;

import java.util.ArrayList;
import java.util.List;

import domain.Jugador;
import inter.CartaInterface;
import repository.JugadorRepository;

public class JugadorService {

    JugadorRepository jugadorRepository = new JugadorRepository();

    public Jugador crearJugador(String nombre, String contrasena, List<CartaInterface> mazo) {
        return new Jugador(nombre, contrasena, mazo);
    }

    public Jugador crearJugador(String nombre, String contrasena) {
        return new Jugador(nombre, contrasena);
    }

    public List<Jugador> ingresarDosJugadores(Jugador jugador1, Jugador jugador2) {

        List<Jugador> jugadoresPartida = new ArrayList<Jugador>();

        if (jugadorRepository.validarJugador(jugador1)) {
            if (jugadorRepository.validarJugador(jugador2)) {

                jugadoresPartida.add(jugadorRepository.devolverJugadorValidado(jugador1));
                jugadoresPartida.add(jugadorRepository.devolverJugadorValidado(jugador2));

            }
        }

        return jugadoresPartida;

    }

    public boolean nombresJugadoresDisponibles(String nombreJugador1, String nombreJugador2) {
        if (jugadorRepository.nombreJugadorDisponible(nombreJugador1)) {
            if (jugadorRepository.nombreJugadorDisponible(nombreJugador2)) {
                return true;
            }
            return false;
        }
        return false;
    }

}
