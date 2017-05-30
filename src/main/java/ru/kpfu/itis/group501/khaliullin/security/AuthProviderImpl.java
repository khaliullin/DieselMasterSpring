package ru.kpfu.itis.group501.khaliullin.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.group501.khaliullin.model.Status;
import ru.kpfu.itis.group501.khaliullin.model.User;
import ru.kpfu.itis.group501.khaliullin.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20170522
 */
@Component
public class AuthProviderImpl implements AuthenticationProvider {

    private static final PasswordEncoder encoder = new BCryptPasswordEncoder();

    private final UserService userService;

    @Autowired
    public AuthProviderImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = authentication.getName();
        User user = userService.getUser(login);
        if (user == null) {
            throw new UsernameNotFoundException("Пользователь не найден!");
        }

        String password = authentication.getCredentials().toString() + user.getSault();

        if (!encoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("Неверный пароль!");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        List<Status> statuses = userService.getStatus(user);
        for (Status status : statuses) {
            StringBuilder role = new StringBuilder("ROLE_");
            role.append(status.getName());
            authorities.add(new SimpleGrantedAuthority(role.toString()));
        }
        System.out.println("!!!!!!!!!");
        System.out.println("!!!!!!!!!");
        System.out.println("!!!!!!!!!");
        System.out.println(authorities.size());
        return new UsernamePasswordAuthenticationToken(user, null, authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }

}