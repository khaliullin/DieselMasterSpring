package ru.kpfu.itis.group501.khaliullin.service;

import ru.kpfu.itis.group501.khaliullin.model.Player;

import java.util.List;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20170527
 */
public interface PlayerService {
    List<Player> getTopTenPlayers(Long id);
    List<Player> getAllByTeamAndName(Long id, String name);
    List<Player> getAllByTeamAndNameAndPosition(Long id, String name, Character position);
    Player getPlayer(Long id);
}
