package ru.kpfu.itis.group501.khaliullin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.itis.group501.khaliullin.model.Match;
import ru.kpfu.itis.group501.khaliullin.service.MatchService;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20170522
 */
@Controller
public class MatchesController {
    private final Pattern pattern = Pattern.compile("^\\S+$");
    private final MatchService matchService;

    @Autowired
    public MatchesController(MatchService matchService) {
        this.matchService = matchService;
    }

    @RequestMapping(value = "/played/{page}")
    public String playedMatchesPage(@PathVariable(name = "page") int pageNumber, Model model) {
        List<Match> playedMatches = matchService.getPlayedMatches(1L, pageNumber);
        int maxPageNumber = matchService.getMaxPageNumberByTeamIdAndPlayed(1L, true);

        if (SecurityContextHolder.getContext().getAuthentication().getAuthorities()
                .contains(new SimpleGrantedAuthority("ROLE_ADMIN")))
            model.addAttribute("admin", true);

        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        if (!userName.equals("anonymousUser"))
            model.addAttribute("logined", true);

        model.addAttribute("playedMatches", playedMatches);
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("maxPageNumber", maxPageNumber);

        return "played";
    }

    @RequestMapping(value = "/future/{page}")
    public String futureMatchesPagePage(@PathVariable(name = "page") int pageNumber, Model model) {
        List<Match> futureMatches = matchService.getFutureMatches(1L, pageNumber);
        int maxPageNumber = matchService.getMaxPageNumberByTeamIdAndPlayed(1L, false);

        if (SecurityContextHolder.getContext().getAuthentication().getAuthorities()
                .contains(new SimpleGrantedAuthority("ROLE_ADMIN")))
            model.addAttribute("admin", true);

        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        if (!userName.equals("anonymousUser"))
            model.addAttribute("logined", true);

        model.addAttribute("futureMatches", futureMatches);
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("maxPageNumber", maxPageNumber);

        return "future";
    }
}
