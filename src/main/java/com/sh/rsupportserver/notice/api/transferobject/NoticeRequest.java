package com.sh.rsupportserver.notice.api.transferobject;

import com.sh.rsupportserver.core.api.transferobject.BaseRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.pojomatic.annotations.AutoProperty;

/**
 * 공지 요청데이터이다.
 *
 * @author seonghyun
 */
@Getter
@AutoProperty
@AllArgsConstructor
public class NoticeRequest extends BaseRequestDto {
    /**
     * 공지제목
     */
    private String noticeTitle;

    /**
     * 공지내용
     */
    private String noticeContent;
}

