package service;

import java.util.List;

import inter.CartaInterface;
import repository.CartaRepository;

public class CartaService {
    private AnimalService animalService = new AnimalService();
    private AlimentoService alimentoService = new AlimentoService();
    private HabitatService habitatService = new HabitatService();
    private HabilidadService habilidadService = new HabilidadService();

    private CartaRepository cartaRepository = new CartaRepository();
    private int idUnico = 1;

    public CartaService() {

    }

    private void crearCartasMazoTerrestre() {
        String nombre;
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

        for (int i = 100; i < cartasMazo + 100; i++) {

            tipoMazo = "Terrestre";

            if (lobos > 0) {

                String efecto;
                int coste;
                int dano;

                nombre = "Lobo Gris";
                efecto = "Gana +1 de daño por cada Lobo Gris en Juego";
                coste = 3;
                dano = 2;

                lobos--;

                cartaRepository.agregarCartaMazoTerrestre(
                        animalService.crearAnimal(idUnico, nombre, efecto, coste, dano, tipoMazo));

            } else if (ratas > 0) {
                nombre = "Rata";
                String efecto = "Sin efecto.";
                int coste = 1;
                int dano = 1;

                ratas--;

                cartaRepository.agregarCartaMazoTerrestre(
                        animalService.crearAnimal(idUnico, nombre, efecto, coste, dano, tipoMazo));

            } else if (iguanas > 0) {
                nombre = "Iguana";
                String efecto = "Puede copiar el ataque de un enemigo y sumarlo al suyo hasta el final del turno.";
                ;
                int coste = 3;
                int dano = 1;

                iguanas--;

                cartaRepository.agregarCartaMazoTerrestre(
                        animalService.crearAnimal(idUnico, nombre, efecto, coste, dano, tipoMazo));

            } else if (mantisOrquideas > 0) {
                nombre = "Mantis Orquídea";
                String efecto = "Puedes pagar 1 alimento para tomar una carta de tu cementerio y ponerla en tu mano.";
                ;
                int coste = 5;
                int dano = 4;

                mantisOrquideas--;

                cartaRepository.agregarCartaMazoTerrestre(
                        animalService.crearAnimal(idUnico, nombre, efecto, coste, dano, tipoMazo));

            } else if (alimentos > 0) {
                nombre = "Alimento";
                alimentos--;

                cartaRepository.agregarCartaMazoTerrestre(alimentoService.crearAlimento(idUnico, nombre, tipoMazo));

            } else if (orquidea > 0) {
                nombre = "Orquidea";

                String efecto = "Si tienes una Mantis Orquídea en juego, esta gana +1 de daño por cada animal aliado en juego. Si Mantis Orquídea está en tu cementerio, puedes revivirla pagando su coste.";
                int coste = 6;

                orquidea--;

                cartaRepository.agregarCartaMazoTerrestre(
                        habitatService.crearHabitat(idUnico, nombre, efecto, coste, tipoMazo));

            } else if (alcantarilla > 0) {
                nombre = "Alcantarilla";

                String efecto = "Puedes revivir una Rata por turno pagando su coste.";
                int coste = 3;

                alcantarilla--;

                cartaRepository.agregarCartaMazoTerrestre(
                        habitatService.crearHabitat(idUnico, nombre, efecto, coste, tipoMazo));

            } else if (aullido > 0) {
                nombre = "Aullido";
                String efecto = "Si tienes un Lobo Gris en juego, puedes jugar a otro desde tu mazo o mano sin pagar su coste.";
                int coste = 2;

                aullido--;

                cartaRepository.agregarCartaMazoTerrestre(
                        habilidadService.crearHabilidad(idUnico, nombre, efecto, coste, tipoMazo));

            } else if (camuflaje > 0) {
                nombre = "Camuflaje";
                String efecto = "Si tienes una Iguana en juego, esta se vuelve indestructible.";
                int coste = 3;

                camuflaje--;

                cartaRepository.agregarCartaMazoTerrestre(
                        habilidadService.crearHabilidad(idUnico, nombre, efecto, coste, tipoMazo));

            } else if (enamoramiento > 0) {

                nombre = "Enamoramiento";
                String efecto = "Toma el control de un animal enemigo hasta el fin de este turno.";
                int coste = 6;

                enamoramiento--;
                cartaRepository.agregarCartaMazoTerrestre(
                        habilidadService.crearHabilidad(idUnico, nombre, efecto, coste, tipoMazo));
            }

            idUnico++;
        }
    }

