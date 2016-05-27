package com.example.estrada.controlersdis.client;


import com.example.estrada.controlersdis.gui.GameScreen;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Listener implements Runnable{

    private byte[] buffer = new byte[256];
    private DatagramSocket clientSocket;
    private final GameScreen gameScreen;

    public Listener(GameScreen gameScreen) throws IOException{
        this.clientSocket = new DatagramSocket(9001); //necessario atualizar
        this.gameScreen = gameScreen;
    }

    public void run(){
        do{
            try{
                DatagramPacket recPacket = new DatagramPacket(buffer,buffer.length);
                clientSocket.receive(recPacket);
                String msg = new String(recPacket.getData(), 0,
                        recPacket.getLength());
                if(msg.startsWith("/Runner/init")){
                    gameScreen.connection = true;
                }
                if(msg.startsWith("/Runner/over")){
                    gameScreen.connection = false;
                }
    // Supostamente não será preciso mais nada pq oo listener é so pra ver se o
    // comando esta ligado
            }
            catch (SocketException e){
                e.printStackTrace();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        } while(true);

    }

    public GameScreen getGameScreen(){
        return gameScreen;
    }
}
