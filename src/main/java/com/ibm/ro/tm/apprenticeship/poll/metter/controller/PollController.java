package com.ibm.ro.tm.apprenticeship.poll.metter.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Poll;
import com.ibm.ro.tm.apprenticeship.poll.metter.service.PollService;

@RestController
@RequestMapping("/polls")
public class PollController {

    private final PollService pollService;

    public PollController(PollService pollService) {
        this.pollService = pollService;
    }

    @GetMapping("")
    public ResponseEntity<List<Poll>> getAllPolls () {
        List<Poll> polls = pollService.findAllPolls();
        return new ResponseEntity<>(polls, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Poll> getPollById (@PathVariable("id") Long id) {
        Poll employee = pollService.findPollById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Poll> addPoll(@RequestBody Poll poll) {
        Poll newPoll = pollService.addPoll(poll);
        return new ResponseEntity<>(newPoll, HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<Poll> updatePoll(@RequestBody Poll poll) {
        Poll updatePoll = pollService.updatePoll(poll);
        return new ResponseEntity<>(updatePoll, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePoll(@PathVariable("id") Long id) {
        pollService.deletePoll(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
