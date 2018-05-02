package miprimerapp.android.teaching.com.miprimeraapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String valor = intent.getStringExtra("VALOR_EXTRA");
        Log.d(" Valor de prueba extra","El string de prueba es" + valor);
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);  //intencion de iniciar la activity en la memoria
        startActivity(intent);
    }

}
