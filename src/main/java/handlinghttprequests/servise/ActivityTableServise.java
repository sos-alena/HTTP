package handlinghttprequests.servise;

import handlinghttprequests.repository.ActivityTableRepository;
import handlinghttprequests.repository.ActivityTableRrepositoryIml;
import handlinghttprequests.models.ActivityTable;

import java.sql.SQLException;

public class ActivityTableServise {

    ActivityTableRepository activityTableRepository;

    public ActivityTableServise(ActivityTableRepository activityTableRepositoryIml) {
        this.activityTableRepository = activityTableRepositoryIml;
    }

    public void add(ActivityTable activityTableTable) throws SQLException {
        activityTableRepository.add(activityTableTable);
    }
}
