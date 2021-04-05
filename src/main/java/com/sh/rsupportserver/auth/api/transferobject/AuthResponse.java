package com.sh.rsupportserver.auth.api.transferobject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.pojomatic.annotations.AutoProperty;

import java.io.Serializable;

/**
 * 인증 응답 데이터이다.
 *
 * @author seonghyun
 */
@Getter
@Setter
@AutoProperty
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse implements Serializable {
    /**
     * 토큰(JWT)
     */
    private String token;

    /**
     * 사용자식별자
     */
    private String userId;

    /**
     * 사용자 명
     */
    private String userNm;
}
