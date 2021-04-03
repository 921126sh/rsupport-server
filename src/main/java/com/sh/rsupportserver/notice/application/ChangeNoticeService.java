package com.sh.rsupportserver.notice.application;

import com.sh.rsupportserver.core.infrastructure.constant.Errors;
import com.sh.rsupportserver.core.infrastructure.exception.IllegalArgException;
import com.sh.rsupportserver.core.util.CheckUtil;
import com.sh.rsupportserver.notice.api.transferobject.NoticeRequest;
import com.sh.rsupportserver.notice.domain.Notice;
import com.sh.rsupportserver.notice.domain.NoticeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 공지 변경 서비스이다.
 *
 * @author seonghyun
 */
@Service
@Transactional
@AllArgsConstructor
public class ChangeNoticeService {
    /**
     * 공지 도메인 서비스
     */
    private final NoticeService noticeService;

    /**
     * 공지를 등록한다.
     *
     * @param req 공지 요청데이터
     */
    public void registerNotice(NoticeRequest req) {
        if (CheckUtil.isNullOrEmpty(req.getNoticeTitle())) {
            throw new IllegalArgException(Errors.NoticeErrCd.NOTICES001.getCode(), new Object[]{req.getNoticeTitle()});
        }

        Notice notice = Notice.of(req.getNoticeTitle(), req.getNoticeContent());

        noticeService.newSave(notice);
    }

    /**
     * 공지를 수정한다.
     *
     * @param noticeNo 공지번호
     * @param req    요청데이터
     */
    public void editNotice(Long noticeNo, NoticeRequest req) {
        if (CheckUtil.isNullOrEmpty(noticeNo)) {
            throw new IllegalArgException(Errors.NoticeErrCd.NOTICES001.getCode(), new Object[]{noticeNo});
        }

        Notice notice = noticeService.find(noticeNo);

        notice.edit(req);
    }

    /**
     * 공지를 삭제한다.
     *
     * @param noticeNo 공지번호
     */
    public void deleteNotice(Long noticeNo) {
        if (CheckUtil.isNullOrEmpty(noticeNo)) {
            throw new IllegalArgException(Errors.NoticeErrCd.NOTICES001.getCode(), new Object[]{noticeNo});
        }

        Notice notice = noticeService.find(noticeNo);
        noticeService.delete(notice);
    }
}
