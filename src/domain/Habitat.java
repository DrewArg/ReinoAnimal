package src.domain;

import src.inter.CartaInterface;

public class Habitat implements CartaInterface {
    private int id;
    private String nombre;
    private String efecto;
    private int coste;
    private String tipoMazo;

    private boolean sePuedeBajarTablero;
    private boolean enLineaApoyo;
    private boolean enMazo;
    private boolean enCementerio;
    private boolean enMano;

    private boolean efectoActivo;

    public Habitat(int id, String nombre, String efecto, int coste, String tipoMazo) {
        this.id = id;
        this.nombre = nombre;
        this.efecto = efecto;
        this.coste = coste;
        this.tipoMazo = tipoMazo;

        inicializarFlags();
    }

    private void inicializarFlags() {
        enMazo = true;

        sePuedeBajarTablero = false;
        enCementerio = false;
        enLineaApoyo = false;

        enMano = false;
        efectoActivo = false;
    }

    public int getId() {
        return id;
    }

    public int getCoste() {
        return coste;
    }

    public void setCoste(int coste) {
        this.coste = coste;
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

    public boolean isSePuedeBajarTablero() {
        return sePuedeBajarTablero;
    }

    public void setSePuedeBajarTablero(boolean sePuedeBajarTablero) {
        this.sePuedeBajarTablero = sePuedeBajarTablero;
    }

    public boolean isEnLineaApoyo() {
        return enLineaApoyo;
    }

    public void setEnLineaApoyo(boolean enLineaApoyo) {
        this.enLineaApoyo = enLineaApoyo;
    }

    public boolean isEnMazo() {
        return enMazo;
    }

    public void setEnMazo(boolean enMazo) {
        this.enMazo = enMazo;
    }

    public boolean isEnCementerio() {
        return enCementerio;
    }

    public void setEnCementerio(boolean enTableroCementerio) {
        this.enCementerio = enTableroCementerio;
    }

    public boolean isEnMano() {
        return enMano;
    }

    public void setEnMano(boolean enMano) {
        this.enMano = enMano;
    }

    public boolean isEfectoActivo(){
        return efectoActivo;
    }

    public void setEfectoActivo(boolean efectoActivo){
        this.efectoActivo=efectoActivo;
    }

}
