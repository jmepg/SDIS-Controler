package com.example.estrada.controlersdis.client;
import java.io.BufferedReader;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.OutputStream;
import java.io.IOException;




public class Client {


    private String hostAddress;
    private int port;



    public Client(String hostAddress,int port){
        this.hostAddress = hostAddress;
        this.port = port;
    }

    public String httpGet(String request)throws IOException{
        URL url = new URL("http",hostAddress,port,request);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        BufferedReader reader =new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        StringBuilder sbuilder = new StringBuilder();
        String line;
        while((line = reader.readLine())!= null){
            sbuilder.append(line);
        }

        reader.close();
        connection.disconnect();
        return sbuilder.toString();

    }
/*
    public String httpPost(){
        URL url = new URL("http", );
    }
    */
}

