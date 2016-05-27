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

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        InputStream is = exchange.getRequestBody();

        Scanner scanner = new Scanner(is, "UTF-8").useDelimiter("\n");

        String path = exchange.getRequestURI().getPath();
        System.out.println(path);
        OutputStream os = exchange.getResponseBody();
        String response;
        if(listener.getGameScreen().connection)
            response ="true";
        else
            response = "false";

        os.write(response.getBytes());
        os.close();
        scanner.close();
    }

}
