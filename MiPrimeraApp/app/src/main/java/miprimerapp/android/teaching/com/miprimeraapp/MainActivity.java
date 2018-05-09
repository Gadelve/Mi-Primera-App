package miprimerapp.android.teaching.com.miprimeraapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

    /* ACTIVITY LIFECYCLE (CICLO DE VIDA DE UNA APP CON SUS RESPECTIVAS ETAPAS
    AÑADIMOS LA PALABRA CURSO PARA PODER BUSCARLO LUEGO EN EL LOGCAT Y PODER VISUALIZAR EN EL LOGCAT LOS PROCESOS QUE VAN SUCEDIENDO EN NUESTRA APLICACIÓN
    USAMOS ANDROID:SCREENORIENTATION PARA EVITAR QUE SE PUEDA PONER EN HORIZONTAL NUESTRA APP Y ASI NO NOS SALGA EN EL LOOGCAT LOS MENSAJES CADA VEZ QUE GIREMOS EL MOVIL
    (ESTO ES EN AndroidManifest.xml) */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupActionBar();
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


    public void onClick(View view) {
        Intent intent = new Intent(this, SecondActivity.class);//intencion de iniciar la activity en la memoria
        intent.putExtra("VALOR_EXTRA", " Android Rool");
        startActivity(intent); // inicia
    }/* al final del "onClick" en activity_main.xml alt+enter para darle a crear el metodo onClick en el MainActivity*/


    public void onClick2(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://google.com"));
        startActivity(intent);
    }

    public void onClick3(View view) {
        String phone = "tel:1234";
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(phone));
        startActivity(intent);
    }

    public void onClickSalir(View view) {
        finish();
    }

    public void onClickLOGIN(View view) {
        Intent intent = new Intent(this, LoginActivity.class);//intencion de iniciar la activity en la memoria
        intent.putExtra("VALOR_EXTRA", " Android Rool");
        startActivity(intent); // inicia
    }


    public void onClickLISTA(View view) {
        Intent intent = new Intent(this, ListActivity.class);//intencion de iniciar la activity en la memoria
        intent.putExtra("VALOR_EXTRA", " Android Rool");
        startActivity(intent); // inicia
    }
}

