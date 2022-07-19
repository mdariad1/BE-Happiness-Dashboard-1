package com.ibm.ro.tm.apprenticeship.poll.metter.service;

import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Answer;
import com.ibm.ro.tm.apprenticeship.poll.metter.exception. AnswerNotFoundException;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class AnswerService {
    private final AnswerRepository answerRepo;

    @Autowired
    public AnswerService(AnswerRepository answerRepo){
        this.answerRepo = answerRepo;
    }

    public Answer addAnswer(Answer answer){ return answerRepo.save(answer); }
    public List<Answer> findAllAnswers(){
        return answerRepo.findAll();
    }
    public Answer updateAnswer(Answer answer){
        return answerRepo.save(answer);
    }

    public Answer findAnswerById(Long id){
        return answerRepo.findAnswerById(id).orElseThrow(() -> new AnswerNotFoundException("Answer by id"  + id + "not found"));
    }

    public void deleteAnswer(Long id){
        answerRepo.deleteAnswerById(id);
    }


}
