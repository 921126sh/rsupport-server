package com.sh.rsupportserver.notice.domain;

import com.sh.rsupportserver.core.domain.DomainEntity;
import com.sh.rsupportserver.notice.api.transferobject.NoticeRequest;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 공지 엔티티이다.
 *
 * @author seonghyun
 */
@Entity
@Getter
@RequiredArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@SequenceGenerator(
        name="NOTICE_NO_GENERATOR",
        sequenceName="NOTICE_NO",
        initialValue=1,
        allocationSize = 1
)
@Table(name = "TB_NOTICE")
public class Notice extends DomainEntity {
    /**
     * 공지번호
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NOTICE_NO")
    private Long noticeNo;

    /**
     * 공지제목
     */
    @NonNull
    @Column(name = "NOTICE_TITLE", length = 225, nullable = false)
    private String noticeTitle;

    /**
     * 공지내용
     */
    @NonNull
    @Column(name = "NOTICE_Content", length = 225, nullable = false)
    private String noticeContent;

    /**
     * 첨부파일../
     */

    /**
     * 공지를 수정한다.
     *
     * @param req 공지 요청데이터
     */
    public void edit(NoticeRequest req) {
        this.noticeTitle = req.getNoticeTile();
        this.noticeContent = req.getNoticeCtnt();
    }
}
