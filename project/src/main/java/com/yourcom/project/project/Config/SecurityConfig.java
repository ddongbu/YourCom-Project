package com.yourcom.project.project.Config;

import com.yourcom.project.project.service.CustomOAuth2UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final CustomOAuth2UserService customOAuth2UserService;
    public SecurityConfig(CustomOAuth2UserService customOAuth2UserService){
        this.customOAuth2UserService = customOAuth2UserService;
    }
    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf().disable().cors().disable();
                http.authorizeHttpRequests(request -> request
                        .antMatchers("/","/login").permitAll()
                        .antMatchers("/MachineInsert").hasAnyRole("GUEST")
                                // LoadBalancer Chk
                )
                .logout()
                .logoutUrl("/session/logout")
                .logoutSuccessUrl("/login")
                .deleteCookies("JSESSIONID","remember-me")
                .and()
                .formLogin(login -> login
                        .loginPage("/login").permitAll() //미인증자일 경우 uri 호출
                        .loginProcessingUrl("/login")
                        .usernameParameter("memberEmail")
                       .passwordParameter("memberPassword")
                       .defaultSuccessUrl("/AfterMain", true)
                )
                .oauth2Login()
                    .loginPage("/loginForm")
                    .defaultSuccessUrl("/social/AfterMain")
                    .failureUrl("/login")
                    .userInfoEndpoint()
                    .userService(customOAuth2UserService);
        return http.build();
    }
    public void configure(WebSecurity web) throws Exception{
        web.ignoring().antMatchers("/css/**","/js/**","/img/**","/files/**");
    }
}
