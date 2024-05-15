package com.microservice.user.services;

import com.microservice.user.models.UserModel;
import com.microservice.user.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    final
    UserRepository UserRepository;

    public UserServices(UserRepository userRepository) {
        UserRepository = userRepository;
    }

    @Transactional
    public UserModel save(UserModel userModel){
        return UserRepository.save(userModel);
    }
}
