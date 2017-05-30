package ru.kpfu.itis.group501.khaliullin.model;


import javax.persistence.*;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20170522
 */
@Entity
@Table(name = "statuses")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    public String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Status() {
    }

    public Status(String name) {
        this.name = name;
    }
}
