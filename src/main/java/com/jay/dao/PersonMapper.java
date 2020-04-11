package com.jay.dao;

import com.jay.core.Person;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements ResultSetMapper<Person> {
    public Person map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException{
        return new Person(Long.parseLong(resultSet.getString("id")),
                resultSet.getString("name"),
                resultSet.getString("phone"),
                resultSet.getString("address"));
    }
}
