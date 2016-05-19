package com.example.estrada.controlersdis.client;
import java.io.BufferedReader;
import java.io.Writer;
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
        StringBuilder sBuilder = new StringBuilder();
        String line;
        while((line = reader.readLine())!= null){
            sBuilder.append(line);
        }

        reader.close();
        connection.disconnect();
        return sBuilder.toString();

    }

    public String httpPost(String urlString) throws Exception{
        URL url = new URL("http","9999",9999,"9999"); //necessario atualizar
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        //connection properties
        connection.setRequestMethod("POST");
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setUseCaches(false);
        connection.setAllowUserInteraction(false);
        connection.setRequestProperty("Content-Type","9999"); //necesdsario atualizar

        OutputStream outStream = connection.getOutputStream();
        Writer writer = new OutputStreamWriter(outStream,"UTF-8");

        //incluir aqui os writes que forem necessarios

        writer.close();
        outStream.close();

        BufferedReader reader =new BufferedReader(
                new InputStreamReader(connection.getInputStream()));

        StringBuilder sBuilder = new StringBuilder();
        String line;

        while((line = reader.readLine())!= null){
            sBuilder.append(line);
        }

        reader.close();
        connection.disconnect();
        return sBuilder.toString();




    }

}

