package com.valerio.nu.springdatajpa.service;


import com.valerio.nu.springdatajpa.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SimpleUserRepo {
    User Post(User params);

    List<User> Get();

    User Get(long id);

    User Update(User params, long id);

    String Delete(long id);
}
