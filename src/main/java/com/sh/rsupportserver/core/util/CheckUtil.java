package com.sh.rsupportserver.core.util;

/**
 * 검사 관련한 기능을 제공하는 유틸리티이다.
 *
 * @author seonghyun
 */
public class CheckUtil {
    private CheckUtil() {
    }

    /**
     * 값이 NULL 이거나 공백인지 여부를 반환한다.
     *
     * @param value 값
     * @return 값이 NULL 이거나 공백인지 여부
     */
    public static boolean isNullOrEmpty(String value) {
        return (null == value || value.trim().isEmpty());
    }

    /**
     * 값이 NULL 이거나 공백인지 여부를 반환한다.
     *
     * @param value 값
     * @return 값이 NULL 이거나 공백인지 여부
     */
    public static boolean isNullOrEmpty(Long value) {
        return null == value;
    }
}
