package request.exemple;

import request.exemple.controller.ActivityTableController;
import request.exemple.repository.ActivityTableRrepositoryIml;
import request.exemple.servise.ActivityTableServise;

public class RequestApplication {

    public static void main(String[] args){

        ActivityTableRrepositoryIml activityTablelRrepositoryIml = new ActivityTableRrepositoryIml();
        ActivityTableServise activityTableServise = new ActivityTableServise(activityTablelRrepositoryIml);
        ActivityTableController activityTableController = new ActivityTableController(activityTableServise);
        activityTableController.createRequest();
    }
}
