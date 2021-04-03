package com.sh.rsupportserver.notice.infarastructure.exception;

import com.sh.rsupportserver.core.infrastructure.exception.DataNotFoundException;

/**
 * 공지 데이터 없음 예외이다.
 *
 * @author seonghyun
 */
public class NoticeNotFoundException extends DataNotFoundException {
    /**
     * 공지 데이터 없음 예외이다.
     *
     * @param code            오류코드
     * @param codeMessageArgs 메세지 치환 아귀먼트 목록
     */
    public NoticeNotFoundException(String code, Object[] codeMessageArgs) {
        super(code, codeMessageArgs);
    }
}
