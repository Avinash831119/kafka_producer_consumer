package com.suth.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.suth.model.User;
import com.suth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    KafkaSender kafkaSender;

    ObjectMapper mapper = new ObjectMapper();

    public String sendUser(int id) throws JsonProcessingException {
        User user = userRepository.findUserById(id);
        if (user != null) {
            String jsonUser = mapper.writeValueAsString(user);
            kafkaSender.sendUser(jsonUser);
            return user.getFullName() + " sent successfully";
        }
        return "invalid user id";
    }

    public String sendAllUser() throws JsonProcessingException {
        List<User> userList = userRepository.findAll();
        if (userList != null && userList.size() > 0) {
            String jsonUser = mapper.writeValueAsString(userList);
            kafkaSender.sendUser(jsonUser);
            return "users sent successfully";
        }
        return "invalid user id";
    }


    public void sendData() {
        kafkaSender.sendData();
    }
}
