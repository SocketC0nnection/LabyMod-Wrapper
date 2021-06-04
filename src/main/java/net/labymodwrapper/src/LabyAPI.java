package net.labymodwrapper.src;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.labymodwrapper.src.utils.AddonInfo;
import net.labymodwrapper.src.utils.Requests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

/**
 * @author SocketConnection
 * @github https://github.com/socketc0nnection
 **/

public class LabyAPI {

    public static String getStatus() throws IOException {
        return getStatus(null);
    }

    public static String getStatus(Proxy proxy) throws IOException {
        return Requests.get(new URL("https://dl.labymod.net"), proxy).getAsJsonObject().get("status").getAsString();
    }

    public static String[] getPublicServers() throws IOException {
        return getPublicServers(null);
    }

    public static String[] getPublicServers(Proxy proxy) throws IOException {
        JsonArray array = Requests.get(new URL("https://dl.labymod.net/servers.json"), proxy).getAsJsonArray();

        String[] strings = new String[array.size()];

        for(int i = 0; i < strings.length; i++) {
            strings[i] = array.get(i).getAsString();
        }

        return strings;
    }

    public static AddonInfo[] getAddons() throws IOException {
        return getAddons(null);
    }

    public static AddonInfo[] getAddons(Proxy proxy) throws IOException {
        JsonObject addonObject = Requests.get(new URL("https://dl.labymod.net/addons.json"), proxy).getAsJsonObject().get("addons").getAsJsonObject();

        ArrayList<AddonInfo> infos = new ArrayList<>();

        for(Map.Entry<String, JsonElement> entry : addonObject.entrySet()) {
            JsonArray array = entry.getValue().getAsJsonArray();

            for(int i = 0; i < array.size(); i++) {
                JsonObject object = array.get(i).getAsJsonObject();

                JsonArray sortingArray = object.get("sorting").getAsJsonArray();

                int[] sorting = new int[sortingArray.size()];

                for(int j = 0; j < sorting.length; j++) {
                    sorting[j] = sortingArray.get(j).getAsInt();
                }

                infos.add(new AddonInfo(object.get("name").getAsString(), UUID.fromString(object.get("uuid").getAsString()), object.get("version").getAsDouble(), object.get("hash").getAsString(), object.get("mcversion").getAsInt(), object.get("enabled").getAsBoolean(), object.get("installer").getAsBoolean(), object.get("restart").getAsBoolean(), object.get("includeInJar").getAsBoolean(), object.get("description").getAsString(), object.get("filesize").getAsLong(), AddonInfo.Category.getCategoryById(object.get("category").getAsInt()), object.get("verified").getAsBoolean(), object.get("performance").getAsBoolean(), object.get("author").getAsString(), sorting));
            }
        }

        return infos.toArray(new AddonInfo[0]);
    }

    public static String reportCape(String reportersName, String capeOwnersName) throws IOException {
        return reportCape(reportersName, capeOwnersName, null);
    }

    public static String reportCape(String reportersName, String capeOwnersName, Proxy proxy) throws IOException {
        HttpURLConnection connection;
        URL url = new URL("https://api.labymod.net/capes/capeReport.php");

        if(proxy == null) {
            connection = (HttpURLConnection) url.openConnection();
        } else {
            connection = (HttpURLConnection) url.openConnection(proxy);
        }

        connection.setDoOutput(true);
        connection.setDoInput(true);

        connection.setRequestMethod("POST");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");

        PrintWriter writer = new PrintWriter(connection.getOutputStream());

        writer.write(String.format("reporter=%s&capeowner=%s", reportersName, capeOwnersName));
        writer.flush();

        return new BufferedReader(new InputStreamReader(connection.getInputStream())).readLine();
    }

    public static String uploadHastebin(String content) throws IOException {
        return uploadHastebin(content, null);
    }

    public static String uploadHastebin(String content, Proxy proxy) throws IOException {
        HttpURLConnection connection;
        URL url = new URL("https://paste.labymod.net/documents");

        if(proxy == null) {
            connection = (HttpURLConnection) url.openConnection();
        } else {
            connection = (HttpURLConnection) url.openConnection(proxy);
        }

        connection.setDoOutput(true);
        connection.setDoInput(true);

        connection.setRequestMethod("POST");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
        connection.setRequestProperty("Content-Type", "text/plain");
        connection.setRequestProperty("charset", "utf-8");
        connection.setRequestProperty("Content-Length", content.length() + "");

        PrintWriter writer = new PrintWriter(connection.getOutputStream());

        writer.println(content);
        writer.flush();

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        StringBuilder builder = new StringBuilder();

        String msg;
        while ((msg = reader.readLine()) != null) {
            builder.append(msg).append("\n");
        }

        return "https://paste.labymod.net/" + new JsonParser().parse(builder.toString()).getAsJsonObject().get("key").getAsString();
    }

}
