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
    private boolean enCementerio;
    private String tipoMazo;

    public Animal(int id, String nombre, String efecto, int coste, int dano, boolean sePuedeBajarTablero,
            boolean enReposo, boolean enBatalla, boolean enCementerio, String tipoMazo) {
        this.id = id;
        this.nombre = nombre;
        this.efecto = efecto;
        this.coste = coste;
        this.dano = dano;
        this.sePuedeBajarTablero = sePuedeBajarTablero;
        this.enReposo = enReposo;
        this.enBatalla = enBatalla;
        this.enCementerio = enCementerio;
        this.tipoMazo = tipoMazo;
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

    public boolean isEnCementerio() {
        return enCementerio;
    }

    public void setEnCementerio(boolean enCementerio) {
        this.enCementerio = enCementerio;
    }

}
