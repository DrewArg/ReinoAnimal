package inter;

public interface CartaInterface {

    public int getId();
    public String getTipoMazo();
    public boolean isEnMazo();
    public void setEnMazo(boolean enMazo);
    public boolean isEnTablero();
    public void setEnTablero(boolean enTablero);
    public boolean isEnCementerio();
    public void setEnCementerio(boolean enTableroCementerio);
    public boolean isEnMano();
    public void setEnMano(boolean enMano);
    public boolean isSePuedeBajarTablero();
    public void setSePuedeBajarTablero(boolean setSePuedebajarTablero);
}
