package com.sdsxer.mmdiary.domain.common;

import com.sdsxer.mmdiary.domain.base.IdEntity;
import com.sdsxer.mmdiary.domain.User;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Comment extends IdEntity {

    private String content;
    @ManyToOne
    private User user;
    private Date publishTime;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }
}
