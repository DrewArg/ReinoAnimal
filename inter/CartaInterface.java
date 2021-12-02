package inter;

public interface CartaInterface {

    public int getId();
    public String getTipoMazo();
    public String getNombre();
    public boolean isEnMazo();
    public void setEnMazo(boolean enMazo);
    public boolean isEnCementerio();
    public void setEnCementerio(boolean enCementerio);
    public boolean isEnMano();
    public void setEnMano(boolean enMano);
    public boolean isSePuedeBajarTablero();
    public void setSePuedeBajarTablero(boolean sePuedeBajarTablero);
}
