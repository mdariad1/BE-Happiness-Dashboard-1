package com.ibm.ro.tm.apprenticeship.poll.metter.entity;

import javax.persistence.*;


@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String content;

    @Column
    private Integer rating;

    @ManyToOne()
    @JoinColumn(name = "poll_id", referencedColumnName = "id")
    private Poll poll;

    @ManyToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user ;

    public Answer() {
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content){
        this.content = content;
    }

    public Integer getRating() {
        return rating;
    }
    public void setRating(Integer rating){
        this.rating = rating;
    }

    public Poll getPoll() {
        return poll;
    }
    public void setPoll(Poll poll){
        this.poll = poll;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user){
        this.user = user;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "(" + this.id + ", " + this.content + ")";
    }

}
