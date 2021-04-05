package com.sh.rsupportserver.auth.application;

import com.sh.rsupportserver.auth.api.transferobject.AuthUserVo;
import com.sh.rsupportserver.user.application.RetrieveUserService;
import com.sh.rsupportserver.user.domain.User;
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
    /**
     * 사용자를 조회하는 서비스
     */
    private final RetrieveUserService retrieveUserService;

    /**
     * 인증된 사용자정보를 반환한다.
     *
     * @param userId 사용자식별자
     *
     * @return 인증된 사용자정보
     */
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        AuthUserVo authUserVo = null;

        // 사용자 정보를 조회한다.
        User user = retrieveUserService.retrieveUserAuth(userId);

        if (null != user) {
            authUserVo = new AuthUserVo(user.getUserId(), user.getUserNm(), user.getUserPwd(), true, true, true, true);
        }

        return authUserVo;
    }
}
