package service;

import java.util.List;

import domain.Jugador;
import inter.CartaInterface;

public class JugadorService {

    public Jugador crearJugador(String nombre, String contrasena, List<CartaInterface> mazo) {
        return new Jugador(nombre, contrasena, mazo);
    }

}
