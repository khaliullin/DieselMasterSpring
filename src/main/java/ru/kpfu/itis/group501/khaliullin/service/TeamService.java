package ru.kpfu.itis.group501.khaliullin.service;

import ru.kpfu.itis.group501.khaliullin.model.Team;

import java.util.List;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20170518
 */
public interface TeamService {
    Team get(Long id);

    List<Team> getAllTeams();


    List<Team> getTopTen();
}
