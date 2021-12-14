package src.service;

import java.util.List;

import src.domain.Habitat;
import src.inter.CartaInterface;

public class HabitatService {
    public Habitat crearHabitat(int id, String nombre, String efecto, int coste, String tipoMazo) {
        return new Habitat(id, nombre, efecto, coste, tipoMazo);
    }

    public String devolverDescripcionHabitats(List<CartaInterface> zonaConHabitats) {
        if (zonaConHabitats.size() == 0) {
            return "Sin cartas";

        } else {
            String cartasInspeccionadas = "";

            for (int i = 1; i <= zonaConHabitats.size(); i++) {

                CartaInterface carta = zonaConHabitats.get(zonaConHabitats.size() - i);
                if (carta instanceof Habitat) {
                    Habitat habitat = (Habitat) carta;

                    cartasInspeccionadas = cartasInspeccionadas + "\n[" + habitat.getId() + "]\n" + habitat.getNombre()
                            + "\nCoste: " + habitat.getCoste() + "\nEfecto: " + habitat.getEfecto()
                            + "\n-----------------------------------------------------";

                }
            }
            return cartasInspeccionadas;
        }
    }

    public int devolverCantidadHabitatsPorZona(List<CartaInterface> zona) {
        int cantidadHabitats = 0;

        for (CartaInterface carta : zona) {
            if (carta instanceof Habitat) {
                cantidadHabitats++;
                System.out.println(cantidadHabitats);

            }

        }

        return cantidadHabitats;

    }

}
