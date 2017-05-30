package ru.kpfu.itis.group501.khaliullin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.group501.khaliullin.model.Discussion;
import ru.kpfu.itis.group501.khaliullin.model.Message;
import ru.kpfu.itis.group501.khaliullin.model.User;
import ru.kpfu.itis.group501.khaliullin.service.DiscussionService;
import ru.kpfu.itis.group501.khaliullin.service.MessageService;

import java.util.Date;
import java.util.List;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20170522
 */
@Controller
public class DiscussionController {
    private final DiscussionService discussionService;
    private final MessageService messageService;

    @Autowired
    public DiscussionController(DiscussionService discussionService, MessageService messageService) {
        this.discussionService = discussionService;
        this.messageService = messageService;
    }

    @RequestMapping(value = "/discussions/{page}")
    public String discussionsList(@PathVariable("page") int pageNumber, Model model) {
        List<Discussion> discussions = discussionService.getAll(pageNumber);
        int maxPageNumber = discussionService.getMaxPageNumber();

        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        if (!userName.equals("anonymousUser"))
            model.addAttribute("logined", true);

        if (SecurityContextHolder.getContext().getAuthentication().getAuthorities()
                .contains(new SimpleGrantedAuthority("ROLE_ADMIN")))
            model.addAttribute("admin", true);

        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("maxPageNumber", maxPageNumber);
        model.addAttribute("discussions", discussions);

        return "discussionsList";
    }

    @RequestMapping(value = "/discussion/create")
    public String createDiscussion(Model model) {

        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        if (!userName.equals("anonymousUser"))
            model.addAttribute("logined", true);

        if (SecurityContextHolder.getContext().getAuthentication().getAuthorities()
                .contains(new SimpleGrantedAuthority("ROLE_ADMIN")))
            model.addAttribute("admin", true);

        return "discussionCreation";
    }

    @RequestMapping(value = "/discussion/create", method = RequestMethod.POST)
    public String discussionCreation(@RequestParam(name = "name") String name,
                                     @RequestParam(name = "content") String content, Model model) {

        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        if (!userName.equals("anonymousUser"))
            model.addAttribute("logined", true);

        if (SecurityContextHolder.getContext().getAuthentication().getAuthorities()
                .contains(new SimpleGrantedAuthority("ROLE_ADMIN")))
            model.addAttribute("admin", true);

        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (name != null && !name.equals("") && content != null && !content.equals("")) {
            Discussion discussion = new Discussion(currentUser, name, content, new Date());
            discussionService.save(discussion);
            return "redirect:/discussions/0";
        }
        model.addAttribute("name", name);
        model.addAttribute("content", content);


        return "discussionCreation";
    }

    @RequestMapping(value = "discussion/{id}/{page}")
    public String discussionPage(@PathVariable(name = "id") Long id,
                                 @PathVariable(name = "page") int pageNumber, Model model) {

        Discussion discussion = discussionService.getDiscussion(id);
        List<Message> messages = messageService.getMessagesByDiscussion(discussion, pageNumber);
        int maxPageNumber = messageService.getMaxPageNumber(discussion);

        model.addAttribute("discussionId", id);
        model.addAttribute("discussion", discussion);
        model.addAttribute("messages", messages);
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("maxPageNumber", maxPageNumber);

        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        if (!userName.equals("anonymousUser"))
            model.addAttribute("logined", true);

        if (SecurityContextHolder.getContext().getAuthentication().getAuthorities()
                .contains(new SimpleGrantedAuthority("ROLE_ADMIN")))
            model.addAttribute("admin", true);

        return "discussion";
    }

    @RequestMapping(value = "discussion/{id}/{page}", method = RequestMethod.POST)
    public String sendMessage(@PathVariable(name = "id") Long id,
                              @PathVariable(name = "page") int pageNumber,
                              @RequestParam(name = "content") String content, Model model) {

        if (content != null && !content.equals("")) {
            Discussion discussion = discussionService.getDiscussion(id);
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Message message = new Message(discussion, user, content, new Date());
            messageService.save(message);
        }
        return "redirect:/discussion/{id}/{page}";
    }
}
