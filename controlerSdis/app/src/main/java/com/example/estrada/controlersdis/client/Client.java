package com.example.estrada.controlersdis.client;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.GeneralSecurityException;



public class Client extends AsyncTask<String, Void, String> {
    private static int count = 0;
    int clientID;
    HttpURLConnection connection;

    public Client() throws GeneralSecurityException, IOException {
        setClientID(++count);
    }

    public void setClientID(int ID){
        this.clientID = ID;
    }

    @Override
    protected String doInBackground(String... params) {
        System.out.println("erro");
        // TODO Auto-generated method stub
        try {
             httpRequest();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }



    public void httpRequest()throws IOException{;
            URL url = new URL("http://172.30.12.172:8000/api");
            String method = "GET";
            connection= (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.connect();
            int responseCode = connection.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        connection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // print result
                System.out.println(response.toString());
            } else {
                System.out.println("GET request not worked");
            }




    }

}