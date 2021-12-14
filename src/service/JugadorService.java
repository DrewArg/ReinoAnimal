package src.service;

import java.util.ArrayList;
import java.util.List;

import src.domain.Jugador;

import src.repository.JugadorRepository;

public class JugadorService {

    JugadorRepository jugadorRepository = new JugadorRepository();
    CartaService cartaService = new CartaService();
    AnimalService animalService = new AnimalService();
    AlimentoService alimentoService = new AlimentoService();

    public Jugador crearJugadorGuardarloYDevolverlo(String nombre, String contrasena,
            int idInicial) {
        Jugador jugador = new Jugador(nombre, contrasena, idInicial);
        jugadorRepository.agregarJugador(jugador);
        return jugador;
    }

    public Jugador crearJugadorYDevolverlo(String nombre, String contrasena) {
        return new Jugador(nombre, contrasena);
    }

    public Jugador devolverJugadorValidado(String nombre, String contrasena) {
        return jugadorRepository.devolverJugadorValidado(nombre, contrasena);
    }

    public boolean validarJugador(String nombreJugador, String contrasena) {
        if (jugadorRepository.validarJugador(nombreJugador, contrasena)) {
            return true;
        } else {
            return false;
        }
    }

    public Jugador validarJugadorYDevolverlo(String nombreJugador, String contrasena) {

        if (jugadorRepository.validarJugador(nombreJugador, contrasena)) {
            return jugadorRepository.devolverJugadorValidado(nombreJugador, contrasena);
        }

        return null;
    }

    public List<Jugador> validarDosJugadores(String nombreJugador1, String contrasenaJugador1, String nombreJugador2,
            String contrasenaJugador2) {

        List<Jugador> jugadoresPartida = new ArrayList<Jugador>();

        if (jugadorRepository.validarJugador(nombreJugador1, contrasenaJugador1)) {

            if (jugadorRepository.validarJugador(nombreJugador2, contrasenaJugador2)) {

                jugadoresPartida.add(jugadorRepository.devolverJugadorValidado(nombreJugador1, contrasenaJugador1));
                jugadoresPartida.add(jugadorRepository.devolverJugadorValidado(nombreJugador1, contrasenaJugador2));

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

    public boolean nombreJugadorDisponible(String nombreJugador) {
        if (jugadorRepository.nombreJugadorDisponible(nombreJugador)) {
            return true;
        }
        return false;

    }

}
