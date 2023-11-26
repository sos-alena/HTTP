package handling.HTTP.requests.Sending.And.Processing.repository;

import handling.HTTP.requests.Sending.And.Processing.models.ActivityTable;

import java.sql.SQLException;
public interface ActivityTableRepository {
    void add(ActivityTable model) throws SQLException;
}
