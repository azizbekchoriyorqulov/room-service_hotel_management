package uz.pdp.roomservice.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import uz.pdp.roomservice.filter.JwtTokenFilter;
import uz.pdp.roomservice.service.auth.AuthenticationService;
import uz.pdp.roomservice.service.jwt.JwtService;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity()
public class SecurityConfig {
    private final AuthenticationService authenticationService;
    private final JwtService jwtService;
    private final String[] roomController = {"/room/api/v1/**"};

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .authorizeHttpRequests((authorize) -> {
                    authorize.
                            requestMatchers(roomController).authenticated();
                })
                .sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(new JwtTokenFilter(authenticationService, jwtService),
                        UsernamePasswordAuthenticationFilter.class)
                .build();

    }
}

