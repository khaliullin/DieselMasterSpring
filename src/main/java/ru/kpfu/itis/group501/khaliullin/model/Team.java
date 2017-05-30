package ru.kpfu.itis.group501.khaliullin.model;

import javax.persistence.*;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20170419
 */

@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String city;

    @Column
    private Integer position;

    @Transient
    private Integer games;

    @Transient
    private Integer points;

    public Team() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public Integer getPosition() {
        return position;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public void setGames(Integer games) {
        this.games = games;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getGames() {
        return games;
    }

    public Integer getPoints() {
        return points;
    }
}
