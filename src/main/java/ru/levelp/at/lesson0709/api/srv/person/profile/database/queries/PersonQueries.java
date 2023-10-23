package ru.levelp.at.lesson0709.api.srv.person.profile.database.queries;

import ru.levelp.at.lesson0709.api.srv.person.profile.database.dao.PersonProfileDao;
import ru.levelp.at.lesson0709.api.srv.person.profile.database.model.PersonEntity;

public class PersonQueries {

    public static PersonEntity getPerson(String id) {
        var sql = "SELECT * FROM person WHERE id::text = ?";

        return PersonProfileDao.getInstance().getJdbcTemplate()
            .queryForObject(sql, PersonEntity.mapper(), id);
    }
}
