package utilities;

import java.util.List;

import domain.Alimento;
import domain.Animal;
import domain.Habilidad;
import domain.Habitat;
import inter.CartaInterface;

public class Inspector {

    public static String devolverCartasEnZonaComoMensaje(List<CartaInterface> zonaAInspeccionar) {

        if (zonaAInspeccionar.size() == 0) {
            return "Sin cartas";
        } else {

            String cartasInspeccionadas = "";

            for (int i = 1; i <= zonaAInspeccionar.size(); i++) {

                CartaInterface carta = zonaAInspeccionar.get(zonaAInspeccionar.size() - i);

                if (carta instanceof Animal) {
                    Animal animal = (Animal) carta;

                    cartasInspeccionadas = cartasInspeccionadas + "\n[" + animal.getId() + "]\n" + animal.getNombre()
                            + "\nCoste: " + animal.getCoste() + "\nDaño: " + animal.getDano() + "\nEfecto: "
                            + animal.getEfecto() + "\n-----------------------------------------------------";

                } else if (carta instanceof Alimento) {

                    Alimento alimento = (Alimento) carta;

                    cartasInspeccionadas = cartasInspeccionadas + "\n[" + alimento.getId() + "]\n"
                            + alimento.getNombre() + "\n-----------------------------------------------------";

                } else if (carta instanceof Habilidad) {
                    Habilidad habilidad = (Habilidad) carta;

                    cartasInspeccionadas = cartasInspeccionadas + "\n[" + habilidad.getId() + "]\n"
                            + habilidad.getNombre() + "\nCoste: " + habilidad.getCoste() + "\nEfecto: "
                            + habilidad.getEfecto() + "\n-----------------------------------------------------";

                } else if (carta instanceof Habitat) {
                    Habitat habitat = (Habitat) carta;

                    cartasInspeccionadas = cartasInspeccionadas + "\n[" + habitat.getId() + "]\n" + habitat.getNombre()
                            + "\nCoste: " + habitat.getCoste() + "\nEfecto: " + habitat.getEfecto()
                            + "\n-----------------------------------------------------";

                }
            }

            return cartasInspeccionadas;
        }

    }

    public static Integer[] devolverIDsCartasEnZona(List<CartaInterface> zonaAInspeccionar) {

        Integer[] idsZona = new Integer[zonaAInspeccionar.size()];

        for (int i = 0; i < zonaAInspeccionar.size(); i++) {
            idsZona[i] = zonaAInspeccionar.get(i).getId();
        }

        return idsZona;
    }

}
