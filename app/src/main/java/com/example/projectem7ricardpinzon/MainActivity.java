package com.example.projectem7ricardpinzon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText etusername;
    EditText etpassword;
    Button login;
    Button registre;
     Locale locale = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*Crear boolean que serveixi per detectar quin idioma s'ha escollit,
        i en funcio d'aquell numero determinat pel boolea, iniciar la activity aqui passantli aquell idioma.*/

        /*
        //CODIGO A EJECUTAR ANTES DE QUE SE MUESTRE LA VISTA DE LA ACTIVITY.
        * Locale catalan = new Locale("ca", "CA");
        locale.setDefault(catalan);
        Configuration config = new Configuration();
        config.locale = catalan;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        Intent cat = new Intent(getApplicationContext(), MainActivity.class);
        cat.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(cat);
        * */


        setContentView(R.layout.activity_main);



        etusername = findViewById(R.id.txt_User);
        etpassword = findViewById(R.id.txt_Password);
        login = findViewById(R.id.btn_signup);
        registre = findViewById(R.id.btn_registre);

    }


    public void formulariRegistre(View view) {
        Intent intent = new Intent(this, Registre.class);

        startActivity(intent);

    }

    public void login(View view) {

        final String username = etusername.getText().toString();
        final String password = etpassword.getText().toString();

        if(username.equals("user") && password.equals("user")){

            saveLoginSharedPreferences(username);

            Intent intent = new Intent(this, principal.class);

            startActivity(intent);

        }else{
            Toast toast =
                    Toast.makeText(getApplicationContext(),
                            "Usuari o contrasenya incorrectes.", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER|Gravity.LEFT,0,0);
            toast.show();
        }
    }

    private void saveLoginSharedPreferences(String username){
        SharedPreferences prefs = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("username", username);//guardar los datos
        editor.commit();
        editor.apply();
    }

    public void cambialCat(View view) {
        Locale catalan = new Locale("ca", "CA");
        locale.setDefault(catalan);
        Configuration config = new Configuration();
        config.locale = catalan;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
     Intent cat = new Intent(getApplicationContext(), MainActivity.class);
        cat.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(cat);
    }

    public void cambialEsp(View view) {
        Locale espanol = new Locale("es", "ES");
        locale.setDefault(espanol);
        Configuration config = new Configuration();
        config.locale = espanol;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());



        /*Intent esp = new Intent(getApplicationContext(), MainActivity.class);
        esp.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(esp);*/
    }

    public void cambialEn(View view) {
        Locale ingles = new Locale("en", "US");
        locale.setDefault(ingles);
        Configuration config = new Configuration();
        config.locale = ingles;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        /*Intent ing = new Intent(getApplicationContext(), MainActivity.class);
        ing.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(ing);*/
    }

}
