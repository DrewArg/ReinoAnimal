package service;

import domain.Alimento;
import domain.Jugador;
import inter.CartaInterface;

public class AlimentoService {
    public Alimento crearAlimento(int id, String nombre, String tipoMazo) {
        return new Alimento(id, nombre, tipoMazo);
    }

    public void pasarAlimentosConsumidosAReserva(Jugador jugadorActual) {
        for (CartaInterface carta : jugadorActual.getAlimentosConsumidos()) {
            Alimento alimento = (Alimento) carta;
            alimento.setEnAlimentoConsumidos(false);
            alimento.setEnReservaDeAlimentos(true);

        }
    }

    public void consumirAlimentosEnReserva(Jugador jugadorActual, int alimentosAConsumir) {
        for (int i = 0; i < alimentosAConsumir; i++) {
            Alimento alimento = (Alimento) jugadorActual.getAlimentosEnReserva().get(i);
            alimento.setEnReservaDeAlimentos(false);
            alimento.setEnAlimentoConsumidos(true);
        }
    }

    public int devolverCantidadAlimentosReserva(Jugador jugadorActual) {
        return jugadorActual.getAlimentosEnReserva().size();
    }
}
