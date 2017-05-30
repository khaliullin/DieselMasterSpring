package ru.kpfu.itis.group501.khaliullin.model;

import javax.persistence.*;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20170521
 */
@Entity
@Table(name = "photos")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @ManyToOne(targetEntity = Match.class)
    public Match match;

    public String name;

    public long getId() {
        return id;
    }

    public Match getMatch() {
        return match;
    }

    public String getName() {
        return name;
    }
}
