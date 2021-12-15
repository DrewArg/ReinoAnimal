package src.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import src.inter.CartaInterface;

public class Jugador {
    private String nombre;
    private String contrasena;
    private int turno;

    private boolean puedeAtacar;

    private List<CartaInterface> mazo;

    public Jugador(String nombre, String contrasena) {
        this.nombre = nombre;
        this.contrasena = contrasena;

        puedeAtacar = true;
    }

    public void setMazoSeleccionado(List<CartaInterface> mazoSeleccionado) {
        this.mazo = mazoSeleccionado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public int getCantidadCartasMazo() {
        return getCartasMazo().size();
    }

    public List<CartaInterface> getMazoCartas(){
        return mazo;
    }

    public List<CartaInterface> getCartasMazo() {

        List<CartaInterface> auxiliar = new ArrayList<CartaInterface>();
        for (CartaInterface carta : mazo) {
            if (carta.isEnMazo()) {
                auxiliar.add(carta);
            }
        }

        return auxiliar;
    }

    public List<CartaInterface> getAlimentosEnReserva() {
        List<CartaInterface> auxiliar = new ArrayList<CartaInterface>();
        for (CartaInterface carta : mazo) {
            if (carta instanceof Alimento) {

                Alimento alimento = (Alimento) carta;
                if (alimento.isEnReservaDeAlimentos()) {
                    auxiliar.add(alimento);
                }
            }
        }

        return auxiliar;
    }

    public List<CartaInterface> getAlimentosConsumidos() {
        List<CartaInterface> auxiliar = new ArrayList<CartaInterface>();
        for (CartaInterface carta : mazo) {
            if (carta instanceof Alimento) {

                Alimento alimento = (Alimento) carta;
                if (alimento.isEnAlimentoConsumidos()) {
                    auxiliar.add(alimento);
                }
            }
        }

        return auxiliar;
    }

    public List<CartaInterface> getAnimalesEnReposo() {
        List<CartaInterface> auxiliar = new ArrayList<CartaInterface>();
        for (CartaInterface carta : mazo) {
            if (carta instanceof Animal) {
                Animal animal = (Animal) carta;
                if (animal.isEnReposo()) {
                    auxiliar.add(animal);
                }
            }

        }

        return auxiliar;
    }

    public List<CartaInterface> getAnimalesEnBatalla() {
        List<CartaInterface> auxiliar = new ArrayList<CartaInterface>();
        for (CartaInterface carta : mazo) {
            if (carta instanceof Animal) {

                Animal animal = (Animal) carta;
                if (animal.isEnBatalla()) {
                    auxiliar.add(animal);
                }
            }

        }

        return auxiliar;
    }

    public List<CartaInterface> getHabitatsEnApoyo() {
        List<CartaInterface> auxiliar = new ArrayList<CartaInterface>();
        for (CartaInterface carta : mazo) {
            if (carta instanceof Habitat) {

                Habitat habitat = (Habitat) carta;
                if (habitat.isEnLineaApoyo()) {
                    auxiliar.add(habitat);
                }
            }
        }

        return auxiliar;
    }

    public List<CartaInterface> getCartasCementerio() {
        List<CartaInterface> auxiliar = new ArrayList<CartaInterface>();
        for (CartaInterface carta : mazo) {
            if (carta.isEnCementerio()) {
                auxiliar.add(carta);

            }

        }

        return auxiliar;
    }

    public List<CartaInterface> getCartasMano() {

        List<CartaInterface> auxiliar = new ArrayList<CartaInterface>();
        for (CartaInterface carta : mazo) {
            if (carta.isEnMano()) {
                auxiliar.add(carta);
            }
        }

        return auxiliar;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public boolean tieneCartasElMazo() {
        if (getCantidadCartasMazo() == 0) {
            return false;
        } else {
            return true;
        }

    }

    public void mezclarMazo() {

        Collections.shuffle(mazo);

    }

    public void setPuedeAtacar(boolean puedeAtacar) {
        this.puedeAtacar = puedeAtacar;
    }

    public boolean isPuedeAtacar() {
        return puedeAtacar;
    }

}
