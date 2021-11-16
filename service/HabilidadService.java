package service;

import domain.Habilidad;

public class HabilidadService {
    public Habilidad crearHabilidad(int id, String nombre, String efecto, int coste, boolean sePuedeBajarTablero,
            boolean enCementerio, String tipoMazo) {
        return new Habilidad(id, nombre, efecto, coste, sePuedeBajarTablero, enCementerio, tipoMazo);
    }
}
