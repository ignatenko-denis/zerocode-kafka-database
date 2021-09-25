package com.sample.utils;

import lombok.Data;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

/**
 * Container for SQL-request naming parameters
 */
@Data
public class SqlRequest {
    /**
     * SQL-request to DB.
     */
    private String sql;

    /**
     * Naming parameters for SQL-request. Pair (name, value).
     */
    private Map<String, String> params = new HashMap<>();

    public MapSqlParameterSource getMapSqlParameterSource() {
        MapSqlParameterSource result = new MapSqlParameterSource();

        for (Map.Entry<String, String> entry : params.entrySet()) {
            result.addValue(entry.getKey(), entry.getValue(), Types.VARCHAR);
        }

        return result;
    }
}