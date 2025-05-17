package littleprince.config;

import littleprince.config.security.CustomAccessDeniedHandler;
import littleprince.config.security.CustomAuthenticationEntryPoint;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomAuthenticationEntryPoint authenticationEntryPoint;
    private final CustomAccessDeniedHandler accessDeniedHandler;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement((session
                        -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)))
                .exceptionHandling(exception
                        -> exception.authenticationEntryPoint(authenticationEntryPoint)
                        .accessDeniedHandler(accessDeniedHandler))
                .authorizeHttpRequests(auth ->
                        auth
                                /* 일반 권한 */
                                /* TODO : 필요 할 때 주석 풀고 작성 해 주세요!*/
//                                .requestMatchers(HttpMethod.GET,
//
//                                ).permitAll()
                                .requestMatchers(HttpMethod.POST,
                                        "/member/login",
                                        "/member/signup"
                                ).permitAll()
                                /* 유저 권한 */
                );

        return http.build();
    }
}
