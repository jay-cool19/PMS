package com.jay.dao;

import com.jay.core.Person;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;

public interface PersonDAO {
    @SqlQuery("select * from people")
    @Mapper(PersonMapper.class)
    public List<Person> getPersonList();

    @SqlUpdate("insert into people (id,name,phone,address) values (:id,:name,:phone,:address)")
    void insertToPerson(@Bind("id") long id, @Bind("name") String name, @Bind("phone") String phone, @Bind("address") String address);

    @SqlQuery("select COUNT(*) from people where id = :id")
    boolean existsPerson( @Bind("id") String id );

    @SqlUpdate("UPDATE people SET name = :name WHERE id = :id")
    void updatePerson( @Bind("id") String id, @Bind("name") String name );

    @SqlUpdate("DELETE FROM people WHERE id = :id")
    void deletePerson( @Bind("id") String id );
}
