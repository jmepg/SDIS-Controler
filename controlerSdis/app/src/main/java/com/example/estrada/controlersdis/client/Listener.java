package com.example.estrada.controlersdis.client;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Listener implements Runnable{

    private byte[] buffer = new byte[256];
    private DatagramSocket clientSocket;

    public Listener() throws IOException{
        this.clientSocket = new DatagramSocket(9999); //necessario atualizar
    }

    public void run(){
        do{
            try{
                DatagramPacket recPacket = new DatagramPacket(buffer,buffer.length);
                clientSocket.receive(recPacket);
                String msg = new String(recPacket.getData(), 0,
                        recPacket.getLength());

                //MISSING CODE HERE
                //regarding messages
            }
            catch (SocketException e){
                e.printStackTrace();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        } while(true);
    }
}
