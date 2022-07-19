package com.ibm.ro.tm.apprenticeship.poll.metter.service;

import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Poll;
import com.ibm.ro.tm.apprenticeship.poll.metter.exception.PollNotFoundException;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class PollService {
    private final PollRepository pollRepo;

    @Autowired
    public PollService(PollRepository pollRepo){
        this.pollRepo = pollRepo;
    }

    public Poll addPoll(Poll poll){ return pollRepo.save(poll); }
    public List<Poll> findAllPolls(){
        return pollRepo.findAll();
    }
    public Poll updatePoll(Poll poll){
        return pollRepo.save(poll);
    }

    public Poll findPollById(Long id){
        return pollRepo.findPollById(id).orElseThrow(() -> new PollNotFoundException("Poll by id"  + id + "not found"));
    }

    public void deletePoll(Long id){
        pollRepo.deletePollById(id);
    }


}
