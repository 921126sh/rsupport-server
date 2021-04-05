package com.sh.rsupportserver.user.application;

import com.sh.rsupportserver.core.infrastructure.constant.Errors;
import com.sh.rsupportserver.core.infrastructure.exception.IllegalArgException;
import com.sh.rsupportserver.core.util.CheckUtil;
import com.sh.rsupportserver.user.api.transferobject.UserRequest;
import com.sh.rsupportserver.user.domain.User;
import com.sh.rsupportserver.user.domain.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 사용자 변경 서비스이다.
 *
 * @author seonghyun
 */
@Service
@Transactional
@AllArgsConstructor
public class ChangeUserService {
    /**
     * 사용자 도메인 서비스
     */
    private final UserService userService;

    /**
     * 사용자를 등록한다.
     *
     * @param req 사용자 요청데이터
     */
    public void registerUser(UserRequest req) {
        if (CheckUtil.isNullOrEmpty(req.getUserId())) {
            throw new IllegalArgException(Errors.UserErrCd.USERS001.getCode(), new Object[]{req.getUserId()});
        }

        User user = User.of(req.getUserId(), req.getUserNm(), req.getUserPwd());

        userService.newSave(user);
    }

    /**
     * 사용자를 수정한다.
     *
     * @param userId 사용자식별자
     * @param req    요청데이터
     */
    public void editUser(String userId, UserRequest req) {
        if (CheckUtil.isNullOrEmpty(userId)) {
            throw new IllegalArgException(Errors.UserErrCd.USERS001.getCode(), new Object[]{userId});
        }

        User user = userService.find(userId);

        user.edit(req);
    }

    /**
     * 사용자를 삭제한다.
     *
     * @param userId 사용자식별자
     */
    public void deleteUser(String userId) {
        if (CheckUtil.isNullOrEmpty(userId)) {
            throw new IllegalArgException(Errors.UserErrCd.USERS001.getCode(), new Object[]{userId});
        }

        User user = userService.find(userId);
        userService.delete(user);
    }
}
