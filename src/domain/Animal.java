package src.domain;

import src.inter.CartaInterface;

public class Animal implements CartaInterface {
    private int id;
    private String nombre;
    private String efecto;
    private boolean efectoManual;
    private boolean efectoPasivo;
    private int coste;
    private int dano;
    private int danoOrginal;
    private String tipoMazo;

    private boolean sePuedeBajarTablero;
    private boolean enReposo;
    private boolean enBatalla;
    private boolean enMazo;
    private boolean enCementerio;
    private boolean enMano;

    private boolean efectoActivo;
    private boolean efectoDefensivo;

    public Animal(int id, String nombre, int coste, int dano, String tipoMazo) {
        this.id = id;
        this.nombre = nombre;
        this.coste = coste;
        this.dano = dano;
        this.tipoMazo = tipoMazo;

        efecto = "";
        efectoManual = false;
        efectoPasivo = false;
        danoOrginal = dano;

        inicializarFlags();
    }

    public Animal(int id, String nombre, String efecto, int coste, int dano, String tipoMazo, boolean efectoManual,
            boolean efectoPasivo, boolean efectoDefensivo) {
        this.id = id;
        this.nombre = nombre;
        this.efecto = efecto;
        this.coste = coste;
        this.dano = dano;
        this.tipoMazo = tipoMazo;
        this.efectoManual = efectoManual;
        this.efectoPasivo = efectoPasivo;
        this.efectoDefensivo = efectoDefensivo;
        danoOrginal = dano;

        inicializarFlags();

    }

    private void inicializarFlags() {
        enMazo = true;

        sePuedeBajarTablero = false;
        enCementerio = false;
        enReposo = false;
        enBatalla = false;

        enMano = false;

        efectoActivo = false;

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

    public int getDanoOriginal() {
        return danoOrginal;
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

    public boolean isEnCementerio() {
        return enCementerio;
    }

    public void setEnCementerio(boolean enCementerio) {
        this.enCementerio = enCementerio;
    }

    public boolean isEnMazo() {
        return enMazo;
    }

    public void setEnMazo(boolean enMazo) {
        this.enMazo = enMazo;
    }

    public boolean isEnMano() {
        return enMano;
    }

    public void setEnMano(boolean enMano) {
        this.enMano = enMano;
    }

    public boolean isEfectoActivo() {
        return efectoActivo;
    }

    public void setEfectoActivo(boolean efectoActivo) {
        this.efectoActivo = efectoActivo;
    }

    public boolean isEfectoManual() {
        return efectoManual;
    }

    public boolean isEfectoPasivo() {
        return efectoPasivo;
    }

    public boolean isTieneEfectoDefensivo() {
        return efectoDefensivo;
    }

}
