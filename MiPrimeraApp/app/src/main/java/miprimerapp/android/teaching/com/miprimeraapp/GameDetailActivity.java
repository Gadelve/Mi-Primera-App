package miprimerapp.android.teaching.com.miprimeraapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import org.w3c.dom.Text;

import miprimerapp.android.teaching.com.miprimeraapp.model.GameModel;
import miprimerapp.android.teaching.com.miprimeraapp.presenters.GameDetailPresenter;
import miprimerapp.android.teaching.com.miprimeraapp.view.GameDetailView;

public class GameDetailActivity extends AppCompatActivity
        implements GameDetailView {

    private GameDetailPresenter presenter;
    private int currentGameId;
    private String currentGameWebSite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_detail);

        android.support.v7.widget.Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        ActionBar myActionBar = getSupportActionBar();
        myActionBar.setDisplayHomeAsUpEnabled(true);

        presenter = new GameDetailPresenter();

        currentGameId = getIntent().getIntExtra("game_id", 0);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.startPresenting(this);
        presenter.loadGameWithID(currentGameId);
    }

    public void onClickOfficial(View view) {
        Intent intent = new Intent(this, MainActivity.class);//intencion de iniciar la activity en la memoria
        startActivity(intent);
    }

    @Override
    public void onGameLoaded(GameModel game) {
        //UPDATE VIEW WITH GAME MODEL DATA
        ImageView icono = findViewById(R.id.iconFFIX);
        icono.setImageResource(game.getIconDrawable());

        // 1. CAMBIAR IMAGEN DE FONDO

        ImageView fondo = findViewById(R.id.group);
        fondo.setImageResource(game.getBackgroundDrawble());

        // 2. CAMBIAR DESCRIPCIÓN

        TextView descripcion = findViewById(R.id.detailact);
        descripcion.setText(game.getDescription());

        // 3. CAMBIAR TÍTULO DE LA TOOLBAR

        getSupportActionBar().setTitle(game.getName());

        this.currentGameWebSite = game.getOfficialWebsiteUrl();

    }

    public void goToWebSite(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(currentGameWebSite));
        startActivity(intent);


    }
}