package com.sh.rsupportserver.core.infrastructure.configuration;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 사용자 인증 서비스이다.
 *
 * @author seonghyun
 */
@Service
@AllArgsConstructor
@Slf4j
public class AuthService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        // TODO: 서버 거래를 위해 임시작성
        return null;
    }
}
