package com.ibm.ro.tm.apprenticeship.poll.metter.service;

import com.ibm.ro.tm.apprenticeship.poll.metter.dto.AnswerDTO;
import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Answer;
import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Poll;
import com.ibm.ro.tm.apprenticeship.poll.metter.entity.User;
import com.ibm.ro.tm.apprenticeship.poll.metter.exception.CustomException;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.AnswerRepository;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.PollRepository;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.UserRepository;
import mapper.AnswerMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class AnswerService {

    private  AnswerRepository answerRepo;

    private  PollRepository pollRepo;

    private UserRepository userRepo;

    @Autowired
    public AnswerService(AnswerRepository answerRepo,PollRepository pollRepo,UserRepository userRepo) {
        this.answerRepo = answerRepo;
        this.pollRepo = pollRepo;
        this.userRepo = userRepo;
    }


    public Set<AnswerDTO> findAnswersByPollId(Long id){
        Optional<Poll> existingPoll = pollRepo.findPollById(id);
        if (!existingPoll.isPresent()) {
            throw new CustomException(HttpStatus.NOT_FOUND,"User with id: "+id+" not found");
        }
        Poll pollEntity = existingPoll.get();
        Set<Answer> answerEntities = answerRepo.findAnswersByPoll(pollEntity);
        return AnswerMapper.toSetDto(answerEntities);
    }

    public Set<AnswerDTO> findAnswersByUserId(Long id){
        Optional<User> existingUser = userRepo.findById(id);
        if (!existingUser.isPresent()) {
            throw new CustomException(HttpStatus.NOT_FOUND,"User with id: "+id+" not found");
        }
        User userEntity = existingUser.get();
        Set<Answer> answerEntities = answerRepo.findAnswersByUser(userEntity);
        return AnswerMapper.toSetDto(answerEntities);
    }

    public AnswerDTO addAnswer(AnswerDTO answerDto){
        Answer answer = AnswerMapper.toEntity(answerDto);
        Answer savedAnswer = answerRepo.save(answer);
        return AnswerMapper.toDto(savedAnswer);
    }

    public AnswerDTO findAnswerById(Long id){
        Optional<Answer> existingAnswer = answerRepo.findAnswerById(id);
        if (!existingAnswer.isPresent()) {
            throw new CustomException(HttpStatus.NOT_FOUND,"User with id: "+id+" not found");
        }
        Answer answerEntity = existingAnswer.get();
        return AnswerMapper.toDto(answerEntity);
    }

    public void deleteAnswer(Long id){
        Optional<Answer> existingAnswer = answerRepo.findById(id);
        if (!existingAnswer.isPresent()) {
            throw new CustomException(HttpStatus.NOT_FOUND,"User with id: "+id+" not found");
        }
        answerRepo.deleteAnswerById(id);
    }


}
