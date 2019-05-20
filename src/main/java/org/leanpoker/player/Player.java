package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.util.HashMap;
import java.util.Map;

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

                Map<String, String> card1 = new HashMap<>();
                card1.put("rank", ownCards.getAsJsonArray().get(0).getAsJsonObject().get("rank").toString());
                card1.put("suit", ownCards.getAsJsonArray().get(0).getAsJsonObject().get("suit").toString());

                System.err.println(card1);



                /*Type listType = new TypeToken<List<JsonObject>>(){}.getType();
                List<JsonObject> cardList = new Gson().fromJson(player, listType);

                Type mapType = new TypeToken<Map<String, String>>(){}.getType();
                Map<String, String> card1 = new Gson().fromJson(cardList.get(0), mapType);
                Map<String, String> card2 = new Gson().fromJson(cardList.get(1), mapType);

                ownHand.add(card1);
                ownHand.add(card2);

                System.err.println(ownHand);
                System.err.println(ownHand.get(0));
                System.err.println(ownHand.get(1));*/

            }
        }
        return 6;
    }

    public static void showdown(JsonElement game) {
    }

}
