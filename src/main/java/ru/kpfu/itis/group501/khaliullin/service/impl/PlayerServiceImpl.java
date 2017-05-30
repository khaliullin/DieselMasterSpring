package ru.kpfu.itis.group501.khaliullin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.group501.khaliullin.model.Player;
import ru.kpfu.itis.group501.khaliullin.model.Team;
import ru.kpfu.itis.group501.khaliullin.repository.PlayerRepository;
import ru.kpfu.itis.group501.khaliullin.repository.TeamRepository;
import ru.kpfu.itis.group501.khaliullin.service.PlayerService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20170527
 */
@Service
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    @Override
    public List<Player> getTopTenPlayers(Long id) {
        Pageable pageable = new PageRequest(0, 10, Sort.Direction.DESC, "goals");
        List<Player> players = playerRepository.getAllByTeamId(id, pageable);
        List<Player> sortedPlayers = new ArrayList<>(players);

        for (Player p : sortedPlayers) {
            p.setPoints(p.getAssists() + p.getGoals() * 2);
        }

        Collections.sort(sortedPlayers, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return o2.getPoints() - o1.getPoints();
            }
        });

        return sortedPlayers;
    }

    @Override
    public List<Player> getAllByTeamAndName(Long id, String name) {
        Team team = teamRepository.findOne(id);
        List<Player> players = playerRepository.getAllByTeamAndFirstNameAndLastName(team, name.toLowerCase());
        return players;
    }

    @Override
    public List<Player> getAllByTeamAndNameAndPosition(Long id, String name, Character position) {
        Team team = teamRepository.findOne(id);
        List<Player> players = playerRepository.getAllByTeamAndFirstNameAndLastNameAndPosition(team, name.toLowerCase(), position);
        return players;
    }

    @Override
    public Player getPlayer(Long id) {
        return playerRepository.findOne(id);
    }
}
