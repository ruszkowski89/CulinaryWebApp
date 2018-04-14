package ruszkowski89.springmvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import ruszkowski89.springmvc.service.UserService;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserService userService;

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider());
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers(
                    "/admin/**").hasRole("ADMIN")                                       // ADMIN can access /admin/**
                .antMatchers(
                    "/app/register",
                    "/app/processRegister",
                    "/webjars/**",
                    "/css/**").permitAll()
                .anyRequest().authenticated()                                                        // any other request just need authentication
            .and()
                .formLogin()
                    .defaultSuccessUrl("/app/")
                    .loginPage("/app/login")
                        .permitAll()                                                                 // enable form login and grant all users access to it
            .and().httpBasic()                                                                       // allows users to authenticate with HTTP Basic authentication
            .and().logout()                                                                          // provides logout support
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/app/logout"))
                .logoutSuccessUrl("/app/login?logout")
                .permitAll()
            .and()
                .exceptionHandling().accessDeniedPage("/app/403");
    }

    @Bean
    public DaoAuthenticationProvider authProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
}
