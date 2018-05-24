package miprimerapp.android.teaching.com.miprimeraapp.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import miprimerapp.android.teaching.com.miprimeraapp.R;
import miprimerapp.android.teaching.com.miprimeraapp.WebViewActivity;
import miprimerapp.android.teaching.com.miprimeraapp.interactors.GamesInteractor;
import miprimerapp.android.teaching.com.miprimeraapp.interactors.GamesInteractorCallBack;
import miprimerapp.android.teaching.com.miprimeraapp.interactors.GamesInteractorCopia;
import miprimerapp.android.teaching.com.miprimeraapp.model.GameModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class GameDetailFragment extends Fragment {

    private GamesInteractorCopia gamesFirebaseInteractor;

    public GameDetailFragment() {
        // Required empty public constructor
    }


    public static GameDetailFragment newInstance(int gameID) {
        GameDetailFragment fragment = new GameDetailFragment();
        Bundle myBundle = new Bundle();
        myBundle.putInt("game_id", gameID);
        fragment.setArguments(myBundle);
        return fragment;
    }

    public void webbutton() {

        String url = "www.google.es";
        Intent intent = new Intent();
        intent.putExtra("url", url);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.fragment_game_detail, container, false);

        // Obtener GameModel del GamesInteractor
        final int gameID = getArguments().getInt("game_id", 0);
        gamesFirebaseInteractor = new GamesInteractorCopia();
        gamesFirebaseInteractor.getGames(new GamesInteractorCallBack() {
            public void onGamesAvailable() {
                final GameModel game = gamesFirebaseInteractor.getGameWithID(gameID);

                //UPDATE VIEW WITH GAME MODEL DATA
                ImageView icono = getView().findViewById(R.id.iconFFIX);
                Glide.with(getView()).load(game.getIcon()).into(icono);
                //icono.setImageResource(game.getIconDrawable());

                // 1. CAMBIAR IMAGEN DE FONDO

                ImageView fondo = getView().findViewById(R.id.group);
                Glide.with(getView()).load(game.getBackground()).into(fondo);
                //fondo.setImageResource(game.getBackgroundDrawble());

                // 2. CAMBIAR DESCRIPCIÓN

                TextView descripcion = getView().findViewById(R.id.detailact);
                descripcion.setText(game.getDescription());

                // 3. DEFINIR ACCIÓN PARA EL BOTON

                Button boton = getView().findViewById(R.id.website_button);
                boton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {

                        Intent webIntent = new Intent(getContext(), WebViewActivity.class);
                        webIntent.putExtra("url", game.getOfficialWebsiteUrl());
                        startActivity(webIntent);
                    }
                });
            }

        });

        return fragmentView;
    }

}
