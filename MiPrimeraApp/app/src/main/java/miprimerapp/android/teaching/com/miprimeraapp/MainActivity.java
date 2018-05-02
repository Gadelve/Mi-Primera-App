package miprimerapp.android.teaching.com.miprimeraapp;

import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    /* ACTIVITY LIFECYCLE (CICLO DE VIDA DE UNA APP CON SUS RESPECTIVAS ETAPAS
    AÑADIMOS LA PALABRA CURSO PARA PODER BUSCARLO LUEGO EN EL LOGCAT Y PODER VISUALIZAR EN EL LOGCAT LOS PROCESOS QUE VAN SUCEDIENDO EN NUESTRA APLICACIÓN
    USAMOS ANDROID:SCREENORIENTATION PARA EVITAR QUE SE PUEDA PONER EN HORIZONTAL NUESTRA APP Y ASI NO NOS SALGA EN EL LOOGCAT LOS MENSAJES CADA VEZ QUE GIREMOS EL MOVIL
    (ESTO ES EN AndroidManifest.xml) */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "onCreate curso");
    }

    @Override
    protected void onStart() {
        super.onStart();
            Log.d("MainActivity", "onStart curso");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity", "onResume curso");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity", "onPause curso");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "onStop curso");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity", "onRestart curso");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "onDestroy curso");
    }
}
