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
import com.example.estrada.controlersdis.client.Player;

import org.json.JSONArray;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.sql.SQLOutput;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class GameScreen extends Activity {

    Button connButton;
    ImageButton leftButton;
    ImageButton rightButton;
    String string;
    public Boolean connection = false;
    Context context = this;
    Player pl;

    public Context getContext()
    {
        return context;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pl = new Player();
        connButton = (Button) findViewById(R.id.connButton);
        leftButton = (ImageButton) findViewById(R.id.leftButton);
        rightButton = (ImageButton) findViewById(R.id.rightButton);
        leftButton.setBackgroundResource(R.drawable.left);
        rightButton.setBackgroundResource(R.drawable.right);


        connButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    if(pl.getPlayerID()>0){
                        Toast.makeText(getApplicationContext(),
                                "Already Connected", Toast.LENGTH_LONG).show();
                        return;
                    }
                    pl.connect();

                    if(pl.getPlayerID()==-1){
                        Toast.makeText(getApplicationContext(),
                                "No More Players Allowed", Toast.LENGTH_LONG).show();
                    }
                    if(pl.getPlayerID()==-2){
                        Toast.makeText(getApplicationContext(),
                                "Error Connecting", Toast.LENGTH_LONG).show();
                    }
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("PLAYER_NUMBER: "+ pl.getPlayerID());
            }});


        leftButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                pl.moveLeft();
            }
        });


        rightButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                pl.moveRight();
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


}
