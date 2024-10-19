package Relationship.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
        @Bean
        protected UserDetailsService userDetailsService() {
                UserDetails user = User.builder()
                                .username("user")
                                .password(passwordEncoder().encode("password"))
                                .roles("USER")
                                .build();
                UserDetails admin = User.builder()
                                .username("user2")
                                .password(passwordEncoder().encode("password"))
                                .roles("ADMIN")
                                .build();

                return new InMemoryUserDetailsManager(user, admin);

        }

        @Bean
        protected PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                return http
                                .csrf(AbstractHttpConfigurer::disable)
                                .authorizeHttpRequests(
                                                request -> request
                                                                .requestMatchers("/auth/login").permitAll()
                                                                .requestMatchers("/auth/home").authenticated()
                                                                .anyRequest().authenticated())
                                .formLogin(form -> form
                                                .loginPage("/auth/login")
                                                .defaultSuccessUrl("/auth/home", true)
                                                .permitAll())
                                .logout(config -> config
                                                .logoutSuccessUrl("/auth/login"))
                                .build();
        }

        @Bean
        public AuthenticationManager authManager(HttpSecurity http) throws Exception {
                AuthenticationManagerBuilder authenticationManagerBuilder = http
                                .getSharedObject(AuthenticationManagerBuilder.class);
                authenticationManagerBuilder.userDetailsService(userDetailsService())
                                .passwordEncoder(passwordEncoder());
                return authenticationManagerBuilder.build();
        }
}
