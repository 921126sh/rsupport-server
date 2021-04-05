package com.sh.rsupportserver.auth.configuration;

import com.sh.rsupportserver.auth.api.transferobject.AuthUserVo;
import com.sh.rsupportserver.auth.application.AuthService;
import com.sh.rsupportserver.core.infrastructure.constant.Errors;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import javax.security.auth.message.AuthException;

/**
 * 사용자 인증 제공자이다.
 *
 * @author seonghyun
 */
@Component
@AllArgsConstructor
public class AuthProvider implements AuthenticationProvider {
    /**
     * 인증 서비스
     */
    private final AuthService authService;

    /**
     * 비밀번호 인코더
     */
    private final AuthPasswordEncoder authPasswordEncoder;

    @SneakyThrows
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String id = authentication.getName();
        String password = (String) authentication.getCredentials();

        AuthUserVo user = (AuthUserVo) authService.loadUserByUsername(id);
        if (null == user) {
            throw new AuthException(Errors.AuthErrCd.AUTHS001.getCode());
        }

        // 비밀번호가 다르면 예외발생
        if (!authPasswordEncoder.matches(password, user.getPassword())) {
            throw new AuthException(Errors.AuthErrCd.AUTHS002.getCode());
        }

        return new UsernamePasswordAuthenticationToken(user, password, user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
