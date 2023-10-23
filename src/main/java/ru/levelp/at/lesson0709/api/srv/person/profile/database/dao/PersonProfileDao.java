package ru.levelp.at.lesson0709.api.srv.person.profile.database.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class PersonProfileDao {

    private static PersonProfileDao personProfileDao;
    private final JdbcTemplate jdbcTemplate;

    private PersonProfileDao() {
        var config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/person_profile");
        config.setUsername("person_profile");
        config.setPassword("password");

        DataSource dataSource = new HikariDataSource(config);
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public static synchronized PersonProfileDao getInstance() {
        if (personProfileDao == null) {
            personProfileDao = new PersonProfileDao();
        }

        return personProfileDao;
    }
}
