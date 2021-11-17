package domain;

import inter.CartaInterface;

public class Animal implements CartaInterface {
    private int id;
    private String nombre;
    private String efecto;
    private int coste;
    private int dano;
    private boolean sePuedeBajarTablero;

    private boolean enReposo;
    private boolean enBatalla;
    private boolean enMazo;
    private boolean enTablero;
    private boolean enTableroCementerio;
    private boolean enMano;
    private String tipoMazo;

    public Animal(int id, String nombre, String efecto, int coste, int dano, String tipoMazo) {
        this.id = id;
        this.nombre = nombre;
        this.efecto = efecto;
        this.coste = coste;
        this.dano = dano;
        this.tipoMazo = tipoMazo;

        inicializarFlags();

    }

    private void inicializarFlags() {
        enMazo = false;

        sePuedeBajarTablero = false;
        enTablero = false;
        enTableroCementerio = false;
        enReposo = false;
        enBatalla = false;

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

    public String getTipoMazo() {
        return tipoMazo;
    }

    public int getCoste() {
        return coste;
    }

    public void setCoste(int coste) {
        this.coste = coste;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public boolean isSePuedeBajarTablero() {
        return sePuedeBajarTablero;
    }

    public void setSePuedeBajarTablero(boolean sePuedeBajarTablero) {
        this.sePuedeBajarTablero = sePuedeBajarTablero;
    }

    public boolean isEnReposo() {
        return enReposo;
    }

    public void setEnReposo(boolean enReposo) {
        this.enReposo = enReposo;
    }

    public boolean isEnBatalla() {
        return enBatalla;
    }

    public void setEnBatalla(boolean enBatalla) {
        this.enBatalla = enBatalla;
    }

    public boolean isEnTableroCementerio() {
        return enTableroCementerio;
    }

    public void setEnTableroCementerio(boolean enCementerio) {
        this.enTableroCementerio = enCementerio;
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
