package service;

import domain.Habitat;

public class HabitatService {
    public Habitat crearHabitat(int id, String nombre, String efecto, int coste, boolean sePuedeBajarTablero,
            boolean enLineaApoyo, boolean enCementerio, String tipoMazo) {
        return new Habitat(id, nombre, efecto, coste, sePuedeBajarTablero, enLineaApoyo, enCementerio, tipoMazo);
    }
}
