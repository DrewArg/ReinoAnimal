package domain;

import inter.CartaInterface;

public class Alimento implements CartaInterface {

    private int id;
    private String nombre;
    private boolean sePuedeBajarTablero;
    private boolean enReservaDeAlimentos;
    private boolean enAlimentoConsumidos;
    private boolean enCementerio;
    private String tipoMazo;

    public Alimento(int id, String nombre, boolean sePuedeBajarTablero, boolean enReservaDeAlimentos,
            boolean enAlimentoConsumidos, boolean enCementerio, String tipoMazo) {
        this.id = id;
        this.nombre = nombre;
        this.sePuedeBajarTablero = sePuedeBajarTablero;
        this.enReservaDeAlimentos = enReservaDeAlimentos;
        this.enAlimentoConsumidos = enAlimentoConsumidos;
        this.enCementerio = enCementerio;
        this.tipoMazo = tipoMazo;
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
