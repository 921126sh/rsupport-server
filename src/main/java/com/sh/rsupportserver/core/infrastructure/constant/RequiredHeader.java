package com.sh.rsupportserver.core.infrastructure.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 필수헤더(인증토큰: {@link RequiredHeader#AuthToken})에 대한 열거형 상수이다.
 *
 * @author seonghyun
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum RequiredHeader {
    /**
     * 인증토큰
     */
    AuthToken("X-Auth-Token", "인증토큰");

    /**
     * 코드
     */
    private String code;

    /**
     * 제목
     */
    private String title;

    /**
     * 코드에 해당되는 열거형 상수를 반환한다.
     *
     * @param code 코드
     * @return 코드에 해당되는 열거형 상수
     */
    public static RequiredHeader codeOf(String code) {
        for (RequiredHeader em : values()) {
            if (em.getCode().equals(code)) {
                return em;
            }
        }

        return null;
    }
}
