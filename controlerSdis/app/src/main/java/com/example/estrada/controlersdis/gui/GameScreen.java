package com.example.estrada.controlersdis.gui;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.estrada.controlersdis.R;
import com.example.estrada.controlersdis.client.Player;
import java.util.concurrent.ExecutionException;

public class GameScreen extends Activity {

    Button connButton;
    ImageButton leftButton;
    ImageButton rightButton;
    String string;
    public Boolean connection = false;
    Context context = this;
    Player pl;
    ImageView img;

    public Context getContext()
    {
        return context;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.controler);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        pl = new Player();

        connButton = (Button) findViewById(R.id.connButton);
        leftButton = (ImageButton) findViewById(R.id.leftButton);
        rightButton = (ImageButton) findViewById(R.id.rightButton);
        img = (ImageView) findViewById(R.id.playerImg);
        img.setVisibility(View.GONE);

        leftButton.setBackgroundResource(R.drawable.left);
        rightButton.setBackgroundResource(R.drawable.right);

        connButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    if(pl.getPlayerID()>0){
                        Toast.makeText(getApplicationContext(),
                                "Disconnected", Toast.LENGTH_LONG).show();
                        pl.disconnect();
                        connButton.setBackgroundColor(0xffff0000);
                        connButton.setText("Connect");
                        img.setVisibility(View.GONE);
                        return;
                    }

                    pl.connect();

                    if(pl.getPlayerID()==-1){
                        Toast.makeText(getApplicationContext(),
                                "No More Players Allowed", Toast.LENGTH_LONG).show();
                                pl.setPlayerID(0);
                        return;
                    }
                    if(pl.getPlayerID()==-2){
                        Toast.makeText(getApplicationContext(),
                                "Error Connecting", Toast.LENGTH_LONG).show();
                        pl.setPlayerID(0);
                        return;

                    }


                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),
                            "Connection Lost", Toast.LENGTH_LONG).show();
                    pl.setPlayerID(0);
                }
                System.out.println("PLAYER_NUMBER: "+ pl.getPlayerID());
                switch(pl.getPlayerID()){
                    case 1:
                        img.setBackgroundResource(R.drawable.grey);
                        img.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        img.setBackgroundResource(R.drawable.blue);
                        img.setVisibility(View.VISIBLE);
                        break;
                    case 3:
                        img.setBackgroundResource(R.drawable.red);
                        img.setVisibility(View.VISIBLE);
                        break;
                    case 4:
                        img.setBackgroundResource(R.drawable.green);
                        img.setVisibility(View.VISIBLE);
                        break;
                    default:
                        break;
                }
                if(pl.getPlayerID()>0){
                    connButton.setText("Disconnect");
                    connButton.setBackgroundColor(0xff00ff00);
                    Toast.makeText(getApplicationContext(),
                            "Connected", Toast.LENGTH_LONG).show();
                }


            }});


        leftButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    pl.moveLeft();
                    return true;
                }
                else if(event.getAction() == MotionEvent.ACTION_UP){
                    pl.moveStop();
                    return true;
                }
                return false;
            }
        });

        rightButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    pl.moveRight();
                    return true;
                }
                else if(event.getAction() == MotionEvent.ACTION_UP){
                    pl.moveStop();
                    return true;
                }
                return false;
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
