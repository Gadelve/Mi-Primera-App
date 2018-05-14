package miprimerapp.android.teaching.com.miprimeraapp.interactors;

import java.util.ArrayList;

import miprimerapp.android.teaching.com.miprimeraapp.R;
import miprimerapp.android.teaching.com.miprimeraapp.model.GameModel;

public class GamesInteractor {
    private static ArrayList<GameModel> games;

    /**
     * Constructor
     */
    public GamesInteractor() {
        // Si no tengo juegos, los creo
        if (games == null) {
            GameModel ffixGameModel = new GameModel(0, "Final Fantasy IX", "Descripción Final Fantasy IX",
                    "https://es.wikipedia.org/wiki/Final_Fantasy_IX",
                    R.drawable.iconffix,
                    R.drawable.ffixgroup);

            GameModel ffviiGameModel = new GameModel(1, "Final Fantasy VII", "Descripción Final Fantasy VII",
                    "https://es.wikipedia.org/wiki/Final_Fantasy_VII",
                    R.drawable.iconffvii,
                    R.drawable.cloud);
            GameModel ffviiiGameModel = new GameModel(2, "Final Fantasy VIII", "Descripción Final Fantasy VIII",
                    "https://es.wikipedia.org/wiki/Final_Fantasy_VIII",
                    R.drawable.iconfviii,
                    R.drawable.squall);
            GameModel ffxGameModel = new GameModel(3, "Final Fantasy X", "Descripción Final Fantasy X",
                    "https://es.wikipedia.org/wiki/Final_Fantasy_X",
                    R.drawable.iconffx,
                    R.drawable.tidus);

            games = new ArrayList<>();
            games.add(ffviiGameModel);
            games.add(ffviiiGameModel);
            games.add(ffixGameModel);
            games.add(ffxGameModel);
        }
    }

    public ArrayList<GameModel> getGames() {
        return games;
    }

    public GameModel getGameWithID(int id) {
        //Obtener de "games" el juegos con el identificador id
        for (GameModel game : games) {
            if (game.getId() == id) {
                return game;
            }
        }
        return null;
    }
}
