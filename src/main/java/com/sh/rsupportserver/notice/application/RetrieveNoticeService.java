package com.sh.rsupportserver.notice.application;

import com.sh.rsupportserver.notice.api.transferobject.NoticeConverter;
import com.sh.rsupportserver.notice.api.transferobject.NoticeResponse;
import com.sh.rsupportserver.notice.domain.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 공지 조회 서비스이다.
 *
 * @author seonghyun
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RetrieveNoticeService {
    /**
     * 공지 도메인 서비스
     */

    private final NoticeService noticeService;

    /**
     * 공지 어그리게이션 <--> TO 객체 변환기
     */
    private final NoticeConverter noticeConverter;

    /**
     * 공지를 조회한다.
     *
     * @param noticeNo 공지번호
     * @return 공지
     */
    public NoticeResponse retrieveNotice(Long noticeNo) {
        return noticeConverter.convert(noticeService.find(noticeNo));
    }

    /**
     * 공지 목록을 조회한다.
     *
     * @return 공지 목록
     */
    public List<NoticeResponse> retrieveNoticeList(Pageable pageable) {
        return noticeService.getNoticeList(pageable).stream().map(noticeConverter::convert).collect(Collectors.toList());
    }
}
