package io.avec.resourceserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    // Use Authorization Server!
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .mvcMatcher("/hello") //
                .authorizeRequests()//
                    .mvcMatchers("/hello").access("hasAuthority('SCOPE_message.read')")//
                    .and()//
            .oauth2ResourceServer()//
                .jwt(); //
        return http.build();
    }

    /*

    // Everything below and the resource server is handling login and users itself

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .anonymous(AbstractHttpConfigurer::disable)
                .authorizeRequests(authorizeRequests ->
                    authorizeRequests
//                            .antMatchers("/hello").permitAll()
                            .antMatchers("/admin").hasRole("ADMIN")
                            .anyRequest().authenticated()
                )
                .httpBasic()
                .and()
                .build();
    }



    @Bean
    UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("user")
                .roles("USER")
                .build();
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

     */
}
