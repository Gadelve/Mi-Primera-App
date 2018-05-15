package miprimerapp.android.teaching.com.miprimeraapp.presenters;

import java.util.ArrayList;

import miprimerapp.android.teaching.com.miprimeraapp.interactors.GamesInteractor;
import miprimerapp.android.teaching.com.miprimeraapp.model.GameModel;
import miprimerapp.android.teaching.com.miprimeraapp.view.GameDetailView;

public class GameDetailPresenter {
    private GamesInteractor interactor;
    private GameDetailView view;

    public void startPresenting(GameDetailView view) {
        this.view = view;
        interactor = new GamesInteractor();
    }

    public void loadGameWithID(int id) {
        GameModel game = interactor.getGameWithID(id);
        view.onGameLoaded(game);
    }

    public ArrayList<GameModel> getGames() {
        return interactor.getGames();
    }

}
