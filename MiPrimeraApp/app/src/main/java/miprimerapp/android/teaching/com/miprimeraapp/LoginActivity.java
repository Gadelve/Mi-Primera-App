package miprimerapp.android.teaching.com.miprimeraapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        ActionBar myActionBar = getSupportActionBar();
        myActionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_login_activity, menu);
        return true;
    }

    public void onClickREGISTER(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);//intencion de iniciar la activity en la memoria
        intent.putExtra("VALOR_EXTRA", " Android Rool");
        startActivity(intent); // inicia
    }

    public void onClickLogin (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
