package ru.kpfu.itis.group501.khaliullin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.itis.group501.khaliullin.model.Match;
import ru.kpfu.itis.group501.khaliullin.model.Photo;
import ru.kpfu.itis.group501.khaliullin.service.MatchService;
import ru.kpfu.itis.group501.khaliullin.service.PhotoService;

import java.util.List;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20170522
 */
@Controller
public class AlbumController {
    private final MatchService matchService;
    private final PhotoService photoService;

    @Autowired
    public AlbumController(MatchService matchService, PhotoService photoService) {
        this.matchService = matchService;
        this.photoService = photoService;
    }

    @RequestMapping(value = "/albums/{page}")
    public String albumsList(@PathVariable("page") int pageNumber, Model model) {
        List<Match> matches = matchService.getPlayedMatches(1L, pageNumber);
        int maxPageNumber = matchService.getMaxPageNumberByTeamIdAndPlayed(1L, true);

        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        if (!userName.equals("anonymousUser"))
            model.addAttribute("logined", true);

        if (SecurityContextHolder.getContext().getAuthentication().getAuthorities()
                .contains(new SimpleGrantedAuthority("ROLE_ADMIN")))
            model.addAttribute("admin", true);
        model.addAttribute("matches", matches);
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("maxPageNumber", maxPageNumber);
        return "albums";
    }

    @RequestMapping(value = "/album/{id}/{page}")
    public String album(@PathVariable(name = "id") Long id, @PathVariable("page") int pageNumber, Model model) {
        List<Photo> photos = photoService.getPhotos(id, pageNumber);
        int maxPageNumber = photoService.getMaxPage(id);

        if (SecurityContextHolder.getContext().getAuthentication().getAuthorities()
                .contains(new SimpleGrantedAuthority("ROLE_ADMIN")))
            model.addAttribute("admin", true);

        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        if (!userName.equals("anonymousUser"))
            model.addAttribute("logined", true);

        model.addAttribute("photos", photos);
        model.addAttribute("matchId", id);
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("maxPageNumber", maxPageNumber);
        return "photos";
    }
}
