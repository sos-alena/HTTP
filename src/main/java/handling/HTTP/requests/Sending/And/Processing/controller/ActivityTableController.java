package handling.HTTP.requests.Sending.And.Processing.controller;

import handling.HTTP.requests.Sending.And.Processing.repository.ActivityTableRrepositoryIml;
import org.json.JSONArray;
import org.json.JSONObject;

import handling.HTTP.requests.Sending.And.Processing.models.ActivityTable;
import handling.HTTP.requests.Sending.And.Processing.servise.ActivityTableServise;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLException;

public class ActivityTableController {
    ActivityTableServise activityTableServise;

    public ActivityTableController(ActivityTableServise activityTableServise) {
        this.activityTableServise = activityTableServise;
    }

    public void createRequest() {
        for (int i = 0; i < 7; i++) {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://www.boredapi.com/api/activity")).build();
            client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenApply(ActivityTableController::parse)
                    .join();

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static Void parse(String responseBody) {

        JSONArray model = new JSONArray("[" + responseBody + "]");

        ActivityTableRrepositoryIml modelRrepositoryIml = new ActivityTableRrepositoryIml();
        ActivityTableServise modelServise = new ActivityTableServise(modelRrepositoryIml);
        int temp = 1;
        for (int i = 0; i < model.length(); i++) {

            ActivityTable modelTable = new ActivityTable();

            int id = temp++;
            modelTable.setId(id);

            JSONObject album = model.getJSONObject(i);

            String activity = album.getString("activity");
            modelTable.setActivity(activity);

            String type = album.getString("type");
            modelTable.setType(type);

            int participants = album.getInt("participants");
            modelTable.setParticipants(participants);

            int price = album.getInt("price");
            modelTable.setPrice(price);

            String link = album.getString("link");
            modelTable.setActivityLine(link);

            String key = album.getString("key");
            modelTable.setActivitykey(key);

            int accessibility = album.getInt("accessibility");
            modelTable.setAccessibility(accessibility);

            System.out.println(activity + " " + type + " " + participants + " "
                    + price + " " + link + " " + key + " " + accessibility);

            try {
                modelServise.add(modelTable);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}
