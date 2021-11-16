
import domain.Jugador;
import repository.CartaRepository;

import service.JugadorService;

public class Main {

    public static void main(String[] args) {
        JugadorService jugadorService = new JugadorService();
        CartaRepository cartaRepository = new CartaRepository();

        Jugador jugador1 = jugadorService.crearJugador("nombre", "contrasena", cartaRepository.getMazoTerrestre());

        System.out.println(cartaRepository.getCantidadCartasMazoTerrestre());

        System.out.println(jugador1.cantidadCartasMazo());
    }

}