package ru.kpfu.itis.group501.khaliullin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.group501.khaliullin.model.Team;
import ru.kpfu.itis.group501.khaliullin.service.TeamService;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20170518
 */
@Controller
public class TeamController {
//    private final Pattern pattern = Pattern.compile("^\\S+$");
    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @RequestMapping(value = "/teams/{id}", method = RequestMethod.GET)
    public String allLaboratories(@PathVariable("id") Long id, Model model) {
        Team team = teamService.get(id);
        model.addAttribute("team", team);

        if (SecurityContextHolder.getContext().getAuthentication().getAuthorities()
                .contains(new SimpleGrantedAuthority("ROLE_ADMIN")))
            model.addAttribute("admin", true);

        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        if (!userName.equals("anonymousUser"))
            model.addAttribute("logined", true);
        return "team";
    }
}
