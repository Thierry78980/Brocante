package com.thierry.brocante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txtFileName = (TextView) findViewById(R.id.sommaire);
        // lecture d'un fichier texte existant dans src/main/assets
        String fichier = "3.s&v";
        String sommaire = lecture_fichier(fichier);
        txtFileName.setText(sommaire);
    }

    public String lecture_fichier(String fichier)
    {
        //TextView txtFileName = (TextView) findViewById(R.id.textView);
        AssetManager assetManager = getAssets();
        String texte="";
        InputStream input;

        try {

            input = assetManager.open(fichier);

            int size = input.available();

            byte[] buffer = new byte[size];
            input.read(buffer);
            input.close();

            texte = new String(buffer);


        } catch (IOException e) {
            e.printStackTrace();
        }

        return texte;
    }


    }
