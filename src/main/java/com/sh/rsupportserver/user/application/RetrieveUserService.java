package com.sh.rsupportserver.user.application;

import com.sh.rsupportserver.user.api.transferobject.UserConverter;
import com.sh.rsupportserver.user.api.transferobject.UserResponse;
import com.sh.rsupportserver.user.domain.User;
import com.sh.rsupportserver.user.domain.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 사용자 조회 서비스이다.
 *
 * @author seonghyun
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RetrieveUserService {
    /**
     * 사용자 도메인 서비스
     */

    private final UserService userService;

    /**
     * 사용자 어그리게이션 <--> TO 객체 변환기
     */
    private final UserConverter userConverter;

    /**
     * 인증을 위해 사용자를 조회한다.
     *
     * @param userId 사용자식별자
     * @return 사용자
     */
    public User retrieveUserAuth(String userId) {
        return userService.findForAuth(userId);
    }

    /**
     * 사용자를 조회한다.
     *
     * @param userId 사용자식별자
     * @return 사용자
     */
    public UserResponse retrieveUser(String userId) {
        return userConverter.convert(userService.find(userId));
    }

    /**
     * 사용자 목록을 조회한다.
     *
     * @return 사용자 목록
     */
    public List<UserResponse> retrieveUserList(String userId) {
        return userService.getUserList(userId).stream().map(userConverter::convert).collect(Collectors.toList());
    }
}
