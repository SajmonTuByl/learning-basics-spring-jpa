package com.example.learningbasicsspringjpa;

import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository.
// Bean userRepository will contain all the database records mapped into User class objects.
// Records will be mapped accordingly to the variables in User class, so if we skip one variable, the data related to it won't be retrieved from the DB.
public interface UserRepository extends CrudRepository<User, Integer> {
}
