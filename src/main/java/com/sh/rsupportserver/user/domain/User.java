package com.sh.rsupportserver.user.domain;

import com.sh.rsupportserver.core.domain.DomainEntity;
import com.sh.rsupportserver.user.api.transferobject.UserRequest;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 사용자 엔티티이다.
 *
 * @author seonghyun
 */
@Entity
@Getter
@RequiredArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "TB_USER", uniqueConstraints = {@UniqueConstraint(name = "U_USER_ID", columnNames = {"USER_ID"})})
public class User extends DomainEntity {
    /**
     * 사용자일련번호
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_SEQ")
    private Long userSeq;

    /**
     * 사용자식별자
     */
    @NonNull
    @Column(name = "USER_ID", length = 100, nullable = false)
    private String userId;

    /**
     * 사용자명
     */
    @NonNull
    @Column(name = "USER_NM", length = 50, nullable = false)
    private String userNm;

    /**
     * 비밀번호
     */
    @NonNull
    @Column(name = "USER_PWD", nullable = false)
    private String userPwd;

    /**
     * 사용자를 수정한다.
     *
     * @param req 사용자 요청데이터
     */
    public void edit(UserRequest req) {
        this.userId = req.getUserId();
        this.userNm = req.getUserNm();
        this.userPwd = req.getUserPwd();
    }
}
