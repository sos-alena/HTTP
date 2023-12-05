package handlinghttprequests;

import handlinghttprequests.controller.ActivityTableController;
import handlinghttprequests.repository.ActivityTableRepository;
import handlinghttprequests.repository.ActivityTableRrepositoryIml;
import handlinghttprequests.servise.ActivityTableServise;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class RequestApplication {

    public static void main(String[] args){

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://www.boredapi.com/api/activity")).build();

        ActivityTableRepository activityTableRepository = new ActivityTableRrepositoryIml();
        ActivityTableServise activityTableServise = new ActivityTableServise(activityTableRepository);
        ActivityTableController activityTableController =
                new ActivityTableController(activityTableServise, client, request);
        activityTableController.createRequests();
    }
}
