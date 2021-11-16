package service;

import java.util.ArrayList;
import java.util.List;

import domain.Jugador;
import inter.CartaInterface;
import repository.JugadorRepository;

public class JugadorService {

    JugadorRepository jugadorRepository = new JugadorRepository();

    public void crearJugadorYGuardarlo(String nombre, String contrasena, List<CartaInterface> mazo) {
        Jugador jugador = new Jugador(nombre, contrasena, mazo);
        jugadorRepository.agregarJugador(jugador);
    }

    public Jugador crearJugadorYDevolverlo(String nombre, String contrasena) {
        return new Jugador(nombre, contrasena);
    }

    public boolean validarJugador(Jugador jugador) {
        if (jugadorRepository.validarJugador(jugador)) {
            return true;
        } else {
            return false;
        }
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

    public Jugador ingresarJugador(Jugador jugador) {

        if (jugadorRepository.validarJugador(jugador)) {
            return jugadorRepository.devolverJugadorValidado(jugador);
        }

        return null;
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

    public boolean nombreJugadorDisponible(String nombreJugador) {
        if (jugadorRepository.nombreJugadorDisponible(nombreJugador)) {
            return true;
        }
        return false;

    }

    public int getCantidadJugadores() {
        return jugadorRepository.getCantidadJugadores();
    }

    public List<Jugador> getJugadores() {
        return jugadorRepository.getJugadores();
    }

}
