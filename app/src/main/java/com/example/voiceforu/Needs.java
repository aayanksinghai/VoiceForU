package com.example.voiceforu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Needs extends AppCompatActivity {
    Button submit;
    EditText etName;
    String name;
    public final static String NAME = "name";
    public static final String DATA = "data";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_needs);


        //Grabbing References
        submit = (Button) findViewById(R.id.buttonSubmit);
        etName = (EditText) findViewById(R.id.editTextName);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Initializing variables
                name = etName.getText().toString();

                //Saves to database
                try {
                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                    SharedPreferences.Editor editor= sharedPreferences.edit();
                    editor.putString(NAME,name);

                    editor.commit();

                } catch (Exception ex) {
                    ex.printStackTrace();
                } finally {

                }

                Intent intent = new Intent(Needs.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}