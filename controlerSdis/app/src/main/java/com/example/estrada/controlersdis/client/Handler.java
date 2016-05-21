package com.example.estrada.controlersdis.client;

import java.io.OutputStream;
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;


class Handler implements HttpHandler {

    private Listener listener;

    public Handler(Listener listener) {
        this.listener = listener;
    }

    public void handler(HttpExchange httpexchange) throws IOException {

        InputStream is = httpexchange.getRequestBody();

        Scanner scanner = new Scanner(is, "UTF-8").useDelimiter("\n");

        String path = httpexchange.getRequestURI().getPath();

       ////MISSING CODE HERE
        //regarding messages
    }
}
