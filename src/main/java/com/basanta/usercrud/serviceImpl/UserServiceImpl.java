package com.basanta.usercrud.serviceImpl;

import com.basanta.usercrud.controller.UserController;
import com.basanta.usercrud.converter.UserConverter;
import com.basanta.usercrud.entity.User;
import com.basanta.usercrud.pojo.UserPojo;
import com.basanta.usercrud.repo.UserRepository;
import com.basanta.usercrud.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("abc")
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;


    @Override
    public User createUser(UserPojo userPojo) {

        User createdUser = userConverter.convertPojotoEntity(userPojo);
        userRepository.save(createdUser);
        return createdUser;
    }

    @Override
    public String viewUser(Long id) {

        User viewUser = userRepository.findById(id).orElseThrow();
        String json = null;
        
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
			 json = ow.writeValueAsString(viewUser);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return json;
    }

	@Override
	public void deleteUser(Long id) {
		
	User deleteUser	=userRepository.findById(id).orElseThrow();
	
	userRepository.delete(deleteUser);
		
	}

	@Override
	public String updateUser(UserPojo userPojo) {
		// TODO Auto-generated method stub
		
		String json = null;
		
			User updatedUser=userRepository.findById(userPojo.getId()).orElseThrow();
			
			updatedUser.setId(userPojo.getId());
			updatedUser.setName(userPojo.getName());
			updatedUser.setUsername(userPojo.getUsername());
			updatedUser.setRole(userPojo.getRole());
			
			userRepository.save(updatedUser);
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
	        try {
				 json = ow.writeValueAsString(updatedUser);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return json;
	}
}
