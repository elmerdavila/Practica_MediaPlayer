package unsa.epis.practica_mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaplayer;
    Button anterior,siguiente;
    TextView titulo;
    int canciones[]={R.raw.black,R.raw.cafune,R.raw.conaltura,R.raw.hawai,R.raw.mueran,R.raw.odio,R.raw.tutu};
    String nombres[]={"Black and Yellow.mp3","Cafune.mp3","Con Altura-Rosalia.mp3","Hawai-Maluma.mp3","Que se mueran.mp3","Odio-Romeo Santos.mp3","Tutu-Camilo.mp3"};
    int indice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anterior=(Button)findViewById(R.id.anterior);
        siguiente=(Button)findViewById(R.id.siguiente);
        titulo=(TextView)findViewById(R.id.titulo);
        titulo.setText(nombres[indice]);

        anterior.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                indice--;
                if(indice<0) indice=canciones.length-1;
                mediaplayer.stop();
                mediaplayer = MediaPlayer.create(getApplicationContext(), canciones[indice]);
                mediaplayer.start();
                titulo.setText(nombres[indice]);
            }
        });

        siguiente.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                indice++;
                if(indice>=canciones.length) indice=0;
                mediaplayer.stop();
                mediaplayer = MediaPlayer.create(getApplicationContext(), canciones[indice]);
                mediaplayer.start();
                titulo.setText(nombres[indice]);
            }
        });
    }
    protected void onStart() {
        super.onStart();
        mediaplayer = MediaPlayer.create(this, canciones[indice]);
        mediaplayer.start();

    }
    protected void onStop() {
        super.onStop();
        mediaplayer.stop();
    }
}