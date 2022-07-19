package com.ibm.ro.tm.apprenticeship.poll.metter.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Answer;

import java.util.Optional;


public interface AnswerRepository extends JpaRepository<Answer, Long> {
    void deleteAnswerById(Long id);

    Optional<Answer> findAnswerById(Long id);
}