    private void crearCartasMazoAcuatico() {
        String nombre;
        String tipoMazo;

        int cartasMazo = 25;
        int tortugas = 3;
        int pecesPayaso = 3;
        int pulpos = 2;
        int tiburonesBlancos = 1;
        int alimentos = 9;
        int costa = 1;
        int anemona = 2;
        int coraza = 3;
        int captura = 1;
        int fortalecimiento = 1;

        for (int i = 200; i < cartasMazo + 200; i++) {
            tipoMazo = "Acuático";

            if (tortugas > 0) {
                String efecto;
                int coste;
                int dano;

                nombre = "Tortuga Marina";
                efecto = "Puede sacrificarse para evitar que el enemigo siga atacando este turno.";
                coste = 3;
                dano = 2;

                tortugas--;

                cartaRepository.agregarCartaMazoAcuatico(
                        animalService.crearAnimal(idUnico, nombre, efecto, coste, dano, tipoMazo));

            } else if (pecesPayaso > 0) {
                nombre = "Pez Payaso";
                String efecto = "Sin efecto.";
                int coste = 1;
                int dano = 1;

                pecesPayaso--;

                cartaRepository.agregarCartaMazoAcuatico(
                        animalService.crearAnimal(idUnico, nombre, efecto, coste, dano, tipoMazo));

            } else if (pulpos > 0) {
                nombre = "Pulpo";
                String efecto = "Puede perder X puntos de daño permanentemente para devolver X cartas del cementerio al mazo.";
                ;
                int coste = 4;
                int dano = 3;

                pulpos--;

                cartaRepository.agregarCartaMazoAcuatico(
                        animalService.crearAnimal(idUnico, nombre, efecto, coste, dano, tipoMazo));

            } else if (tiburonesBlancos > 0) {
                nombre = "Tiburón Blanco";
                String efecto = "Puede devorar a un aliado para devorar a un enemigo de coste 3 o menos y adicionar su fuerza a la suya hasta el final del turno.";
                ;
                int coste = 5;
                int dano = 4;

                tiburonesBlancos--;

                cartaRepository.agregarCartaMazoAcuatico(
                        animalService.crearAnimal(idUnico, nombre, efecto, coste, dano, tipoMazo));

            } else if (alimentos > 0) {
                nombre = "Alimento";

                alimentos--;

                cartaRepository.agregarCartaMazoAcuatico(alimentoService.crearAlimento(idUnico, nombre, tipoMazo));

            } else if (costa > 0) {
                nombre = "Costa";

                String efecto = "Si tienes un Tiburón Blanco en juego, este gana +1 de daño por cada animal devorado hasta ser destruido.";
                int coste = 6;

                costa--;

                cartaRepository.agregarCartaMazoAcuatico(
                        habitatService.crearHabitat(idUnico, nombre, efecto, coste, tipoMazo));

            } else if (anemona > 0) {
                nombre = "Anemona";

                String efecto = "Puedes duplicar un Pez Payaso en juego pagando su coste hasta el final del turno.";
                int coste = 3;

                anemona--;

                cartaRepository.agregarCartaMazoAcuatico(
                        habitatService.crearHabitat(idUnico, nombre, efecto, coste, tipoMazo));

            } else if (coraza > 0) {
                nombre = "Coraza";
                String efecto = "Evita que un animal aliado muera este turno.";
                int coste = 2;

                coraza--;

                cartaRepository.agregarCartaMazoAcuatico(
                        habilidadService.crearHabilidad(idUnico, nombre, efecto, coste, tipoMazo));

            } else if (captura > 0) {
                nombre = "Captura";
                String efecto = "Evita que un enemigo pueda atacar o defender por 2 turnos.";
                int coste = 3;

                captura--;

                cartaRepository.agregarCartaMazoAcuatico(
                        habilidadService.crearHabilidad(idUnico, nombre, efecto, coste, tipoMazo));

            } else if (fortalecimiento > 0) {

                nombre = "Fortalecimiento";
                String efecto = "Si tienes un Tiburón Blanco en juego, este gana +3 de daño. Si tienes un Tiburón Blanco en tu cementerio, puedes revivirlo sin pagar su coste.";
                int coste = 6;

                fortalecimiento--;
                cartaRepository.agregarCartaMazoAcuatico(
                        habilidadService.crearHabilidad(idUnico, nombre, efecto, coste, tipoMazo));
            }

            idUnico++;
        }
    }

    public List<CartaInterface> seleccionarMazo(String tipoMazo) {
        if (tipoMazo.equalsIgnoreCase("Terrestre")) {
            crearCartasMazoTerrestre();
            return cartaRepository.getMazoTerrestre();
        } else {
            crearCartasMazoAcuatico();
            return cartaRepository.getMazoTerrestre();
        }

    }

}
