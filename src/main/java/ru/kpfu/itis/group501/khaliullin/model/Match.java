package ru.kpfu.itis.group501.khaliullin.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20170419
 */
@Entity
@Table(name = "matches")
public class Match {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Team.class)
    @JoinColumn(name = "first_team_id")
    private Team firstTeam;

    @ManyToOne(targetEntity = Team.class)
    @JoinColumn(name = "second_team_id", referencedColumnName = "id")
    private Team secondTeam;

    private Date date;

    private boolean played;

    @Column(name = "first_team_score")
    private int firstTeamScore;

    @Transient
    @Column(name = "first_team_name")
    private String firstTeamName;

    @Transient
    @Column(name = "second_team_name")
    private String secondTeamName;

    @Column(name = "second_team_score")
    private int secondTeamScore;

    private String stadium;

    @Column(name = "about_goals")
    private String aboutGoals;

    public Match(Team firstTeam, Team secondTeam, Date date, boolean played, int firstTeamScore, int secondTeamScore, String stadium, String aboutGoals) {
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
        this.date = date;
        this.played = played;
        this.firstTeamScore = firstTeamScore;
        this.secondTeamScore = secondTeamScore;
        this.stadium = stadium;
        this.aboutGoals = aboutGoals;
    }

    public Match(Team firstTeam, Team secondTeam, Date date, boolean played, String stadium) {
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
        this.date = date;
        this.played = played;
        this.stadium = stadium;
    }

    public Match() {
    }

    public Long getId() {
        return id;
    }

    public Team getFirstTeam() {
        return firstTeam;
    }

    public Team getSecondTeam() {
        return secondTeam;
    }

    public Date getDate() {
        return date;
    }

    public boolean isPlayed() {
        return played;
    }

    public int getFirstTeamScore() {
        return firstTeamScore;
    }

    public int getSecondTeamScore() {
        return secondTeamScore;
    }

    public String getStadium() {
        return stadium;
    }

    public String getAboutGoals() {
        return aboutGoals;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstTeam(Team firstTeam) {
        this.firstTeam = firstTeam;
    }

    public void setSecondTeam(Team secondTeam) {
        this.secondTeam = secondTeam;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPlayed(boolean played) {
        this.played = played;
    }

    public void setFirstTeamScore(int firstTeamScore) {
        this.firstTeamScore = firstTeamScore;
    }

    public String getFirstTeamName() {
        return firstTeamName;
    }

    public void setFirstTeamName(String firstTeamName) {
        this.firstTeamName = firstTeamName;
    }

    public String getSecondTeamName() {
        return secondTeamName;
    }

    public void setSecondTeamName(String secondTeamName) {
        this.secondTeamName = secondTeamName;
    }

    public void setSecondTeamScore(int secondTeamScore) {
        this.secondTeamScore = secondTeamScore;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public void setAboutGoals(String aboutGoals) {
        this.aboutGoals = aboutGoals;
    }
}

