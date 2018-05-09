package miprimerapp.android.teaching.com.miprimeraapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class ProfileActivity extends AppCompatActivity {

    private EditText user;
    private EditText email;
    private EditText password;
    private RadioButton radioButtonMale;
    private RadioButton radioButtonFemale;
    private EditText edad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        user = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        radioButtonMale = findViewById(R.id.radioButtonMale);
        radioButtonFemale = findViewById(R.id.radioButtonFemale);
        edad = findViewById(R.id.edad);
    }

    public void SAVE(View view) {

        Log.d("ProfileActivity", user.getText().toString());
        Log.d("ProfileActivity", email.getText().toString());
        Log.d("ProfileActivity", password.getText().toString());
        Log.d("ProfileActivity", edad.getText().toString());


        // Radio Buttons

        if (radioButtonMale.isChecked()) {
            // El usuario ha seleccionado "H"
            Log.d("ProfileActivity", "Gender: male");
        } else if (radioButtonFemale.isChecked()) {
            // El usuario ha seleccionado "M"
            Log.d("ProfileActivity", "Gender: female");
        }
    }
}
