package com.demojuin.demojuin.services;

import com.demojuin.demojuin.entities.UserEntity;

import java.util.List;

public interface UserInterface {
    UserEntity adduser(UserEntity user);
    void deletedUser(Long id);
    List<UserEntity> AddListUsers(List<UserEntity> users);
    String addUserWTCP(UserEntity user);
    String addUserWTUN(UserEntity user);
    UserEntity UpdateUser( UserEntity user, Long id );
    List<UserEntity> getAllUsers();
    UserEntity getUserById(Long id);
    UserEntity getUserByUsername(String username);
    List<UserEntity> getUsersSWT(String un);
    List<UserEntity> getUserByEmail(String un);

}
