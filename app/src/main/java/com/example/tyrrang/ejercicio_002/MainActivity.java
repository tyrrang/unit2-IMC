package com.example.tyrrang.ejercicio_002;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    EditText txtNombre, txtPeso, txtEstatura;
    CheckBox chEjercicio;
    RadioButton rdHombre, rdMujer;
    MediaPlayer mediaPlayer;
    Button btnCalcular;
    TextView nombreP, pesoK, esta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //se pone la cancion en el main

        mediaPlayer = MediaPlayer.create(this, R.raw.fondo);
        mediaPlayer.setLooping(true);
        mediaPlayer.setVolume(100,100);
        mediaPlayer.start();

        //se relacionan los objetos del xml
        Typeface miPropiaTypeFace = Typeface.createFromAsset(getAssets(), "fonts/comic.ttf");
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtPeso = (EditText) findViewById(R.id.txtPeso);
        txtEstatura = (EditText) findViewById(R.id.txtEstatura);
        chEjercicio = (CheckBox) findViewById(R.id.chEjercicio);
        rdHombre = (RadioButton) findViewById(R.id.rdHombre);
        rdMujer = (RadioButton) findViewById(R.id.rdMujer);
        nombreP =(TextView) findViewById(R.id.nombreP);
        pesoK =(TextView) findViewById(R.id.pesoK);
        esta =(TextView) findViewById(R.id.esta);

        btnCalcular = (Button) findViewById(R.id.btnCalcular);

        //asignando el tipo de fuente
        txtNombre.setTypeface(miPropiaTypeFace);
        txtPeso.setTypeface(miPropiaTypeFace);
        txtEstatura.setTypeface(miPropiaTypeFace);
        chEjercicio.setTypeface(miPropiaTypeFace);
        rdHombre.setTypeface(miPropiaTypeFace);
        rdMujer.setTypeface(miPropiaTypeFace);
        btnCalcular.setTypeface(miPropiaTypeFace);
        nombreP.setTypeface(miPropiaTypeFace);
        pesoK.setTypeface(miPropiaTypeFace);
        esta.setTypeface(miPropiaTypeFace);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Persona p = new Persona(); //objeto de la clase persona
                p.setNombre(txtNombre.getText().toString());
                p.setPeso(Double.parseDouble(txtPeso.getText().toString()));
                p.setEstatura(Double.parseDouble(txtEstatura.getText().toString()));

                if (chEjercicio.isChecked()) {
                    p.setEjercicio((byte) 1);
                } else {
                    p.setEjercicio((byte) 0);
                }
                if (rdHombre.isChecked()) {
                    p.setSexo('M');
                } else if (rdMujer.isChecked()) {
                    p.setSexo('F');
                } else {
                    p.setSexo('X');
                }

                p.calcularImc();
                p.definirEstatus();
                p.resultado();

                if(p.resultado()>=20 && p.resultado()<=25){
                    mediaPlayer.stop();
                    Intent btnCalcular = new Intent(MainActivity.this, PesoNormal.class);
                    startActivity(btnCalcular);
                }

                if(p.resultado()<20){
                    mediaPlayer.stop();
                    Intent btnCalcular = new Intent(MainActivity.this, BajoPeso.class);
                    startActivity(btnCalcular);
                }

                if (p.resultado()>25){
                    mediaPlayer.stop();
                    Intent btnCalcular = new Intent(MainActivity.this, SobrePeso.class);
                    startActivity(btnCalcular);
                }
            }
        });



    }
}
