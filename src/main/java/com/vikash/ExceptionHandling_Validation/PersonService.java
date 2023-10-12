package com.vikash.ExceptionHandling_Validation;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface PersonService
{
  public Person saveDetails(Person person);
  public List<Person> fetchAllUsers();

}
