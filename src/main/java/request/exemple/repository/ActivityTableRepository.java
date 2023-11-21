package request.exemple.repository;

import request.exemple.models.ActivityTable;

import java.sql.SQLException;
public interface ActivityTableRepository {
    void add(ActivityTable model) throws SQLException;
}
