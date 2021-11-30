package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import inter.CartaInterface;

public class Jugador {
    private String nombre;
    private String contrasena;
    private int turno;

    private List<CartaInterface> cartas;

    public Jugador(String nombre, String contrasena, List<CartaInterface> cartas) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.cartas = cartas;
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

    public List<CartaInterface> getCartasMazo() {

        List<CartaInterface> auxiliar = new ArrayList<CartaInterface>();
        for (CartaInterface carta : cartas) {
            if (carta.isEnMazo()) {
                auxiliar.add(carta);
            }
        }

        return auxiliar;
    }

    public List<CartaInterface> getCartasTablero() {

        List<CartaInterface> auxiliar = new ArrayList<CartaInterface>();
        for (CartaInterface carta : cartas) {
            if (carta.isEnTablero()) {
                auxiliar.add(carta);
            }
        }

        return auxiliar;
    }

    public List<CartaInterface> getAlimentosEnReserva() {
        List<CartaInterface> auxiliar = new ArrayList<CartaInterface>();
        for (CartaInterface carta : cartas) {
            if (carta.isEnTablero()) {
                if (carta instanceof Alimento) {

                    Alimento alimento = (Alimento) carta;
                    if (alimento.isEnReservaDeAlimentos()) {
                        auxiliar.add(alimento);
                    }
                }
            }

        }

        return auxiliar;
    }

    public List<CartaInterface> getAlimentosConsumidos() {
        List<CartaInterface> auxiliar = new ArrayList<CartaInterface>();
        for (CartaInterface carta : cartas) {
            if (carta.isEnTablero()) {
                if (carta instanceof Alimento) {

                    Alimento alimento = (Alimento) carta;
                    if (alimento.isEnAlimentoConsumidos()) {
                        auxiliar.add(alimento);
                    }
                }
            }

        }

        return auxiliar;
    }

    public List<CartaInterface> getAnimalesEnReposo() {
        List<CartaInterface> auxiliar = new ArrayList<CartaInterface>();
        for (CartaInterface carta : cartas) {
            if (carta.isEnTablero()) {
                if (carta instanceof Animal) {

                    Animal animal = (Animal) carta;
                    if (animal.isEnReposo()) {
                        auxiliar.add(animal);
                    }
                }
            }

        }

        return auxiliar;
    }

    public List<CartaInterface> getAnimalesEnBatalla() {
        List<CartaInterface> auxiliar = new ArrayList<CartaInterface>();
        for (CartaInterface carta : cartas) {
            if (carta.isEnTablero()) {
                if (carta instanceof Animal) {

                    Animal animal = (Animal) carta;
                    if (animal.isEnBatalla()) {
                        auxiliar.add(animal);
                    }
                }
            }

        }

        return auxiliar;
    }

    public List<CartaInterface> getHabitatsEnApoyo() {
        List<CartaInterface> auxiliar = new ArrayList<CartaInterface>();
        for (CartaInterface carta : cartas) {
            if (carta.isEnTablero()) {
                if (carta instanceof Habitat) {

                    Habitat habitat = (Habitat) carta;
                    if (habitat.isEnLineaApoyo()) {
                        auxiliar.add(habitat);
                    }
                }
            }

        }

        return auxiliar;
    }

    public List<CartaInterface> getCartasCementerio() {
        List<CartaInterface> auxiliar = new ArrayList<CartaInterface>();
        for (CartaInterface carta : cartas) {
            if (carta.isEnCementerio()) {
                auxiliar.add(carta);

            }

        }

        return auxiliar;
    }

    public List<CartaInterface> getCartasMano() {

        List<CartaInterface> auxiliar = new ArrayList<CartaInterface>();
        for (CartaInterface carta : cartas) {
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

    public void robarCartas(int cantidadCartas) {

        if (cantidadCartas >= getCartasMazo().size()) {
            // se quedo sin cartas
        } else {
            for (CartaInterface carta : cartas) {
                if (tieneCartasElMazo()) {

                    if (carta.isEnMazo()) {

                        if (cantidadCartas > 0) {

                            cantidadCartas--;

                            carta.setEnMano(true);
                            carta.setEnMazo(false);
                        }

                    }

                }

            }
        }
    }

    public boolean tieneCartasElMazo() {
        if (getCartasMazo().size() == 0) {
            return false;
        } else {
            return true;
        }

    }

    public void mezclarMazo() {

        Collections.shuffle(cartas);

    }

}
