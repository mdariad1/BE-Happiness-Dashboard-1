package com.ibm.ro.tm.apprenticeship.poll.metter.repository;

import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Poll;
import com.ibm.ro.tm.apprenticeship.poll.metter.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Answer;



import java.util.Optional;
import java.util.Set;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    void deleteAnswerById(Long id);

    Optional<Answer> findAnswerById(Long id);

    Set<Answer> findAnswersByPoll(Poll pollEntity);

    Set<Answer> findAnswersByUser(User userEntity);
}
