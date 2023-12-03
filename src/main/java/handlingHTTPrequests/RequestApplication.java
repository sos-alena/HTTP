package handlingHTTPrequests;

import handlingHTTPrequests.controller.ActivityTableController;
import handlingHTTPrequests.repository.ActivityTableRrepositoryIml;
import handlingHTTPrequests.servise.ActivityTableServise;

public class RequestApplication {

    public static void main(String[] args){

        ActivityTableRrepositoryIml activityTableRepositoryIml = new ActivityTableRrepositoryIml();
        ActivityTableServise activityTableServise = new ActivityTableServise(activityTableRepositoryIml);
        ActivityTableController activityTableController =
                new ActivityTableController(activityTableServise);
        activityTableController.createRequests();
    }
}
