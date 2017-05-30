package ru.kpfu.itis.group501.khaliullin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;
import ru.kpfu.itis.group501.khaliullin.security.AuthProviderImpl;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20170522
 */

@Configuration
@EnableWebSecurity
@ComponentScan("ru.kpfu.itis.group501.khaliullin.security")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final AuthProviderImpl authProvider;
    private final AccessDeniedHandler accessDeniedHandler;

    @Autowired
    public SecurityConfig(AuthProviderImpl authProvider, AccessDeniedHandler accessDeniedHandler) {
        this.authProvider = authProvider;
        this.accessDeniedHandler = accessDeniedHandler;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/discussion/**", "/discussions/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/login/**", "/register/**", "/", "/future", "/played", "/albums", "/player",
                        "/players", "/files", "/albums", "/album", "/check", "/search", "add_match").permitAll();

        http.csrf().disable()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login/process")
                .usernameParameter("login")
                .passwordParameter("password")
                .defaultSuccessUrl("/discussions/0", true)
                .failureUrl("/login?error=true")
                .and()
                .logout().logoutSuccessUrl("/")
                .and()
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
    }
}
