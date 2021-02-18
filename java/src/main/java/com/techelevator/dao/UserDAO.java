package com.techelevator.dao;

import com.techelevator.model.User;

import java.util.List;

public interface UserDAO {

    List<User> findAll();

    User getUserById(Long userId);

    User findByUsername(String username);

    int findIdByUsername(String username);
    
    void addDisplayName(String username, String displayName);

    boolean create(String username, String password, String role, String displayName);
}
