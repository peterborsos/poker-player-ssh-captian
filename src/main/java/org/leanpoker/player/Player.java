package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {

    static final String VERSION = "1.4";
    private static Map<String, String> card1;
    private static Map<String, String> card2;

    public static int betRequest(JsonElement request) {
        //System.err.println(request.getAsJsonObject().get("players"));
        JsonArray players = request.getAsJsonObject().get("players").getAsJsonArray();
        for (JsonElement player : players) {
            player.getAsJsonObject();
            //System.err.println(player);
            if (player.getAsJsonObject().get("name").getAsString().equals("SSH Captian")) {
                JsonElement ownCards = player.getAsJsonObject().get("hole_cards");
                //System.err.println(ownCards);

                card1 = new HashMap<>();
                card1.put("rank", ownCards.getAsJsonArray().get(0).getAsJsonObject().get("rank").toString());
                card1.put("suit", ownCards.getAsJsonArray().get(0).getAsJsonObject().get("suit").toString());

                card2 = new HashMap<>();
                card2.put("rank", ownCards.getAsJsonArray().get(1).getAsJsonObject().get("rank").toString());
                card2.put("suit", ownCards.getAsJsonArray().get(1).getAsJsonObject().get("suit").toString());

                System.err.println(card1);
                System.err.println(card2);
            }
        }
        List<String> highValueCards = new ArrayList<>();
        highValueCards.add("J");
        highValueCards.add("Q");
        highValueCards.add("K");
        highValueCards.add("A");

        if (highValueCards.indexOf(card1.get("rank")) > -1 &&
                highValueCards.indexOf(card2.get("rank")) > -1) {
            return request.getAsJsonObject().get("current_buy_in").getAsInt();
        }
        return 6;
    }

    public static void showdown(JsonElement game) {
    }

}
