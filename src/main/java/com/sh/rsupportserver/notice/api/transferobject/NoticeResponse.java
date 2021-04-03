package com.sh.rsupportserver.notice.api.transferobject;

import com.sh.rsupportserver.core.api.transferobject.BaseResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.pojomatic.annotations.AutoProperty;

/**
 * 공지 응답데이터이다.
 *
 * @author seonghyun
 */
@Getter
@Setter
@AutoProperty
@NoArgsConstructor
@AllArgsConstructor
public class NoticeResponse extends BaseResponseDto {
    /**
     * 공지번호
     */
    private Long noticeNo;

    /**
     * 공지제목
     */
    private String noticeTitle;

    /**
     * 공지내용
     */
    private String noticeContent;
}

