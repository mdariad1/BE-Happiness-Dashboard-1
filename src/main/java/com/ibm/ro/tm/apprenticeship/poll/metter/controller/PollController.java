package com.ibm.ro.tm.apprenticeship.poll.metter.controller;

import java.util.List;
import java.util.Set;


import com.ibm.ro.tm.apprenticeship.poll.metter.dto.PollDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Poll;
import com.ibm.ro.tm.apprenticeship.poll.metter.service.PollService;

@RestController
@RequestMapping("/polls")
public class PollController {


    private final PollService pollService;
    @Autowired
    public PollController(PollService pollService) {
        this.pollService = pollService;
    }

    @GetMapping("")
    public ResponseEntity<Set<PollDTO>> getAllPolls () {
        Set<PollDTO> pollDTOS = pollService.findAllPolls();
        return new ResponseEntity<>(pollDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PollDTO> getPollById (@PathVariable("id") Long id) {
        PollDTO pollDTO = pollService.findPollById(id);
        return new ResponseEntity<>(pollDTO, HttpStatus.OK);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<Set<PollDTO>> getPollsByUserId (@PathVariable("id") Long id) {
        Set<PollDTO> pollDTOS = pollService.findPollsByUserId(id);
        return new ResponseEntity<>(pollDTOS, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<PollDTO> addPoll(@RequestBody PollDTO pollDTO) {
        PollDTO newPoll = pollService.addPoll(pollDTO);
        return new ResponseEntity<>(newPoll, HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<PollDTO> updatePoll(@RequestBody PollDTO pollDTO) {
        PollDTO updatedPoll = pollService.updatePoll(pollDTO);
        return new ResponseEntity<>(updatedPoll, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePoll(@PathVariable("id") Long id) {
        pollService.deletePoll(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
