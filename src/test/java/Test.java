import com.google.gson.JsonObject;
import net.labymodwrapper.src.LabyAPI;
import net.labymodwrapper.src.LabyProfile;
import net.labymodwrapper.src.utils.AddonInfo;
import net.labymodwrapper.src.utils.enums.Cosmetic;
import net.labymodwrapper.src.utils.enums.Emote;
import net.labymodwrapper.src.utils.enums.Group;
import net.labymodwrapper.src.utils.enums.Sticker;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.UUID;

/**
 * @author SocketConnection
 * @github https://github.com/socketc0nnection
 **/

public class Test {

    public static void main(String[] args) throws IOException {
        //Documentation for LabyAPI

        String status = LabyAPI.getStatus(); //Returns the labymod api status
        String[] publicServers = LabyAPI.getPublicServers(); //Returns the public server list
        AddonInfo[] addons = LabyAPI.getAddons(); //Returns all official available labymod addons

        String response = LabyAPI.reportCape("SocketConnection", "kxmpetentes"); //Reports the cape from a player and returns the response
        String link = LabyAPI.uploadHastebin("LabyMod-Wrapper for Java TEST"); //Uploads content to the labymod haste server and returns the link

        //Documentation for LabyProfile

        LabyProfile profile = new LabyProfile(UUID.fromString("c2f6cf3f-48b6-44cf-aaf8-c282c2842de3")).update(); //Instantiate the LabyProfile class with a uuid. Call the update() method to renew the profile informations

        profile.setUuid(UUID.fromString("fb7db415-a78d-4575-b782-336fd25af5f1")); //Updates the profile instance to a new uuid
        profile.update(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 8080))); //Updates the profile instance through a specific proxy

        JsonObject object = profile.getObject(); //Returns the completely JsonObject of the profile
        UUID uuid = profile.getUuid(); //Returns the uuid of the current profile

        Cosmetic[] cosmetics = profile.getCosmetics(); //Returns a integer array with all cosmetics ids of the profile
        Emote[] emotes = profile.getEmotes(); //Returns a integer array with all emote ids of the profile
        Sticker[] stickers = profile.getStickers(); //Returns a integer array with all sticker ids of the profile
        Group[] groups = profile.getGroups(); //Returns a integer array with all group ids of the profile

        String cloakUrl = profile.getCloakTexture(); //Returns the url from the cloak texture
        String bandanaUrl = profile.getBandanaTexture(); //Returns the url from the bandana texture

        if(profile.hasCosmetic(Cosmetic.ANGEL_WINGS) || profile.hasEmote(Emote.INFINITY_SIT) || profile.hasGroup(Group.LABYMOD_PLUS) || profile.hasSticker(Sticker.STAY_SAFE_PACK)) { //Asks whether the profile has a certain item
            //DO STUFF
        }
    }

}
