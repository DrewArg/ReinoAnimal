package service;

import domain.Alimento;

public class AlimentoService {
    public Alimento crearAlimento(int id, String nombre, boolean sePuedeBajarTablero, boolean enReservaDeAlimentos,
            boolean enAlimentoConsumidos, boolean enCementerio, String tipoMazo) {
        return new Alimento(id, nombre, sePuedeBajarTablero, enReservaDeAlimentos, enAlimentoConsumidos, enCementerio,
                tipoMazo);
    }
}
