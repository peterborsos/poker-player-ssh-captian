package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.util.HashMap;
import java.util.Map;

public class Player {

    static final String VERSION = "2.4";
    private static Map<String, String> card1;
    private static Map<String, String> card2;

    public static int betRequest(JsonElement request) {
        JsonArray players = request.getAsJsonObject().get("players").getAsJsonArray();
        for (JsonElement player : players) {
            player.getAsJsonObject();

            if (player.getAsJsonObject().get("name").getAsString().equals("SSH Captian")) {
                JsonElement ownCards = player.getAsJsonObject().get("hole_cards");

                card1 = new HashMap<>();
                card1.put("rank", ownCards.getAsJsonArray().get(0).getAsJsonObject().get("rank").toString());
                card1.put("suit", ownCards.getAsJsonArray().get(0).getAsJsonObject().get("suit").toString());

                card2 = new HashMap<>();
                card2.put("rank", ownCards.getAsJsonArray().get(1).getAsJsonObject().get("rank").toString());
                card2.put("suit", ownCards.getAsJsonArray().get(1).getAsJsonObject().get("suit").toString());

            }
        }
        String rank1 = card1.get("rank");
        String rank2 = card2.get("rank");

        int currentBuyIn = request.getAsJsonObject().get("current_buy_in").getAsInt();
        System.err.println(currentBuyIn);

        if (card1.get("rank").equals("A") && card2.get("rank").equals("A")) {
            System.err.println("ACE PAIR!!!!");
            return 1000;
        }
        if (card1.get("rank").equals("K") && card2.get("rank").equals("K")) {
            return 800;
        }
        if (card1.get("rank").equals("Q") && card2.get("rank").equals("Q")) {
            return 600;
        }
        if (card1.get("rank").equals("J") && card2.get("rank").equals("J")) {
            return 400;
        }

        if (rank1.equals("J") && rank2.equals("Q") ||
                rank1.equals("J") && rank2.equals("K") ||
                rank1.equals("J") && rank2.equals("A") ||
                rank1.equals("Q") && rank2.equals("J") ||
                rank1.equals("Q") && rank2.equals("K") ||
                rank1.equals("Q") && rank2.equals("A") ||
                rank1.equals("K") && rank2.equals("J") ||
                rank1.equals("K") && rank2.equals("Q") ||
                rank1.equals("K") && rank2.equals("A") ||
                rank1.equals("A") && rank2.equals("J") ||
                rank1.equals("A") && rank2.equals("Q") ||
                rank1.equals("A") && rank2.equals("K")) {

            return 200;
        }
        return 100;
    }

    public static void showdown(JsonElement game) {
    }

}
