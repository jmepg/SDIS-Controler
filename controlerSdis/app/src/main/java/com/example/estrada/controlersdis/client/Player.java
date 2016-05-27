package com.example.estrada.controlersdis.client;

import java.util.concurrent.ExecutionException;

/**
 * Created by Estrada on 27/05/2016.
 */
public class Player {

    int playerID;

    public Player(){
    }

    public void moveLeft(){
        new Client().execute("left");
    }

    public void moveRight(){
       new Client().execute("right");
    }

    public void connect() throws ExecutionException, InterruptedException {
        Client c = new Client();
        String str = c.execute("connect").get();
        playerID = Integer.parseInt(str);
    }

    public int getPlayerID(){
        return playerID;
    }
}
