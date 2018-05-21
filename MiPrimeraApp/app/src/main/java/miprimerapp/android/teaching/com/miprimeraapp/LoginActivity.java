package miprimerapp.android.teaching.com.miprimeraapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.EditText;

import java.io.File;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.editUsername);
        passwordEditText = findViewById(R.id.editpassword);

        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        ActionBar myActionBar = getSupportActionBar();
        myActionBar.setDisplayHomeAsUpEnabled(true);

        File directorioInterno = getFilesDir();
        File directorioCache = getCacheDir();
        Log.d("LoginActivity", "Interno: " + directorioInterno.getAbsolutePath());
        Log.d("LoginActivity", "Cache: " + directorioCache.getAbsolutePath());
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

   /* public void onClickLogin(View view) {
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        SharedPreferences mySharedPreferences = getSharedPreferences(getString(R.string.user_preferences), Context.MODE_PRIVATE);
        SharedPreferences.Editor myEditor = mySharedPreferences.edit("username_key",user);
        myEditor.apply();

}*/

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences mySharedPreferences = getSharedPreferences(getString(R.string.user_preferences), Context.MODE_PRIVATE);
        String savedUsername = mySharedPreferences.getString("username_key", "");
        usernameEditText.setText(savedUsername);
    }

    public void onClickLogin(View view) {
        // Obtener valores
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        SharedPreferences mySharedPreferences = getSharedPreferences(getString(R.string.user_preferences), Context.MODE_PRIVATE);

        SharedPreferences.Editor myEditor = mySharedPreferences.edit();
        myEditor.putString("username_key", username);
        myEditor.apply();
    }
}