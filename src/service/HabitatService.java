package src.service;

import src.domain.Habitat;

public class HabitatService {
    public Habitat crearHabitat(int id, String nombre, String efecto, int coste, String tipoMazo) {
        return new Habitat(id, nombre, efecto, coste, tipoMazo);
    }

}
