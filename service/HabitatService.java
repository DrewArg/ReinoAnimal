package service;

import java.util.ArrayList;
import java.util.List;

import domain.Habitat;
import inter.CartaInterface;

public class HabitatService {
    public Habitat crearHabitat(int id, String nombre, String efecto, int coste, String tipoMazo) {
        return new Habitat(id, nombre, efecto, coste, tipoMazo);
    }

    public List<CartaInterface> devolverHabitatsEnApoyo(List<CartaInterface> cartasTablero) {
        List<CartaInterface> auxiliar = new ArrayList<CartaInterface>();

        for (CartaInterface carta : cartasTablero) {
            if (carta instanceof Habitat) {
                Habitat habitat = (Habitat) carta;
                if (habitat.isEnLineaApoyo()) {
                    auxiliar.add(habitat);
                }
            }
        }

        return auxiliar;
    }
}
