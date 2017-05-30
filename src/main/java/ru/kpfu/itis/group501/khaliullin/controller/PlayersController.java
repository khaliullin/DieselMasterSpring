package ru.kpfu.itis.group501.khaliullin.controller;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.itis.group501.khaliullin.model.Player;
import ru.kpfu.itis.group501.khaliullin.service.PlayerService;

import java.util.List;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20170522
 */
@Controller
public class PlayersController {
    private final PlayerService playerService;

    public PlayersController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @RequestMapping(value = "/players")
    public String playersPage(Model model) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        if (!userName.equals("anonymousUser"))
            model.addAttribute("logined", true);

        if (SecurityContextHolder.getContext().getAuthentication().getAuthorities()
                .contains(new SimpleGrantedAuthority("ROLE_ADMIN")))
            model.addAttribute("admin", true);
        return "playersList";
    }

    @ResponseBody
    @RequestMapping(value = "/search")
    public List<Player> playersSearch(@RequestParam(value = "name", required = false) String name,
                                      @RequestParam(value = "position", required = false) Character position) {
        if (!(position == 'A'))
            return playerService.getAllByTeamAndNameAndPosition(1L, name, position);
        else
            return playerService.getAllByTeamAndName(1L, name);
    }

    @RequestMapping(value = "/player/{id}")
    public String playerPage(@PathVariable(name = "id") Long id, Model model) {

        if (SecurityContextHolder.getContext().getAuthentication().getAuthorities()
                .contains(new SimpleGrantedAuthority("ROLE_ADMIN")))
            model.addAttribute("admin", true);

        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        if (!userName.equals("anonymousUser"))
            model.addAttribute("logined", true);
        Player player = playerService.getPlayer(id);
        model.addAttribute("p", player);
        return "player";
    }

}
