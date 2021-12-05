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

        int alimentosConsumidos = 0;
        for (CartaInterface carta : jugadorActual.getAlimentosEnReserva()) {

            if (alimentosConsumidos < alimentosAConsumir) {
                Alimento alimento = (Alimento) carta;
                alimento.setEnReservaDeAlimentos(false);
                alimento.setEnAlimentoConsumidos(true);
                alimentosConsumidos++;
            }
        }

    }

    public int devolverCantidadAlimentosReserva(Jugador jugadorActual) {
        return jugadorActual.getAlimentosEnReserva().size();
    }
}
