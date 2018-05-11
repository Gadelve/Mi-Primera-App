package miprimerapp.android.teaching.com.miprimeraapp;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
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
        edad.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    //mostrar datepicker dialog
                    new DatePickerDialog(ProfileActivity.this,
                            new DatePickerDialog.OnDateSetListener() {
                                @Override
                                public void onDateSet(DatePicker view,
                                                      int year, int month, int dayOfMonth) {
                                    edad.setText(dayOfMonth + "/" + month + "/" + year);
                                    String.valueOf(edad);
                                }
                            }, 1992, 5, 1).show();

                }

            }

        });

        Toolbar myToolbar = findViewById(R.id.toolbar);

        setSupportActionBar(myToolbar);

        ActionBar myActionBar = getSupportActionBar();
        myActionBar.setDisplayHomeAsUpEnabled(true);

        // PARA CAMBIAR LA IMG DE BACK de la toolbar --->  getSupportActionBar().setHomeAsUpIndicator(R.drawable.leftarrow);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_profile_activity, menu);
        return true;
    }

   /* public void SAVE(View view) {

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
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem
                                                 item) {
        switch (item.getItemId()) {
            case R.id.saveAction:
                SAVETOOLBAR();
                break;
            case R.id.deleteAction:
                BORRAR();
                break;

        }
        return true;
    }

    public void SAVETOOLBAR() {

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

    public void BORRAR() {


        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);

        builder
                .setMessage(R.string.dialog_message)
                .setTitle(R.string.dialog_title);


        builder
                .setPositiveButton(R.string.Ok,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(
                                    DialogInterface dialog,
                                    int which) {

                                user.setText("");
                                email.setText("");
                                password.setText("");
                                edad.setText("");
                                radioButtonMale.setChecked(false);
                                radioButtonFemale.setChecked(false);

                            }
                        });

        builder
                .setNegativeButton(R.string.No,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(
                                    DialogInterface dialog,
                                    int which) {
                            }
                        });

        builder
                .setNeutralButton(R.string.Cancel,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(
                                    DialogInterface dialog,
                                    int which) {
                            }
                        });

        AlertDialog dialog = builder.create();
        dialog.show();


    }

    public void BORRARboton(View view) {

        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);

        builder
                .setMessage(R.string.dialog_message)
                .setTitle(R.string.dialog_title);


        builder
                .setPositiveButton(R.string.Ok,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(
                                    DialogInterface dialog,
                                    int which) {

                                user.setText("");
                                email.setText("");
                                password.setText("");
                                edad.setText("");
                                radioButtonMale.setChecked(false);
                                radioButtonFemale.setChecked(false);

                            }
                        });

        builder
                .setNegativeButton(R.string.No,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(
                                    DialogInterface dialog,
                                    int which) {
                            }
                        });

        builder
                .setNeutralButton(R.string.Cancel,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(
                                    DialogInterface dialog,
                                    int which) {
                            }
                        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }

}
