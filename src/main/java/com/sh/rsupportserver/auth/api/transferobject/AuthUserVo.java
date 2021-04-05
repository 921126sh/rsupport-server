package com.sh.rsupportserver.auth.api.transferobject;

import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collections;

/**
 * 사용자 인증정보 객체이다.
 *
 * @author seonghyun
 */
public class AuthUserVo extends User {
    /**
     * 사용자명
     */
    @Getter
    private String userNm;

    /**
     * 사용자 인증정보를 초기화하는 생성자이다.
     *
     * @param userId                사용자 식별자
     * @param userNm                사용자 명
     * @param password              사용자 비밀번호
     * @param enabled               사용자 활성여부
     * @param accountNonExpired     사용자 만료안됨 여부
     * @param credentialsNonExpired 자격증명 만료안됨 여부
     * @param accountNonLocked      사용자 잠금안됨 여부
     */
    public AuthUserVo(String userId, String userNm, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired,
                      boolean accountNonLocked) {
        // TODO: 역할 로직 적용 후 Authority에 적용 된 상수 제거
        super(userId, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, Collections.singleton(new SimpleGrantedAuthority("role")));

        this.userNm = userNm;
    }

    /**
     * 사용자 식별자를 반환한다.
     *
     * @return 사용자 식별자
     */
    public String getUserId() {
        return getUsername();
    }
}
