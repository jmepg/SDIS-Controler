package com.example.estrada.controlersdis.gui;

import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.estrada.controlersdis.R;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONArray;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URL;

public class GameScreen extends Activity {

    Button connButton;
    ImageButton leftButton;
    ImageButton rightButton;
    String string;
    public Boolean connection;


    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        connButton = (Button) findViewById(R.id.connButton);
        leftButton = (ImageButton) findViewById(R.id.leftButton);
        rightButton = (ImageButton) findViewById(R.id.rightButton);
        leftButton.setBackgroundResource(R.drawable.left);
        rightButton.setBackgroundResource(R.drawable.right);


        InetSocketAddress socket;


        connButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Context context = getApplicationContext();
                CharSequence text = "Hello toast aaaaa!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

            }
        });


        leftButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
            }
        });


        rightButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
            }
        });


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();


    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.estrada.controlersdis/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.estrada.controlersdis/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }



}
