package ru.kpfu.itis.group501.khaliullin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.itis.group501.khaliullin.model.Match;
import ru.kpfu.itis.group501.khaliullin.model.Player;
import ru.kpfu.itis.group501.khaliullin.model.Team;
import ru.kpfu.itis.group501.khaliullin.service.MatchService;
import ru.kpfu.itis.group501.khaliullin.service.PlayerService;
import ru.kpfu.itis.group501.khaliullin.service.TeamService;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20170518
 */
@Controller
public class MainController {
    private final Pattern pattern = Pattern.compile("^\\S+$");
    private final MatchService matchService;
    private final TeamService teamService;
    private final PlayerService playerService;

    @Autowired
    public MainController(MatchService matchService, TeamService teamService, PlayerService playerService) {
        this.matchService = matchService;
        this.teamService = teamService;
        this.playerService = playerService;
    }

    @RequestMapping(value = "/")
    public String homePage(Model model) {
        List<Match> playedMatches = matchService.getPlayedMatches(1L);
        List<Match> futureMatches = matchService.getFutureMatches(1L);
        List<Team> topTeams = teamService.getTopTen();
        List<Player> topPlayers = playerService.getTopTenPlayers(1L);

        model.addAttribute("playedMatches", playedMatches);
        model.addAttribute("futureMatches", futureMatches);
        model.addAttribute("topTeams", topTeams);
        model.addAttribute("topPlayers", topPlayers);

        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        if (SecurityContextHolder.getContext().getAuthentication().getAuthorities()
                .contains(new SimpleGrantedAuthority("ROLE_ADMIN")))
            model.addAttribute("admin", true);

        System.out.println();
        if (!userName.equals("anonymousUser"))
            model.addAttribute("logined", true);
        
        return "main";
    }

}
