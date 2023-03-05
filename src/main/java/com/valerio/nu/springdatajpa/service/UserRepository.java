package com.valerio.nu.springdatajpa.service;


import com.valerio.nu.springdatajpa.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByTheUsersName(String username);

    Optional<User> findByUsername(Optional<String> username);

    List<User> findByLastname(String lastname);

    @Query("select u from Users u where u.firstname = :firstname")
    List<User> findByFirstname(String firstname);

    @Query("select u from Users u where u.firstname = :name or u.lastname = :name")
    List<User> findByFirstnameOrLastname(String name);

    @Query("select u from Users u where u.firstname = :#{#user.firstname} or u.lastname = :#{#user.lastname}")
    Iterable<User> findByFirstnameOrLastname(User user);



}