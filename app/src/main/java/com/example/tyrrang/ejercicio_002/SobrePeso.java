package com.example.tyrrang.ejercicio_002;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SobrePeso extends AppCompatActivity {

    Button btnRegresar;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre_peso);

        //fuente
        Typeface miPropiaTypeFace = Typeface.createFromAsset(getAssets(), "fonts/comic.ttf");
        TextView txt = (TextView)findViewById(R.id.txtsobrePeso);
        TextView txt1 =(TextView)findViewById(R.id.txtAyuda);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);
        btnRegresar.setTypeface(miPropiaTypeFace);
        txt.setTypeface(miPropiaTypeFace);
        txt1.setTypeface(miPropiaTypeFace);

        //se pone la cancion en el main

        mediaPlayer = MediaPlayer.create(this, R.raw.sobrepeso);
        mediaPlayer.setLooping(true);
        mediaPlayer.setVolume(100, 100);
        mediaPlayer.start();


        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                Intent btnCalcular = new Intent(SobrePeso.this, MainActivity.class);
                startActivity(btnCalcular);
            }
        });
    }
}
