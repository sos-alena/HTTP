package handlingHTTPrequests.servise;

import handlingHTTPrequests.repository.ActivityTableRepository;
import handlingHTTPrequests.repository.ActivityTableRrepositoryIml;
import handlingHTTPrequests.models.ActivityTable;

import java.sql.SQLException;

public class ActivityTableServise {

    ActivityTableRepository activityTableRepository;

    public ActivityTableServise(ActivityTableRrepositoryIml activityTableRepositoryIml) {
        this.activityTableRepository = activityTableRepositoryIml;
    }

    public void add(ActivityTable activityTableTable) throws SQLException {
        activityTableRepository.add(activityTableTable);
    }
}
