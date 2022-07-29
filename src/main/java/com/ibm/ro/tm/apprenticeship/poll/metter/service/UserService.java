package com.ibm.ro.tm.apprenticeship.poll.metter.service;

import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Answer;
import com.ibm.ro.tm.apprenticeship.poll.metter.entity.User;
import com.ibm.ro.tm.apprenticeship.poll.metter.exception.AnswerNotFoundException;
import com.ibm.ro.tm.apprenticeship.poll.metter.exception.UserNotFoundException;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo){
        this.userRepo = userRepo;
    }

    public User addUser(User user){
        return userRepo.save(user);
    }
    public List<User> findAllUsers(){
        return userRepo.findAll();
    }

    public User updateUser(User newuser){
        return userRepo.save(newuser);
    }


    public User findUserById(Long id){
        return userRepo.findUserById(id).orElseThrow(() -> new UserNotFoundException("User with this id not found"));
    }
    /*
    @ExceptionHandler({ UserNotFoundException.class})
    public User getUserById(Long id){
        return userRepo.getById(id);
    }*/
    public void deleteUser(Long id){
        User searched = findUserById(id);
        userRepo.deleteUserById(id);
    }



}

