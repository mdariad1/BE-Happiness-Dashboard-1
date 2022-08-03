package com.ibm.ro.tm.apprenticeship.poll.metter.controller;

import com.ibm.ro.tm.apprenticeship.poll.metter.dto.AnswerDTO;
import com.ibm.ro.tm.apprenticeship.poll.metter.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Answer;



import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/answers")
public class AnswerController {


    private final AnswerService answerService;
    @Autowired
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping("/poll/{id}")
    public ResponseEntity<Set<AnswerDTO>> getAnswersByPollId (@PathVariable("id") Long id) {
        Set<AnswerDTO> answers = answerService.findAnswersByPollId(id);
        return new ResponseEntity<>(answers, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Set<AnswerDTO>> getAnswersByUserId (@PathVariable("id") Long id) {
        Set<AnswerDTO> answers = answerService.findAnswersByUserId(id);
        return new ResponseEntity<>(answers, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<AnswerDTO> addAnswer(@RequestBody AnswerDTO answerDTO) {
        AnswerDTO newAnswer = answerService.addAnswer(answerDTO);
        return new ResponseEntity<>(newAnswer, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAnswer(@PathVariable("id") Long id) {
        answerService.deleteAnswer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
