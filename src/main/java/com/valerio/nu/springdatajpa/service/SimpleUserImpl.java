package com.valerio.nu.springdatajpa.service;


import com.valerio.nu.springdatajpa.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleUserImpl implements SimpleUserRepo {
  private final UserRepository userRepository;
  public SimpleUserImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User Post(User params) {
        userRepository.save(params);
        return params;
    }
    @Override
    public List<User> Get() {
        return (List<User>) userRepository.findAll();
    }
    @Override
    public User Get(long id) {
        return userRepository.findById(id).get();
    }
    @Override
    public User Update(User params, long id) {

        User user =  userRepository.findById(id).get();
        user.setFirstname(params.getFirstname());
        user.setLastname(params.getLastname());

        return userRepository.save(user);
    }
    @Override
    public String Delete(long id) {
        userRepository.deleteById(id);
        return "User(" + id + ")" + " has been deleted!";
    }
}
