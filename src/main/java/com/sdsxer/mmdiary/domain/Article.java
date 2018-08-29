package com.sdsxer.mmdiary.domain;

import com.sdsxer.mmdiary.domain.base.IdEntity;
import com.sdsxer.mmdiary.domain.common.Comment;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@MappedSuperclass
public abstract class Article extends IdEntity {

    enum Classify {
        NEWS,
        STORY,
        PERIODICAL,
        OTHER
    }

    enum Status {
        UNDER_REVIEW,
        APPROVED
    }

    protected String title;
    protected String summary;
    protected String content;
    protected String snapshot;
    protected Date publishTime;
    protected Date lastModifyTime;
    protected String source;
    @ManyToOne
    protected User author;
    @ManyToOne
    protected User editor;
    @OneToMany
    protected List<Comment> comments;
    protected int classify;
    protected int status;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public User getEditor() {
        return editor;
    }

    public void setEditor(User editor) {
        this.editor = editor;
    }

    public String getSnapshot() {
        return snapshot;
    }

    public void setSnapshot(String snapshot) {
        this.snapshot = snapshot;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public int getClassify() {
        return classify;
    }

    public void setClassify(int classify) {
        this.classify = classify;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
