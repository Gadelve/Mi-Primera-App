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
                    " ",
                    " ");

            GameModel ffviiGameModel = new GameModel(1, "Final Fantasy VII", "Descripción Final Fantasy VII",
                    "https://es.wikipedia.org/wiki/Final_Fantasy_VII",
                    " ",
                    " ");

            games = new ArrayList<>();
            games.add(ffviiGameModel);
            games.add(ffixGameModel);

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
