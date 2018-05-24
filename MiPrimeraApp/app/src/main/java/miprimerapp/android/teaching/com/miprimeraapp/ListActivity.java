package miprimerapp.android.teaching.com.miprimeraapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import miprimerapp.android.teaching.com.miprimeraapp.interactors.GamesInteractor;
import miprimerapp.android.teaching.com.miprimeraapp.interactors.GamesInteractorCallBack;
import miprimerapp.android.teaching.com.miprimeraapp.interactors.GamesInteractorCopia;

public class ListActivity extends AppCompatActivity {

    private MyAdapter myAdapter;
    private GamesInteractorCopia gamesFirebaseInteractor;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = findViewById(R.id.list_view);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListActivity.this, GameDetailActivity.class);
                int gameId = new GamesInteractor().getGames().get(position).getId();
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });

        gamesFirebaseInteractor = new GamesInteractorCopia();
        gamesFirebaseInteractor.getGames(new GamesInteractorCallBack() {

            public void onGamesAvailable() {
                findViewById(R.id.loading).setVisibility(View.GONE);
                // Aquí, GamesFirebaseInteractor ya tiene la lista de juegos
                myAdapter = new MyAdapter();
                listView.setAdapter(myAdapter);
            }
        });

        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        //Crea automáticamente la carpeta privada en sdcard

        getExternalFilesDir(null).mkdirs();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main_activity, menu);
        return true;
    }

    public void onClickDetail() {
        Intent intent = new Intent(this, GameDetailActivity.class);//intencion de iniciar la activity en la memoria
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int identificador = item.getItemId();
        switch (identificador) {
            case R.id.loginAction:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    private class MyAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return gamesFirebaseInteractor.getGames().size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.list_item, parent, false);

            ImageView icon = rowView.findViewById(R.id.image_view);
            Glide.with(ListActivity.this).load(gamesFirebaseInteractor.getGames().get(position).getIcon()).into(icon);
            //incon.setImageResource(gameicons.get(position));

            TextView textView = rowView.findViewById(R.id.text_view);
            textView.setText(gamesFirebaseInteractor.getGames().get(position).getName());

            return rowView;
        }
    }


}
