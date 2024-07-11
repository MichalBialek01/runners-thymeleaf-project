package pl.bialek.runnersthymeleafproject.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    // NOTE : This implementation is used only for internal testing purposes
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf()
                .disable()
                .authorizeRequests()
                .requestMatchers("/login", "/register", "/clubs", "/css/**", "/jss/**")
                .permitAll()
                .and()
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/clubs")
                        .loginProcessingUrl("/login")
                        .failureUrl("/login?error=true")
                        .permitAll()
                ).logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll()
                );
        return httpSecurity.build();
    }
}
