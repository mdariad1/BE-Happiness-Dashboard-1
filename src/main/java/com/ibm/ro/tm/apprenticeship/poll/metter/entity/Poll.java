package com.ibm.ro.tm.apprenticeship.poll.metter.entity;


import java.util.Optional;
import java.util.Set;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String topic;

    @JsonIgnore
    @OneToMany(mappedBy = "poll",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Answer> answers;

    @ManyToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Poll() {
    }

    public Long getId() {
        return id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "(" + this.id + ", " + this.topic + ")";
    }
}

