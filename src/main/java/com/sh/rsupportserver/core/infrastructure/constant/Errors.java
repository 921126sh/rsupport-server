package com.sh.rsupportserver.core.infrastructure.constant;

import com.fasterxml.jackson.annotation.JsonValue;
import com.sh.rsupportserver.core.util.CheckUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 오류 정의 클래스이다.
 *
 * @author seonghyun
 */
public class Errors {
    /**
     * 주어진 메세지 코드와 아귀먼트로 조립된 메세지 내용을 반환한다.
     *
     * @param msgCd 메세지 코드
     * @param msgArgs 메세지 아귀먼트
     *
     * @return 메세지 내용
     */
    public static String getCdMsg(String msgCd, Object... msgArgs) {
        String msgCtnt = null;

        if (CheckUtil.isNullOrEmpty(msgCd)) {
            return msgCtnt;
        }

        if (msgCd.startsWith("USER")) {
            NoticeErrCd em = NoticeErrCd.codeOf(msgCd);
            if (null != em) {
                msgCtnt = em.getMessage();
            }
        }

        // 메세지 아귀먼트가 반영된 메세지 내용을 조립한다.
        // 미등록 코드이면 메세지 내용으로 코드를 할당한다.
        try {
            msgCtnt = (null == msgCtnt ? msgCd : msgCtnt);
            msgCtnt = String.format(msgCtnt, msgArgs);
        }
        catch (Exception e) {
        }

        return msgCtnt;
    }

    /**
     * 공지 관련 오류코드 enum 클래스이다.
     *
     * <ul>
     * <li>USER + S + [000 ~ 999]</li>
     * <li>S(시스템)</li>
     * </ul>
     *
     * @author seonghyun
     */
    @Getter
    @AllArgsConstructor
    public enum NoticeErrCd {
        /**
         * "공지번호가 입력되지 않았습니다. : [%s]"
         */
        NOTICES001("NOTICES001", "공지번호가 입력되지 않았습니다. : [%s]"),
        /**
         * "존재하지않는 공지입니다. : [%s]"
         */
        NOTICES002("NOTICES002", "존재하지않는 공지입니다. : [%s]"),
        /**
         * "동일한 공지번호가 존재합니다. : [%s]"
         */
        NOTICES003("NOTICES003", "동일한 공지번호가 존재합니다. : [%s]");

        private String code;
        private String message;

        /**
         * 코드에 해당되는 열거형 상수를 반환한다.
         *
         * @param code 코드
         *
         * @return 코드에 해당되는 열거형 상수
         */
        public final static NoticeErrCd codeOf(String code) {
            for (NoticeErrCd em : values()) {
                if (em.getCode().equals(code)) {
                    return em;
                }
            }

            return null;
        }

        @JsonValue
        @Override
        public String toString() {
            return this.getCode();
        }
    }

}
