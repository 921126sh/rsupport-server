package com.sh.rsupportserver.notice.api.transferobject;

import com.sh.rsupportserver.notice.domain.Notice;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 공지 어그리게이션 TO객체 변환기이다.
 *
 * @author seonghyun
 */
@Component
public class NoticeConverter {
    public NoticeResponse convert(Notice notice) {
        NoticeResponse response = new NoticeResponse();
        BeanUtils.copyProperties(notice, response);
        return response;
    }
}
