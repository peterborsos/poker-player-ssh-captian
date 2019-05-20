package org.leanpoker.player;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import java.util.Map;

public class Player {

    static final String VERSION = "1.2";

    public static int betRequest(JsonElement request) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        PlayerInformation playerInformation = gson.fromJson(request, PlayerInformation.class);
        System.err.println(playerInformation.name);
        return 0;
    }

    public static void showdown(JsonElement game) {
    }

}
class PlayerInformation {
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
