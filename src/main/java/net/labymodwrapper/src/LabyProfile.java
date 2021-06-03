package net.labymodwrapper.src;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.labymodwrapper.src.utils.Requests;
import net.labymodwrapper.src.utils.enums.Cosmetic;
import net.labymodwrapper.src.utils.enums.Emote;
import net.labymodwrapper.src.utils.enums.Group;
import net.labymodwrapper.src.utils.enums.Sticker;

import java.io.IOException;
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
        object = Requests.get(new URL(String.format("https://dl.labymod.net/userdata/%s.json", uuid))).getAsJsonObject();

        return this;
    }

    public LabyProfile update() throws IOException {
        return update(null);
    }

    public Sticker[] getStickers() {
        JsonArray array = object.getAsJsonObject("st").getAsJsonArray("p");

        Sticker[] stickers = new Sticker[array.size()];

        for(int i = 0; i < stickers.length; i++) {
            stickers[i] = Sticker.getStickerById(array.get(i).getAsInt());
        }

        return stickers;
    }

    public Group[] getGroups() {
        JsonArray array = object.getAsJsonArray("g");

        Group[] groups = new Group[array.size()];

        for(int i = 0; i < groups.length; i++) {
            JsonObject object = array.get(i).getAsJsonObject();

            groups[i] = Group.getGroupById(object.get("i").getAsInt());
        }

        return groups;
    }

    public Emote[] getEmotes() {
        JsonArray array = object.getAsJsonArray("e");

        Emote[] emotes = new Emote[array.size()];

        for(int i = 0; i < emotes.length; i++) {
            emotes[i] = Emote.getEmoteById(array.get(i).getAsInt());
        }

        return emotes;
    }

    public Cosmetic[] getCosmetics() {
        JsonArray array = object.getAsJsonArray("c");

        Cosmetic[] cosmetics = new Cosmetic[array.size()];

        for(int i = 0; i < cosmetics.length; i++) {
            JsonObject object = array.get(i).getAsJsonObject();

            cosmetics[i] = Cosmetic.getCosmeticById(object.get("i").getAsInt());
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

    public String getCloakTexture() {
        return "https://dl.labymod.net/capes/" + uuid;
    }

    public String getBandanaTexture() {
        return "https://dl.labymod.net/textures/bandanas/" + uuid;
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
