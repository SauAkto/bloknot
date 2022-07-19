package com.bloknote.bloknot.config;

import com.bloknote.bloknot.security.jwt.JwtConfigurer;
import com.bloknote.bloknot.security.jwt.JwtTokenFilter;
import com.bloknote.bloknot.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtTokenProvider jwtTokenProvider;
    private final JwtConfigurer jwtConfigurer;

    private static  final String ADMIN_ENDPOINT = "/admin/**";
    private static  final String LOGIN_ENDPOINT = "/**";

    @Autowired
    public SecurityConfig(JwtTokenProvider jwtTokenProvider, JwtConfigurer jwtConfigurer) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.jwtConfigurer = jwtConfigurer;
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .formLogin()
                .loginPage("/auth/login").permitAll()
                .defaultSuccessUrl("/appeals")
                .and()
                .authorizeRequests()
                .antMatchers(ADMIN_ENDPOINT)
                .hasRole("ADMIN")
                .antMatchers(LOGIN_ENDPOINT)
                .hasRole("USER")
                .anyRequest().authenticated()
                .and()
                .apply(new JwtConfigurer(new JwtTokenProvider()))
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout", "POST"))
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/auth/login");
    }
}
