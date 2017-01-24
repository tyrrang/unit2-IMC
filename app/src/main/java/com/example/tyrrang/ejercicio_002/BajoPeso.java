package com.example.tyrrang.ejercicio_002;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BajoPeso extends AppCompatActivity {

    Button btnRegresar;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bajo_peso);

        //fuente
        Typeface miPropiaTypeFace = Typeface.createFromAsset(getAssets(), "fonts/comic.ttf");
        TextView txt = (TextView)findViewById(R.id.txtbajoPeso);
        TextView txta =(TextView)findViewById(R.id.txtAyuda);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);
        txt.setTypeface(miPropiaTypeFace);
        txta.setTypeface(miPropiaTypeFace);
        btnRegresar.setTypeface(miPropiaTypeFace);

        //se pone la cancion en el main

        mediaPlayer = MediaPlayer.create(this, R.raw.bajopeso);
        mediaPlayer.setLooping(true);
        mediaPlayer.setVolume(100,100);
        mediaPlayer.start();


        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                Intent btnCalcular = new Intent(BajoPeso.this, MainActivity.class);
                startActivity(btnCalcular);
            }
        });
    }
}
