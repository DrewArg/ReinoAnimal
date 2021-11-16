package domain;

import java.util.List;
import inter.CartaInterface;

public class Jugador {
    private String nombre;
    private String contrasena;

    private List<CartaInterface> mazo;

    public Jugador(String nombre, String contrasena, List<CartaInterface> mazo) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.mazo = mazo;
    }

    public Jugador(String nombre, String contrasena) {
        this.nombre = nombre;
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public List<CartaInterface> getMazo() {
        return mazo;
    }

    public void setMazo(List<CartaInterface> mazo) {
        this.mazo = mazo;
    }

    public int cantidadCartasMazo() {
        return mazo.size();
    }
}
