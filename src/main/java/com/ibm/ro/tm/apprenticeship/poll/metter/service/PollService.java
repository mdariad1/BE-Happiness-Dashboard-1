package com.ibm.ro.tm.apprenticeship.poll.metter.service;

import com.ibm.ro.tm.apprenticeship.poll.metter.dto.PollDTO;
import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Poll;
import com.ibm.ro.tm.apprenticeship.poll.metter.entity.User;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.AnswerRepository;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.PollRepository;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.UserRepository;
import mapper.PollMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.ibm.ro.tm.apprenticeship.poll.metter.exception.CustomException;


import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class PollService {

    private PollRepository pollRepo;
    private UserRepository userRepo;

    @Autowired
    public PollService( PollRepository pollRepo,UserRepository userRepo) {
        this.pollRepo = pollRepo;
        this.userRepo = userRepo;
    }


    public PollDTO addPoll(PollDTO pollDto){
        Poll poll = PollMapper.toEntity(pollDto);
        Poll savedPoll = pollRepo.save(poll);
        return PollMapper.toDto(savedPoll);
    }
    public Set<PollDTO> findAllPolls(){
        Set<Poll> polls = new HashSet<Poll>(pollRepo.findAll());
        return PollMapper.toSetDto(polls);
    }
    public PollDTO updatePoll(PollDTO pollDto){
        Poll updatedEntityPoll = PollMapper.toEntity(pollDto);
        updatedEntityPoll = pollRepo.save(updatedEntityPoll);
        return PollMapper.toDto(updatedEntityPoll);
    }

    public PollDTO findPollById(Long pollId){
        Optional<Poll> existingPoll = pollRepo.findById(pollId);
        if (!existingPoll.isPresent()) {
            throw new CustomException(HttpStatus.NOT_FOUND,"User with id: "+pollId+" not found");
        }
        Poll pollEntity = existingPoll.get();
        return PollMapper.toDto(pollEntity);
    }

    public Set<PollDTO> findPollsByUserId(Long userId){
        Optional<User> existingUser = userRepo.findById(userId);
        if (!existingUser.isPresent()) {
            throw new CustomException(HttpStatus.NOT_FOUND,"User with id: "+userId+" not found");
        }
        User userEntity = existingUser.get();
        Set<Poll> pollEntities = pollRepo.findPollsByUser(userEntity);
        return PollMapper.toSetDto(pollEntities);
    }

    public void deletePoll(Long pollId){
        Optional<Poll> existingPoll = pollRepo.findById(pollId);
        if (!existingPoll.isPresent()) {
            throw new CustomException(HttpStatus.NOT_FOUND,"User with id: "+pollId+" not found");
        }
        pollRepo.deletePollById(pollId);
    }


}
