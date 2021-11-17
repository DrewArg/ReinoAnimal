package domain;

import inter.CartaInterface;

public class Habilidad implements CartaInterface {
    private int id;
    private String nombre;
    private String efecto;
    private int coste;
    private boolean sePuedeBajarTablero;
    private boolean enMazo;
    private boolean enTablero;
    private boolean enTableroCementerio;
    private boolean enMano;
    private String tipoMazo;

    public Habilidad(int id, String nombre, String efecto, int coste, String tipoMazo) {
        this.id = id;
        this.nombre = nombre;
        this.efecto = efecto;
        this.coste = coste;
        this.tipoMazo = tipoMazo;

        inicializarFlags();
    }

    private void inicializarFlags() {
        enMazo = false;

        sePuedeBajarTablero = false;
        enTablero = false;
        enTableroCementerio = false;

        enMano = false;

    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEfecto() {
        return efecto;
    }

    public void setEfecto(String efecto) {
        this.efecto = efecto;
    }

    public int getCoste() {
        return coste;
    }

    public void setCoste(int coste) {
        this.coste = coste;
    }

    public boolean isSePuedeBajarTablero() {
        return sePuedeBajarTablero;
    }

    public void setSePuedeBajarTablero(boolean sePuedeBajarTablero) {
        this.sePuedeBajarTablero = sePuedeBajarTablero;
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

    public boolean isEnTableroCementerio() {
        return enTableroCementerio;
    }

    public void setEnTableroCementerio(boolean enTableroCementerio) {
        this.enTableroCementerio = enTableroCementerio;
    }

    public boolean isEnMano() {
        return enMano;
    }

    public void setEnMano(boolean enMano) {
        this.enMano = enMano;
    }

}
