package handling.HTTP.requests.Sending.And.Processing.controller;

import handling.HTTP.requests.Sending.And.Processing.repository.ActivityTableRepository;
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
    ActivityTableRepository activityTableRepository;
    ActivityTableServise activityTableServise;
    JSONArray model;
    HttpClient client;
    HttpRequest request;

    public ActivityTableController(ActivityTableServise activityTableServise) {
        this.activityTableServise = activityTableServise;
    }

    public void createRequests() {

        for (int i = 0; i < 7; i++) {
            client = HttpClient.newHttpClient();
            request = HttpRequest.newBuilder().uri(URI.create("https://www.boredapi.com/api/activity")).build();
            client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenApply(this::parseAndSaveInBD)
                    .join();

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public Void parseAndSaveInBD(String responseBody) {

        model = new JSONArray("[" + responseBody + "]");
        activityTableRepository = new ActivityTableRrepositoryIml();
        activityTableServise = new ActivityTableServise((ActivityTableRrepositoryIml) activityTableRepository);
        int temp = 1;
        for (int i = 0; i < model.length(); i++) {

            ActivityTable activityTable = new ActivityTable();

            int id = temp++;
            activityTable.setId(id);

            JSONObject album = model.getJSONObject(i);

            String activity = album.getString("activity");
            activityTable.setActivity(activity);

            String type = album.getString("type");
            activityTable.setType(type);

            int participants = album.getInt("participants");
            activityTable.setParticipants(participants);

            int price = album.getInt("price");
            activityTable.setPrice(price);

            String link = album.getString("link");
            activityTable.setActivityLine(link);

            String key = album.getString("key");
            activityTable.setActivitykey(key);

            int accessibility = album.getInt("accessibility");
            activityTable.setAccessibility(accessibility);

            System.out.println(activity + " " + type + " " + participants + " "
                    + price + " " + link + " " + key + " " + accessibility);

            try {
                activityTableServise.add(activityTable);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}
