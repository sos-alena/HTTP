package handlinghttprequests;

import handlinghttprequests.controller.ActivityTableController;
import handlinghttprequests.repository.ActivityTableRepository;
import handlinghttprequests.repository.ActivityTableRrepositoryIml;
import handlinghttprequests.servise.ActivityTableServise;

public class RequestApplication {

    public static void main(String[] args){

        ActivityTableRepository activityTableRepository = new ActivityTableRrepositoryIml();
        ActivityTableServise activityTableServise = new ActivityTableServise((ActivityTableRrepositoryIml) activityTableRepository);
        ActivityTableController activityTableController =
                new ActivityTableController(activityTableServise);
        activityTableController.createRequests();
    }
}
