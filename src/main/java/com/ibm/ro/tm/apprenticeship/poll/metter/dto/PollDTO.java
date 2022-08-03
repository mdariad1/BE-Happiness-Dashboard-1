package com.ibm.ro.tm.apprenticeship.poll.metter.dto;

import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Answer;

import java.util.Set;

public class PollDTO {
    private Long id;
    private Long userId;
    private String topic;

    public PollDTO() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }


    public String getTopic() {
        return topic;
    }
    public void setTopic(String topic) {
        this.topic = topic;
    }



}
