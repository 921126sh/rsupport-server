package com.sh.rsupportserver.notice.domain;

import com.sh.rsupportserver.core.infrastructure.constant.Errors;
import com.sh.rsupportserver.notice.infarastructure.exception.NoticeDuplicateException;
import com.sh.rsupportserver.notice.infarastructure.exception.NoticeNotFoundException;
import com.sh.rsupportserver.notice.infarastructure.repository.NoticeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * 공지 도메인 서비스이다.
 *
 * @author seonghyun
 */
@Service
@AllArgsConstructor
public class NoticeService {
    /**
     * 공지 도메인 레파지토리
     */
    private final NoticeRepository noticeRepository;

    /**
     * 공지를 등록한다.
     *
     * @param notice 공지
     */
    public void newSave(Notice notice) {
        checkDuplicate(notice.getNoticeNo(), Errors.NoticeErrCd.NOTICES003.getCode());
        noticeRepository.save(notice);
    }

    /**
     * 공지를 삭제한다.
     *
     * @param notice 공지
     */
    public void delete(Notice notice) {
        noticeRepository.delete(notice);
    }

    /**
     * 공지를 조회한다.
     *
     * @param noticeNo 공지번호
     * @return 공지
     */
    public Notice find(Long noticeNo) {
        return find(noticeNo, Errors.NoticeErrCd.NOTICES002.getCode());
    }

    /**
     * 공지를 조회한다.
     *
     * @param noticeNo 공지번호
     * @param errCd  에러코드
     * @return 공지
     */
    private Notice find(Long noticeNo, String errCd) {
        Notice notice = noticeRepository.findByNoticeNo(noticeNo);

        if (null == notice) {
            throw new NoticeNotFoundException(errCd, new Object[]{noticeNo});
        }

        return notice;
    }

    /**
     * 동일한 공지가 존재하는지 확인한다.
     *
     * @param noticeNo 공지번호
     * @param errCd  오류코드
     */
    private void checkDuplicate(final Long noticeNo, String errCd) {
        Notice notice = noticeRepository.findByNoticeNo(noticeNo);

        if (null != notice) {
            throw new NoticeDuplicateException(errCd, new Object[]{noticeNo});
        }
    }

    // ================================================================

    /**
     * 공지 목록을 조회한다.
     *
     * @return 공지목록
     */
    public Page<Notice> getNoticeList(Pageable pageable) {
        Page<Notice> noticeList = noticeRepository.findAll(pageable);

        return noticeList;
    }

}
