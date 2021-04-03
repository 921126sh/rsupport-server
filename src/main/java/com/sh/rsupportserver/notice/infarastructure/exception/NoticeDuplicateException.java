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
     * @param code            오류코드
     * @param codeMessageArgs 메세지 치환 아귀먼트 목록
     */
    public NoticeDuplicateException(String code, Object[] codeMessageArgs) {
        super(code, codeMessageArgs);
    }
}
