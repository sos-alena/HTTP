package handling.HTTP.requests.Sending.And.Processing.servise;

import handling.HTTP.requests.Sending.And.Processing.repository.ActivityTableRrepositoryIml;
import handling.HTTP.requests.Sending.And.Processing.models.ActivityTable;

import java.sql.SQLException;

public class ActivityTableServise {

    static ActivityTableRrepositoryIml modelRepositoryIml;

   public ActivityTableServise(ActivityTableRrepositoryIml modelRepositoryIml) {

        ActivityTableServise.modelRepositoryIml = modelRepositoryIml
        ;
    }

    public void add(ActivityTable modelTable) throws SQLException {
      modelRepositoryIml.add(modelTable);

    }
}
