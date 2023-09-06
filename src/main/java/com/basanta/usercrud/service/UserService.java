package com.basanta.usercrud.service;

import com.basanta.usercrud.entity.User;
import com.basanta.usercrud.pojo.UserPojo;

public interface UserService {

    User createUser (UserPojo userPojo);

    String viewUser(Long id);
    
    void deleteUser(Long id);
    
    String updateUser(UserPojo userPojo);


}
