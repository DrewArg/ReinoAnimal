package domain;

import inter.CartaInterface;

public class Alimento implements CartaInterface {

    private int id;
    private String nombre;
    private boolean sePuedeBajarTablero;
    private boolean enReservaDeAlimentos;
    private boolean enAlimentoConsumidos;
    private boolean enMazo;
    private boolean enTablero;
    private boolean enTableroCementerio;
    private boolean enMano;
    private String tipoMazo;

    public Alimento(int id, String nombre, String tipoMazo) {
        this.id = id;
        this.nombre = nombre;
        this.tipoMazo = tipoMazo;

        inicializarFlags();
    }

    private void inicializarFlags() {
        enMazo = true;

        sePuedeBajarTablero = false;
        enTablero = false;
        enTableroCementerio = false;
        enReservaDeAlimentos = false;
        enAlimentoConsumidos = false;

        enMano = false;

    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isSePuedeBajarTablero() {
        return sePuedeBajarTablero;
    }

    public void setSePuedeBajarTablero(boolean sePuedeBajarTablero) {
        this.sePuedeBajarTablero = sePuedeBajarTablero;
    }

    public boolean isEnReservaDeAlimentos() {
        return enReservaDeAlimentos;
    }

    public void setEnReservaDeAlimentos(boolean enReservaDeAlimentos) {
        this.enReservaDeAlimentos = enReservaDeAlimentos;
    }

    public boolean isEnAlimentoConsumidos() {
        return enAlimentoConsumidos;
    }

    public void setEnAlimentoConsumidos(boolean enAlimentoConsumidos) {
        this.enAlimentoConsumidos = enAlimentoConsumidos;
    }

    public boolean isEnTableroCementerio() {
        return enTableroCementerio;
    }

    public void setEnTableroCementerio(boolean enCementerio) {
        this.enTableroCementerio = enCementerio;
    }

    public String getTipoMazo() {
        return tipoMazo;
    }

    public void setTipoMazo(String tipoMazo) {
        this.tipoMazo = tipoMazo;
    }

    public boolean isEnMazo() {
        return enMazo;
    }

    public void setEnMazo(boolean enMazo) {
        this.enMazo = enMazo;
    }

    public boolean isEnTablero() {
        return enTablero;
    }

    public void setEnTablero(boolean enTablero) {
        this.enTablero = enTablero;
    }

    public boolean isEnMano() {
        return enMano;
    }

    public void setEnMano(boolean enMano) {
        this.enMano = enMano;
    }

}
