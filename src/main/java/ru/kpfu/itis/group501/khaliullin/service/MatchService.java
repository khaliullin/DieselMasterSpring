package ru.kpfu.itis.group501.khaliullin.service;

import ru.kpfu.itis.group501.khaliullin.model.Match;

import java.util.List;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20170522
 */
public interface MatchService {

    List<Match> getPlayedMatches(Long id);

    List<Match> getPlayedMatches(Long id, int pageNumber);

    List<Match> getFutureMatches(Long id);

    List<Match> getFutureMatches(Long id, int pageNumber);

    int getMaxPageNumberByTeamIdAndPlayed(Long id, boolean played);

    void save(Match match);

}
