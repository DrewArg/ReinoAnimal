package service;

import java.util.ArrayList;
import java.util.List;

import domain.Alimento;
import inter.CartaInterface;

public class AlimentoService {
    public Alimento crearAlimento(int id, String nombre, String tipoMazo) {
        return new Alimento(id, nombre, tipoMazo);
    }

    public List<CartaInterface> devolverAlimentosEnReserva(List<CartaInterface> cartasTablero) {
        List<CartaInterface> auxiliar = new ArrayList<CartaInterface>();

        for (CartaInterface carta : cartasTablero) {
            if (carta instanceof Alimento) {
                Alimento alimento = (Alimento) carta;
                if (alimento.isEnReservaDeAlimentos()) {
                    auxiliar.add(alimento);
                }
            }
        }

        return auxiliar;
    }

    public List<CartaInterface> devolverAlimentosConsumidos(List<CartaInterface> cartasTablero) {
        List<CartaInterface> auxiliar = new ArrayList<CartaInterface>();

        for (CartaInterface carta : cartasTablero) {
            if (carta instanceof Alimento) {
                Alimento alimento = (Alimento) carta;
                if (alimento.isEnAlimentoConsumidos()) {
                    auxiliar.add(alimento);
                }
            }
        }

        return auxiliar;
    }

    public void pasarAlimentosConsumidosAReserva(List<CartaInterface> cartasTablero) {
        for (CartaInterface carta : cartasTablero) {
            if (carta instanceof Alimento) {
                Alimento alimento = (Alimento) carta;
                if (alimento.isEnAlimentoConsumidos()) {
                    alimento.setEnAlimentoConsumidos(false);
                    alimento.setEnReservaDeAlimentos(true);
                }
            }
        }
    }

    public int devolverCantidadAlimentosReserva(List<CartaInterface> cartasTablero) {
        int contador = 0;
        for (CartaInterface carta : cartasTablero) {
            if (carta instanceof Alimento) {
                Alimento alimento = (Alimento) carta;
                if (alimento.isEnReservaDeAlimentos()) {
                    contador++;
                }
            }
        }

        return contador;
    }
}
