package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.util.List;

public class Player {

    static final String VERSION = "1.3";

    public static int betRequest(JsonElement request) {
        //System.err.println(request.getAsJsonObject().get("players"));
        JsonArray players = request.getAsJsonObject().get("players").getAsJsonArray();
        for (JsonElement player : players) {
            player.getAsJsonObject();
            //System.err.println(player);
            if (player.getAsJsonObject().get("name").getAsString().equals("SSH Captian")) {
                JsonElement ownCards = player.getAsJsonObject().get("hole_cards");
                System.err.println(ownCards);
            }
        }
        return 0;
    }

    public static void showdown(JsonElement game) {
    }

}
