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
    HttpURLConnection connection;
    static int clientID=0;



    @Override
    protected String doInBackground(String... params) {
        // TODO Auto-generated method stub
        try {
            System.out.println("oi");

            System.out.println("oi_CLI: " + clientID);

            if(params[0].equals("left")|| params[0].equals("right"))
                params[0] = clientID+"/"+params[0];

            System.out.println("PARAM[0]: "+params[0]);

            String num = httpRequest(params[0]);

            System.out.println("NUMMMMM: "+num);

            if(num.equals("max")){
                return "unable";
            }

            if(params[0].equals("connect")){
                clientID = Integer.parseInt(num);
                setClientID(clientID);
            }

            System.out.println("ID_CLI: "+clientID);
            return num;
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }

    }



    public String httpRequest(String param)throws IOException{
            String urlStr = "http://172.30.12.172:8000/api/" + param;
            URL url = new URL(urlStr);
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
                System.out.println("REPOSTA AQUI: " +response.toString());
                return response.toString();
            } else {
                System.out.println("GET request not worked");
                return "error";
            }


    }
    public void onPostExecute(Void result) {

    }

    public int getClientID(){
        return clientID;
    }

    public void setClientID(int clientID){
        this.clientID=clientID;
    }
}