package com.sample.utils;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import static com.sample.utils.DateUtils.toDateTime;

public class SelectRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Map<String, Object> resultRow = new HashMap<>();

        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        for (int j = 1; j <= columnCount; j++) {
            String columnName = metaData.getColumnName(j);
            Object columnValue = resultSet.getObject(columnName);

            if (columnValue instanceof Timestamp) {
                columnValue = toDateTime(columnValue);
            }

            resultRow.put(columnName, columnValue);
        }

        return resultRow;
    }
}