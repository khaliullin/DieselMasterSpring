package ru.kpfu.itis.group501.khaliullin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.group501.khaliullin.model.Match;
import ru.kpfu.itis.group501.khaliullin.repository.MatchRepository;
import ru.kpfu.itis.group501.khaliullin.repository.TeamRepository;
import ru.kpfu.itis.group501.khaliullin.service.MatchService;

import java.util.List;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20170522
 */
@Service
public class MatchServiceImpl implements MatchService {
    private final MatchRepository matchRepository;
    private final TeamRepository teamRepository;

    private int pageSize = 3;

    @Autowired
    public MatchServiceImpl(MatchRepository matchRepository, TeamRepository teamRepository) {
        this.matchRepository = matchRepository;
        this.teamRepository = teamRepository;
    }

    @Override
    public List<Match> getPlayedMatches(Long id) {
        Pageable pageable = new PageRequest(0, 3, Sort.Direction.ASC, "date");
        List<Match> matches = matchRepository.getAllPlayed(id, pageable);
        for (Match match : matches) {
            match.setFirstTeamName(teamRepository.findOne(match.getFirstTeam().getId()).getName());
            match.setSecondTeamName(teamRepository.findOne(match.getSecondTeam().getId()).getName());
        }
        return matches;
    }

    @Override
    public List<Match> getPlayedMatches(Long id, int pageNumber) {
        Pageable pageable = new PageRequest(pageNumber, pageSize, Sort.Direction.ASC, "date");
        List<Match> matches = matchRepository.getAllPlayed(id, pageable);
        for (Match match : matches) {
            match.setFirstTeamName(teamRepository.findOne(match.getFirstTeam().getId()).getName());
            match.setSecondTeamName(teamRepository.findOne(match.getSecondTeam().getId()).getName());
        }
        return matches;
    }

    @Override
    public List<Match> getFutureMatches(Long id) {
        Pageable pageable = new PageRequest(0, 3, Sort.Direction.ASC, "date");
        List<Match> matches = matchRepository.getAllFuture(id, pageable);
        for (Match match : matches) {
            match.setFirstTeamName(teamRepository.findOne(match.getFirstTeam().getId()).getName());
            match.setSecondTeamName(teamRepository.findOne(match.getSecondTeam().getId()).getName());
        }
        return matches;
    }

    @Override
    public List<Match> getFutureMatches(Long id, int pageNumber) {
        Pageable pageable = new PageRequest(pageNumber, pageSize, Sort.Direction.ASC, "date");
        List<Match> matches = matchRepository.getAllFuture(id, pageable);
        for (Match match : matches) {
            match.setFirstTeamName(teamRepository.findOne(match.getFirstTeam().getId()).getName());
            match.setSecondTeamName(teamRepository.findOne(match.getSecondTeam().getId()).getName());
        }
        return matches;
    }

    @Override
    public int getMaxPageNumberByTeamIdAndPlayed(Long id, boolean played) {
        int totalMatches = matchRepository.countByTeamAndPlayed(id, played);
        return totalMatches/pageSize - 1;
    }

    @Override
    public void save(Match match) {
        matchRepository.save(match);
    }
}
