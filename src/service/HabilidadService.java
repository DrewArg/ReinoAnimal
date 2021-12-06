package src.service;

import src.domain.Habilidad;

public class HabilidadService {
    public Habilidad crearHabilidad(int id, String nombre, String efecto, int coste, String tipoMazo) {
        return new Habilidad(id, nombre, efecto, coste, tipoMazo);
    }

}
