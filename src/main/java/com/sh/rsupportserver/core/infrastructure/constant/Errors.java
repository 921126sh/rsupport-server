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

        if (msgCd.startsWith("AUTH")) {
            AuthErrCd em = AuthErrCd.codeOf(msgCd);
            if (null != em) {
                msgCtnt = em.getMessage();
            }
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
     * 인증 관련 오류코드 enum 클래스이다.
     *
     * <ul>
     * <li>AUTH + S + [000 ~ 999]</li>
     * <li>S(시스템)</li>
     * </ul>
     *
     * @author seonghyun
     */
    @Getter
    @AllArgsConstructor
    public enum AuthErrCd {
        /**
         * "존재하지 않는 사용자 입니다."
         */
        AUTHS001("AUTHS001", "존재하지 않는 사용자 입니다."),
        /**
         * "비밀번호가 일치하지 않습니다."
         */
        AUTHS002("AUTHS002", "비밀번호가 일치하지 않습니다."),
        /**
         * "정지된 사용자입니다.\n관리자에게 문의하세요."
         */
        AUTHS003("AUTHS003", "정지된 사용자입니다.\n관리자에게 문의하세요."),
        /**
         * "부여된 권한이 없습니다.\n관리자에게 문의하세요."
         */
        AUTHS004("AUTHS004", "부여된 권한이 없습니다.\n관리자에게 문의하세요.");

        private String code;
        private String message;

        /**
         * 코드에 해당되는 열거형 상수를 반환한다.
         *
         * @param code 코드
         *
         * @return 코드에 해당되는 열거형 상수
         */
        public final static AuthErrCd codeOf(String code) {
            for (AuthErrCd em : values()) {
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

    /**
     * 사용자 관련 오류코드 enum 클래스이다.
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
    public enum UserErrCd {
        /**
         * "아이디가 입력되지 않았습니다. : [%s]"
         */
        USERS001("USERS001", "아이디가 입력되지 않았습니다. : [%s]"),
        /**
         * "존재하지않는 사용자입니다. : [%s]"
         */
        USERS002("USERS002", "존재하지않는 사용자입니다. : [%s]"),
        /**
         * "동일한 아이디가 존재합니다. : [%s]"
         */
        USERS003("USERS003", "동일한 아이디가 존재합니다. : [%s]");

        private String code;
        private String message;

        /**
         * 코드에 해당되는 열거형 상수를 반환한다.
         *
         * @param code 코드
         *
         * @return 코드에 해당되는 열거형 상수
         */
        public final static UserErrCd codeOf(String code) {
            for (UserErrCd em : values()) {
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
