package src.service;

import src.domain.Id;

public class IdService {
    public int devolverIdInicial(Id id) {

        int idInicialActual = id.getId() * id.getMultiplicando();

        id.setMultiplicando(id.getMultiplicando() + 1);

        return idInicialActual;
    }
}
