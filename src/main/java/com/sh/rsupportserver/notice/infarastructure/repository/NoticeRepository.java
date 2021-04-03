package com.sh.rsupportserver.notice.infarastructure.repository;

import com.sh.rsupportserver.core.domain.DomainRepository;
import com.sh.rsupportserver.notice.domain.Notice;

/**
 * 공지 도메인 레파지토리이다.
 *
 * @author seonghyun
 */
public interface NoticeRepository extends DomainRepository<Notice, Long> {
    Notice findByNoticeNo(Long noticeNo);
}
