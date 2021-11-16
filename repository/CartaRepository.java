package repository;

import java.util.ArrayList;
import java.util.List;

import inter.CartaInterface;
import service.AlimentoService;
import service.AnimalService;
import service.HabilidadService;
import service.HabitatService;

public class CartaRepository {
    private AnimalService animalService = new AnimalService();
    private AlimentoService alimentoService = new AlimentoService();
    private HabitatService habitatService = new HabitatService();
    private HabilidadService habilidadService = new HabilidadService();

    private List<CartaInterface> mazoTerrestre = new ArrayList<>();

    public CartaRepository() {
        crearMazoTerrestre();
    }

    public void agregarCarta(CartaInterface carta) {
        mazoTerrestre.add(carta);
    }

    public List<CartaInterface> getMazoTerrestre() {
        return mazoTerrestre;
    }

    public int getCantidadCartasMazoTerrestre() {
        return mazoTerrestre.size();
    }

    private void crearMazoTerrestre() {
        int id;
        String nombre;
        boolean sePuedeBajarTablero = false;
        boolean enCementerio = false;
        String tipoMazo;

        int cartasMazo = 25;
        int lobos = 3;
        int ratas = 3;
        int iguanas = 2;
        int mantisOrquideas = 1;
        int alimentos = 9;
        int orquidea = 1;
        int alcantarilla = 2;
        int aullido = 3;
        int camuflaje = 1;
        int enamoramiento = 1;

        for (int i = 1; i <= cartasMazo; i++) {
            id = i;
            tipoMazo = "Terrestre";

            if (lobos > 0) {
                boolean enReposo = false;
                boolean enBatalla = false;
                String efecto;
                int coste;
                int dano;

                nombre = "Lobo Gris";
                efecto = "Gana +1 de daño por cada Lobo Gris en Juego";
                coste = 3;
                dano = 2;

                lobos--;

                agregarCarta(animalService.crearAnimal(id, nombre, efecto, coste, dano, sePuedeBajarTablero, enReposo,
                        enBatalla, enCementerio, tipoMazo));

            } else if (ratas > 0) {
                nombre = "Rata";
                boolean enReposo = false;
                boolean enBatalla = false;
                String efecto = "Sin efecto.";
                int coste = 1;
                int dano = 1;

                ratas--;

                agregarCarta(animalService.crearAnimal(id, nombre, efecto, coste, dano, sePuedeBajarTablero, enReposo,
                        enBatalla, enCementerio, tipoMazo));

            } else if (iguanas > 0) {
                nombre = "Iguana";
                boolean enReposo = false;
                boolean enBatalla = false;
                String efecto = "Puede copiar el ataque de un enemigo y sumarlo al suyo hasta el final del turno.";
                ;
                int coste = 3;
                int dano = 1;

                iguanas--;

                agregarCarta(animalService.crearAnimal(id, nombre, efecto, coste, dano, sePuedeBajarTablero, enReposo,
                        enBatalla, enCementerio, tipoMazo));

            } else if (mantisOrquideas > 0) {
                nombre = "Mantis Orquídea";
                boolean enReposo = false;
                boolean enBatalla = false;
                String efecto = "Puedes pagar 1 alimento para tomar una carta de tu cementerio y ponerla en tu mano.";
                ;
                int coste = 5;
                int dano = 4;

                mantisOrquideas--;

                agregarCarta(animalService.crearAnimal(id, nombre, efecto, coste, dano, sePuedeBajarTablero, enReposo,
                        enBatalla, enCementerio, tipoMazo));

            } else if (alimentos > 0) {
                nombre = "Alimento";
                boolean enReservaDeAlimentos = false;
                boolean enAlimentoConsumidos = false;

                alimentos--;

                agregarCarta(alimentoService.crearAlimento(id, nombre, sePuedeBajarTablero, enReservaDeAlimentos,
                        enAlimentoConsumidos, enCementerio, tipoMazo));

            } else if (orquidea > 0) {
                nombre = "Orquidea";

                String efecto = "Si tienes una Mantis Orquídea en juego, esta gana +1 de daño por cada animal aliado en juego. Si Mantis Orquídea está en tu cementerio, puedes revivirla pagando su coste.";
                int coste = 6;
                boolean enLineaApoyo = false;

                orquidea--;

                agregarCarta(habitatService.crearHabitat(id, nombre, efecto, coste, sePuedeBajarTablero, enLineaApoyo,
                        enCementerio, tipoMazo));

            } else if (alcantarilla > 0) {
                nombre = "Alcantarilla";

                String efecto = "Puedes revivir una Rata por turno pagando su coste.";
                int coste = 3;
                boolean enLineaApoyo = false;

                alcantarilla--;

                agregarCarta(habitatService.crearHabitat(id, nombre, efecto, coste, sePuedeBajarTablero, enLineaApoyo,
                        enCementerio, tipoMazo));

            } else if (aullido > 0) {
                nombre = "Aullido";
                String efecto = "Si tienes un Lobo Gris en juego, puedes jugar a otro desde tu mazo o mano sin pagar su coste.";
                int coste = 2;

                aullido--;

                agregarCarta(habilidadService.crearHabilidad(id, nombre, efecto, coste, sePuedeBajarTablero,
                        enCementerio, tipoMazo));

            } else if (camuflaje > 0) {
                nombre = "Camuflaje";
                String efecto = "Si tienes una Iguana en juego, esta se vuelve indestructible.";
                int coste = 3;

                camuflaje--;

                agregarCarta(habilidadService.crearHabilidad(id, nombre, efecto, coste, sePuedeBajarTablero,
                        enCementerio, tipoMazo));

            } else if (enamoramiento > 0) {

                nombre = "enamoramiento";
                String efecto = "Toma el control de un animal enemigo hasta el fin de este turno.";
                int coste = 6;

                enamoramiento--;
                agregarCarta(habilidadService.crearHabilidad(id, nombre, efecto, coste, sePuedeBajarTablero,
                        enCementerio, tipoMazo));
            }
        }

    }
}
