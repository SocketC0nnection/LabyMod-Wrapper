package net.labymodwrapper.src;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.labymodwrapper.src.utils.Cosmetic;
import net.labymodwrapper.src.utils.Emote;
import net.labymodwrapper.src.utils.Group;
import net.labymodwrapper.src.utils.Sticker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.util.UUID;

/**
 * @author SocketConnection
 * @github https://github.com/socketc0nnection
 **/

public class LabyProfile {

    private UUID uuid;
    private JsonObject object;

    public LabyProfile(UUID uuid) {
        this.uuid = uuid;
    }

    public LabyProfile update(Proxy proxy) throws IOException {
        HttpURLConnection connection;
        URL url = new URL(String.format("https://dl.labymod.net/userdata/%s.json", uuid));

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

        object = new JsonParser().parse(builder.toString()).getAsJsonObject();

        return this;
    }

    public LabyProfile update() throws IOException {
        return update(null);
    }

    public Sticker[] getStickers() {
        JsonArray array = object.getAsJsonObject("st").getAsJsonArray("p");

        Sticker[] stickers = new Sticker[array.size()];

        for(int i = 0; i < stickers.length; i++) {
            stickers[i] = Sticker.getStickerById(Integer.parseInt(array.get(i).toString()));
        }

        return stickers;
    }

    public Group[] getGroups() {
        JsonArray array = object.getAsJsonArray("g");

        Group[] groups = new Group[array.size()];

        for(int i = 0; i < groups.length; i++) {
            JsonObject object = array.get(i).getAsJsonObject();

            groups[i] = Group.getGroupById(Integer.parseInt(object.get("i").toString()));
        }

        return groups;
    }

    public Emote[] getEmotes() {
        JsonArray array = object.getAsJsonArray("e");

        Emote[] emotes = new Emote[array.size()];

        for(int i = 0; i < emotes.length; i++) {
            emotes[i] = Emote.getEmoteById(Integer.parseInt(array.get(i).toString()));
        }

        return emotes;
    }

    public Cosmetic[] getCosmetics() {
        JsonArray array = object.getAsJsonArray("c");

        Cosmetic[] cosmetics = new Cosmetic[array.size()];

        for(int i = 0; i < cosmetics.length; i++) {
            JsonObject object = array.get(i).getAsJsonObject();

            cosmetics[i] = Cosmetic.getCosmeticById(Integer.parseInt(object.get("i").toString()));
        }

        return cosmetics;
    }

    public boolean hasCosmetic(Cosmetic cosmetic) {
        for(Cosmetic cosmetics : getCosmetics()) {
            if(!cosmetics.equals(cosmetic)) {
                continue;
            }

            return true;
        }

        return false;
    }

    public boolean hasEmote(Emote emote) {
        for(Emote emotes : getEmotes()) {
            if(!emotes.equals(emote)) {
                continue;
            }

            return true;
        }

        return false;
    }

    public boolean hasGroup(Group group) {
        for(Group groups : getGroups()) {
            if(!groups.equals(group)) {
                continue;
            }

            return true;
        }

        return false;
    }

    public boolean hasSticker(Sticker sticker) {
        for(Sticker stickers : getStickers()) {
            if(!stickers.equals(sticker)) {
                continue;
            }

            return true;
        }

        return false;
    }

    public JsonObject getObject() {
        return object;
    }

    public LabyProfile setUuid(UUID uuid) {
        this.uuid = uuid;

        return this;
    }

    public UUID getUuid() {
        return uuid;
    }

}
