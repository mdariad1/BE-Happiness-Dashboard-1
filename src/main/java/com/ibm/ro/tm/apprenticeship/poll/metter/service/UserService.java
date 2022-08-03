package com.ibm.ro.tm.apprenticeship.poll.metter.service;

import com.ibm.ro.tm.apprenticeship.poll.metter.dto.UserDTO;
import com.ibm.ro.tm.apprenticeship.poll.metter.entity.User;
import com.ibm.ro.tm.apprenticeship.poll.metter.exception.CustomException;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.UserRepository;
import mapper.PollMapper;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class UserService {


    private UserRepository userRepo;


    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }


    public UserDTO addUser(UserDTO userDto){
        User user = UserMapper.toEntity(userDto);
        User savedUser = userRepo.save(user);
        UserDTO newUserDto = UserMapper.toDto(savedUser);
        return  newUserDto;
    }
    public Set<UserDTO> findAllUsers(){
        Set<User> users = new HashSet<User>(userRepo.findAll());
        return UserMapper.toSetDto(users);
    }

    public UserDTO findUserById(Long userId){
        Optional<User> existingUser = userRepo.findById(userId);
        if (!existingUser.isPresent()) {
            throw new CustomException(HttpStatus.NOT_FOUND,"User with id: "+userId+" not found");
        }
        User userEntity = existingUser.get();
        UserDTO updatedUserDto = UserMapper.toDto(userEntity);
        return  updatedUserDto;
    }

    public void deleteUser(Long userId){
        Optional<User> existingUser = userRepo.findById(userId);
        if (!existingUser.isPresent()) {
            throw new CustomException(HttpStatus.NOT_FOUND,"User with id: "+userId+" not found");
        }
        userRepo.deleteUserById(userId);
    }

}

