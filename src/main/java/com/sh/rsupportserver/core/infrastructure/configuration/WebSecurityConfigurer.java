package com.sh.rsupportserver.core.infrastructure.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
    /**
     * 스프링 환경 제공자
     */
    @Autowired
    private Environment environment;

    /**
     * 인증관리자 빈
     *
     * @return 인증관리자 빈
     * @throws Exception 예외
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // UTF-8로 캐릭터셋 필터 적용(한글 깨짐 방지)
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);

        // 캐릭터셋 필터를 csrf필터 전에 적용
        http.addFilterBefore(filter, CsrfFilter.class);

        // CORS(Cross-Origin Resource Sharing : 타 도메인 간 자원 호출을 승인하거나 차단) 활성화
        http.cors().and()
                // CSRF(Cross Site Request Forgery : 사이트 간 요청 위조) 비활성화
                // STATELESS : Security 인증 세션을 유지하지 않도록 설정
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // iframe 허용
        http.headers().frameOptions().sameOrigin();

        http.authorizeRequests()
                // preflight(HttpMethod.OPTIONS) 요청 오류 방지
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                // static resources
                .antMatchers("/css/**", "/js/**", "/resources/**", "/webjars/**", "/h2/**","/**").permitAll();
    }
}
