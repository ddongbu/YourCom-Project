package com.yourcom.project.project.service;


import com.yourcom.project.project.entity.Users;
import com.yourcom.project.project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserPageService {
    private final UserRepository userRepository;

    public Users findUser(Integer id){
        return userRepository.findById(id).get();
    }
}
