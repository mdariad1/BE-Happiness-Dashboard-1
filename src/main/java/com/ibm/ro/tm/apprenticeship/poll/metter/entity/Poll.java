package com.ibm.ro.tm.apprenticeship.poll.metter.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.SortNatural;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author O09860826
 *
 */

@Entity
public class Poll implements Comparable<Poll> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String topic;

    @JsonIgnore
    @OneToMany(mappedBy = "poll")
    private Set<Answer> answers = new HashSet<>();

    protected Poll() {
    }

    public Poll(String topic) {
        this.topic = topic;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the topic
     */
    public String getTopic() {
        return topic;
    }

    /**
     * @return the roles
     */

    public Set<Answer> getAnswers() {
        return answers;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "(" + this.id + ", " + this.topic + ")";
    }

    @Override
    public int compareTo(Poll o) {
        int result = 0;
        if (o != null) {
            if (id != null) {
                result = id.compareTo(o.getId());
            } else if (o.getId() != null) {
                result = 1;
            }else {
                result = 0;
            }
        } else {
            result = -1;
        }
        return result;
    }
}
