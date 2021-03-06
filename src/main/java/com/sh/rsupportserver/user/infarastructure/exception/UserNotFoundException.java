package com.sh.rsupportserver.user.infarastructure.exception;

import com.sh.rsupportserver.core.infrastructure.exception.DataNotFoundException;

/**
 * 사용자 데이터 없음 예외이다.
 *
 * @author seonghyun
 */
public class UserNotFoundException extends DataNotFoundException {
    /**
     * 사용자 데이터 없음 예외이다.
     *
     * @param code 오류코드
     */
    public UserNotFoundException(String code) {
        this(code, new Object[]{}, null);
    }

    /**
     * 사용자 데이터 없음 예외이다.
     *
     * @param code  오류코드
     * @param cause 원인예외
     */
    public UserNotFoundException(String code, Throwable cause) {
        this(code, new Object[]{}, cause);
    }

    /**
     * 사용자 데이터 없음 예외이다.
     *
     * @param code            오류코드
     * @param codeMessageArgs 메세지 치환 아귀먼트 목록
     */
    public UserNotFoundException(String code, Object[] codeMessageArgs) {
        super(code, codeMessageArgs);
    }

    /**
     * 사용자 데이터 없음 예외이다.
     *
     * @param code            오류코드
     * @param codeMessageArgs 메세지 치환 아귀먼트 목록
     * @param cause           원인예외
     */
    public UserNotFoundException(String code, Object[] codeMessageArgs, Throwable cause) {
        super(code, codeMessageArgs, cause);
    }
}
