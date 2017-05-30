package ru.kpfu.itis.group501.khaliullin.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20170521
 */
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @ManyToOne(targetEntity = Discussion.class)
    private Discussion discussion;

    @ManyToOne(targetEntity = User.class)
    private User user;

    private String content;

    private Date created;

    public Message(Discussion discussion, User user, String content, Date created) {
        this.discussion = discussion;
        this.user = user;
        this.content = content;
        this.created = created;
    }

    public Message() {
    }

    public long getId() {
        return id;
    }

    public Discussion getDiscussion() {
        return discussion;
    }

    public User getUser() {
        return user;
    }

    public String getContent() {
        return content;
    }

    public Date getCreated() {
        return created;
    }
}
