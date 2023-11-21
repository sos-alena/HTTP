package request.exemple.servise;

import request.exemple.models.ActivityTable;
import request.exemple.repository.ActivityTableRrepositoryIml;

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
