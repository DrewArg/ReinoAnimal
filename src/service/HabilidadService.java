package src.service;

import java.util.ArrayList;
import java.util.List;

import src.domain.Habilidad;
import src.inter.CartaInterface;

public class HabilidadService {
    public Habilidad crearHabilidad(int id, String nombre, String efecto, int coste, String tipoMazo) {
        return new Habilidad(id, nombre, efecto, coste, tipoMazo);
    }

    public int devolverCantidadHabilidadesPorZona(List<CartaInterface> zona) {

        int contador = 0;
        for (CartaInterface carta : zona) {
            if (carta instanceof Habilidad) {
                contador++;
            }
        }

        return contador;
    }

    public String devolverDescripcionHabilidadesPorZona(List<CartaInterface> zona) {
        zona.sort((a1, a2) -> ((a2.getId()).compareTo(a1.getId())));
        String cartasInspeccionadas = "";

        for (int i = 1; i <= zona.size(); i++) {

            CartaInterface carta = zona.get(zona.size() - i);

            if (carta instanceof Habilidad) {
                Habilidad habilidad = (Habilidad) carta;

                cartasInspeccionadas = cartasInspeccionadas + "\n[" + habilidad.getId() + "]\nTipo: "
                        + habilidad.getTipoCarta() + "\n"
                        + habilidad.getNombre() + "\nCoste: " + habilidad.getCoste() + "\nEfecto: "
                        + habilidad.getEfecto() + "\n-----------------------------------------------------";

            }
        }

        return cartasInspeccionadas;

    }

    public List<Integer> devolverIdsHabilidadesEnZona(List<CartaInterface> zona) {
        List<Integer> auxiliar = new ArrayList<Integer>();

        for (CartaInterface carta : zona) {
            if (carta instanceof Habilidad) {
                auxiliar.add(carta.getId());
            }
        }

        auxiliar.sort((a1, a2) -> (a1.compareTo(a2)));
        return auxiliar;
    }

}
