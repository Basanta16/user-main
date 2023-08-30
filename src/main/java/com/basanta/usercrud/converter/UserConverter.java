package com.basanta.usercrud.converter;


import com.basanta.usercrud.entity.User;
import com.basanta.usercrud.pojo.UserPojo;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public User convertPojotoEntity(UserPojo userPojo){

        User user = new User();

        user.setId(userPojo.getId());
        user.setName(userPojo.getName());
        user.setUsername(userPojo.getUsername());
        user.setPassword(userPojo.getPassword());
        user.setRole(userPojo.getRole());

        return user;
    }

    public UserPojo convertEntitytoPojo(User user){

        UserPojo userPojo = new UserPojo();

        userPojo.setId(user.getId());
        userPojo.setName(user.getName());
        userPojo.setUsername(user.getUsername());
        userPojo.setPassword(user.getPassword());
        userPojo.setRole(user.getRole());

        return userPojo;
    }


}
