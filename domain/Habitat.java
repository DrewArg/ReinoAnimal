package domain;

import inter.CartaInterface;

public class Habitat implements CartaInterface {
    private int id;
    private String nombre;
    private String efecto;
    private int coste;
    private boolean sePuedeBajarTablero;
    private boolean enLineaApoyo;
    private boolean enCementerio;
    private String tipoMazo;

    public Habitat(int id, String nombre, String efecto, int coste, boolean sePuedeBajarTablero, boolean enLineaApoyo,
            boolean enCementerio, String tipoMazo) {
        this.id = id;
        this.nombre = nombre;
        this.efecto = efecto;
        this.coste = coste;
        this.sePuedeBajarTablero = sePuedeBajarTablero;
        this.enLineaApoyo = enLineaApoyo;
        this.enCementerio = enCementerio;
        this.tipoMazo = tipoMazo;
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

    public void setEfecto(String efecto) {
        this.efecto = efecto;
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

    public boolean isEnCementerio() {
        return enCementerio;
    }

    public void setEnCementerio(boolean enCementerio) {
        this.enCementerio = enCementerio;
    }

    public String getTipoMazo() {
        return tipoMazo;
    }

    public void setTipoMazo(String tipoMazo) {
        this.tipoMazo = tipoMazo;
    }

}
