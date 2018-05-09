package miprimerapp.android.teaching.com.miprimeraapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void onClickREGISTER(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);//intencion de iniciar la activity en la memoria
        intent.putExtra("VALOR_EXTRA", " Android Rool");
        startActivity(intent); // inicia
    }
}
