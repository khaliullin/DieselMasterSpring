package ru.kpfu.itis.group501.khaliullin.model;

import javax.persistence.*;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20170419
 */

@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @ManyToOne(targetEntity = Team.class)
    private Team team;

    private String birthDate;

    private char position;

    private char grip;

    private byte number;

    private int games;

    private int goals;

    private int assists;

    @Transient
    private int points;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Team getTeam() {
        return team;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public char getPosition() {
        return position;
    }

    public char getGrip() {
        return grip;
    }

    public byte getNumber() {
        return number;
    }

    public int getGames() {
        return games;
    }

    public int getGoals() {
        return goals;
    }

    public int getAssists() {
        return assists;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}



