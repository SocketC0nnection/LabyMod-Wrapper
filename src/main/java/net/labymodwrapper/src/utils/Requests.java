package net.labymodwrapper.src.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

/**
 * @author SocketConnection
 * @github https://github.com/socketc0nnection
 **/

public class Requests {

    public static JsonElement get(URL url) throws IOException {
        return get(url, null);
    }

    public static JsonElement get(URL url, Proxy proxy) throws IOException {
        HttpURLConnection connection;

        if(proxy == null) {
            connection = (HttpURLConnection) url.openConnection();
        } else {
            connection = (HttpURLConnection) url.openConnection(proxy);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        StringBuilder builder = new StringBuilder();

        String msg;
        while ((msg = reader.readLine()) != null) {
            builder.append(msg).append("\n");
        }

        return new JsonParser().parse(builder.toString());
    }

}
