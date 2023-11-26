package handling.HTTP.requests.Sending.And.Processing;

import handling.HTTP.requests.Sending.And.Processing.controller.ActivityTableController;
import handling.HTTP.requests.Sending.And.Processing.repository.ActivityTableRrepositoryIml;
import handling.HTTP.requests.Sending.And.Processing.servise.ActivityTableServise;

public class RequestApplication {

    public static void main(String[] args){

        ActivityTableRrepositoryIml activityTableRepositoryIml = new ActivityTableRrepositoryIml();
        ActivityTableServise activityTableServise = new ActivityTableServise(activityTableRepositoryIml);
        ActivityTableController activityTableController =
                new ActivityTableController(activityTableServise);
        activityTableController.createRequests();
    }
}
