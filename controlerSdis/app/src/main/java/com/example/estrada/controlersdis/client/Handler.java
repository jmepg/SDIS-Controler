package com.example.estrada.controlersdis.client;


import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.OutputStream;
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStream;


class Handler implements HttpHandler {

    private Listener listener;

    public Handler(Listener listener) {
        this.listener = listener;
    }

    public void handler(HttpExchange httpexchange) throws IOException {

        InputStream iStream = httpexchange.getRequestBody();

        Scanner scanner = new Scanner(iStream, "UTF-8").useDelimiter("\n");

        String path = httpexchange.getRequestURI().getPath();


       // httpexchange.sendResponseHeaders(200,);
        OutputStream oStream = httpexchange.getResponseBody();
       // oStream.write(response.getBytes());

       ////MISSING CODE HERE
        //regarding messages
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {

    }

}
