package handlinghttprequests.repository;

import handlinghttprequests.models.ActivityTable;

import java.sql.SQLException;
public interface ActivityTableRepository {
    void add(ActivityTable model) throws SQLException;
}
