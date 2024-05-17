package com.microservice.user.services;

import com.microservice.user.models.UserModel;
import com.microservice.user.producers.UserProducer;
import com.microservice.user.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    final UserRepository userRepository;
    final UserProducer userProducer;

    public UserServices(UserRepository userRepository, UserProducer userProducer) {
        this.userRepository = userRepository;
        this.userProducer = userProducer;
    }

    @Transactional
    public UserModel save(UserModel userModel){
        userModel = userRepository.save(userModel);
        userProducer.publishMessageEmail(userModel);

        return userModel;
    }
}
