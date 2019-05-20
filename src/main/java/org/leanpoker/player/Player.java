package org.leanpoker.player;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {

    static final String VERSION = "1.3";
    private static List<Map<String, String>> ownHand = new ArrayList<>();

    public static int betRequest(JsonElement request) {
        //System.err.println(request.getAsJsonObject().get("players"));
        JsonArray players = request.getAsJsonObject().get("players").getAsJsonArray();
        for (JsonElement player : players) {
            player.getAsJsonObject();
            //System.err.println(player);
            if (player.getAsJsonObject().get("name").getAsString().equals("SSH Captian")) {
                JsonElement ownCards = player.getAsJsonObject().get("hole_cards");
                //System.err.println(ownCards);
                /*Type listType = new TypeToken<List<JsonObject>>(){}.getType();
                List<JsonObject> cardList = new Gson().fromJson(player, listType);

                Type mapType = new TypeToken<Map<String, String>>(){}.getType();
                Map<String, String> card1 = new Gson().fromJson(cardList.get(0), mapType);
                Map<String, String> card2 = new Gson().fromJson(cardList.get(1), mapType);

                ownHand.add(card1);
                ownHand.add(card2);*/

                System.err.println(ownHand);
                System.err.println(ownHand.get(0));
                System.err.println(ownHand.get(1));

            }
        }
        return 6;
    }

    public static void showdown(JsonElement game) {
    }

}
