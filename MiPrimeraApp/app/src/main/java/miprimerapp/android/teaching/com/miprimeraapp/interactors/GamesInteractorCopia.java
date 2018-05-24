package miprimerapp.android.teaching.com.miprimeraapp.interactors;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import miprimerapp.android.teaching.com.miprimeraapp.model.GameModel;

public class GamesInteractorCopia {

    private ArrayList<GameModel> games = new ArrayList<>();

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

    public GamesInteractorCopia() {

    }

    public void getGames(final GamesInteractorCallBack callback) {

        // 1 - Llamar a firebase

        FirebaseDatabase firebasedatabase = FirebaseDatabase.getInstance();
        DatabaseReference myReference = firebasedatabase.getReference("games");
        myReference.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override // Aquí recibimos los datos de la base de datos
            public void onDataChange(DataSnapshot dataSnapshot) {

                // 2 - Obtener la lista de GameModel

                for (DataSnapshot nodoJuego : dataSnapshot.getChildren()) {
                    GameModel model = nodoJuego.getValue(GameModel.class);
                    Log.d("Firebase Interactor", "Game: " + model.getName());
                    games.add(model);
                }

                // 3- Notificar a callback.onGamesAvailable()

                callback.onGamesAvailable();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Algún error ha ocurrido
            }
        });


    }

    //callback.onGamesAvailable()
    {
    }
}