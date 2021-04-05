package com.sh.rsupportserver.user.api.transferobject;

import com.sh.rsupportserver.core.api.transferobject.BaseRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.pojomatic.annotations.AutoProperty;

/**
 * 사용자 요청데이터이다.
 *
 * @author seonghyun
 */
@Getter
@Setter
@AutoProperty
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest extends BaseRequestDto {
    /**
     * 사용자식별자
     */
    private String userId;

    /**
     * 사용자명
     */
    private String userNm;

    /**
     * 비밀번호
     */
    private String userPwd;
}

