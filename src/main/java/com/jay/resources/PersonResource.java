package com.jay.resources;
import com.jay.core.Person;
import com.jay.dao.PersonDAO;
import io.swagger.annotations.Api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/person")
@Api(value = "Person Management System")
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {
    private PersonDAO personDAO;
    public PersonResource(PersonDAO personDAO){
        this.personDAO = personDAO;
    }
    //Get all persons
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getPerson(){
        return personDAO.getPersonList();
    }

    //Add a new person
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addPeople(Person newPerson){
        personDAO.insertToPerson(newPerson.getId(),newPerson.getName(),newPerson.getPhone(),newPerson.getAddress());
    }

    //Update an existing person
    @Path("{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean updatePerson(@PathParam("id") String id,Person updatePerson){
        if (personDAO.existsPerson(id)){
            personDAO.updatePerson(id, updatePerson.getName());
            return true;
        }
        else {
            return false;
        }
    }

    //Delete a person

    @Path("{id}")
    @DELETE
    public void delete(@PathParam("id") String id){
        personDAO.deletePerson(id);
    }
}
