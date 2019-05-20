package org.leanpoker.player;

import com.google.gson.JsonElement;

import java.util.Arrays;
import java.util.List;

public class Player {

    static final String VERSION = "1.2";

    public static int betRequest(JsonElement request) {
        //System.err.println(request.getAsJsonObject().get("players"));
        List<JsonElement> players  = Arrays.asList(request.getAsJsonObject().get("players"));
        for (JsonElement player : players) {
            System.err.println(player);
        }


        return 0;
    }

    public static void showdown(JsonElement game) {
    }

}
