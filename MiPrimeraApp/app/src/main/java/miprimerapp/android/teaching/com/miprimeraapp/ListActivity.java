package miprimerapp.android.teaching.com.miprimeraapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import miprimerapp.android.teaching.com.miprimeraapp.interactors.GamesInteractor;
import miprimerapp.android.teaching.com.miprimeraapp.interactors.GamesInteractorCallBack;
import miprimerapp.android.teaching.com.miprimeraapp.interactors.GamesInteractorCopia;

public class ListActivity extends AppCompatActivity {

    private MyAdapter myAdapter;
    private GamesInteractorCopia gamesFirebaseInteractor;
    private ListView listView;
    private MyConnectivityBroadcastReceiver myConnectivityReceiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState); // SIEMPRE SIEMPRE ESTAS DOS LINEAS LAS PRIMERAS
        setContentView(R.layout.activity_list); // <--------------------------->

        //region Escuchar cambios de conectividad
        IntentFilter intentFilter = new IntentFilter(); //MIRAR TAMBIEN MyConnectivityBroadcastReceiver.java
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);

        myConnectivityReceiver = new MyConnectivityBroadcastReceiver();
        registerReceiver(myConnectivityReceiver, intentFilter);
        //endregion
        ConnectivityManager cm = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null
                && activeNetwork.isConnectedOrConnecting();

        // region Comprobaciones de Conectividad

        if (isConnected == false) {
            findViewById(R.id.loading).setVisibility(View.GONE);
            Toast.makeText(this,
                    "No dispones de conexión a internet!!", Toast.LENGTH_SHORT).show();


        } else {


            String token = FirebaseInstanceId.getInstance().getToken(); //Obtienes el token del dispositivo
            FirebaseDatabase database = FirebaseDatabase.getInstance(); // Llamas a Firebase
            DatabaseReference myRef = database.getReference("device_push_token"); // Haces referenia al nodo, como en este caso no habia ninguno que se llamara asi se creará un nodo con el nombre dado
            myRef.setValue(token); // Escribes en el nodo el token de tu movil en un campo-

        }

        // endregion

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

        // VERSIONES ANTERIORES A LA 6 NO APARECE EL POP-UP
        int permissionCheck = ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION);
        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            // Tenemos permisos
            obtenerUbicacion();
        } else {
            // No tenemos permisos
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                    100);
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResult) {
        if (requestCode == 100) {
            if (grantResult.length > 0
                    && grantResult[0] == PackageManager.PERMISSION_GRANTED) {
                // El usuario acepta los permisos
                Toast.makeText(getApplicationContext(), "Permission granted", Toast.LENGTH_SHORT);
                obtenerUbicacion();

            } else {
                // El usuario deniega los permisos
                Toast.makeText(getApplicationContext(), "Permission denied", Toast.LENGTH_SHORT);
            }
        }
    }

    @SuppressLint("MissingPermission")
    private void obtenerUbicacion() {
        // 1. Obtener LocationManager
        LocationManager locationManager = (LocationManager)
                getSystemService(Context.LOCATION_SERVICE);

        // 2. Crear el listener
        LocationListener listener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                Log.d("Location Changed", "Location changed: " + location.toString());
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };

        // 3.
        locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER, 0, 0, listener);

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
