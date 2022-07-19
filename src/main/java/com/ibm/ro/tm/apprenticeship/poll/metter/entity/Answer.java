package com.ibm.ro.tm.apprenticeship.poll.metter.entity;

import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.*;

import org.hibernate.annotations.SortNatural;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author O09860826
 *
 */
@Entity
public class Answer implements Comparable<Answer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String content;

    @Column
    private Integer rating;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "poll_id", referencedColumnName = "id")
    private Poll poll;

    protected Answer() {

    }

    public Answer(String content) {
        this.content = content;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @return the rating
     */
    public Integer getRating() {
        return rating;
    }

    /**
     * @return the pollID
     */

    public Long getPoll() {
        return poll.getId();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "(" + this.id + ", " + this.content + ")";
    }

    @Override
    public int compareTo(Answer o) {
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
