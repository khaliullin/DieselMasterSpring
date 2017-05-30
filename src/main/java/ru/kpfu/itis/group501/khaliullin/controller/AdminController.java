package ru.kpfu.itis.group501.khaliullin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.group501.khaliullin.model.Match;
import ru.kpfu.itis.group501.khaliullin.model.Team;
import ru.kpfu.itis.group501.khaliullin.service.MatchService;
import ru.kpfu.itis.group501.khaliullin.service.PlayerService;
import ru.kpfu.itis.group501.khaliullin.service.TeamService;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20170529
 */
@Controller
public class AdminController {
    private final Pattern pattern = Pattern.compile("^\\S+$");
    private final MatchService matchService;
    private final TeamService teamService;
    private final PlayerService playerService;

    @Autowired
    public AdminController(MatchService matchService, TeamService teamService, PlayerService playerService) {
        this.matchService = matchService;
        this.teamService = teamService;
        this.playerService = playerService;
    }

    @RequestMapping(value = "/add_match", method = RequestMethod.POST)
    public String addMatch(@RequestParam(name = "first_team_id", required = true) Long firstTeamId,
                           @RequestParam(name = "second_team_id", required = true) Long secondTeamId,
                           @RequestParam(name = "date", required = false) String dateInString,
                           @RequestParam(name = "stadium", required = true) String stadium,
                           @RequestParam(name = "played", required = false, defaultValue = "false") boolean played,
                           @RequestParam(name = "first_team_score", required = false) int firstTeamScore,
                           @RequestParam(name = "second_team_score", required = false) int secondTeamScore,
                           @RequestParam(name = "about", required = false) String about,
                           HttpServletRequest request) {

        dateInString += ":00Z";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        Date date = new Date();
        try {
            date = formatter.parse(dateInString.replaceAll("Z$", "+0000"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (firstTeamId != null && secondTeamId != null && date != null && stadium != null && !stadium.equals("")) {
            Team team1 = teamService.get(firstTeamId);
            Team team2 = teamService.get(secondTeamId);

            Match match;
            if (played && (firstTeamScore > 0 || secondTeamScore > 0)) {
                match = new Match(team1, team2, date, played, firstTeamScore, secondTeamScore, stadium, about);
            }
            else {
                match = new Match(team1, team2, date, played, stadium);
            }

            matchService.save(match);
        }

        return "redirect:admin";
    }

    @RequestMapping(value = "/admin")
    public String adminPlayers(Model model) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        if (!userName.equals("anonymousUser"))
            model.addAttribute("logined", true);

        model.addAttribute("teams", teamService.getAllTeams());
        return "adminPage";
    }
}

