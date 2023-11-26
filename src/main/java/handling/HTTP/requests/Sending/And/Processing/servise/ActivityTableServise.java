package handling.HTTP.requests.Sending.And.Processing.servise;

import handling.HTTP.requests.Sending.And.Processing.repository.ActivityTableRepository;
import handling.HTTP.requests.Sending.And.Processing.repository.ActivityTableRrepositoryIml;
import handling.HTTP.requests.Sending.And.Processing.models.ActivityTable;

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
