package com.example.estrada.controlersdis.gui;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.estrada.controlersdis.R;
//import com.example.estrada.controlersdis.client.Client;
import com.example.estrada.controlersdis.client.Client;
import com.example.estrada.controlersdis.client.Listener;

import org.json.JSONArray;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.sql.SQLOutput;
import java.util.List;

public class GameScreen extends Activity {

    Button connButton;
    ImageButton leftButton;
    ImageButton rightButton;
    String string;
    public Boolean connection = false;
    Context context = this;


    public Context getContext()
    {
        return context;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        connButton = (Button) findViewById(R.id.connButton);
        leftButton = (ImageButton) findViewById(R.id.leftButton);
        rightButton = (ImageButton) findViewById(R.id.rightButton);
        leftButton.setBackgroundResource(R.drawable.left);
        rightButton.setBackgroundResource(R.drawable.right);


        connButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    System.out.println("ola1");
                    new Client().execute();
                } catch (GeneralSecurityException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }});


        leftButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
              /*  Toast.makeText(getApplicationContext(), st,
                        Toast.LENGTH_SHORT).show();*/
            }
        });


        rightButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onStop() {
        super.onStop();

    }
/*
    public void req(){

        String urlStr = "http://localhost:8000/api";
        try {
            Client cli = new Client();
            URL url = new URL(urlStr);
            String response = cli.httpRequest(url, "GET");
            Toast.makeText(getApplicationContext(), response,
                    Toast.LENGTH_SHORT).show();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "error",
                    Toast.LENGTH_SHORT).show();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/


}
