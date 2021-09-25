package com.sample.utils;

import org.postgresql.Driver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.util.ClassUtils;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostgreSqlExecutor {
    private static final Logger LOGGER = LoggerFactory.getLogger(PostgreSqlExecutor.class);

    private static final String RESULTS_KEY = "rows";

    private final Map<String, List<Map<String, Object>>> dbRecordsMap = new HashMap<>();

    @Inject
    @Named("db.host.url")
    private String dbHostUrl;

    @Inject
    @Named("db.username")
    private String dbUserName;

    @Inject
    @Named("db.password")
    private String dbPassword;

    public Map<String, List<Map<String, Object>>> executeSimpleSql(SqlRequest request) throws Exception {
        LOGGER.info("DB - Executing SQL query: {}", request);

        List<Map<String, Object>> recordsList = getNamedParameterJdbcTemplate().query(request.getSql(),
                request.getMapSqlParameterSource(), new SelectRowMapper());

        dbRecordsMap.put(RESULTS_KEY, recordsList);

        return dbRecordsMap;
    }

    public Map<String, List<Map<String, Object>>> updateSql(SqlRequest request) throws Exception {
        LOGGER.info("DB - Executing update SQL query: {}", request);

        getNamedParameterJdbcTemplate().update(request.getSql(), request.getMapSqlParameterSource());

        return dbRecordsMap;
    }

    private NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() throws Exception {
        final String driverClassName = "org.postgresql.Driver";

        // Build dataSource & JDBC template from the host properties file
        final Class<?> driverClass = ClassUtils.resolveClassName(driverClassName, this.getClass().getClassLoader());
        Driver driver = (Driver) ClassUtils.getConstructorIfAvailable(driverClass).newInstance();
        final DataSource dataSource = new SimpleDriverDataSource(driver, dbHostUrl, dbUserName, dbPassword);

        return new NamedParameterJdbcTemplate(dataSource);
    }
}