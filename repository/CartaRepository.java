package repository;

import java.util.ArrayList;
import java.util.List;

import inter.CartaInterface;

public class CartaRepository {
    private List<CartaInterface> mazoTerrestre = new ArrayList<CartaInterface>();
    private List<CartaInterface> mazoAcuatico = new ArrayList<CartaInterface>();

    public CartaRepository() {

    }

    public void agregarCartaMazoTerrestre(CartaInterface carta) {
        mazoTerrestre.add(carta);
    }

    public void agregarCartaMazoAcuatico(CartaInterface carta) {
        mazoAcuatico.add(carta);
    }

    public List<CartaInterface> seleccionarMazo(String tipoMazo) {
        if(tipoMazo.equalsIgnoreCase("Terrestre")){
            return mazoTerrestre;
        }else{
            return mazoAcuatico;
        }
    }

    public List<CartaInterface> getMazoAcuatico() {
        return mazoAcuatico;
    }

    public int getCantidadCartasMazoTerrestre() {
        return mazoTerrestre.size();
    }

    public int getCantidadCartasMazoAcuatico() {
        return mazoAcuatico.size();
    }

}
