package ru.kpfu.itis.group501.khaliullin.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20170521
 */
@Table(name = "discussions")
@Entity
public class Discussion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "author_id")
    private User author;

    private String name;

    private String content;

    private Date created;

    public Long getId() {
        return id;
    }

    public User getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public Date getCreated() {
        return created;
    }

    public Discussion(User author, String name, String content, Date created) {
        this.author = author;
        this.name = name;
        this.content = content;
        this.created = created;
    }

//    public Discussion(User author, String name, String content) {
//        this.author = author;
//        this.name = name;
//        this.content = content;
//    }

    public Discussion() {
    }
}