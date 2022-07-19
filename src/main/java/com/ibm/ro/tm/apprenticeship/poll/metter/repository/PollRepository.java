package com.ibm.ro.tm.apprenticeship.poll.metter.repository;

import com.ibm.ro.tm.apprenticeship.poll.metter.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Poll;

import java.util.Optional;

public interface PollRepository extends JpaRepository<Poll, Long>  {
    void deletePollById(Long id);
    Optional<Poll> findPollById(Long id);
}
