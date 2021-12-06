package src.service;

import java.util.ArrayList;
import java.util.List;

import src.domain.Jugador;
import src.inter.CartaInterface;
import src.repository.JugadorRepository;

public class JugadorService {

    JugadorRepository jugadorRepository = new JugadorRepository();
    CartaService cartaService = new CartaService();
    AnimalService animalService = new AnimalService();
    AlimentoService alimentoService = new AlimentoService();

    public Jugador crearJugadorGuardarloYDevolverlo(String nombre, String contrasena, List<CartaInterface> mazo) {
        Jugador jugador = new Jugador(nombre, contrasena, mazo);
        jugadorRepository.agregarJugador(jugador);
        return jugador;
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

    public Jugador validarJugadorYDevolverlo(Jugador jugador) {

        if (jugadorRepository.validarJugador(jugador)) {
            return jugadorRepository.devolverJugadorValidado(jugador);
        }

        return null;
    }

    public List<Jugador> validarDosJugadores(Jugador jugador1, Jugador jugador2) {

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

    public boolean nombreJugadorDisponible(String nombreJugador) {
        if (jugadorRepository.nombreJugadorDisponible(nombreJugador)) {
            return true;
        }
        return false;

    }

}
