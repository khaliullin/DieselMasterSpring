package ru.kpfu.itis.group501.khaliullin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.group501.khaliullin.model.Team;
import ru.kpfu.itis.group501.khaliullin.repository.MatchRepository;
import ru.kpfu.itis.group501.khaliullin.repository.TeamRepository;
import ru.kpfu.itis.group501.khaliullin.service.TeamService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20170518
 */
@Service
public class TeamServiceImpl implements TeamService{
    private final TeamRepository teamRepository;
    private final MatchRepository matchRepository;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository, MatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }

    @Override
    public Team get(Long id) {
        return teamRepository.findOne(id);
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public List<Team> getTopTen() {
        Pageable pageable = new PageRequest(0, 10, Sort.Direction.DESC, "position");
        Page<Team> page = teamRepository.findAll(pageable);
        List<Team> teams = page.getContent();

        for (Team team : teams) {
            team.setGames(matchRepository.countGames(team.getId()));
            team.setPoints(matchRepository.countWins(team.getId()));
        }

        List<Team> sortedTeams = new ArrayList<>(teams);

        Collections.sort(sortedTeams, new Comparator<Team>() {
            @Override
            public int compare(Team o1, Team o2) {
                return o1.getGames() - o2.getGames();
            }
        });

        Collections.sort(sortedTeams, new Comparator<Team>() {
            @Override
            public int compare(Team o1, Team o2) {
                return o2.getPoints() - o1.getPoints();
            }
        });

        return sortedTeams;
    }
}
