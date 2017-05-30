package ru.kpfu.itis.group501.khaliullin.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.itis.group501.khaliullin.model.Status;
import ru.kpfu.itis.group501.khaliullin.model.User;
import ru.kpfu.itis.group501.khaliullin.model.UsersStatus;
import ru.kpfu.itis.group501.khaliullin.service.StatusService;
import ru.kpfu.itis.group501.khaliullin.service.UserService;
import ru.kpfu.itis.group501.khaliullin.service.UsersStatusService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20170522
 */
@Controller
public class SignUpController {
    private final UserService userService;
    private final UsersStatusService usersStatusService;
    private final StatusService statusService;

    public SignUpController(UserService userService, UsersStatusService usersStatusService, StatusService statusService) {
        this.userService = userService;
        this.usersStatusService = usersStatusService;
        this.statusService = statusService;
    }

    @RequestMapping(value = "/register")
    public String signUpStudentPage(Model model) {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String signUp(@RequestParam(name = "login", required = true) String login,
                         @RequestParam(name = "password", required = true) String password,
                         @RequestParam(name = "password_confirmation", required = true) String passwordConfirmation,
                         @RequestParam(name = "firstname", required = true) String firstName,
                         @RequestParam(name = "lastname", required = true) String lastName,
                         @RequestParam(name = "gender", required = false) String gender,
                         @RequestParam(name = "email", required = true) String email,
                         Model model, HttpServletRequest request) {

        String registrationResult = null;
        if (login != null && !login.equals("") && password != null && !password.equals("") &&
                passwordConfirmation != null && !passwordConfirmation.equals("") && email != null && !email.equals("") &&
                firstName != null && !firstName.equals("") && lastName != null && !lastName.equals("") && gender != null && !gender.equals("")) {
            String salt = "koiu#" + Math.random() + "s$req!";
            System.out.println(salt);
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            password += salt;
            String hashedPassword = passwordEncoder.encode(password);

            User user = new User(login, hashedPassword, email, firstName, lastName, gender.charAt(0), salt);
            Status status = statusService.getStatus("USER");
            UsersStatus userStatus = new UsersStatus(user, status);
            userService.save(user);
            usersStatusService.save(userStatus);
            return "redirect:login";
        } else {
            model.addAttribute("error", "Заполните форму!");
            model.addAttribute("login", login);
            model.addAttribute("firstname", firstName);
            model.addAttribute("lastname", lastName);
            model.addAttribute("email", email);
            return "register";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/check")
    public boolean checkLogin(@RequestParam(name = "login") String login) {
        if (userService.getUser(login) != null) {
            return true;
        }
        return false;
    }
}
