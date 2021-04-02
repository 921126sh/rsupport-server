package com.sh.rsupportserver.notice.infarastructure.exception;

import com.sh.rsupportserver.core.infrastructure.exception.DataDuplicateException;

/**
 * 공지 중복 예외이다.
 *
 * @author seonghyun
 */
public class NoticeDuplicateException extends DataDuplicateException {
    /**
     * 공지 중복 예외이다.
     *
     * @param code 오류코드
     */
    public NoticeDuplicateException(String code) {
        this(code, new Object[]{}, null);
    }

    /**
     * 공지 중복 예외이다.
     *
     * @param code  오류코드
     * @param cause 원인예외
     */
    public NoticeDuplicateException(String code, Throwable cause) {
        this(code, new Object[]{}, cause);
    }

    /**
     * 공지 중복 예외이다.
     *
     * @param code            오류코드
     * @param codeMessageArgs 메세지 치환 아귀먼트 목록
     */
    public NoticeDuplicateException(String code, Object[] codeMessageArgs) {
        super(code, codeMessageArgs);
    }

    /**
     * 공지 중복 예외이다.
     *
     * @param code            오류코드
     * @param codeMessageArgs 메세지 치환 아귀먼트 목록
     * @param cause           원인예외
     */
    public NoticeDuplicateException(String code, Object[] codeMessageArgs, Throwable cause) {
        super(code, codeMessageArgs, cause);
    }
}
